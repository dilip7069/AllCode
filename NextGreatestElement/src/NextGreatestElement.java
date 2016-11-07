import java.util.NoSuchElementException;

public class NextGreatestElement {
	
	public  static void main(String[] args)
	{
		System.out.println("Hello");
		NextGreatestElement e=new NextGreatestElement();
		int x[]={7,1,2,3,4,5,6};
		e.NGE(x);		
	}

	public void NGE(int[] x)
	{
		Stk t=new Stk();
		t.push(x[0]);
		for(int i=1;i<x.length;i++)
		{			
			if(!t.isEmpty()&&t.peek()<x[i])
			{
				System.out.println(t.pop()+"'s Next Greatest Element is "+x[i]);
				
				while(!t.isEmpty()&&t.peek()<x[i])
				{
					System.out.println(t.pop()+"'s Next Greatest Element is "+x[i]);										
				}
					t.push(x[i]);				
			}
			else 
			{
				t.push(x[i]);
			}			
				
		  }
		while(!t.isEmpty())
		{
			System.out.println(t.pop()+"'s Next Greatest Element is -1");
		}
	}
}


class Node
{
    protected int data;
    protected Node link;
    /*  Constructor  */
    public Node()
    {
        link = null;
        data = 0;
    }    
    /*  Constructor  */
    public Node(int d,Node n)
    {
        data = d;
        link = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}
 
/*  Class Stk  */
class Stk
{
    protected Node top ;
    protected int size ;
 
    /*  Constructor  */
    public Stk()
    {
        top = null;
        size = 0;
    }    
    /*  Function to check if stack is empty */
    public boolean isEmpty()
    {
        return top == null;
    }    
    /*  Function to get the size of the stack */
    public int getSize()
    {
        return size;
    }    
    /*  Function to push an element to the stack */
    public void push(int data)
    {
        Node nptr = new Node (data, null);
        if (top == null)
            top = nptr;
        else
        {
            nptr.setLink(top);
            top = nptr;
        }
        size++ ;
    }    
    /*  Function to pop an element from the stack */
    public int pop()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception") ;
        Node ptr = top;
        top = ptr.getLink();
        size-- ;
        return ptr.getData();
    }    
    /*  Function to check the top element of the stack */
    public int peek()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception") ;
        return top.getData();
    }    
    /*  Function to display the status of the stack */
    public void display()
    {
        System.out.print("\nStack = ");
        if (size == 0) 
        {
            System.out.print("Empty\n");
            return ;
        }
        Node ptr = top;
        while (ptr != null)
        {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getLink();
        }
        System.out.println();        
    }
}