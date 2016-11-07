public class Node {
	
	private int data;
	private Node next;
	public Node(int d,Node n)
	{
		data=d;
		next=n;
	}
	public Node (int d)
	{
	    data=d;
	    next=null;
	}
	public void setData(int d)
	{
		data=d;
	}
	public int getData()
	{
		return data;
	}
	public void setNext(Node n)
	{
		next=n;
	}
	public Node getNext()
	{
		return next;
	}
}

class SingleLinkedList
{

	protected Node head=null;
	protected int data;
	
	public void traverse()
	{
		Node temp=head;
		if (temp==null)
		System.out.println("List is empty");
		else
		while(temp!=null)
		{
			System.out.print(temp.getData()+"->");
			temp=temp.getNext();
		}
	}
	
	public void reverseinchunks(int chunks)
	{
		Node master=head,previoushead=null;
		
		boolean flag=true;
		if(head==null)
		{
			System.out.println("Empty LL");
			return;
		}
		else
		{
			outerloop:
			while(master.getNext()!=null)
			{
				Node currhead=master,currtail=master,temp,temp1;
				for(int i=1;i<chunks;i++)
				{
					temp=currtail.getNext();
					temp1=temp.getNext();
					temp.setNext(currhead);
					currhead=temp;
					currtail.setNext(temp1);
					System.out.println("From loop1");
				}
				for(int i=1;i<=chunks;i++)
				    {
				    	
				    	if(currtail.getNext()!=null)
				    	{
				    	currtail=currtail.getNext();
				    	System.out.println("From loop2"+currtail.getData());
				    	}
				    	else
				    	{
				    		break outerloop;
				    	}
				    }
				if(flag==true)
				{
				head=currhead;	
				previoushead=currtail;
				flag=false;
				}
				else
				{
			     previoushead.setNext(currhead);
			     previoushead=currtail;
				}
			   
			    master=currtail;
			}
		}
	}
	public int length()
	{
		Node temp=head;
		int length=0;
		while(temp!=null)
		{
			length++;			
			temp=temp.getNext();
		}
		return length;
	}
	
	public void insert(int position, int data)
	{
		int length=length();
		if ((position>(length+1)||position<1))
		{
			System.out.println("Wrong position please enter any value between 1 to "+(length+1));							
		}
		else
		{
			if(position==1)
			{
				Node nptr = new Node(data,head);
				head=nptr;				
			}
			else if (position==(length+1))
			{
				Node temp=head;
				while(temp.getNext()!=null)
				{
					temp=temp.getNext();
				}
				Node nptr=new Node(data,null);
				temp.setNext(nptr);
			}
			else
			{
				Node temp=null,next=head;
				for (int i=1;i<position;i++)
				{   
					temp=next;
					next=temp.getNext();					
				}
				Node nptr=new Node(data,next);
				temp.setNext(nptr);
			}
		}
		
	}
	public void delete(int data)
	{
		Node temp=null,next=head;
		while(next.getData()!=data&&next.getNext()!=null)
		{
			temp=next;
			next=next.getNext();
		}
		if(next.getData()==data)
		{
			if(temp==null)
			head=next.getNext();
			else if(next.getNext()==null)
			{
			temp.setNext(null);	
			}
			else
			{
				temp.setNext(next.getNext());
			}
		}
		else if(next.getNext()==null)
		{
			System.out.println("No Data Found");
		}
	}
	
	public Node reverse(Node head)
	{
		Node h=head,t=head,sn=null;
		while(t.getNext()!=null)
		{
			sn=t.getNext();
			t.setNext(sn.getNext());
			sn.setNext(h);
			h=sn;	
		}
		return h;
	}
	
	public Node reverseinchunks(Node head, int chunks)
	{
		Node currenthead=head, localhead, localtail=head,prevtail=null,prevhead=head,temp,master=null,temp1;
		boolean first=true;
		outer:
		while(prevhead!=null)
		{
			localhead=prevhead;
			if (first==true)
			{
			for(int i=1;i<chunks;i++)
			{
				localtail=localtail.getNext();
				if(localtail==null)
				break outer;
			}
				master=localtail;
				first=false;
				localtail=head;
			}
			if(first==false)
			{
			temp1=prevhead;
			for(int i=1;i<chunks;i++)
			{
				temp1=temp1.getNext();
				if(temp1==null)
				break outer;
			}
			}
			currenthead=prevhead;
			localtail=prevhead;
			System.out.println("second"+currenthead.getData());

			for(int i=1;i<chunks;i++)
			{
			temp=currenthead;
			currenthead=localtail.getNext();
			localtail.setNext(currenthead.getNext());
			currenthead.setNext(temp);
			}
			if(prevtail!=null)
			{
				prevtail.setNext(currenthead);
			}
			prevtail=localtail;
			prevhead=localtail.getNext();
			//System.out.println(prevhead.getData());
			
			
		}
		
		return master;
	}
}
