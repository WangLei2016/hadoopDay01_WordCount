package acgchenji;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

public class AvgMapper extends Mapper<LongWritable, Text, IntWritable  , IntWritable> {
	private static IntWritable data=new IntWritable();
	@Override
	protected void map(LongWritable key, Text value,
			org.apache.hadoop.mapreduce.Mapper.Context context)
					throws IOException, InterruptedException {
		
		 				 String string = value.toString();
		 				if(string.equals("")){
		 				System.out.println("×Ö·û´®Îª¿Õ");	
		 				}else{
		 				
		 				data.set(Integer.parseInt(string));
		 				  System.out.println(">>>>>>>>>>>>.."+string);
		 				 context.write(data,new IntWritable(1));
		 				
		 				}
	}



}
