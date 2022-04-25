package binaryTree;

// creating Node
class Node<T> implements Comparable<T> {
	// child node
	Node<T> left;
	Node<T> right;
	
	T value;
	
	public Node(T data) {
		this.value = data;
		this.left = null;
		this.right = null;
	}
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		try {
			if (String.class.isInstance(o)) {
				// if T is String, we compare it as string
				return ((String) value).compareTo((String)o);
			} else if (Integer.class.isInstance(o)) {
				return ((int)this.value) - (int)o;
			} else {
				// Exceptions
				throw new CompareException("only integer or string is valid to be compared");
			}	
		} catch (CompareException e){
			System.err.println(e.getMessage());
			return 0;
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("data: ").append(this.value).append(" ,left child: ").append(this.left.value);
		} catch (NullPointerException e) {
//			return sb.append("---null--").toString();
//			System.out.println(e.getMessage());
		}
		try {
			sb.append(",right child: ").append(this.right.value);
		} catch (NullPointerException e) {
			return sb.append("---null--").toString();
//			System.out.println(e.getMessage());
		}
		return sb.toString();
	}
}

public class BinaryTree<T> {
	Node<T> head;
	
	
	public boolean addNode(T data) {
		// case 1 : head is null
		if (head == null) {
			head = new Node<T>(data);
			return true;
		} else {
			Node<T> node = head;
			// case 2 : when head is not null
			while (true) {
				 // compare the data and node's data
				// left
				if (node.compareTo(data) > 0) {
					if (node.left == null) {
						node.left = new Node<T>(data);
						return true;
					}
					node = node.left;
				// right
				} else {
					if (node.right == null) {
						node.right = new Node<T>(data);
						return true;
					}
					node = node.right;
				}
			}
		} 
	}
	public Node<T> searchNode(T data) {
		// when the data we want to search for is head
		if (head.compareTo(data) == 0) {
			return head;
		}
		Node<T> findNode = head;
		while (true) {
			if (findNode.compareTo(data) == 0) {
				return findNode;
			} 
			// left
			if (findNode.compareTo(data) > 0) {
				findNode = findNode.left;
			} else {
				// right
				findNode = findNode.right;
			}
		}
	}
	
	public boolean delNode(T data) {

		if (head == null) {
			
			return false;
		} else {
			Node<T> node = head;
			Node<T> parentNode = head;
			while (true) {
				if (node.compareTo(data) == 0) break;
					parentNode = node;
				if (node.compareTo(data) > 0) {
					node = node.left;
				} else {
					node = node.right;
				}
			}
			
			// case1 : if node has no child
			if (node.left == null && node.right == null) {
				System.out.println("pass1");
				if (parentNode.left.equals(node)) {
					parentNode.left = null;
				} else if (parentNode.right.equals(node)) {
					parentNode.right = null;
				}
				node = null;
				return true;
				
			} else if (node.left != null && node.right == null){
					// case2 : if node has only left child
					System.out.println("pass2");
					Node<T> child = null;
					if (node.left != null) {
						child = node.left;
					} else if (node.right != null) {
						child = node.right;
					}
					if (parentNode.right.equals(node)) {
						parentNode.right = child;
					} else if (parentNode.left.equals(node)) {
						parentNode.left = child;
					}
					node = null;
					return true;
				
				
				// case 3 : two child or node has right child
			} else {
				System.out.println("pass3");
				// finding minimum value of right child's tree
				Node<T> minNode = node.right;
				Node<T> minNodeParent = null;
				while (minNode.left != null) {
					minNodeParent = minNode;
					minNode = minNode.left;
				}
				// if minNode --> right child
				if (minNode.equals(node.right)) {
					// is node left child of parent node or is node right child of parent node??
					// replace node with node's child
					if (parentNode.right.equals(node)) {
						parentNode.right = node.right;
					} else if (parentNode.left.equals(node)) {
						parentNode.left = node.right;
					}
					// connect with new node left branch
					node.right.left = node.left;
					node = null;
					return true;
				} else {
					
					// if minNode do not have right children
					if (minNode.right == null) {
						// if minNode --> not right child
						// is node left child of parent node or is node right child of parent node??
						// replace node with minNode
						if (parentNode.right.equals(node)) {
							parentNode.right = minNode;
						} else if (parentNode.left.equals(node)) {
							parentNode.left = minNode;
						}
						
						minNodeParent.left = null;
						minNode.right = node.right;
						minNode.left = node.left;
						node = null;
						return true;
						// if minNode has right children
					} else {
						if (parentNode.right.equals(node)) {
							parentNode.right = minNode;
						} else if (parentNode.left.equals(node)) {
							parentNode.left = minNode;
						}
						
						minNodeParent.left = minNode.right;
						minNode.right = node.right;
						minNode.left = node.left;
						node = null;
						return true;
						
					}
				}	
			}
		}
		
	}	
	
	
	public static void main(String[] args) {
		BinaryTree<Integer> binaryTree = new BinaryTree<>();
		System.out.println("hello");
		binaryTree.addNode(2);
		binaryTree.addNode(1);
		binaryTree.addNode(4);
//		binaryTree.addNode(3);
//		binaryTree.addNode(5);
		binaryTree.addNode(10);
//		binaryTree.addNode(8);
//		binaryTree.addNode(7);
		binaryTree.addNode(6);
//		binaryTree.addNode(5);
		binaryTree.addNode(13);
		binaryTree.addNode(11);
		binaryTree.addNode(12);
		System.out.println(binaryTree.searchNode(1));
		System.out.println(binaryTree.searchNode(2));
		System.out.println(binaryTree.searchNode(4));
		System.out.println(binaryTree.searchNode(10));
		System.out.println(binaryTree.searchNode(6));
		System.out.println(binaryTree.searchNode(13));
		System.out.println(binaryTree.searchNode(11));
		System.out.println(binaryTree.searchNode(12));
		System.out.println("--------test--------");
//		binaryTree.delNode(5);
		System.out.println(binaryTree.delNode(10));
//		System.out.println(binaryTree.delNode(5));
//		System.out.println(binaryTree.delNode(5));
//		System.out.println(binaryTree.searchNode(5));
		System.out.println(binaryTree.searchNode(4));
		System.out.println(binaryTree.searchNode(11));
		System.out.println(binaryTree.searchNode(13));
	}
	
}
