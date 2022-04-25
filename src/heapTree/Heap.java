package heapTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




public class Heap<T> {
	
	ArrayList<T> heapArray = new ArrayList<T>();
	Comparator<T> comp = new Comparator<T>() {
		@Override
		public int compare(T o1, T o2) {
			try {
				if (String.class.isInstance(o1)) {
					return ((String)o1).compareTo((String)o2);
				} else if (Integer.class.isInstance(o1)) {
					return ((Integer)o1)-((Integer)o2);
				} else {
					throw new CompareException("please put Integer value or String value");
				}
			}catch(CompareException e) {
				System.err.println(e.getMessage());
				return 0;
			}
		} 
	};
	
	public Heap (T data) {
		heapArray = new ArrayList<T>();
		
		heapArray.add(null);
		heapArray.add(data);
	}
	
	
	public void insertNode (T data) {
		if (heapArray.size() == 0) {
			heapArray.add(null);
			heapArray.add(data);
			return;
		}
		heapArray.add(data);
		
		Integer currentIdx = heapArray.size()-1;
		while (moveUp(currentIdx)) {
			Integer parentIdx = currentIdx/2;
			Collections.swap(heapArray, currentIdx, parentIdx);
			currentIdx = parentIdx;
		}	
	}
	public T pop () {
		if (heapArray.size() == 1) {
			return null;
		}
		T returnData = heapArray.get(1);
		heapArray.set(1, heapArray.get(heapArray.size()-1));
		heapArray.remove(heapArray.size()-1);
		
		
		moveDown(1);
		
		return returnData;
	}
	
	public void moveDown(Integer curIdx) {
		if (curIdx >= heapArray.size()) {
			return;
		}
		Integer childIdx = heapArray.size();
		Integer leftChild = curIdx*2;
		Integer rightChild = curIdx*2+1;
		
		// CASE WHEN curNode has no child
		if (leftChild >= heapArray.size()) {
			return;
		}
		
		
		//CASE WHEN curNode has one child --> only left
		if (rightChild >= heapArray.size())  {
			// curNode < left child --> swap
			if (comp.compare(heapArray.get(curIdx), heapArray.get(leftChild)) < 0) {
				Collections.swap(heapArray, curIdx, leftChild);
				childIdx = leftChild;
			} 
			
		} else {
			//CASE WHEN curNode has two child --> left, right
			// left child > right child
			if (comp.compare(heapArray.get(leftChild), heapArray.get(rightChild)) > 0) {
				// left child > curNode --> swap
				if (comp.compare(heapArray.get(curIdx), heapArray.get(leftChild))< 0) {
					Collections.swap(heapArray, curIdx, leftChild);
					childIdx = leftChild;
				}
				
			} else {
				// left child <= right child
				if (comp.compare(heapArray.get(curIdx), heapArray.get(rightChild))< 0) {
					Collections.swap(heapArray, curIdx, rightChild);
					childIdx = rightChild;
				}
			}
		}
		moveDown(childIdx);
	}
	
	
	public boolean moveUp(Integer curIdx) {
		if (curIdx <= 1) return false;
		Integer parentIdx = curIdx/2;
		
		if (comp.compare(heapArray.get(curIdx), heapArray.get(parentIdx)) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>(15);
		heap.insertNode(5);
		heap.insertNode(8);
		heap.insertNode(15);
		heap.insertNode(20);
		heap.insertNode(4);
		heap.insertNode(32);
		heap.insertNode(13);
		
		System.out.println(heap.heapArray);
		System.out.println(heap.pop());
		System.out.println(heap.heapArray);
		
	}
}
