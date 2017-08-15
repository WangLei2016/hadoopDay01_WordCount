package org.apache.hadoop.example1;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//reduce将输入中的key复制到输出数据的key上，并直接输出

public  class Reduce extends Reducer<Text,Text,Text,Text>{

    //实现reduce函数

    public void reduce(Text key,Iterable<Text> values,Context context)

            throws IOException,InterruptedException{
       
        
        Iterator i$ = values.iterator();
        while(i$.hasNext()){
         String str = (String) i$.next();
         System.out.println("11111111111111"+str);
        }
        context.write(key, new Text(""));

    }

   

}