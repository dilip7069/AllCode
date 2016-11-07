import java.util.Scanner;


public class Nqueen {
public static void main(String[] args)
{
	Nqueen n = new Nqueen();
	int no;
	Scanner sc=new Scanner(System.in);
	no=Integer.parseInt(sc.nextLine());
	n.getIndexes(no);
	
}

public void getIndexes(int n)
{
	int ind=0;
	int[][] arr = new int[n][n];
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			arr[i][j]=0;
	int p=0;
	for(int i=0; i<n;)
	{
		ind=safeindex(i,p,arr,n);
		for(int q=0;q<n;q++)
		{
			for(int w=0;w<n;w++)
				System.out.print(arr[q][w]);
			System.out.println("");
		}
		System.out.println("i = "+i);		
		System.out.println("Ind"+ind);
		if(ind==-1)
		{
			i--;
			for(p=0;p<n;p++)
			{
				if(arr[i][p]==1)
				{
					arr[i][p]=0;
					if(p==n-1)
					{	i--;
					    for(int k=0;k<n;k++)
					    {
					    	if(arr[i][k]==1)
					    	{
					    		arr[i][k]=0;
					    		p=k+1;
					    		break;
					    	}
					    }
					   break;
					}
					else
					{
						p++;
						break;
					}
						
			    }
				
			}
		}
		else
		{
		p=0;
	    arr[i][ind]=1;
	    i++;
		}

	}
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
			System.out.print(arr[i][j]);
		System.out.println("");
	}
}

public int safeindex(int j,int k,int arr[][],int n)
{
	System.out.println("one"+j+"two"+k+"three"+n);
	boolean flag=true;
	int x=k;
  while(x<n)
  {
    flag=true;
	for(int p=0; p<n;p++)
	{
		if(arr[p][x]!=0)
		{
			flag=false;
			break;
		}
	}
	for(int i=j,p=x;i<n&&p<n&&flag;i++,p++)
	{
		if(arr[i][p]!=0)
		{
			flag=false;
			break;
		}	
	}
	for(int i=j,p=x;i<n&&p>0&&flag;i++,p--)
	{
		if(arr[i][p]!=0)
		{
			flag=false;
			break;
		}	
	}
	for(int i=j,p=x;i>0&&p<n&&flag;i--,p++)
	{	
		if(arr[i][p]!=0)
		{
			flag=false;
			break;
		}	
	}
	for(int i=j,p=x;i>-1&&p>-1&&flag;i--,p--)
	{
		if(arr[i][p]!=0)
		{
			flag=false;
			break;
		}	
	}
	if(flag)
		return x;
	else
		x++;
	}
  return -1;
}


}
