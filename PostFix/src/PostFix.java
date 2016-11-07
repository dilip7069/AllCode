import java.util.NoSuchElementException;
import java.util.Scanner;


public class PostFix {
	
	 public static void main(String[] args)
     {		 
		 PostFix p=new PostFix();
         Scanner scan = new Scanner(System.in);   
         String expr;         
         System.out.println("Enter data to be parsed.Ex: (a+b*c+d)");
         expr=scan.nextLine();     
         p.infixtopostfix(expr);
     }
	 public void infixtopostfix(String expr)
	 {
		 Run r=new Run();
		 char ch;
         for(int i=0;i<expr.length();i++)
         {
        	 ch = expr.charAt(i);
        	 if((expr.charAt(i)>='a'&&expr.charAt(i)<='z')||(expr.charAt(i)>='A'&&expr.charAt(i)<='Z'))
        	 {
        		 System.out.print(expr.charAt(i));
        	 }
        	 else
        	 {
                switch (ch) {
                case '+': 
                case '-':                
                case '*': 
                case '/':
                case '^':
                gotOper(ch, r); 
                break; 
                case '(': 
                r.push(ch);
                break;
                case ')': 
                gotParen(r,ch); 
                break;
                default: 
                System.out.print(ch); 
                break;
             }
         }
	   }
	 }
	 public int Prec(char ch)
	 {
	     switch (ch)
	     {
	     case '+':
	     case '-':
	         return 1;
	  
	     case '*':
	     case '/':
	         return 2;
	  
	     case '^':
	         return 3;
	     }
	     return -1;
	 }
	  
	  
     public void gotParen(Run r,char ch)
     {
    	 if(ch=='(')
         {
            	r.push(ch);
         }
    	 else if(ch==')')
    	 {
    		 while((!(r.isEmpty()))&&r.peek()!='(')
    			r.pop();
              if(!(r.isEmpty())&&r.peek()!='(')
              {
            	  System.out.println("Wrong expression");
              }
              else
              r.pop();
    	 }

     }
     public void gotOper(char ch,Run r)     
     {
    	 
    	 if(Prec(r.peek())<Prec(ch))
    	 {
    		// System.out.println("pushed" +ch + "into stack"); 
    		 r.push(ch);
    	 }
    	 else if(Prec(ch)<=Prec(r.peek()))		 
    	 {
    		r.pop();
    		 gotOper(ch,r);
    	 }
     }
    	 
}

class Node
{
	protected Node link;
	protected char data;
	
	public Node()
	{
		link=null;
		data=0;
	}
	public Node (Node n, char d)
	{
		link=n;
		data=d;
	}
	public Node (char d)
	{
		data=d;
	}
	public void setChar(char d)
	{
		data=d;
	}
	public char getChar()
	{
		return(data);
	}
	public void setLink(Node n)
	{
		link=n;
	}
	public Node getLink()
	{
		return link;
	}
}

class Run{
	
	protected Node top;
	
	public Run()
	{
		top=null;
	}
	public boolean isEmpty()
	{
		return(top==null);
	}
	public void push(char data)
	{
		Node nptr =new Node(data);
		if(top==null)
		top=nptr;
		else
		{
		nptr.setLink(top);
		top=nptr;
		}
		
	}	
	public char pop()
	{
		 if (isEmpty() )
         throw new NoSuchElementException("Underflow Exception") ;
		 else
		 {
			 Node ptr=top;
			 System.out.print(ptr.getChar());
			 top=ptr.getLink();
			 return ptr.getChar();
		 }
	}
    public char peek()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception") ;
        return top.getChar();
    } 
	
}