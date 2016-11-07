package SingleLinkedList;
import java.util.Scanner;
import java.util.Stack;
public class SLL {
	
	public static void main(String[] args)
	{
		int choice=0,value,value2;
		boolean flag;
		SLLImplementation S= new SLLImplementation();
		Scanner sc=new Scanner(System.in);
		do			
		{
		System.out.println("1.Insert into Linked List(At the Front)\n2.Insert after a  Particular Node\n3.Insert at End\n4.Delete a Node\n5.Delete at First Node of LL\n6.Traverse\n7.Get Nth Node\n8.Search\n9.Find Middle\n10.NthNode from End\n11.Delete LL\n12.Count number of times a number Occurs\n13.Reverse a LL\n14.Palindrome???\n15.Pair wise Swap\n16.Pair Wise delete\n17.Delete Node frm list if it has higher value on Right\n18.Reverse in Junks");
		choice=Integer.parseInt(sc.nextLine());	
		switch(choice)	
		{
		case 1:
		System.out.println("Enter the value to be inserted");
		value=Integer.parseInt(sc.nextLine());
		S.insert(value);
		break;
		case 2:
		System.out.println("Enter the reference node value");
		value2=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the value to be inserted");
		value=Integer.parseInt(sc.nextLine());
		flag=S.insertAt(value, value2);
		if(flag)
			System.out.println(value + "Inserted into LL");
		else
			System.out.println(value + "Not Found");
		break;
		case 3:
			System.out.println("Enter the value to be inserted");
			value=Integer.parseInt(sc.nextLine());
			S.insertAtEnd(value);
		break;
		case 4:
			System.out.println("Enter value to be deleted");
			value=Integer.parseInt(sc.nextLine());
			flag=S.deleteNode(value);
			if(flag)
			System.out.println("Node deleted");
			else
			System.out.println("Node with "+value+" not found");
		break;
		case 5:
			flag=S.deleteFirst(S.getHead());
			if(flag)
			  System.out.println("Node deleted");
			else
				System.out.println("Empty LL");
		break;
		case 6: 
			S.traverse();
		break;
		case 7:
			System.out.println("Enter the Node index");
			value=Integer.parseInt(sc.nextLine());
			S.getNthValue(value);
		break;
		case 8:
			System.out.println("Enter the value to be searched");
			value=Integer.parseInt(sc.nextLine());
            flag=S.search(value);
            if(flag)
            	System.out.println("Value  Found");
            else
            	System.out.println("Value Not Found");
         break;
		case 9:
			S.findMiddle();
		break;
		case 10:
			System.out.println("Enter the index from end");
			value=Integer.parseInt(sc.nextLine());
			S.nthNodeFromEnd(value);
		break;
		case 11:
			S.deleteLL();
			System.out.println("Linked List deleted");
		break;
		case 12:
			System.out.println("Enter the value for which you want to count occurence");
			value=Integer.parseInt(sc.nextLine());
			value2=S.countOccurence(value);
			System.out.println("Occurence of Number "+value+" is "+value2);
		break;
		case 13:
			S.reverseLL();
		break;
		case 14:
		flag=S.palindrome();
		if(flag)
			System.out.println("Given LL is a Palindrome");
		else
			System.out.println("LL is not a Palindrome");
		break;
		case 15:
			S.pairWiseSwap();
			System.out.println("Pair Wise Swap Completed");
		break;
		case 16: 
			S.deletePairwise();
			System.out.println("Deleted Pair Wise");
		break;
		case 17:
			S.deleteNodeWhichhasHigherValueonRight();
		break;
		case 18:
			System.out.println("Enter the size of Junks");
			value=Integer.parseInt(sc.nextLine());
			S.insert(8);
			S.insert(7);
			S.insert(6);
			S.insert(5);
			S.insert(4);
			S.insert(3);
			S.insert(2);
			S.insert(1);
			S.reverseInJunks(value);
			break;
		default:
		System.out.println("Wrong option");
		}
		}while(choice<100);
	}

}

class SLLImplementation
{
	Node head=null;
	
