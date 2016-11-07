package Ass7;
import java.io.*;
import java.util.regex.*;

public class CNDP {
	
	public static void main(String[] args) throws Exception
	{
		String temp;
		System.out.println("Hello");
		File f =new File("C:\\death_penality.csv");
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		FileReader fr=new FileReader("C:\\death penality");
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();				
		for(int i=1;line!=null;i++)
		{
			String[] s1=line.split("[ ]");
			int p=1;
			for(String s2:s1)
			{
				if(Integer.parseInt(s2)==1)
				{
					p++;
					temp=""+i+","+p;	
					System.out.println(temp);
					bw.write(temp);
					bw.newLine();
					
				}
				else
				{
					p++;
				}
			}
		line=br.readLine();
		}
	}

}
