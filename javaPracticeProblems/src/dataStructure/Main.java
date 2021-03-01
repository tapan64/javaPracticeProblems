package dataStructure;

public class Main {

	public static void main(String[] args) {
		Queue queue=new Queue(5);
		queue.enqueue(29);
		queue.enqueue(12);
		queue.enqueue(45);
		queue.display();
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		queue.display();
		System.out.println(queue.peek());
		queue.enqueue(29);
		queue.enqueue(12);
		queue.display();
		queue.enqueue(45);
		queue.display();
		queue.enqueue(45);
		queue.display();
		

		
	}

}