	public Node getHead()			//Return Head pointer
	{
		return this.head;
	}
	
	public void setHead(Node head)	//Update Head Pointer
	{
		this.head=head;
	}
	
	public void insert(int value)    // Inserting at the Head
	{
		Node n=new Node(head,value); // Create a Node 
		head=n;						 // Update Head Pointer
	}
	
	public boolean insertAt(int value, int value2)	//Insert value after value2 in LL
	{
		boolean flag=false;
		Node temp=head;
		while(temp!=null)
		{
			if(temp.getVal()==value2)	//If Value2 is found in LL update flag and break while loop
			{
				flag=true;
				break;
			}
			else						//If value2 is not found update temp pointer with next Node
			{
				temp=temp.getNext();
			}
		}
		if(flag)						//If value2 is present in LL insert value in LL after Value2
		{
			Node n = new Node(temp.getNext(),value);
			temp.setNext(n);
		}
		return flag;
	}
	
	public void insertAtEnd(int value)		// Insert value at end of LL.
	{
		Node temp=head;
		if(temp==null)						//If LL is Empty
		insert(value);
		else								//If LL is not empty
		{
		 while(true)						//Loop until end node is reached
		 {
			if(temp.getNext()==null)
				break;
			else
				temp=temp.getNext();
		 }
		 Node n = new Node(null,value);		// Add new Node at the end.
		 temp.setNext(n);
		}
	}
	
	public void traverse()
	{
		Node head=this.getHead();		//Get the current head
		if(isEmpty())					//Check if LL is empty
		{
			System.out.println("Empty Linked List");			
		}
		else							//Print LL
		{
			while(head!=null)			//Iterate until next pointer is null(End of LL).
			{
				System.out.print("->"+head.getVal());
				head=head.getNext();
			}
			System.out.println("");
		}
	}
	
	public boolean isEmpty()	//Returns true if head==null which means LL is Empty
	{
		return this.head==null;
	}
	
	public boolean deleteNode(int value)	//Delete a node with particular value
	{
		Node prev=null, curr=null;			//Take two pointers pointing to Current and previous Nodes
		if(isEmpty())						
			return false;
		else         						//If LL is not empty.
		{
			curr=this.getHead();			//Initialize current with head
			while(curr!=null)
			{
				if(curr.getVal()==value)	//If value equals current Node value
				{
					if(prev==null)			//If Previous node is null i.e., head node value matches
					{
						if(curr.getNext()!=null)	//If there is  next Node
						{
						curr.setVal(curr.getNext().getVal());
						curr.setNext(curr.getNext().getNext());
						return true;
						}
						else						//If there is no next Node
						{
							setHead(null);			//Set Head = null i.e., Deleting the only one existing node
							return true;	
						}
									
					}
					else							//If Previous not equals null
					{
						prev.setNext(curr.getNext());	//Update Previous Nodes next pointer to current node Next pointer
						return true;
					}
				}
				else
				{
					prev=curr;							//Update Current, Previous Nodes pointers
					curr=curr.getNext();
				}
			}
		}
		return false;
	}
	public int length(Node head)
	{
		Node temp=head;
		int count=0;
		while(temp!=null) //while temp!=null loop and increment count
		{
			count++;
			temp=temp.getNext();
		}
		return count;
	}
	public boolean deleteFirst(Node head)	//Delete First Node of the Linked List
	{
		Node temp=head;
		if(temp==null)						//Empty LL
			return false;
		else
		{
			if(temp.getNext()==null)		//LL with only one Node
			{
				setHead(null);
				return true;
				
			}
			else
			{
				setHead(temp.getNext());	//Update Head
				return true;
			}
		}
	}
	
	public void getNthValue(int value)   // Get Nth Node in the LL
	{
		Node temp=getHead();			//Store Head pointer in temp
		int max=length(getHead());		//Get length of LL in max
		if(value>max||value<1)			//If value >max or Max<1 invalid index
		{
			System.out.println("Wrong Index Entered");
			return;
		}
		else if(temp!=null)				//If LL is not Null
		{
			for(int i=2;i<=max;i++)		//Loop max-1 times 
			{
				if(max==1)				//If max = 1 temp pints to required Node
				{
					//System.out.println("Value at "+temp.getVal());
					break;
				}
				temp=temp.getNext();				
			}
		}
		else
		System.out.println("Empty LL");	
		System.out.println("Value at "+ value + " is "+temp.getVal());
	}
	
