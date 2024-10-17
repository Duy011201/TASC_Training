package OOP.Demo;

public class Child extends Parent3 implements Parent1, Parent2 {

	@Override
	public void displayA() {
		System.out.println("Child display A");
	}

	@Override
	public void displayB() {
		super.displayB();
		System.out.println("Child display B");
	}
}
