package Stack;

public class StackDriver {

	public static void main(String[] args) {
		Stack stack=new Stack(5);
		stack.push(29);
		stack.push(12);
		stack.push(45);
		stack.display();
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		stack.display();
		System.out.println(stack.peek());
		stack.push(29);
		stack.push(12);
		stack.push(45);
		stack.push(45);
		stack.display();
		

		
	}

}
