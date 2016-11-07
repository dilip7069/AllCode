import java.util.Scanner;
public class SingleLinkedListImplementation {
	
	public static void main(String[] args)
	{
		
		SingleLinkedList t = new SingleLinkedList();
		int choice=0,position,data;
		Scanner sc = new Scanner(System.in);
		
		while(choice!=-1)
		{
			System.out.println(" Enter 1 for traversal\n Enter 2 to find length\n Enter 3 to insert\n Enter 4 to delete\n 5 to reverse in chunks\n6. reverse");
			choice=Integer.parseInt(sc.nextLine());
			switch(choice)
			{
			case 1: t.traverse();
			        break;
			case 2: System.out.println(" Lenght of List is "+t.length());
			        break;
			case 3: System.out.println("Enter a position to insert link");
			        position=Integer.parseInt(sc.nextLine());
			        System.out.println("Enter value to be inserted");
			        data=Integer.parseInt(sc.nextLine());
			        t.insert(position, data);
			        break;
			case 4: System.out.println("Enter Number to be deleted");
			        data=Integer.parseInt(sc.nextLine());
			        t.delete(data);
			        break;
			case 5:System.out.println("Enter the value of chunk size");
			       data=Integer.parseInt(sc.nextLine());
			       t.reverseinchunks(data);
			       break;
			case 6:t.head=t.reverse(t.head);
			       break;
			case 7:System.out.println("Enter the value of chunk size");
		           data=Integer.parseInt(sc.nextLine());
		           t.head=t.reverseinchunks(t.head, data);
			      break; 
			 default: System.out.println("Wrong input");
			}
		}
		
	}

}
