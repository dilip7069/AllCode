package Btree;

public class Queue {
private QNode head;  //Pointer to the Head of the Queue(Newly Inserted Node).
private QNode tail;  //Pointer to the Tail of the Queue(Node to be Removed ).

public Queue()		 //Default Constructor
{
	this.head=null;
	this.tail=null;
}

public boolean isEmpty() 	//Checks if Queue is Empty
{
	return head==null;
}

public void enqueue(Node data)	//Insert Node into Queue
{
	if(isEmpty())				//IF Queue is Empty
	{
		QNode QN=new QNode(data,null);
		head=QN;
		tail=QN;
	}
	else						//IF Queue initiated before
	{
		QNode QN=new QNode(data);
		head.setQNode(QN);		//Updating pointer of QNode pointed by head to point to newly created Node
		head=QN;				//Updating Head
	}
}

public Node dequeue()	//Deleting Node from Queue(LIFO)
{
	Node data=null;		//Create a temporary Node
	if(isEmpty())		//Return if Queue is Empty
	{		
		return data;
	}
	else if(head==tail) //If only a single Node is present in the Queue.
	{
		data=tail.getValue();	//Get Node pointed by tail	
		head=null;				//Update Head Pointer
		tail=null;				//Update Tail Pointer		
		
	}
	else
	{
		data=tail.getValue(); //Get Node pointed by tail
		tail=tail.getNode();  //Update Tail Pointer		
	}	
	return data;
}

public void traverse()
{
	QNode temp1=head,temp2=tail;
	if(isEmpty())			//Check if Queue is Empty
	{	
	return;
	}
	while(temp1!=temp2)		//Until Both pointer point to same Node
	{
		System.out.println("data"+temp1.getValue().getData());	
		temp1=temp1.next;
	}
	System.out.println(temp2.getValue().getData());		//Print the last Node
}

}




