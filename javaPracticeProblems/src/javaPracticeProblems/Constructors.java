package javaPracticeProblems;

class Person {

	String name;
	int id;

	public Person() {

	}

	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}

}

class A {
	public A() {
		System.out.println("Default constructor of A");
	}

	public A(int num) {
		System.out.println("Parameterized constructor of A");
	}
}

class B extends A {
	public B() {
		System.out.println("Default constructor of B");
	}

	public B(int num) {
		super(num);
		System.out.println("Parameterized constructor of B");
	}
}

public class Constructors {

	public static void main(String[] args) {
		Person person1 = new Person("john smith", 1234);
		System.out.println(person1.name);
		System.out.println(person1.id);
		System.out.println();

		Person person2 = new Person();
		System.out.println(person2.name);
		System.out.println(person2.id);
		person2.name = "elon musk";
		person2.id = 4893;
		System.out.println();
		System.out.println(person2.name);
		System.out.println(person2.id);
		System.out.println();

		B b = new B();

	}
}