	public boolean search(int value)	//Returns true/false 
	{
		boolean flag=false;
		Node temp=getHead();
		while(temp!=null)
		{
			if(temp.getVal()==value)
			{
				flag=true;
				break;
			}
			temp=temp.getNext();
		}
		return flag;
	}
	
	public void findMiddle()
	{
		Node slptr=getHead(),ftptr=getHead();	//Slow pointer moves only one node forward and Fast pointer moves 2 steps
		while(ftptr!=null)
		{
			
			if(ftptr.getNext()!=null)
			{
				ftptr=ftptr.getNext();
				if(ftptr.getNext()==null)    // Even Number of Nodes
				{
					System.out.println("Middle values are "+slptr.getVal()+ " "+slptr.getNext().getVal());
					break;
				}
				ftptr=ftptr.getNext();
				slptr=slptr.getNext();
			}
			else	//If Fast pointer reaches end then print slow pointer value.
			{
				System.out.println("Middle values is "+slptr.getVal());
				break;
			}
			
		}
	}
	
	public void nthNodeFromEnd(int value)
	{
		Node first=getHead(),second=getHead();		//First pointer is moved n steps then second pointer is moved with first pointer
		if(first==null)								//At end when first pointer reaches end second pointer is at desired location
		{
			System.out.println("Empty LL");
			return;
		}
		for(int i=1;i<value;i++)
		{
			if(first.getNext()==null)
			{
				System.out.println("LL lenght is less than "+value);
				break;
			}
			first=first.getNext();
		}
		while(first.getNext()!=null)
		{
			second=second.getNext();
			first=first.getNext();
		}
		
		System.out.println(value+" value from end is "+second.getVal());
		
	}
	
	public void deleteLL()
	{
		setHead(null);
	}
	
	public int countOccurence(int value)
	{
		Node temp=getHead();
		int count=0;
		while(temp!=null)
		{
			if(temp.getVal()==value)
				count++;
			temp=temp.getNext();
		}
		return count;
	}
	
	public void reverseLL()
	{
		Node  curr, next;
		Node buf1;
		curr=getHead();  //  Points to Previous Node of the Node that is going to be swapped.
		if(curr==null)
		{
			System.out.println("Empty LL");
			return;
		}
		next=curr.getNext(); //Points to Node to be swapped.
		traverse();
		while(next!=null)	      //While There are Nodes to be swapped
		{
			buf1=next.getNext();  // Store the address of the next element of node to be swapped.
			next.setNext(getHead());	  // update next address of swapped Node to head. 
			curr.setNext(buf1);   // Update next address of Node Previous of swapped Node
			setHead(next);		  // Update Head 
			next=curr.getNext();  // Update next pointer. It should point to Node to be swapped.
			traverse();
		}	
	}
	
