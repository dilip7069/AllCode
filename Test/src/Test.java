import java.util.Date;
public class Test {

	public static void main(String[] args)throws Exception
	{
		//FileReader fr=new FileReader("C:\\test.txt");
		//BufferedReader br=new BufferedReader(fr);
		//String line=br.readLine(),aa;
		/*for(;line!=null;)
		{
			StringTokenizer st = new StringTokenizer(line, ".");
			while(st.hasMoreTokens())
			{
			String r1=st.nextToken();
			aa=r1.substring(0, 1).toUpperCase() + r1.substring(1);
			System.out.println(aa);
		    }
			line=br.readLine();
		}*/
		/*for(int i=0;i<100;i++)
		{
			System.out.print(" "+ i+'\r');
		}*/
		/*Pattern p=Pattern.compile("a*");
		Matcher m=p.matcher("ab");
		boolean b=m.matches();
		System.out.println(b);
		System.out.println(m.pattern());
		*/
		/*Pattern p=Pattern.compile("\\s");
		String[] s= p.split("caabacabdcabwe");
		for(String s1:s)
		System.out.println(s1);
		*/
		/*Pattern p=Pattern.compile("ab?");
		Matcher m=p.matcher("ababcabcef");
		while(m.find())
		{
			System.out.println(m.start()+"..."+m.end()+"...."+m.group());
		}*/
		/*String s1=new String("durga");
		s1.concat("software");
		String s2=s1.concat("solutions");
		s2.concat("durga");
		System.out.println(s1);
		System.out.println(s2);
		*/
		/*String s1 = new String("gee gee gopo ra");
		int index = -1
		while()
		{
			
		}*/
		Date D = new Date();
		double x,y,l;
		int count;
		
		int p[]={10000,100000,1000000,10000000,100000000};
		for(int i=0;i<5;i++)
		{
			count=0;
			for(int j=0;j<p[i];j++)
			{
			x = Math.random();
			y = Math.random();
			l=Math.sqrt((x*x)+(y*y));
			if(l<=1)
				count++;
			}
			System.out.println("Pi/4 value is "+(double)count/p[i]);
		}
		System.out.println("Time Stamp:"+D.toString());
	}      	   
}
