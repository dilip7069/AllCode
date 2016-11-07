package methodhiding;
class Parent {

	public static void function()
	{
		System.out.println("This is from parent function");

	}
	
}

class Child extends Parent {
	public static void function()
	{
		System.out.println("This is from child function");
	}
	
}

public class test
{

	public static void main(String[] args)
	{
		Parent p = new Parent();
		p.function();
		Child c = new Child();
		c.function();
		Parent pc = new Child();
		pc.function();
	}
	
}
