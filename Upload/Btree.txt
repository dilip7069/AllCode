import java.util.Scanner;
// 100 operations on a Binary Tree
public class Btree 
{

	    public static void main(String[] args){
	    int choice,data,data1;
		BtreeImplementation b=new BtreeImplementation();
        Scanner sc=new Scanner(System.in);       
        System.out.println("1.Insert into tree \n2.Delete \n3.Search \n4.Post Order Traverse \n5.Pre Order \n6.Inorder \n7.Levelorder \n8.Maximum of Tree \n9.Find Size of Tree"+
        		"\n10.LevelOrder Traversal in reverse \n11.Find Height \n12.Get Depest Node data \n13.Number of Leaf Nodes\n14.Number of Full Nodes\n15.Number of Half Nodes\n16.Diameter of Tree,\n17.Level that has Maximum \n18.Get all of its root to leaf paths\n19.Check for exixtance of a path with given sum \n20.Sum of all elements in binary tree \n21.Convert tree into Mirror binary tree\n22.Binary Tree Delete\n23. Print all ancestors of a given node\n24.Find LCA of given Nodes \n25.ZigZagTraversal\n26.Construct a Binary tree from given Inorder and pre order traversals"
        		+ "\n101.Default Insertion");
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
		case 2:
		System.out.println("Enter No to Delete");
		data=Integer.parseInt(sc.nextLine());
		b.delete(data);
		break;
		case 3: System.out.println("Enter No to search");
		data=Integer.parseInt(sc.nextLine());
		b.search(data);
		break;
		case 4: b.postorder();
		break;
		case 5: b.preorder();
		break;
		case 6: b.Inorder();
		break;
		case 7: b.levelorder();
		break;
		case 8: b.MaxofTree();
		break;
		case 9: data=b.SizeofTree();
		System.out.println("Size of the Tree is "+data);
		break;
		case 10:b.levelorderinreverse();
		break;
		case 11: data=b.height();
		System.out.println("Height of the Tree is "+data);
		break;
		case 12: data=b.depest();
		System.out.println("Depest Node is "+data);
		break;
		case 13: data=b.noofleafnodes();
		System.out.println("No of leaf nodes are "+data);
		break;
		case 14: data=b.nooffullnodes();
		System.out.println("No of Full nodes are "+data);
		break;
		case 15: data=b.noofhalfnodes();
		System.out.println("No of Half nodes are "+data);
		break;
		case 16:data=b.diameteroftree(b.getHead(),0);
		System.out.println("Diameter of tree is "+data);
		break;
		case 17:data=b.levelthathasmax(b.getHead());
		System.out.println("Level that has Max value is "+data);
		break;
		case 18: b.roottoleafpaths();
		break;
		case 19: System.out.println("Enter sum value to check on tree");
		data=Integer.parseInt(sc.nextLine());
		System.out.println(b.sumwithpath(data));
		break;
		case 20: System.out.println("Sum of all elements are "+b.sumofallnodes());
		break;
		case 21: b.MirrorTree(b.getHead());
		System.out.println("Converted to mirror tree");
		break;
		case 22: b.BinaryTreeDelete(b.getHead());
		System.out.println("Binary Tree Deleted");
		break;
		case 23: System.out.println("Enter Number to get ancestors");
		data=Integer.parseInt(sc.nextLine());
		b.printallancestors(b.getHead(),data);
		break;
		case 24: System.out.println("Enter Number 1");
		data=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Number 2");
		data1=Integer.parseInt(sc.nextLine());
		break;
		case 101:
			b.defaultinsert();
			break;
		default:
		System.out.println("Wrong Option");
		break;
		}
		}while(choice>=1&&choice<=101);
	} 
}

