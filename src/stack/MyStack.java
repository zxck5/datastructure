package stack;

import java.util.ArrayList;

public class MyStack <T> {
	private ArrayList<T> stack = new ArrayList<T>();

	public ArrayList<T> getStack() {
		return stack;
	}

	public void setStack(ArrayList<T> stack) {
		this.stack = stack;
	}
	public void push(T o) {
		stack.add(o);
	}
	public T pop() {
		if (stack.size()== 0) {
			return null;
		}
		
		return stack.remove(stack.size()-1);		
	}
	
	
	
	public static void main(String[] args) {
		MyStack<Integer> ms = new MyStack<Integer>();
        ms.push(1);
        ms.push(2);
        System.out.println(ms.pop());
        ms.push(3);
        System.out.println(ms.pop());
        System.out.println(ms.pop());    
	}
}
