package Btree;

class QNode
{

	Node value;
	QNode next;
	public QNode (Node data)
	{
		this.value=data;
		this.next=null;
	}
	public QNode(Node data, QNode n)
	{
		this.value=data;
		this.next=n;
	}
	
	public void setValue(Node data)
	{
		this.value=data;		
	}
	public Node getValue()
	{
		return this.value;
	}
	public void setQNode(QNode addr)
	{
		this.next=addr;
	}
	public QNode getNode()
	{
		return this.next;
	}
	
}
