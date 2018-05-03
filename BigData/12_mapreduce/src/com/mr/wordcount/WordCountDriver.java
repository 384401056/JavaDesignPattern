package com.mr.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * 相当于一个yarn集群的客服端。
 * 需要在此封装我的mr程序的相关运行参数。指定jar包，最后提交给yarn。
 */
public class WordCountDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();
        //如果在是hadoop集群的机器上去运行此程序，则以下参数可以不设置
//        conf.set("mapreduce.framwork.name","yarn"); //设置使用yarn做为mapreduce的框架。
//        conf.set("yarn.resourcemanager.hostname","master"); //告诉job，yarn的主节点在哪台主机。
        Job job = Job.getInstance(conf);

        //指定本程序的jar包所在的路径。
//        job.setJar("/home/hadoop/myjob.jar");
        job.setJarByClass(WordCountDriver.class);

        //告诉本业务job，要使用的mapper业务类和educer业务类
        job.setMapperClass(WordCountMap.class);
        job.setReducerClass(WordCountReduce.class);

        //指定mapper输出的key和value类型。
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //指定最终输出的key和value类型。此处可理解为Reducer的输出类型。但不是所有程序都有Reducer的。
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //指定job输入原始文件的所在目录。HDFS中的路径。
//        FileInputFormat.setInputPaths(job, new Path("/wordcount/input"));
        FileInputFormat.setInputPaths(job, new Path(args[1])); //也可通过运行jar包时，指定路径。


        //指定job输出结果的所在目录.
        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        //将job中设置的相关参数，及java类所在的jar包，提交给yarn。
        //job.submit();

        //另一种提交方式，等待集群运算结束，并打印出结果(true)。
        boolean res = job.waitForCompletion(true);

        System.exit(res?0:1); //如果运行成功，退出0，否则退出1.这里主要是给脚本进行判断用的。

    }

}
