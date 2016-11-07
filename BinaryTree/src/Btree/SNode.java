package Btree;

class SNode
{

	Node data;
	SNode next;
	public SNode (Node data)
	{
		this.data=data;
		this.next=null;
	}
	public SNode(Node data, SNode n)
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
	public void setNext(SNode n)
	{
		this.next=n;
	}
	public SNode getNext()
	{
		return this.next;
	}
	
}