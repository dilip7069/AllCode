package Btree;

public class Stack {

	private SNode head;
	
	public Stack()
	{
		this.head=null;
	}
	
	public void push(Node n)
	{
		if(head==null)
		{
			SNode x=new SNode(n);
			head=x;
		}
		else
		{
			SNode x= new SNode(n,head);	
			head=x;
		}
	}
	
	public Node top()
	{
		return head.getData();
	}
	
	public Node pop()
	{
		SNode temp=null;
		if(isEmpty())
		{
			System.out.println("Empty Stack");
		}
		else
		{
			temp=head;
			head=temp.getNext();
			
		}
		return temp.getData();
	}
	
	public boolean isEmpty()
	{
		return head==null;
	}
	
}

