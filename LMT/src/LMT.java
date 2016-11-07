
public class LMT 
{

	public static void main(String[] args)
	{
		int x[]={1,3,2,4,2,6},temp[];
		LMT l=new LMT();
		temp=l.lmt(x);
		for(int i=0;i<temp.length;i++)
			System.out.print(temp[i]);
	}
	public int[] lmt(int [] x)
	{
		int[] temp=x;
		int sum=0;
		for(int i=0;i<temp.length;i++)
		{
			sum=sum+temp[i];
		}
		if(sum%3==0)
			return sort(temp);
		return temp;
	}
	public int[] sort(int[] y)
	{
		int[] x=y;
		int max,temp;
		for(int i=0;i<x.length-1;i++)
		{
			max=i;
			for(int j=i+1;j<x.length;j++)
			{
				if(x[j]>x[max])
				{
					max=j;
				}
			}
			temp=x[max];
			x[max]=x[i];
			x[i]=temp;
			
		}
		return x;
	}
}
