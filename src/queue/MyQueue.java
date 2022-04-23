package queue;
import java.util.ArrayList;

public class MyQueue <T> {
	private ArrayList<T> queue = new ArrayList<T>();
	
	public static void main(String[] args) {
		MyQueue<Integer> mq = new MyQueue<Integer>();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());      

			
	}
	
	public void enqueue(T o) {
		queue.add(o);
	}
	public T dequeue() {
		if (queue.size()!=0) {
			
			return queue.remove(0);
		} else {
			return null;
		}
		
	}








	public ArrayList<T> getQueue() {
		return queue;
	}


	public void setQueue(ArrayList<T> queue) {
		this.queue = queue;
	}
	
	
	
	
	
	
	
	
	
	
}
