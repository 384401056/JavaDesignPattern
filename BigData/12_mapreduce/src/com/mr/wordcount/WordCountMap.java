package com.mr.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Mapper的四个泛型分别代表：KeyIN, ValueIn, KeyOut, ValueOut.
 * KeyIn : 代表mr框架所读取到的每一行文本的偏移量,此处为long类型。在hadoop中有自己的精简序列化接口，所以此处用LongWritable.
 * ValueIn : 代表mr框架所读取到的每一行文本的内容，此处为String类型。同上，用Text
 *
 * KeyOut: 代表map程序输出(即reduce程序的输入)的key,此处是单词 String类型。
 * ValueOut: 代表map程序输出的value, 此处是统计的单词次数,为Integer。
 */
public class WordCountMap extends Mapper<LongWritable, Text, Text, IntWritable> {

    /**
     * 重写Mapper中的map方法。
     * map中的业务逻辑就写在这个方法中。maptask会每输入一行数据就会调用一次map方法。
     * @param key
     * @param value
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //将输入的一行数据，转为String
        String line = value.toString();
        //根据空格，将String分割成String数组
        String[] words = line.split(" ");

        //因为map方法每输入一行数据就调一次，所以这里是做不了统计的，只是简单的输出 <单词，1> 这样的键值对，在后的同reduce程序会去做统计。
        for(String word:words){
            //将word转为Text, 将1转为IntWritable,输出至reduce程序。
            context.write(new Text(word), new IntWritable(1));
        }
    }
}


