class BtreeImplementation
{
	private static final int INT_MIN = 0;
	private Node head=null;
	public Node getHead()
	{
		return this.head;
	}	
	public void defaultinsert()
	{
		 
	}
	public void BinaryTreeDelete(Node root)
	{
		if(root==null)
		{
			return;
		}
	
			BinaryTreeDelete(root.getLeft());
			BinaryTreeDelete(root.getRight());
			System.out.println(root.getData()+"Deleted");
			root=null;
	}
	public void insert (int data)
	{
		Queue l=new Queue();
		Node temp;
		Node n=new Node(data);
		n.setLeft(null);
		n.setRight(null);
		if(head==null)
		{
			head=n;
			System.out.println("Root Node ="+data);
			return;
		}
		l.enqueue(head);
		
		while(!l.isEmpty())
		{			
			if(temp.getLeft()!=null)
				temp=l.dequeue();
			{
				l.enqueue(temp.getLeft());				
			}			
			else{
				temp.setLeft(n);
				System.out.println(data+" "+"Set to left"+temp.data);
				return;
			}
			if(temp.getRight()!=null)
			{
				l.enqueue(temp.getRight());
				
			}
			else
			{  
				temp.setRight(n);
				System.out.println(data +" "+"Set to Right"+temp.data);
				return;
			}						
		}
	}	
	public void search(int data)
	{
		Queue q=new Queue();
		Node temp=head;
		if(head==null)
		{
			System.out.println("Empty tree");
			return;
		}
		q.enqueue(temp);
		while(!q.isEmpty())
		{
			temp=q.dequeue();
			if(temp.getData()==data)
			{
				System.out.println("Object Found");
				return;
			}
			if(temp.getRight()!=null)
				{
					q.enqueue(temp.getRight());
				}
		   if(temp.getLeft()!=null)
		   {
			   q.enqueue(temp.getLeft());
		   }
	   }
	System.out.println("Object Not Found");
	return;
	}				
	public void postorder()
	{
		if(head!=null)
		{
			postorder(head.getLeft());
			postorder(head.getRight());
			System.out.println(head.getData());
		}
	}	
	public void postorder(Node head)
	{
		if(head!=null)
		{
			postorder(head.getLeft());
			postorder(head.getRight());
			System.out.println(head.getData());
		}
	}	
	public void preorder()
	{
		Node temp=head;
		Stack s=new Stack();
		StackNode sn=null;
		if(temp!=null)
		s.push(temp);
		else
		{
			System.out.println("Empty Tree");
			return;
		}
		while(!s.isEmpty())
		{
			sn=s.pop();
			System.out.println(sn.getData().getData());
			if(sn.getData().getRight()!=null)
				s.push(sn.getData().getRight());
			if(sn.getData().getLeft()!=null)
				s.push(sn.getData().getLeft());
		}
		
	}
	public void Inorder()
	{
		Stack s=new Stack();
		StackNode sn;
		Node temp=head;
		if(temp==null)
		{
			System.out.println("Empty Tree");
			return;
		}
		else
		{
			
			while(true)
			{
				while(temp!=null)
				{
					s.push(temp);
					temp=temp.getLeft();
				}
				if(s.isEmpty())
				{
					break;
				}
				sn=s.pop();
				System.out.println(sn.getData().getData());
				temp=sn.getData().getRight();
			}
		}
	}	

