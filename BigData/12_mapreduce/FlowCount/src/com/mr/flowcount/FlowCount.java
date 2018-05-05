package com.mr.flowcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowCount {
    /**
     * Mapper
     */
    static class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //将读入的一行数据，转为String[]
            String line = value.toString();
            String[] fields = line.split("\t"); //根据Tab来切割一行数据。


            String phoneNumber = fields[0];//取出手机号
            long up = Long.parseLong(fields[fields.length - 3]);//取出上行流量
            long down = Long.parseLong(fields[fields.length - 2]);//取出下行流量

            //输出数据。如：<13634322343,flowbean>
            context.write(new Text(phoneNumber), new FlowBean(up, down));

        }
    }

    /**
     * Reducer
     */
    static class FlowReducer extends Reducer<Text, FlowBean, Text, FlowBean> {
        @Override
        protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
            long sum_upFlow = 0;
            long sum_downFlow = 0;

            //遍历相同手机号的FlowBean对象，对其upFlow和downFlow进行求和。
            for (FlowBean value : values) {
                sum_upFlow += value.getUpFlow();
                sum_downFlow += value.getDownFlow();
            }

            context.write(key, new FlowBean(sum_upFlow, sum_downFlow));
        }
    }


    /**
     * 提交Job至yarn
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //指定本程序的jar包所在的路径。
        job.setJarByClass(FlowCount.class);

        //告诉本业务job，要使用的mapper业务类和educer业务类
        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);

        //指定mapper输出的key和value类型。
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        //指定最终输出的key和value类型。此处可理解为Reducer的输出类型。但不是所有程序都有Reducer的。
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //指定job输入原始文件的所在目录。HDFS中的路径。
        FileInputFormat.setInputPaths(job, new Path(args[1])); //通过运行jar包时，指定路径。

        //指定job输出结果的所在目录.
        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        //等待集群运算结束，并打印出结果(true)。
        boolean res = job.waitForCompletion(true);

        System.exit(res?0:1); //如果运行成功，退出0，否则退出1.这里主要是给脚本进行判断用的。
    }
}
