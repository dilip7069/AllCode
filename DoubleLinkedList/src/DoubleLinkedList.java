 class Node {
	
	private int data;
	private Node next;
	private Node previous;
	public Node(int d,Node n,Node p)
	{
		data=d;
		next=n;
		previous=p;
	}
	public Node (int d)
	{
	    data=d;
	    next=null;
	}
	public void setData(int d)
	{
		data=d;
	}
	public int getData()
	{
		return data;
	}
	public void setNext(Node n)
	{
		next=n;
	}
	public Node getNext()
	{
		return next;
	}
	public void setPrevious(Node p)
	{
		previous=p;
	}
	public Node getPrevious()
	{
		return previous;
	}
}
public class DoubleLinkedList {
   protected Node head=null;
   protected int data;
   
   public void traverse()
	{
		Node temp=head;
		if (temp==null)
		System.out.println("List is empty");
		else
		while(temp!=null)
		{
			System.out.print(temp.getData()+"->");
			temp=temp.getNext();
		}
	}
   
    public int length()
	{
		Node temp=head;
		int length=0;
		while(temp!=null)
		{
			length++;			
			temp=temp.getNext();
		}
		return length;
	}
    
    public void insert(int position, int data)
    {
    	Node temp=null,next=head;
    	int length=length();
		if ((position>(length+1)||position<1))
		{
			System.out.println("Wrong position please enter any value between 1 to "+(length+1));							
		}
		if(position==1)
		{
			if(head==null)
			{	
			Node nptr=new Node(data,head,null);
			
			head=nptr;
			}
			else
			{
				Node nptr=new Node(data,head,null);
				head.setPrevious(nptr);
				head=nptr;
			}
		}
		else if(position==length+1)
		{
			while(next.getNext()!=null)
			{
				next=next.getNext();
			}
			Node nptr=new Node(data,null,next);
			next.setNext(nptr);
		}
		else
		{
			for(int i=1;i<position;i++)
			{
				temp=next;
				next=next.getNext();				
			}
			Node nptr=new Node(data,next,temp);
			temp.setNext(nptr);
			next.setPrevious(nptr);
		}
    }
    
    public void printreverse()
    {
    	Node temp=head;
    	while(temp.getNext()!=null)
    		temp=temp.getNext();
    	while(temp.getPrevious()!=null)
    	{
    		System.out.print(temp.getData()+"->");
    		temp=temp.getPrevious();
    	}
    }
    
    public void delete(int position)
    {
    	Node temp=null,next=head;
    	int length=length();
    	if ((position>(length)||position<1))
		{
			System.out.println("Wrong position please enter any value between 1 to "+length);							
		}
    	else if (position==1)
    	{
    		if(head.getNext()==null)
    		{
    			head=null;
    		}
    		else
    		{
    			head.getNext().setPrevious(null);
    			head=head.getNext();
    		}
    	}
    	else if (position==length)
    	{    		
    		while(next.getNext()!=null)
    		{
    			temp=next;
    			next=next.getNext();
    		}
    		temp.setNext(null);    		
    	}
    	else
    	{
    		for (int i=1;i<position;i++)
    		{
    			temp=next;
    			next=next.getNext();
    		}
    		temp.setNext(next.getNext());
    		temp.getNext().setPrevious(temp);
    	}
    }
   
}
