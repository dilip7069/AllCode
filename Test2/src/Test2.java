



public class Test2 extends Animal {
    public static void testClassMethod() {
        System.out.println("The class method" + " in Cat.");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method" + " in Cat.");
    }

    public static void main(String[] args) {
    	Test2 myCat = new Test2();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
        myAnimal.testClassMethod();
        myCat.testClassMethod();
    }
}
