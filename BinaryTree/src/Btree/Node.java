package Btree;

class Node
{
	private int data;
	private Node left=null;
	private Node right=null;
	
	public Node (int data)
	{
		this.data=data;
	}
	
	public void setData(int data)
	{
		this.data=data;
	}
	
	public int getData()
	{
		return this.data;
	}
	
	public void setLeft(Node left)
	{
		this.left=left;
	}
	
	public Node getLeft()
	{
		return this.left;
	}
	
	public void setRight(Node right)
	{
		this.right=right;
	}
	
	public Node getRight()
	{
		return this.right;
	}
}
