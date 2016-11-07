import java.util.Scanner;
    public class StkImplement
    {    
        public static void main(String[] args)
        {
            Scanner scan = new Scanner(System.in);   
            /* Creating object of class Stk */   
            Stk ls = new Stk();          
            /* Perform Stack Operations */  
            System.out.println("Linked Stack Test\n");  
            char ch;     
            do 
            {
                System.out.println("\nLinked Stack Operations");
                System.out.println("1. push");
                System.out.println("2. pop");
                System.out.println("3. peek");
                System.out.println("4. check empty");
                System.out.println("5. size");   
                System.out.println("6. Display");
                System.out.println("7. Reverse a Stack");
                int choice = scan.nextInt();
                switch (choice) 
                {
                case 1 :
                    System.out.println("Enter integer element to push");
                    ls.push( scan.nextInt() ); 
                    break;                         
                case 2 : 
                    try
                    {
                        System.out.println("Popped Element = "+ ls.pop());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error : " + e.getMessage());
                    }    
                    break;                         
                case 3 : 
                    try
                    {
                        System.out.println("Peek Element = "+ ls.peek());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;                         
                case 4 : 
                    System.out.println("Empty status = "+ ls.isEmpty());
                    break;                
                case 5 : 
                    System.out.println("Size = "+ ls.getSize()); 
                    break;                
                case 6 : 
                    System.out.println("Stack = "); 
                    ls.display();
                    break;                        
                case 7 :
                	ls.reverse();
                	break;
                default : 
                    System.out.println("Wrong Entry \n ");
                    break;
                }           
                /* display stack */    
                ls.display();            
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);       
     
            } while (ch == 'Y'|| ch == 'y');                 
        }
    }