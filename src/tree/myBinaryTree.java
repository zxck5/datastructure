package tree;

public class myBinaryTree {
	Node head;
	
	public class Node{
		Node left;
		Node right;
		int data;
		
		public Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	public boolean insertData (int data) {
		// case1: when head is null. when there is nothing in binary tree.
		if (head == null) {
			head = new Node(data);
//			System.out.println("case1 : create head when null");
			return true;	
		} else {
			// case 2 : when head is not null
//			System.out.println("case2 : head is not null");
			Node node = head;
		
			while(true) {
				// compare node's data with the data that we are going to insert in tree.
				// when node is null, that is the spot where the node is going to be inserted
				if (node.data > data) {
					// left
					if (node.left == null) {
						node.left = new Node(data);
						return true;
					} else {
						node = node.left;
					}
					
				} else {
					// right
					if (node.right == null) {
						node.right = new Node(data);
						return true;
					} else {
						node = node.right;						
					}
				}
			}
			
		}
	}
	// three cases
	//case1: node that has no child
	//case2: node that has one child
	//case3: node that has two child
	public boolean delData(int data) {
		if (head != null) {
			// search node
			Node node = head;
			Node parentNode = null;
			while (node!=null) {
				if (node.data == data) {
					break;
				}
				// left
				if (node.data > data) {
					parentNode = node;
					node = node.left;
				} else {
					// right
					parentNode = node;
					node = node.right;
				}
			}
			if (node == null) {
				return false;
			} else {
				//CASE1: if there is no child
				if (node.left == null && node.right == null) {
					// just cut one branch
					if (parentNode.left == node) {
						parentNode.left = null;
					} else {
						parentNode.right = null;
					}
					node = null;
					return true;
					
					
				} else if (node.left == null || node.right == null) {
					//CASE2: if there is one child
					// one branch
					Node nodeChild = null;
					if (node.left != null) {
						nodeChild = node.left;
					} else {
						nodeChild = node.right;
					}
					
					if (parentNode.left == node) {
						parentNode.left = nodeChild;
					
					
					} else {
						parentNode.right = nodeChild;
					}
					node = null;
					return true;
					
				} else {
					//CASE3:if there is two child
					Node minNode = node.right;
					Node minNodeParent = null;
					while (minNode.left!=null) {
						minNodeParent = minNode;
						minNode = minNode.left;
					}
						// 2branches
						//First
					if (minNodeParent == null) {
						if (parentNode.left == node) {
							parentNode.left = minNode;
						} else {
							parentNode.right = minNode;
						}
						//Second
						minNode.left = node.left;
						node = null;
						return true;
					}
					
					// if minNode has no child
					if (minNode.left == null && minNode.right == null) {
						
						// 4 branches
						
						//FIRST BRANCH
						minNodeParent.left = null;
						// connect the branch with parentNode and minNode
						//SECOND BRANCH
						if (parentNode.left == node) {
							parentNode.left = minNode;
						} else {
							parentNode.right = minNode;
						}
						//THRID&FOURTH BRANCH
						minNode.left = node.left;
						minNode.right = node.right;
						
						node = null;
						return true;
						
					} else if (minNode.right != null) {
						
						// if minNode has child (right)
						// 4 Branches
						//FIRST BRANCH
						minNodeParent.left = minNode.right;
						//SECOND BRANCH
						if (parentNode.left == node) {
							parentNode.left = minNode;
						} else {
							parentNode.right = minNode;
						}
						//THRID&FOURTH BRANCH
						minNode.left = node.left;
						minNode.right = node.right;
						node = null;
						return true;
						
					}
					return false;
					
				}
			}
			
		} else {
			return false;
		}
		
	}
	
	public Integer searchData(int data) {
		if (head != null) {
			Node node = head;
			while (node!=null) {
				
				if (node.data == data) {	
					return node.data;
				}
				if (node.data> data) {
					node = node.left;
				} else {
					node = node.right;
				}
			}
			// if the node is null, that means there is no data in tree
			System.out.println("no data");
			return null;
		} else {
			return null; 
		}
		
	}
	
	
	public static void main(String[] args) {
		myBinaryTree myTree = new myBinaryTree();
		myTree.insertData(10);
		myTree.insertData(5);
		myTree.insertData(15);
		myTree.insertData(13);
		myTree.insertData(16);
		myTree.insertData(9);
		myTree.insertData(4);
		myTree.insertData(20);
		myTree.insertData(18);
		myTree.insertData(19);

		myTree.insertData(21);
		myTree.insertData(30);
		myTree.delData(15);
		myTree.delData(16);
		System.out.println("head:"+myTree.head.data);
		System.out.println("head.left:"+myTree.head.left.data);
		System.out.println("head.right:"+myTree.head.right.data);
		System.out.println("head.right.right:"+myTree.head.right.right.data);
		System.out.println("head.right.right.right:"+myTree.head.right.right.right.data);
		System.out.println("head.right.left:"+myTree.head.right.left.data);
		System.out.println("head.right.right.left:"+myTree.head.right.right.left.data);
		System.out.println("head.right.right.left.left:"+myTree.head.right.right.left.left);
//		System.out.println("head.right.left:"+myTree.head.right.right.left.left.left.data);
		System.out.println("head.left.left:"+myTree.head.left.left);
		System.out.println("head.left.right:"+myTree.head.left.right);
//		System.out.println(myTree.searchData(10));
//		System.out.println(myTree.searchData(5));
//		System.out.println(myTree.searchData(15));
//		System.out.println(myTree.searchData(13));
	}
}
