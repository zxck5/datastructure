package linkedList;


public class DoubleLinkedList<T> {
	
	Node<T> head = null;
	Node<T> tail = null;
	
	
	public class Node<T>{
		T data;
		Node<T> next = null;
		Node<T> prev = null;
		
		public Node(T o){
			this.data = o;
		}	
	}
	public void addNode(T o) {
		if (head == null) {
			head = new Node<T>(o);
			tail = head;
			
		} else {
			Node<T> node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node<T>(o);
			node.next.prev = node;
			tail = node.next;
		}
	}
	public T searchFromHead(T o) {
		if (head == null) {
			return null;
		}
		Node<T> node = head;
		while (node != null) {
			if (node.data == o ) {
				return node.data;
			}
			
			node = node.next;
		}
		return null;
	}
	public Node<T> searchNodeFromTail(T o) {
		if (tail == null) {
			return null;
		}
		Node<T> node = tail;
		while(node != null) {
			if (node.data == o) {
				return node;
			}
			node = node.prev;
		}
		return null;
	}
	
	public T searchFromTail(T o) {
		if (tail == null) {
			return null;
		}
		Node<T> node = tail;
		while(node != null) {
			if (node.data == o) {
				return node.data;
			}
			node = node.prev;
		}
		return null;
	}
	
	public boolean insertNode(T data, T o) { // data 앞에 o넣기
		Node<T> searchedNode = searchNodeFromTail(data);
		if (searchedNode == null) { // 찾으려는 값이 없을때
			return false;
		}
		if (searchedNode == head) { // head앞에 데이터를 넣으려 할때
			Node<T> newHead = new Node<T>(o);
			
			newHead.next = head; // 기존 헤드가 넥스트
			head = newHead; // 새로운 해드
			head.next.prev = head;
			return true;
		}
		
		if (head == null) { // 데이터가 비어있을때
			addNode(o);
			return true;
		}

		else {
			Node<T> temp = searchedNode.prev;
			
			searchedNode.prev = new Node<T>(o);
			searchedNode.prev.prev = temp;
			
			temp.next = searchedNode.prev;
			searchedNode.prev.next = searchedNode;
			
			return true;
			
		}
		
	}
	
	
	
	public void printAll() {
		if (head != null) {
			Node<T> node = head;
			while (node.next != null) {
				System.out.println(node.data);
				node = node.next;
			}
			System.out.println(node.data);
			
		}
	}
	
	
	
	
	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
//		list.addNode(1);
//		list.addNode(2);
//		list.addNode(3);
//		list.addNode(4);
//		list.addNode(5);
//		list.printAll();
		
		
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
	    list.printAll();
	    System.out.println("----------------");

	    list.insertNode(3, 2);
	    list.printAll();
	    System.out.println("----------------");

	    list.insertNode(6, 2);
	    list.insertNode(1, 0);
	    list.printAll();
	    System.out.println("----------------");

	    list.addNode(6);
	    list.printAll();
	}
}
