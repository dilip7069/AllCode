package queue;
import java.util.*;
public class Queue
{
	public static void main(String[] args)
	{
		int choice,data;
		QueueImplementation q=new QueueImplementation();
		Scanner sc=new Scanner(System.in);
		
		do
		{
		System.out.println("1.Enqueue \n2.Dequeue \n3.traverse \n4.ISempty");
		System.out.println("Enter your choice" );
		choice =Integer.parseInt(sc.nextLine());
		switch(choice)
		{
		case 1:System.out.println("Enter data");
		data=Integer.parseInt(sc.nextLine());
		q.enqueue(data);
		break;
		case 2: q.dequeue();
		break;
		case 3: q.traverse();
		break;
		case 4:System.out.println( q.isEmpty());
		break;
		default:
		System.out.println("Wrong Option");
		break;
		}
		}while(choice>=1&&choice<=4);
	}
	
}
