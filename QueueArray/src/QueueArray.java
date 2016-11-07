
public class QueueArray {

}


class Queue
{

	private int capacity,front,rear;
	private int [] array;
	public Queue(int size)
	{
		front=-1;
		rear=-1;
		capacity=size;
		array=new int[size];
	}
	public boolean isEmpty()
	{
		return front==-1;
	}
	public boolean isFull()
	{
		return ((rear+1)%capacity==front);
	}
	public int queueSize()
	{
		int size;
		size=(capacity-front+rear+1)%capacity;
		if(size==0)
		{
			return capacity;
		}
		else 
			return size;
	}
	public void enqueue(int data)
	{
		if(isFull())
		{
            System.out.println("Queue is Full");
		}
		else
		{
			rear=(rear+1)%capacity;
			array[rear]=data;
			if(front==-1)
				front=rear;
		}
	}
	public int deQueue()
	{
		int data=-1;
		if(front==-1)
		{
			System.out.println("Empty Queue");			
		}
		else
		{
			data=array[front];
			if(front==rear)
			{
				front=rear-1;
			}
			else
			front=(front+1)%capacity;
		}
		return data;
	}
	
}