package dataStructure;

public class Queue {
	/*
	 * create an array of size n. implement enqueue method at the end of the array.
	 * check if array is full. implement dequeue method from front of the
	 * array. check if array is empty. implement peek method to
	 * return item from end of the array. check if array is empty.
	 * implement isEmpty method to check if array is empty.
	 * 
	 */
	static int[] array;
	static int count,front,rare;
	public Queue(int n) {
		array=new int[n];
	}
	public void enqueue(int item) {
		if(array.length==count) {
			System.out.println("Queue is Full");
		}
		else {
		array[rare]=item;
		rare=(rare+1)%array.length;
		count++;
		}
	}
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		int item=array[front];
		array[front]=0;
		front=(front+1)%array.length;
		count--;
		return item;
	}
	public boolean isEmpty() {
		if(count==0)
			return true;
		return false;
	}
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		return array[front];
	}
	public void display() {
		if(isEmpty())
			System.out.println("Queue is Empty");
		else {
			for (int i = 0; i < array.length; i++) {
				if(array[i]!=0)
					System.out.print(array[i]+" ");
			}
			System.out.println();
		}
	}
}
