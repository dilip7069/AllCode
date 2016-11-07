package queue;

public class QueueImplementation {
private Node head;
private Node tail;

public QueueImplementation()
{
	this.head=null;
	this.tail=null;
}

public boolean isEmpty()
{
	return head==null;
}

public void enqueue(int data)
{
	if(isEmpty())
	{
		Node n=new Node(data,null);
		head=n;
		tail=n;
	}
	else
	{
		Node n=new Node(data,head);
		head=n;
	}
}
public void dequeue()
{
	int data;
	if(isEmpty())
	{
		System.out.println("Empty Queue");
		return ;
	}
	else if(head==tail)
	{
		data=tail.data;
		System.out.println("Deleted number is "+data);
		head=null;
		tail=null;
	}
	else
	{
		data=tail.data;
		tail=tail.next;
		System.out.println("Deleted number is "+data);
	}	
	return ;
}
public void traverse()
{
Node temp1=head,temp2=tail;
if(isEmpty())
{
	System.out.println("Empty Queue");
	return;
}
while(temp1!=temp2)
{
   System.out.println(temp1.data+"->");	
   temp1=temp1.next;
}

System.out.println(temp2.data);
}
}

class Node 
{

	int data;
	Node next;
	public Node (int data)
	{
		this.data=data;
	}
	public Node(int data, Node n)
	{
		this.data=data;
		this.next=n;
	}
	
	public void setData(int data)
	{
		this.data=data;		
	}
	public int getData()
	{
		return this.data;
	}
	public void setNode(Node n)
	{
		this.next=n;
	}
	public Node getNode()
	{
		return this.next;
	}
	
}