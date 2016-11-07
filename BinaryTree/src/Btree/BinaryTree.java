package Btree;
import java.util.Scanner;

public class BinaryTree {
	
	static int max=0,min=9999,size=0;
	public static void main(String[] args){
		int choice,val,path=0;
		boolean lf=true,flag;
		Node temp;
		System.out.println("1.Insert into tree\n2.Delete Tree\n3.PreOrderTraversal\n4.InOrderTraversal\n5.PostOrderTraversal\n6LevelOrderTraversal\n7.ZigZagTraversal\n8.Print EachLevel in a Seperate Line\n9.Sumtree\n10.MaxBstinBtree\n11.printAllRoottoLeafPaths\n12.findPathWithSum\n101.CreateDefaultTree");
		BtreeImplementation bTree=new BtreeImplementation();
		Scanner sc=new Scanner(System.in); 
		do
		{
		System.out.println("Enter your choice" );
		choice =Integer.parseInt(sc.nextLine());
		switch(choice)
		{
		case 1:System.out.println("Enter data");
		val=Integer.parseInt(sc.nextLine());
		bTree.insert(val);
		break;	
		case 3:bTree.preOrder(bTree.getHead());
		break;
		case 4:bTree.inOrder(bTree.getHead());
		break;
		case 5:bTree.postOrder(bTree.getHead());
		break;
		case 6:bTree.levelOrder(bTree.getHead());
		break;
		case 7:bTree.zigZagOrder(bTree.getHead());
		break;
		case 8:bTree.printLevelOrder(bTree.getHead());
		break;
		case 9:bTree.toSumTree(bTree.getHead());
		break;
		case 10:val=bTree.maxbstinbtree(bTree.getHead(), min, max, lf);
		System.out.println(val);
		break;
		case 11:bTree.printAllRoottoLeafPaths(bTree.getHead(),null);
		break;
		case 12:System.out.println("Enter Value");
		val=Integer.parseInt(sc.nextLine());
		flag=bTree.findPathWithSum(bTree.getHead(), path, val);
		if(flag)
			System.out.println("Path Exists");
		else 
			System.out.println("Path Does not exist");
		break;
		case 101:bTree.defaultTree();
		break;
		}
		}while(choice>=1&&choice<=101);
	}
}
class BtreeImplementation
{
	private Node head; //Pointer to the root of the tree
	
	public BtreeImplementation() 	//Default Constructor
	{
		head=null;
	}
	public Node getHead() 		   // Returns Current root of the Tree
	{
		return head;
	}
	public void insert (int data)  //Inserting New Nodes into Tree
	{
		Queue l=new Queue();	   //Queue to store Data
		Node temp;				   
		Node n=new Node(data);
		n.setLeft(null);
		n.setRight(null);
		if(head==null)				//Inserting into empty Tree
		{
			head=n;
			System.out.println("Root Node ="+data);
			return;
		}
		l.enqueue(head);			//Insert root of the tree into Queue		
		while(!l.isEmpty())			//Until Q becomes empty
		{			
			temp=l.dequeue();		//Get Node from Queue
			if(temp.getLeft()!=null)//If Node has Left child add it to the Queue
			{
				l.enqueue(temp.getLeft());				
			}			
			else					//If Node does not have a Left Child add Node as left Child
			{
				temp.setLeft(n);
				System.out.println(data+" "+"Set to left"+temp.getData());
				return;
			}
			if(temp.getRight()!=null)//If Node has Right child add it to the Queue
			{
				l.enqueue(temp.getRight());
				
			}
			else					//If Node does not have a Left Child add Node as left Child
			{  
				temp.setRight(n);
				System.out.println(data +" "+"Set to Right"+temp.getData());
				return;
			}						
		}
	}
	
	public void preOrder(Node root) //Left, Right, Node
	{
		if(root==null)				//Empty Tree
			return;
		Stack St=new Stack();		//Create Stack to Store Nodes
		while(true)
		{
			while(root!=null)							//Loop Until all the Left Nodes under current Node are inserted into Stack
			{
				System.out.println(root.getData()); 	//Print the Node and push it into Stack
				St.push(root);
				root=root.getLeft();					//Get the LeftNode of the Root
			}
			if(St.isEmpty())							//Break if Stack is Empty
			break;
			
			root=St.pop();
			root=root.getRight();						//Update root to Right of TOP when there are no more Left Nodes.
		}		
		return;
	}
	
	public void inOrder(Node root)		//Left Node Right
	{
		if(root==null)					//Check for Empty Tree
			return;
		Stack St=new Stack();			//Create Empty Stack 
		while(true)
		{
			while(root!=null)			//RUn this loop untill all the left nodes are put into Queue
			{
				St.push(root);
				root=root.getLeft();
			}
			if(St.isEmpty())			//Break if Stack is Empty
			break;
			root=St.pop();				//Get the top Element from the Stack
			System.out.println(root.getData());		//Print the Data
			root=root.getRight();					//Update Root Node with Right Node.
		}
		
	}
	
	public void postOrder(Node root)
	{
		if(root==null)
			return;
		Stack St=new Stack();
		while(true)
		{
			if(root!=null)
			{
				St.push(root);
				root=root.getLeft();
			}
			else 
			{
				if(St.isEmpty())
				return;
				else if(St.top().getRight()==null)
				root=St.pop();
				{
				System.out.println("1  " + root.getData());
				if(root==St.top().getRight())
				{
					System.out.println("2 " + St.top().getData());
					St.pop();
				}
				}
			
				if(!St.isEmpty())
				root=St.top().getRight();
				else
				root=null;
			}
		}
	}
	
