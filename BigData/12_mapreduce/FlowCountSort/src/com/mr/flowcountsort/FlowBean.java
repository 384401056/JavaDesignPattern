package com.mr.flowcountsort;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 实现WritableComparable<>序列化接口，可以设置当FlowBean做为mapper输出的key时的排序方法。
 */
public class FlowBean implements WritableComparable<FlowBean> {

    private long upFlow;
    private long downFlow;
    private long sumFlow;

    //反序列化时，需要反射调用一个空参构造函数，所以要显示的声明一个。
    public FlowBean(){};

    public FlowBean(long upFlow, long downFlow) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = upFlow + downFlow;
    }

    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(long downFlow) {
        this.downFlow = downFlow;
    }

    public long getSumFlow() {
        return sumFlow;
    }

    /**
     * 设置所有属性
     * @param upFlow
     * @param downFlow
     */
    public void setAll(long upFlow, long downFlow){
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = upFlow + downFlow;
    }

    /**
     * 序列化方法,当将FlowBean对象传递出去时执行的方法。
     *
     * @param dataOutput 输出流
     * @throws IOException
     */
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upFlow); //将upFlow字段写入流中。
        dataOutput.writeLong(downFlow);
        dataOutput.writeLong(sumFlow);
    }

    /**
     * 反序列化方法,当收到序列化数据后组装FlowBean对象时调用的方法。
     * 注意：反序列化的顺序要与序列化的顺序一致。
     *
     * @param dataInput 输入流
     * @throws IOException
     */
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        //反序列化的顺序要与序列化的顺序一致。先是upFlow,后是downFlow
        this.upFlow = dataInput.readLong(); //从输入流中读取long类型长度的字节，转为一个long类型的变量。
        this.downFlow = dataInput.readLong();
        this.sumFlow = dataInput.readLong();
    }

    /**
     * 当reduce程序输出FlowBean时，会调用toString()方法，所以这里要重写一下输出格式。
     * @return
     */
    @Override
    public String toString() {
        return this.upFlow+"\t"+this.downFlow+"\t"+this.sumFlow;
    }

    /**
     * 排序的方法
     * @param obj
     * @return
     */
    @Override
    public int compareTo(FlowBean obj) {
        //当前bean大于输入bean时，返回-1，否则返回1.
        if (this.sumFlow>obj.getSumFlow()){
            return -1;
        }
        return 1;
    }
}
