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
		// ������Ĵ��ı��ļ�������ת����String

        String line = value.toString();
     // ��������������Ȱ��н��зָ�

        StringTokenizer tokenizerArticle = new StringTokenizer(line, "\n");
        while (tokenizerArticle.hasMoreElements()) {

            // ÿ�а��ո񻮷�

            StringTokenizer tokenizerLine = new StringTokenizer(tokenizerArticle.nextToken());
            String strName = tokenizerLine.nextToken();// ������������
            String strScore = tokenizerLine.nextToken();// �ҳ�����
        
            
        
        }
		
	}

}
