import java.util.Scanner;


public class DoublelinkedListImplementation {

	public static void main(String[] args)
	{
		
		DoubleLinkedList t = new DoubleLinkedList();
		int choice=0,position,data;
		Scanner sc = new Scanner(System.in);
		
		while(choice!=-1)
		{
			System.out.println(" Enter 1 for traversal\n Enter 2 to find length\n Enter 3 to insert\n Enter 4 to delete\n Enter 5 to see Linked List in reverse");
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
			case 4: System.out.println("Enter Number to position to be deleted");
			        position=Integer.parseInt(sc.nextLine());
			        t.delete(position);
			        break;
			case 5: t.printreverse();
			        break;
			 default: System.out.println("Wrong input");
			}
		}
		
	}
}
