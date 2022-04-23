package linkedList;

public class SingleLinkedList<T> {
	
	Node<T> head = null;
	
	public class Node<T>{
		Node<T> next = null;
		T data;
		
		public Node (T o) {
			this.data = o;
		}
	}
	
	public void addNode(T o) {
		if (head == null) {
			head = new Node<T>(o);
			
		} else {
			Node<T> node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node<T>(o);
			
		}
	}
	public void insertNode(T data, T frontData) {
		Node<T> searchedNode = this.searchNode(frontData);
		
		if (searchedNode == null) {
			addNode(data);
		} else {
			Node<T> temp = searchedNode.next;
			searchedNode.next = new Node<T>(data);
			searchedNode.next.next = temp;
		}
	}
	
	
	private Node<T> searchNode(T o) {
		// TODO Auto-generated method stub
		Node<T> node = head;
		while (node.next!=null) {
			if (node.data==o) {
				return node;
			}
			node = node.next;
		}
		return null;
	}
	public boolean delNode(T o) {
		// 삭제 할값이 head일때, 아닐때, 끝 값일때.
		if (head == null) {
			return false;
		} else {
			Node<T> node = head;
			if (node.data == o) {
				head = head.next;
				return true;
			} else {
				while (node.next!=null) {
					if (node.next.data == o) {
						node.next = node.next.next;
						return true;
					}
					
					node = node.next;
				}
				return false;			
			}
			
		}
		
	}
	
	
	public void printAll() {
		if (head != null) {
			Node<T> node = head;
			while (node.next!=null) {
				System.out.println(node.data);
				node = node.next;
			}
			System.out.println(node.data);	
		}
	}
	
	
	
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<Integer>();
		
		
		
		
		myLinkedList.addNode(1);
		myLinkedList.addNode(2);
		myLinkedList.addNode(3);
		myLinkedList.addNode(4);
		myLinkedList.addNode(5);
		myLinkedList.printAll(); 
		myLinkedList.insertNode(10, 1);
		myLinkedList.printAll(); 
		myLinkedList.insertNode(5, 1);
		myLinkedList.printAll(); 

		myLinkedList.insertNode(6, 20);
		myLinkedList.printAll();
		
		myLinkedList.delNode(6);
		myLinkedList.printAll();
		myLinkedList.delNode(5);
		myLinkedList.printAll();
		myLinkedList.delNode(10);
		myLinkedList.printAll();
		System.out.println(myLinkedList.delNode(0));
		
		
	}
	
	
}
