package dataStructure;

public class Stack {
	/*
	 * create an array of size n. implement push method at the end of the array.
	 * check if array is full: stack overflow. implement pop method from end of the
	 * array. check if array is empty: stack underflow. implement peek method to
	 * return item from end of the array. check if array is empty: stack underflow.
	 * implement isEmpty method to check if array is empty.
	 * 
	 */
	public Stack(int n) {
		array = new int[n];
	}

	static int[] array;
	static int count;

	public void push(int item) {
		if (array.length == count)
			System.out.println("Stack is Full");
		else
			array[count++] = item;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return array[--count];
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return array[count-1];
	}

	public boolean isEmpty() {
		if (count == 0)
			return true;
		return false;
	}

	public void display() {
		if (isEmpty())
			System.out.println("Stack is Empty");
		else {
			for (int i = 0; i < count; i++) {
					System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	}
}
