
public class MyArrayQueueTest {

	public static void main(String[] args) {
		//ArrayQueue queue =  new ArrayQueue(10);
		//QueueUsingStack queue = new QueueUsingStack(10);
		QueueUsing1Stack queue = new QueueUsing1Stack();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