	public void levelOrder(Node root)
	{
		Queue q=new Queue();		//Create Queue
		Node temp=root;
		if(temp==null)
		{
			System.out.println("Empty Treee");
			return;
		}
		else
		{
			q.enqueue(temp);		//Store Root Node in the Queue
			while(!q.isEmpty())
			{
				temp=q.dequeue();	//Get Node from the Queue
				System.out.println(temp.getData());
				if(temp.getLeft()!=null)	//Add LeftChild of the Node obtained Above
				{
					q.enqueue(temp.getLeft());
				}
				if(temp.getRight()!=null)	//Add RightChild of the Node obtained Above
				{
					q.enqueue(temp.getRight());
				}
			}
		}
	}
	
	public void printLevelOrder(Node root)
	{
		Queue q=new Queue();		//Create Queue
		Node temp=root;
		if(temp==null)
		{
			System.out.println("Empty Treee");
			return;
		}
		else
		{
			q.enqueue(temp);//Store Root Node in the Queue
			q.enqueue(null);//Store null to indicate First level Nodes are stored
			while(!q.isEmpty())
			{
				temp=q.dequeue();	//Get Node from the Queue
				if(temp==null)		//Null Indicates Current level Nodes are Processed
				{
					System.out.println();	//Print new Line				
					if(!q.isEmpty())		//If Queue is not Empty
					{
					q.enqueue(null);		//Add Null to Queue to indicate the next level of Nodes
					temp=q.dequeue();
					}
					else
					return;
				}
				System.out.println(temp.getData());
				if(temp.getLeft()!=null)	//Add LeftChild of the Node obtained Above
				{
					q.enqueue(temp.getLeft());
				}
				if(temp.getRight()!=null)	//Add RightChild of the Node obtained Above
				{
					q.enqueue(temp.getRight());
				}
			}
		}
	}
	
	public void zigZagOrder(Node root)      //Traverse Left to Right in one level and Right to Left in other Level.
	{
		Node temp=root;
		int LefttoRight=1;					//Use this flag to decide whether to store Right node/ Left node first in Stack.
		if(temp==null)						//Check if Tree is Null
			return;
		Stack ts;
		Stack cl=new Stack();				//Create Stack to store Current Level Nodes
		Stack nl=new Stack();				//Create Stack to Store Next Level Nodes
		cl.push(temp);						//Push the root Node to Current Level
		while(!cl.isEmpty())
		{
			temp=cl.pop();					//Get Top Element from Current Level and display
			System.out.println(temp.getData());
			if(LefttoRight==1)				//Use this flag to put into stack
			{
				if(temp.getLeft()!=null)
				{
					nl.push(temp.getLeft());
				}
				if(temp.getRight()!=null)
				{
				}
				nl.push(temp.getRight());
			}
			else
			{
				if(temp.getRight()!=null)
				{
					nl.push(temp.getRight());
				}	
				if(temp.getLeft()!=null)
				{
					nl.push(temp.getLeft());
				}
							
			}
			if(cl.isEmpty())	// Swap Stacks
			{
				LefttoRight=1-LefttoRight;
				ts=cl;
				cl=nl;
				nl=ts;			
			}
		}
	}
	
	public int toSumTree(Node root)
	{
	    // Base case
	    if(root == null)
	      return 0;
	 
	    // Store the old value
	    int old_val = root.getData();
	 
	    // Recursively call for left and right subtrees and store the sum as
	    // new value of this node
	    root.setData(toSumTree(root.getLeft())+toSumTree(root.getRight()));
	 
	    // Return the sum of values of nodes in left and right subtrees and
	    // old_value of this node
	    return  root.getData()+old_val;
	}
	public int maxbstinbtree(Node n,int min, int max, boolean lf )
	{
		int localmin, localmax;
		
		if(n.getLeft()==null)
		{
			return n.getData();
		}
		else
		{
			min=maxbstinbtree(n.getLeft(),min, max, true);
			max=maxbstinbtree(n.getRight(),min, max, false);
		}
		if (min<n.getData()&&max>n.getData())
		{
			System.out.println(min + " "+ max);
			if(lf==true)
				return min;
			else 
				return max;
		}
		else
		{
			System.out.println("outerloop"+min + " "+ max);
			if(lf==true)
				return 000;
			else 
				return 9999;
		}
		
	}
	
	public void printAllRoottoLeafPaths(Node root, String path)
	{
			path=path+"  "+root.getData();
			if(root.getLeft()!=null)
			printAllRoottoLeafPaths(root.getLeft(),path);
			if(root.getRight()!=null)
			printAllRoottoLeafPaths(root.getRight(),path);
			if(root.getRight()==null&&root.getLeft()==null) 
				System.out.println(path);
	}
	
	public boolean findPathWithSum(Node root, int path, int value)
	{
			boolean flag=false,flag1=false;
		    path=path+root.getData();
			if(root.getLeft()!=null)
			flag=findPathWithSum(root.getLeft(),path,value);
			if(root.getRight()!=null)
			flag1=findPathWithSum(root.getRight(),path,value);
			if((root.getRight()==null||root.getLeft()==null)&&path==value) 
				return true;
			return(flag||flag1);
	}
	
	public boolean 
	public void defaultTree()
	{
		 head=null;
		 insert(9);
	     insert(5);
	     insert(2);
	     insert(1);
	     insert(8);
	     insert(3);
	     insert(7);
	     insert(12);
	     insert(4);
	     insert(6);
	     insert(15);
	     insert(10);
	     insert(18);
	     insert(16);
	     insert(13);
	     insert(55);
	     System.out.println("9,5,20,15,30,3,7,2,4,6,8,10,18,32,35 inserted into tree");
	}
}

