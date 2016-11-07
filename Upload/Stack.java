
public class Stack {

	private StackNode head;
	
	public Stack()
	{
		this.head=null;
	}
	
	public void push(Node n)
	{
		if(head==null)
		{
			StackNode x=new StackNode(n,null);
			head=x;
		}
		else
		{
			StackNode x= new StackNode(n,head);	
			head=x;
		}
	}
	
	public StackNode pop()
	{
		StackNode temp=null;
		if(isEmpty())
		{
			System.out.println("Empty Stack");
		}
		else
		{
			temp=head;
			head=temp.getNext();
			
		}
		return temp;
	}
	
	public boolean isEmpty()
	{
		return head==null;
	}
	
}

class StackNode
{

	Node data;
	StackNode next;
	public StackNode (Node data)
	{
		this.data=data;
		this.next=null;
	}
	public StackNode(Node data, StackNode n)
	{
		this.data=data;
		this.next=n;
	}
	
	public void setData(Node data)
	{
		this.data=data;		
	}
	public Node getData()
	{
		return this.data;
	}
	public void setNext(StackNode n)
	{
		this.next=n;
	}
	public StackNode getNext()
	{
		return this.next;
	}
	
}