	public boolean  palindrome()
	{
		boolean flag=true;
		Stack<Integer> s = new Stack<Integer>();
		Node slptr=getHead(),ftptr=getHead();	//Slow pointer moves only one node forward and Fast pointer moves 2 steps
		while(ftptr!=null)
		{
			
			if(ftptr.getNext()!=null)
			{
				ftptr=ftptr.getNext();
				if(ftptr.getNext()==null)    // Even Number of Nodes
				{
					break;
				}
				ftptr=ftptr.getNext();
				if(ftptr==null)
				{
					break;
				}
				else{
					s.push(slptr.getVal());
				    slptr=slptr.getNext();
				}
			}
			else	
			{
				break;
			}
			
		}
		slptr=slptr.getNext();
		while(slptr!=null)
		{
			if(s.pop()!=slptr.getVal())
			{
				flag=false;
				break;
			}
			else
			{
				slptr=slptr.getNext();
			}
		}
		return flag;	
	}
	public void pairWiseSwap()
	{
		Node curr=getHead(),next;
		int buf1;
		while(curr!=null)
		{
			if(curr.getNext()==null)
			{
				break;
			}
			else
			{
				next=curr.getNext();
				buf1=curr.getVal();
				curr.setVal(next.getVal());
				next.setVal(buf1);			
			}
			curr=curr.getNext();
		}
	}
	public void deletePairwise()
	{
		Node curr=getHead(),next;

		while(curr!=null)
		{
			if(curr.getNext()==null)
			{
				break;
			}
			else
			{
				next=curr.getNext();
				curr.setNext(next.getNext());					
			}
			curr=curr.getNext();
		}
	}
	public void deleteNodeWhichhasHigherValueonRight()
	{
		Node curr=getHead(),next;
		int val;
		if(curr.getNext()==null)   //If Empty List
		{
			return;
		}
		while(curr.getNext()!=null)		//While there are more elements in Right
		{
			next=curr.getNext();		//Initialize next with Next element of current
				while(next!=null)		//Loop continues until there are more elements on right or we encounter higher value element on right than current
				{
					if(curr.getVal()>next.getVal())
					{
						next=next.getNext();		
					}
					else
					break;
				}			
			if(next!=null)  //End of loop is not reached this implies there is an element greater than current in ll to right of it.
			{
			
				while(curr!=next)  //delete the element including current to node before next, update curr to next
				{					
					val=curr.getVal();
					curr=curr.getNext();
					deleteNode(val);
				}

			}
			else          //Update cur pointer control reaches here because it did not find a value greater than curr in LL.
			{
				curr=curr.getNext();
			}
		}
	}
	
	public void reverseInJunks(int value)
	{
		Node prev=null,top=getHead(),end,temp1;
		boolean flag;
		while(top!=null)			//Loop continues until top is pointed to Null
		{   end=top;
			for(int i=1;i<value;i++)	//For loop is used to get end of current chunk (if not enough nodes are available last Node)
			{
				end=end.getNext();
				if(end==null)
					break;
			}
			flag=true;
			while(flag)						//While Flag is true
			{
				temp1=top.getNext();		//Get pointer to next node of top
				if(temp1==end)				//If temp1 == end only this node need to be rotated in current chunk
				{
					flag=false;
				}
				if(temp1==null||top==end)   //If temp1==null there is only one Node is current chunk so Break
				{
					break;
				}
				else if(temp1.getNext()==null)   //If there are no nodes beyond Temp1 in Linked List Swap nodes and break
				{
					if(prev==null)
					{
						top.setNext(temp1.getNext());
						temp1.setNext(getHead());
						setHead(temp1);		
						break;
					}
					else
					{
						top.setNext(temp1.getNext());
						temp1.setNext(prev.getNext());
						prev.setNext(temp1);
						break;
					}
					
				}
				else                                      //If there are more nodes beyond temp1 Node swap is done.
				{
					if(prev==null)
					{
						
						top.setNext(temp1.getNext());
						temp1.setNext(getHead());
						setHead(temp1);
					}
					else
					{

						top.setNext(temp1.getNext());
						temp1.setNext(prev.getNext());
						prev.setNext(temp1);
					}
				}		
			}
			prev=top;
			top=top.getNext();
		}
	}
	
}



class Node   //This class represents a Node in Single Linked List
{
	private Node next;	//This is a pointer used to point to the next Node 
	private int val;	//Variable used to store Integer value.
	Node()		//Default Constructor
	{
		this.next=null;
	}
	Node(Node pointer, int value)   //Constructor with initial value
	{
		this.next=pointer;
		this.val=value;
	}
	public int getVal()		//Returns current node value
	{
		return this.val;
	}
	public void setVal(int value)	//Sets current node value
	{
		this.val=value;
	}
	public Node getNext()	// Returns current Nodes next value. Which is a pointer to the next node.
	{
		return this.next;
	}
	public void setNext(Node pointer) 	//Sets Current Nodes next value i.e., pointer to the next node.
	{
		this.next=pointer;
	}
}
