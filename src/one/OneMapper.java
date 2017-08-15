package one;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class OneMapper extends Mapper<Object, Text, Text, Text> {

	@Override
	protected void map(Object key, Text value,
			org.apache.hadoop.mapreduce.Mapper.Context context)
			throws IOException, InterruptedException {
		// 将输入的纯文本文件的数据转化成String

        String line = value.toString();
     // 将输入的数据首先按行进行分割

        StringTokenizer tokenizerArticle = new StringTokenizer(line, "\n");
        while (tokenizerArticle.hasMoreElements()) {

            // 每行按空格划分

            StringTokenizer tokenizerLine = new StringTokenizer(tokenizerArticle.nextToken());
            String strName = tokenizerLine.nextToken();// 孩子姓名部分
            String strScore = tokenizerLine.nextToken();// 家长部分
        
            
        
        }
		
	}

}
