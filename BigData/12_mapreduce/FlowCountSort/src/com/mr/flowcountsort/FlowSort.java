package com.mr.flowcountsort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowSort {

    /**
     * 流量排序Mapper的输入是flowcount计算完成后输出的文件，所以再次读入mapper时，是 LongWritable, Text 格式的。
     */
    static class FlowSortMapper extends Mapper<LongWritable, Text, FlowBean, Text>{

        FlowBean bean = new FlowBean(); //在这里定义对象,避免对象被重复创建。
        Text v = new Text();

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //将读入的一行数据，转为String[]
            String line = value.toString();
            String[] fields = line.split("\t"); //根据Tab来切割一行数据。

            String phoneNumber = fields[0];//取出手机号
            long up = Long.parseLong(fields[1]);//取出上行流量
            long down = Long.parseLong(fields[2]);//取出下行流量

            bean.setAll(up,down);
            v.set(phoneNumber);

            context.write(bean, v); //把bean做为key输出至reduce,这样就可对其排序(reducer只会对key进行排序)。也就是对流量进行排序了。这样在bean中就要指定排序的方法。
        }
    }

    static class FlowSortReducer extends Reducer<FlowBean, Text, Text, FlowBean>{
        @Override
        protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

            //由mapper输出的key是bean对象,不会出现重复，所以reducer这里的values迭代器中只会有一个值。
            context.write(values.iterator().next(), key); //由于reducer默认会对key进行排序，所以这里就直接输出了。
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        //指定本程序的jar包所在的路径。
        job.setJarByClass(FlowSort.class);

        //告诉本业务job，要使用的mapper业务类和educer业务类
        job.setMapperClass(FlowSortMapper.class);
        job.setReducerClass(FlowSortReducer.class);

        //指定mapper输出的key和value类型。
        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);

        //指定最终输出的key和value类型。此处可理解为Reducer的输出类型。但不是所有程序都有Reducer的。
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //指定job输入原始文件的所在目录。HDFS中的路径。
        FileInputFormat.setInputPaths(job, new Path(args[1])); //通过运行jar包时，指定路径。

        //如果输出目录存在,则先进行删除。
        Path outPath = new Path(args[2]);
        FileSystem fs = FileSystem.get(conf);
        if (fs.exists(outPath)){
            fs.delete(outPath, true);
        }
        //指定job输出结果的所在目录.
        FileOutputFormat.setOutputPath(job, outPath);

        //等待集群运算结束，并打印出结果(true)。
        boolean res = job.waitForCompletion(true);

        System.exit(res?0:1); //如果运行成功，退出0，否则退出1.这里主要是给脚本进行判断用的。
    }
}
