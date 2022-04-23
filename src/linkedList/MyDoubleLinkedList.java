package linkedList;

public class MyDoubleLinkedList <T>{
	Node<T> head = null;
	Node<T> tail = null;
	
	
	
	
	public class Node<T>{
		Node<T> next = null;
		Node<T> prev = null;
		T data;
		
		public Node (T data) {
			this.data = data;
			
		}
	}
	
	
	public void addNode(T data) {
		if (head == null) {
			head = new Node<T>(data);
			tail = head;
			
		} else {
			Node<T> node = head;
			while (node.next != null) {	
				node = node.next;
			}
			node.next = new Node<T>(data);
			tail = node.next;
			node.next.prev = node;
		}
	}
	public boolean insertNodeFront (T data, T insertData) {
		Node<T> searchedNode = this.searchNodeFromTail(data);
		if (searchedNode == null) return false;
		
		if (searchedNode.equals(head)) {
			Node<T> formerHead = head;
			this.head = new Node<T>(insertData);
			head.next = formerHead;
			formerHead.prev = head;
			return true;
		}
		
		Node<T> prevNode = searchedNode.prev;
		searchedNode.prev.next = new Node<T>(insertData);
		searchedNode.prev.next.next = searchedNode;
		searchedNode.prev = searchedNode.prev.next;
		searchedNode.prev.prev = prevNode;
		return true;
		
		
	}	
	public Node<T> searchNodeFromHead(T data) {
		if (head.data == data) {
		
			return head;
		}
		Node<T> node = head;
		while (node.next!=null) {
			if (node.next.data == data) {
	
				return node.next;
			}
			node = node.next;
		}
		return null;
	}
	public Node<T> searchNodeFromTail(T data){
		if (tail.data == data) {

			return tail;
		}
		Node<T> node = tail;
		while (node.prev != null) {
			if (node.prev.data == data) {
			
				return node.prev;
			}
			node = node.prev;
		}
	
		return null;
	}
	
	public void printAll() {
		if (head != null) {
			Node<T> node = head;
//			System.out.println(node.data + "|prev|" + node.prev.data + " |next| " + node.next.data);
			System.out.println(node.data);
			while (node.next != null) {
//				System.out.println(node.next.data +"|prev|" + node.next.prev.data + " |next| " + node.next.next.data);
				System.out.println(node.next.data);
				node = node.next;
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		MyDoubleLinkedList<Integer> dll = new MyDoubleLinkedList<Integer>();
		dll.addNode(1);
		dll.addNode(2);
		dll.addNode(3);
		dll.addNode(4);
		dll.addNode(5);
		dll.printAll();
		System.out.println("search test");
		System.out.println(dll.searchNodeFromHead(null));
		System.out.println(dll.searchNodeFromHead(3).data);
		System.out.println(dll.searchNodeFromHead(1).data);
		System.out.println("search test");
		System.out.println(dll.searchNodeFromTail(null));
		System.out.println(dll.searchNodeFromTail(3).data);
		System.out.println(dll.searchNodeFromTail(5).data);
		System.out.println("insert test");
		System.out.println(dll.insertNodeFront(1,10));
		System.out.println(dll.insertNodeFront(5,11));
		System.out.println(dll.insertNodeFront(3,4));
		dll.printAll();
		System.out.println("insert test");
//		System.out.println(dll.insertNodeFront(0,100));
//		System.out.println(dll.insertNodeFront(100,0));
//		dll.printAll();
//		System.out.println("insert test");
		
		
	}
}