	public void delete(int data)
	{
		int flag=0;
		Stack s=new Stack();
		StackNode SN=null,prev=null;
		Node temp=head;
		if(head==null)
		{
			System.out.println("Empty tree");
			return;
		}
		s.push(temp);		//insert root node to tree
		while(!s.isEmpty()&&flag==0)
		{
			SN=s.pop();
			if(SN.getData().getData()==data) //If Nodes data equals the number to be deleted
			{
				flag=1;   //update flag
				if(SN.getData().getLeft()==null&&SN.getData().getRight()==null)//incase if node is leaf node
					{
					   if(prev==null) //Incase if node is root node
					   {
						   head=null;
						   return;
					   }
					   if(prev.getData().getLeft()!=null&&prev.getData().getLeft().getData()==data)
						   prev.getData().setLeft(null);  //Updating Parent Node pointer
					   else if(prev.getData().getRight()!=null&&prev.getData().getRight().getData()==data)
						   prev.getData().setRight(null); //Updating Parent Node pointer
					}
				else //if Node is not a leaf Node get deepest node and replace in Node. 
				SN.data.setData(DeleteandGetDeepest(SN));
			}
			if(SN.getData().getLeft()!=null)
			{
				s.push(SN.getData().getLeft());
			}
			if(SN.getData().getRight()!=null) 
			{
				s.push(SN.getData().getRight());
			}
			prev=SN;
	   }
		if(flag==0)
		{
			System.out.println("Number Not found");
		}
	
	}
    public int DeleteandGetDeepest(StackNode s)
    {
	int flag=0;
	Stack s1=new Stack();
	StackNode SN=null,prev=null;
	s1.push(s.data);//Push Node to be deleted in to stack
	
	while(!s1.isEmpty()&&flag==0)
	{
		SN=s1.pop();
		if(SN.getData().getLeft()!=null)
		{
			s1.push(SN.getData().getLeft());
		}
		else if(SN.getData().getRight()!=null) 
		{
			s1.push(SN.getData().getRight());
		}
		if(SN.getData().getLeft()==null&&SN.getData().getRight()==null)
		{
			int data=SN.getData().getData();
			if(prev.getData().getLeft()!=null&&prev.getData().getLeft().getData()==data)
			 prev.getData().setLeft(null);
			 if(prev.getData().getRight()!=null&&prev.getData().getRight().getData()==data)
			 prev.getData().setRight(null);
			 flag=1;
			 return data;
		}
		
		prev=SN;
   }

	return 0;
}
    public void MaxofTree()
    {
    	Node temp=head;    	
    	int max=INT_MIN;
    	Queue q=new Queue();
    	if(temp==null)
    	{
    		System.out.println("Empty Tree");
    		return;
    	}
    	q.enqueue(temp);
    	while(!q.isEmpty())
    	{
    		temp=q.dequeue();
    		if(temp.getData()>max)
    		{
    			max=temp.getData();
    		}
    		if(temp.getLeft()!=null)
    		{
    			q.enqueue(temp.getLeft());
    		}
    		if(temp.getRight()!=null)
    		{
    			q.enqueue(temp.getRight());
    		}

    	}
    	System.out.println("Max value in tree is "+max);
    }
    public int SizeofTree()
    {
    	Node temp=head;    	
    	int count=0;;
    	Queue q=new Queue();
    	if(temp==null)
    	{
    		System.out.println("Empty Tree");
    		return count;
    	}
    	q.enqueue(temp);
    	while(!q.isEmpty())
    	{
    		count++;  
    		temp=q.dequeue();
    		if(temp.getLeft()!=null)
    		{
    			q.enqueue(temp.getLeft());
    		}
    		if(temp.getRight()!=null)
    		{
    			q.enqueue(temp.getRight());
    		}
    	}
    	return count;
    }
    public void levelorderinreverse()
    {
    	Queue q=new Queue();
    	Stack s=new Stack();
		Node temp=head;
		if(temp==null)
		{
			System.out.println("Empty Treee");
			return;
		}
		else
		{
			q.enqueue(temp);
			while(!q.isEmpty())
			{
				temp=q.dequeue();
				s.push(temp);
				if(temp.getLeft()!=null)
				{
					q.enqueue(temp.getLeft());
				}
				if(temp.getRight()!=null)
				{
					q.enqueue(temp.getRight());
				}
			}
		}
		while(!s.isEmpty())
		{
			System.out.println(s.pop().getData().getData());
		}
	}
    public int height()
    {
    	int level=0;
    	Node temp=head;
    	Queue q=new Queue();
    	if(temp==null)
    	{
    		return 0;
    	}
    	else
    	{
    		q.enqueue(temp);
    		q.enqueue(null);
    		while(!q.isEmpty())
    		{
    			temp=q.dequeue();
    			if(temp==null)
    			{
    				if(!q.isEmpty())    				
    				q.enqueue(null);
    				level++;
    			}
    			else
    			{
    				if(temp.getLeft()!=null)
    				{
    					q.enqueue(temp.getLeft());
    				}
    				if(temp.getRight()!=null)
    				{
    					q.enqueue(temp.getRight());
    				}
    			}
    		}
    	}
    	return level;
    }
    public int depest()
    {
    	Node temp=head;    	    	
    	Queue q=new Queue();
    	if(temp==null)
    	{
    		System.out.println("Empty Tree");
    		return -1;
    	}
    	q.enqueue(temp);
    	while(!q.isEmpty())
    	{
    		temp=q.dequeue();    		
    		if(temp.getLeft()!=null)
    		{
    			q.enqueue(temp.getLeft());
    		}
    		if(temp.getRight()!=null)
    		{
    			q.enqueue(temp.getRight());
    		}

    	}
    	return temp.getData();
    }
    public int noofleafnodes()
   {
	int count=0;   
	Node temp=head;    	    	
   	Queue q=new Queue();
   	if(temp==null)
   	{
   		System.out.println("Empty Tree");
   		return count;
   	}
   	q.enqueue(temp);
   	while(!q.isEmpty())
   	{
   		temp=q.dequeue();   
   		if(temp.getLeft()==null&&temp.getRight()==null)
   		{
   			count++;
   		}
   		else
   		{
   		if(temp.getLeft()!=null)
   		{
   			q.enqueue(temp.getLeft());
   		}
   		if(temp.getRight()!=null)
   		{
   			q.enqueue(temp.getRight());
   		}
   	    }   		
   	}
   	return count;
   }
   public int nooffullnodes()
   {
	   int count=0;   
		Node temp=head;    	    	
	   	Queue q=new Queue();
	   	if(temp==null)
	   	{
	   		System.out.println("Empty Tree");
	   		return count;
	   	}
	   	q.enqueue(temp);
	   	while(!q.isEmpty())
	   	{
	   		temp=q.dequeue();   
	   		if(temp.getLeft()!=null&&temp.getRight()!=null)
	   		{
	   			count++;
	   		}	   		
	   		if(temp.getLeft()!=null)
	   		{
	   			q.enqueue(temp.getLeft());
	   		}
	   		if(temp.getRight()!=null)
	   		{
	   			q.enqueue(temp.getRight());
	   		} 		
	   	}
	   	return count;
   }
   public int noofhalfnodes()
   {
	   int count=0;   
		Node temp=head;    	    	
	   	Queue q=new Queue();
	   	if(temp==null)
	   	{
	   		System.out.println("Empty Tree");
	   		return count;
	   	}
	   	q.enqueue(temp);
	   	while(!q.isEmpty())
	   	{
	   		temp=q.dequeue();   
	   		if(temp.getLeft()!=null&&temp.getRight()==null||temp.getLeft()==null&&temp.getRight()!=null)
	   		{
	   			count++;
	   		}	   		
	   		if(temp.getLeft()!=null)
	   		{
	   			q.enqueue(temp.getLeft());
	   		}
	   		if(temp.getRight()!=null)
	   		{
	   			q.enqueue(temp.getRight());
	   		} 		
	   	}
	   	return count;
   }
   public int diameteroftree(Node root, int diameter)
   {
	   int left,right;
	   if (root==null) return 0;
	   else
	   {
		   left=diameteroftree(root.getLeft(),diameter);
		   right=diameteroftree(root.getRight(),diameter);
		   if(left+right>diameter)
			   diameter=left+right;
		   return Math.max(left, right)+1;
	   }
   }
   public int levelthathasmax(Node root)
   {
	int maxlevel=0,maxval=0,level=0;
	Node temp=root;
   	Queue q=new Queue();
   	if(temp==null)
   	{
   		return 0;
   	}
   	else
   	{
   		q.enqueue(temp);
   		q.enqueue(null);
   		while(!q.isEmpty())
   		{
   			temp=q.dequeue();
   			if(temp!=null&&temp.getData()>maxval)
   			{
   				maxval=temp.getData();
   				maxlevel=level;
   			}
   			if(temp==null)
   			{
   				if(!q.isEmpty())    				
   				q.enqueue(null);
   				level++;
   			}
   		
   			else
   			{
   				if(temp.getLeft()!=null)
   				{
   					q.enqueue(temp.getLeft());
   				}
   				if(temp.getRight()!=null)
   				{
   					q.enqueue(temp.getRight());
   				}
   			}
   		}
   	}
   	return level;
   }
   public void roottoleafpaths()
   {
	   int[] path=new int[256];
	   roottoleafpaths(head,path,0);
   }
   public void roottoleafpaths(Node root, int[] path, int pathLen)
   {
	   if(root==null)
		   return;
	   path[pathLen]=root.getData();
	   pathLen++;
	   if(root.getLeft()==null&&root.getRight()==null)
	   {
		   printArray(path,pathLen);
	   }
	   else
	   {
		   roottoleafpaths(root.getLeft(),path,pathLen);
		   roottoleafpaths(root.getRight(),path,pathLen);
	   }
   }
   private void printArray(int[] ints, int len)
   {
	   for (int i=0;i<len;i++)
		   System.out.print(ints[i]+"->");
	   System.out.println(" ");
	   
   }
   public boolean sumwithpath(int sum)
   {
	   return sumwithpath(head,sum);
   }  
   public boolean sumwithpath(Node root, int sum)
   {
	   if(root==null)
		   return sum==0;
	   else
	   {
		   int subsum=sum-root.getData();
		   return(sumwithpath(root.getLeft(),subsum)||sumwithpath(root.getRight(),subsum));
	   }
   }
   public int sumofallnodes()
   {
	   int sum=0;
	   Stack s=new Stack();
	   Node temp=head;
	   if(temp==null)
		   return 0;
	   else
	   {
		   s.push(temp);
		   while(!s.isEmpty())
		   {
			  temp=s.pop().data;
			  sum=sum+temp.getData();
			  if(temp.getLeft()!=null)
			  {
				  s.push(temp.getLeft());
			  }
			  if(temp.getRight()!=null)
			  {
				  s.push(temp.getRight());
			  }			  
			   
		   }
	   }
	   return sum;
   }
   public Node MirrorTree(Node root)
   {
	   Node temp;
	   if(root!=null)
	   {
		   MirrorTree(root.getLeft());
		   MirrorTree(root.getRight());
		   temp=root.getLeft();
		   root.setLeft(root.getRight());
		   root.setRight(temp);		   
	   }
	   return root;	   
   }
   public int printallancestors(Node root,int data)
   {
	   int flag=0;
	   if(root==null)
		   return 0;
	   else
	   {
		   if(root.getData()==data)
		   {
			   System.out.println(root.getData());
			   return 1;
		   }
		   else
		   {
			   flag=printallancestors(root.getLeft(),data);
			   if(flag==1)
			   {
				   System.out.println(root.getData());
				   return flag;
			   }

			   flag=printallancestors(root.getRight(),data);
		   
			   if(flag==1)
			   {
				   System.out.println(root.getData());
				   return flag;
			   }
		   }   
	   }
	   return flag;
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
