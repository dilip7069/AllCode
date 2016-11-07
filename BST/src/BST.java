import java.util.Scanner;
public class BST {
	 public static void main(String[] args){
		    int choice,data,data1;
		    boolean flag;
		    BSTImplementation b=new BSTImplementation();
	        Scanner sc=new Scanner(System.in);
	        System.out.println("1.Insert into tree \n2.InOrder Traversal\n3.Find\n4.Find Min\n5.FindMax\n6.Delete\n7.LCA");
			do
			{
			System.out.println("Enter your choice" );
			choice =Integer.parseInt(sc.nextLine());
			switch(choice)
			{
			case 1:System.out.println("Enter data");
			data=Integer.parseInt(sc.nextLine());
			b.insert(data);
			break;	
			case 2:b.traverse(b.getHead());
			break;
			case 3:System.out.println("Enter Number to be searched for");
			data=Integer.parseInt(sc.nextLine());
			flag=b.find(data,b.getHead());
			if(flag)
			System.out.println("Data Found");
			else
			System.out.println("Data Not Found");
			break;
			case 4:b.findmin();
			break;
			case 5:b.findmax();
			break;
			case 6: System.out.println("Enter data to be deleted");
			data=Integer.parseInt(sc.nextLine());			
			b.delete(b.getHead(),data);			
			break;
			case 7:System.out.println("Enter data");
			data=Integer.parseInt(sc.nextLine());			
			data1=Integer.parseInt(sc.nextLine());			
			Node temp=b.lca(b.getHead(),data,data1);
			System.out.println("LCA is"+temp.getData());
			case 8:System.out.println("Enter Minimum and Maximum values");
			data=Integer.parseInt(sc.nextLine());
			data1=Integer.parseInt(sc.nextLine());
			data=b.getdistbetween2givennodes(b.getHead(), data1, data);
			break;
			default:
			System.out.println("Wrong Option");
			break;
			}
			}while(choice>=1&&choice<=100);
		} 
}


class BSTImplementation{
	
	Node head=null;
	public Node getHead()
	{
		return this.head;
	}
	public void insert(int data)
	{
		Node temp=head;
		Node n=new Node(data);
		if(head==null)			
		{
			head=n;
			return;
		}
		else
		{
			while(temp!=null)
			{
				if(data<temp.getData())
				{
					if(temp.getLeft()==null)
					{
					   temp.setLeft(n);
					   return;
					}
					else
					temp=temp.getLeft();
				}
				else if(data>temp.getData())
				{
					if(temp.getRight()==null)
					{
						temp.setRight(n);
						return;
					}
					else
					temp=temp.getRight();
				}
			}
		}
	}
	public void traverse(Node n)
	{
		
		if(n==null)
			return;
		else
		{			
			traverse(n.getLeft());		
			System.out.println("->"+n.getData());
			traverse(n.getRight());			
		}
	}
	
	public boolean find(int data,Node n)
	{
		boolean flag=false;
		if(n==null)
		return false;
		else
		{
			if(n.getData()==data)
			{				
				return true;
			}
			else
			{
				if(data<n.getData())
				flag=find(data,n.getLeft());
				else if(data>n.getData()&&flag!=true)
				flag=find (data,n.getRight());
			}			
		}
		return flag;
	}
	
	public void findmin()
	{
		Node temp=head;
		if(head==null)
			System.out.println("Empty Tree");
		else
		{
			while(temp.getLeft()!=null)
			{
				temp=temp.getLeft();
			}
			System.out.println("Minimum value is "+temp.getData());			
		}
		
	}
	
	public void findmax()
	{
		Node temp=head;
		if(head==null)
			System.out.println("Empty Tree");
		else
		{
			while(temp.getRight()!=null)
			{
				temp=temp.getRight();
			}
			System.out.println("Maximum value is "+temp.getData());			
		}
		
	}
	
	public Node findmax(Node n)
	{
		Node temp=n;
		if(n==null)
		return null;
		else
		{
			while(temp.getRight()!=null)
			{
				temp=temp.getRight();
			}				
		}
		return temp;
	}
	

	public Node delete(Node n, int data)
	{
		Node temp;
		if(n==null)
		System.out.println("Element not there in tree");
		else if(n.getData()>data)
		{
			n.left=delete(n.getLeft(),data);
		}
		else if(n.getData()<data)
		{
			n.right=delete(n.getRight(),data);
		}
		else
		{
			if(n.getLeft()!=null&&n.getRight()!=null)
			{
				temp=findmax(n.getLeft());
				n.setData(temp.data);
				n.left=delete(n.getLeft(),temp.data);
				
			}
			else
			{
				temp=n;
				if(n.getLeft()==null)
					n=n.getRight();
				if(n.getRight()==null)
					n=n.getLeft();
			}
		}
		return n;
	}
	public Node lca(Node root,int data, int data1)
	{		
		Node n=root;
		while(true)
		{
			System.out.println("Hello");
			if(data<=n.getData()&&data1>=n.getData())
			return n;
			if(data>=n.getData()&&data1<=n.getData())
			return n;
			if(data<n.getData())
				n=n.getLeft();
			else
				n=n.getRight();
		}
	}
	
	public int getdistbetween2givennodes(Node root,int mx, int mn )
	{
		Node temp,temp1;int count=0;
		temp=lca(root, mn, mx);
		System.out.println("LCA is"+temp.getData());
		if(temp.getData()==mn)
		{
			temp=temp.getRight();
			count++;
			while(true)
			{
				if(mx>temp.getData())
				{
					temp=temp.getRight();
					count++;
				}
				else if(mx<temp.getData())
				{
					temp=temp.getLeft();
					count++;
				}
				else if( temp.getData()==mx )
				{
					return count;
				}
				
			}
		}
		else if(temp.getData()==mx)
		{
			temp=temp.getLeft();
			count++;
			while(true)
			{
				if( temp.getData()==mx )
				{
					return count;
				}
			   else if(mn>temp.getData())
				{
					temp=temp.getRight();
					count++;
				}
				else if(mn<temp.getData())
				{
					temp=temp.getLeft();
					count++;
				}	
			}
		}
		else
		{
			temp1=temp.getLeft();
			count++;
			while(true)
			{
				if(mn<temp1.getData())
				{
					temp1=temp1.getLeft();
					count++;
				}
				else if(mn>temp1.getData())
				{
					temp1=temp1.getRight();
					count++;
				}
				else if(mn==temp1.getData())
				{
					break;
				}
			}
			temp=temp.getRight();
			count++;
			while(true)
			{
				if(mx<temp.getData())
				{
					temp=temp.getLeft();
					count++;
				}
				else if(mn>temp.getData())
				{
					temp=temp.getRight();
					count++;
				}
				else if(mn==temp.getData())
				{
					break;
				}
			}
		}
		return count;
	}
	
}

class Node
{
	public int data;
	public Node left=null;
	public Node right=null;
	
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
