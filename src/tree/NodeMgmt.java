package tree;

public class NodeMgmt {
	Node head;
	
	
	public class Node {
		
//		Node parent;
		Node left;
		Node right;
		int value;
		
		Node(int data) {
			this.left = null;
			this.right = null;
			this.value = data;
		}
		
	}
	
	
	public boolean insertNode(int data) {
		if (head == null) {
			head = new Node(data);
//			head.parent = null;
			
			return true;
		} else {
			Node node = head;
			while (true) {
				// check left
				if (node.value > data) {
					if (node.left == null) {
						node.left = new Node(data);
//						node.left.parent = node;
						return true;
					} else {
						node = node.left;
					}
					
				}
				// check right
				else {
					if (node.right == null) {
						node.right = new Node(data);
//						node.right.parent = node;
						return true;
					} else {
						node = node.right;
					}
				}	
			}
		}
	}
	public Node search(int data) {
		// case1: if node is available
		if (head != null) {
			Node node = head;
			if (head.value == data) {
				return head;
			}
			while (node != null) {
				// check left
				if (node.value > data) {
					if (node.value == data) {
						return node;
					} else {
						node = node.left;
					}
				} else {
					// check right
					if (node.value == data) {
						return node;
					} else {
						node = node.right;
					}
				}
			}
			return null;
		} else {
			// case2: if node is not available
			return null;
		}
	}
	
	public Boolean delNode(int data) {
		//case1 : if any of the value is not in the binary tree
		if (head == null) {
			return false;
		} else {
			// find the node that matches the data in binary tree
			Node node = head;
			Node parentNode = null;
			boolean check = false;
			while (node != null) {
				if (node.value == data) {
					check = true;
					break;
				} else if (node.value > data) { 
					parentNode = node;
					node = node.left;
				} else {
					parentNode = node;
					node = node.right;
				} 
				
				
			}
			// if there is no data in the binary
			// case3: if the value is not in the binary tree
			if (check == false) {
				return false;
			} else { // case3: if we found the data in binary tree, sort parentNode and the node.
				 
				// case 3-1 if the value is deleted from the leaf Node 
				// no child in this node.
				if (node.right == null && node.left == null) {
					System.out.println("pass?");
					if (parentNode.right == node) {
						parentNode.right = null;
					} else {
						parentNode.left = null;
					}
					node = null;
					return true;
				} else if (node.right == null || node.left == null) { // case 3-2 if the node has one child
					System.out.println("pass2");
					Node nodeChild = null;
					
					if (node.left != null) {
						nodeChild = node.left;
					} else {
						nodeChild = node.right;
					}
					
					
					if (parentNode.right == node) {
						parentNode.right = nodeChild;
					} else {
						parentNode.left = nodeChild;
					}
					node = null;
					return true;
					
				}  else if (node.right != null && node.left != null ) { // case 3-3 if the node has two child.
					// There are three cases
					// switch the node to the node which has the lowest node. 2 possible cases
					Node minNode = node.right;
					Node minNodeParent = null;
					if (minNode.left == null) {
						// case for if the minNode has no left child
						minNodeParent = node;
					} else {
						// case for if the minNode has left childs
						while (minNode.left != null) {
							minNodeParent = minNode;
							minNode = minNode.left;
						}						
					}
					// FIRST case : if the minNode has no any other child, 
					// and minNode's parent is node
					// total two branch has to be changed
					if (minNode == node.right) {
						// renew the pointer of parentNode
						// first branch
						if (parentNode.right == node) {
							parentNode.right = minNode;
						} else {
							parentNode.left = minNode;
						}
						// second branch
						minNode.left = node.left;
						node = null;
						return true;
					}
					
					
					// SECOND CASE: if the minNode's parent is not node. minNode is stretched down to the left side 
					// the lowest value node is situated in the one step of right side of the node that we are going to delete,  
					// and at the end of left side of right after the one step.
					
					// total 4 branches has to be renewed
					if (minNode.right == null && minNode.left == null) {
						
						// first branch: renew the pointer of parentNode
						if (parentNode.right == node) {
							parentNode.right = minNode;
						} else {
							parentNode.left = minNode;
						}
						// second branch renew the pointer to null of minNode's parent
						minNodeParent.left = null;

						// third and fourth branch: give node's pointer to the minNode
						minNode.left = node.left;
						minNode.right = node.right;
						return true;
						
					} else if (minNode.right != null) {
						// THIRD case: if the minNode has right child
						// Total 4 branch or more
						
						// First branch: renew the pointer of parentNode
						if (parentNode.right == node) {
							parentNode.right = minNode;
						} else {
							parentNode.left = minNode;
						}
						
						// Second branch: renew the pointer of minNode's parent
						minNodeParent.left = minNode.right;
						
						// Third and fourth branch: 
						minNode.left = node.left;
						minNode.right = node.right;
						return true;
					}
					
				}
			}
			
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		NodeMgmt myTree = new NodeMgmt();
//		myTree.insertNode(10);
//		myTree.insertNode(6);
//		myTree.insertNode(2);
//		myTree.insertNode(8);
//		myTree.insertNode(7);
//		myTree.insertNode(6);
//		myTree.insertNode(9);
//		myTree.insertNode(12);
//		myTree.insertNode(5);
//		
//		myTree.delNode(8);
//		myTree.delNode(6);
//		myTree.delNode(2);
//		myTree.delNode(6);
//		Node node = myTree.search(7);
//		System.out.println(node);
//		System.out.println(node.left.value);
//		System.out.println(node.right.value);
		myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delNode(15));
        System.out.println(myTree.delNode(13));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
//        System.out.println(myTree.head.right.left.right);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);

	}
	
	
	
}
