package linkedList;

public class MyLinkedList<T> {
	Node<T> head = null;
	
	public class Node<T> {
		Node<T> next = null;
		T data;
		public Node(T data){
			
			this.data = data;
		}
//		@Override
//		public int compareTo(T o) {
//			// TODO Auto-generated method stub
//			if (String.class.isInstance(o)) {
//				return ((String)data).compareTo((String)o);
//				
//			} else if (Double.class.isInstance(o)) {
//				return (int)((Double)data - (Double)o);
//			}
//			return 0;
////			return this.data - o;
//		}
	}
//	public void sortNode () {
//		
//	}
	
	
	public void AddNode(T data) {
		if (head == null) {
			head = new Node<T>(data);
		} else {
			Node<T> node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node<T>(data);
			
		}
	}
	public boolean insertNode(T data, T insertData) {
		Node<T> searchedNode = this.searchNode(data);
		
		if (searchedNode == null) return false;
		
		
		if (searchedNode.next == null) {
			searchedNode.next = new Node<T>(insertData);
			return true;
		} else {
			Node<T> temp = searchedNode.next;
			searchedNode.next = new Node<T>(insertData);
			searchedNode.next.next = temp;
			return true;
		}
	}
	public Node<T> searchNode(T data) {
		if (head.data == data) {
			return head;
		} else {
			Node<T> node = head;
			while (node.next != null) {
				if (node.next.data == data) {
					return node.next;
				}
				node = node.next;
			}
			return null;
		}
	}
	public boolean delNode(T data) {
		Node<T> searchedNode = this.searchNode(data);
		if (searchedNode == null) return false;
		
		if (searchedNode.data == head.data) {
			head = head.next;
			return true;
		} else {
			Node<T> node = head;
			while (node.next.data != data) {
				node = node.next;
			}
			System.out.println("node data =" + node.next.data + "=" + data);
			
			node.next = node.next.next;
			return true;	
		}
	}
	
	public void printAll() {
		if (head != null) {
			System.out.println(head.data);
			Node<T> node = head;
			while (node.next != null) {
				System.out.println(node.next.data);
				node = node.next;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		MyLinkedList<Integer> ml = new MyLinkedList<Integer>();
		ml.AddNode(1);
		ml.AddNode(2);
		ml.AddNode(3);
		ml.AddNode(4);
		ml.printAll();
		System.out.println("-----------test---------");
		ml.insertNode(2, 10);
		ml.printAll();
		System.out.println("-----------test---------");
		ml.delNode(10);
		ml.printAll();
		System.out.println("-----------test---------");
		ml.delNode(1);
		ml.printAll();
		System.out.println("-----------test---------");
		ml.delNode(100);
		ml.printAll();
		System.out.println("-----------test---------");
		ml.delNode(2);
		ml.printAll();
		System.out.println("-----------test---------");
		ml.delNode(4);
		ml.printAll();
		System.out.println("-----------test--------");
		ml.delNode(3);
		ml.printAll();
		System.out.println("-----------test---------");
		ml.delNode(3);
		ml.printAll();
		
	}
	
}
