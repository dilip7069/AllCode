
public class Egg {

   public static void main(String[] args)
   {
	   Egg e =new Egg();
	   e.eggDrop(2,100);
	   
   }
   public int eggDrop(int n, int k)
   {
	   int temp;
	    /* A 2D table where entery eggFloor[i][j] will represent minimum
	       number of trials needed for i eggs and j floors. */
	    int[][] eggFloor = new int[n+1][100+1];
	    int res;
	    int i, j, x;
	 
	    // We need one trial for one floor and0 trials for 0 floors
	    for (i = 1; i <= n; i++)
	    {
	        eggFloor[i][1] = 1;
	        eggFloor[i][0] = 0;
	    }
	    for (int p=0; p<=n;p++)
	    	for(int q=0;q<=k;q++)
	    		System.out.println("    "+ eggFloor[p][q]);
	 
	    // We always need j trials for one egg and j floors.
	    for (j = 1; j <= k; j++)
	        eggFloor[1][j] = j;
	 
	    // Fill rest of the entries in table using optimal substructure
	    // property
	    for (i = 2; i <= n; i++)
	    {
	        for (j = 2; j <= k; j++)
	        {
	            eggFloor[i][j] =999999;
	            for (x = 1; x <= j; x++)
	            {
	            	if(eggFloor[i-1][x-1]>eggFloor[i][j-x])
	            		temp=eggFloor[i-1][x-1];
	            		else 
	            			temp=eggFloor[i][j-x];
	                res = 1 + temp;
	                if (res < eggFloor[i][j])
	                    eggFloor[i][j] = res;
	            }
	        }
	    }
	 
	    System.out.println(eggFloor[n][k]);
	    
	    for (int p=0; p<=n;p++)
	    	for(int q=0;q<=k;q++)
	    		System.out.println("    "+ eggFloor[p][q]);
	    // eggFloor[n][k] holds the result
	    return eggFloor[n][k];
	}
	 
}
