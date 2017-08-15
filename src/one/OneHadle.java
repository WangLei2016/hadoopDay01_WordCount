package one;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import acgchenji.AvgHadle;
import acgchenji.AvgMapper;
import acgchenji.AvgRedure;

public class OneHadle {
      public static void main(String[] args) throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException {
		
    	   Configuration conf = new Configuration();//这里创建conf对象有一个默认参数，boolean loadDefaults，默认为true
    	   System.setProperty("hadoop.home.dir", "C:\\Users\\Administrator\\Desktop\\hadoop\\hadoop-2.6.5");
    	        
    	        conf.set("mapred.job.tracker", "192.168.96.128:9001");
    	      String[] otherArgs={"/home/avg成绩/","/home/123321/"};
    	      if(otherArgs.length < 2) {
    	          System.err.println("Usage: wordcount <in> [<in>...] <out>");
    	          System.exit(2);
    	      }

    	      Job job = Job.getInstance(conf, "avgchenji");
    	      job.setJarByClass(AvgHadle.class);
    	      job.setMapperClass(AvgMapper.class);
    	     // job.setCombinerClass(WordCount.IntSumReducer.class);
    	     
    	      job.setReducerClass(AvgRedure.class);
    	      //设置输出类型
    	      job.setOutputKeyClass(IntWritable.class);
    	      job.setOutputValueClass(IntWritable.class);
    	      
    	      
    	      //设置输入和输出目录

    	      FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
    	      
    	      Path path = new Path(otherArgs[otherArgs.length - 1]);
    	      FileSystem fs = FileSystem.get(conf);
    	      if( fs.exists(path)){
    	     	 fs.delete(path);
    	      }
    	      FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

    	      System.exit(job.waitForCompletion(true) ? 0 : 1);
    	      
    	      
    	      
    	      
    	      
    	  	
      	 }	
    	  
	
}
