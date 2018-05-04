package com.mr.wordcount;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Text, IntWritable 与mapper程序的输出对应。
 * Text, IntWritable 与Reducer处理后的想得到的输出结果对应。
 */
public class WordCountReduce extends Reducer<Text, IntWritable, Text, IntWritable> {

    /**
     * 每一组相同的<k,v>就会调用一次reduce方法
     * @param key mapper程序输出的key,在这里是一组相同的单词的key 如：<hello,1><hello,1><hello, 1>, 这里的key就是hello
     * @param values  mapper程序输出的value的可迭代对象 如：<hello,1><hello,1><hello, 1>，这里的values就是[1,1,1]
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;

        //迭代获取一个key的总数。
        for(IntWritable value:values){
            count+=value.get();
        }

        context.write(key, new IntWritable(count));
    }
}
