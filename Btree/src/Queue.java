public class Queue {
private Nod head;
private Nod tail;

public Queue()
{
	this.head=null;
	this.tail=null;
}

public boolean isEmpty()
{
	return head==null;
}

public void enqueue(Node data)
{
	if(isEmpty())
	{
		Nod n=new Nod(data,null);
		head=n;
		tail=n;
	}
	else
	{
		Nod n=new Nod(data);
		head.setNode(n);		
		head=n;
	}
}
public Node dequeue()
{
	Node data=null;
	if(isEmpty())
	{
		//System.out.println("Empty Queue");
		return data;
	}
	else if(head==tail)
	{
		data=tail.data;		
		head=null;
		tail=null;
		traverse();
	}
	else
	{
		data=tail.getData();
		tail=tail.getNode();		
	}	
	return data;
}
public void traverse()
{
Nod temp1=head,temp2=tail;
if(isEmpty())
{
	//System.out.println("Empty Queue");
	return;
}
while(temp1!=temp2)
{
   System.out.println("data"+temp1.data.data);	
   temp1=temp1.next;
}

System.out.println(temp2.data);
}
}

class Nod
{

	Node data;
	Nod next;
	public Nod (Node data)
	{
		this.data=data;
		this.next=null;
	}
	public Nod(Node data, Nod n)
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
	public void setNode(Nod n)
	{
		this.next=n;
	}
	public Nod getNode()
	{
		return this.next;
	}
	
}