package acgchenji;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AvgRedure extends
		Reducer<IntWritable, IntWritable, IntWritable, NullWritable> {

	protected void reduce(IntWritable arg0, Iterable<IntWritable> arg1,Context arg2)
			throws IOException, InterruptedException {
		           
		/*    for (IntWritable intWritable : arg1) {
				
		    	   System.out.println(arg0+"aaaaa"+intWritable);
			}
		*/
		arg2.write(arg0, NullWritable.get());
		
	}

}
