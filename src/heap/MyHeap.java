package heap;
import java.util.ArrayList;

import java.util.Collections;


public class MyHeap {
	
	ArrayList<Integer> heap;

	
	public MyHeap (Integer data) {
		heap = new ArrayList<Integer>();
		heap.add(null);
		heap.add(data);
	}
	
	public boolean insertData(Integer data) {
		if (heap == null) {
			heap = new ArrayList<Integer>();
			heap.add(data);
			return true;
		}
		
		heap.add(data);
		int index = heap.size()-1;
		while (moveUp(index)) {
			int parentIndex = index/2;
			
			Collections.swap(heap,index, parentIndex);
			index = parentIndex;
		}
		return true;
	}
	public Integer pop() {
		if (heap == null) {
			return null;
		}
		
		Integer popped_idx, leftChild_poppedIdx, rightChild_poppedIdx, returnData;
		returnData = heap.get(1);
		popped_idx = 1;
		Collections.swap(heap, 1, heap.size()-1);

		heap.remove(heap.size()-1);
		
		while (moveDown(popped_idx)) {
			leftChild_poppedIdx = popped_idx*2;
			rightChild_poppedIdx = popped_idx*2+1;
			
			//CASE2: only left child
			if (leftChild_poppedIdx == heap.size()-1 && rightChild_poppedIdx >= heap.size()) {
				System.out.println("pass1");
				if (heap.get(popped_idx) < heap.get(leftChild_poppedIdx)) {
					
					Collections.swap(heap, popped_idx, leftChild_poppedIdx);
					popped_idx = leftChild_poppedIdx;
				} else {
					break;
				}
			} else {
				//CASE3: if there is left child and right child
				// comapare the values between rightChild and leftChild
				if (heap.get(rightChild_poppedIdx) < heap.get(leftChild_poppedIdx)) {
					System.out.println("pass2-left");
					
					// swap between the popped and the child if the child has bigger value
					if (heap.get(popped_idx) < heap.get(leftChild_poppedIdx)) {
						Collections.swap(heap, popped_idx, leftChild_poppedIdx);
						popped_idx = leftChild_poppedIdx;
					} else {
						break;
					}
					
				} else {
					System.out.println("pass2-right");
					if (heap.get(popped_idx) < heap.get(rightChild_poppedIdx)) {
						Collections.swap(heap, popped_idx, rightChild_poppedIdx);
						popped_idx = rightChild_poppedIdx;
					} else {
						break;
					}
				}
				
				
			}
			
			
			
		}
		
		
		return returnData;
		
	}
	
	public boolean moveDown(Integer popped_idx) {
		// TODO Auto-generated method stub
		//CASE1: if there is no child
		Integer leftChild_poppedIdx = popped_idx*2;
		Integer rightChild_poppedIdx = popped_idx*2+1;
		
		if (leftChild_poppedIdx >= heap.size()) {
			return false;
		}
		
		//CASE2: only left child
		else if (leftChild_poppedIdx == heap.size()-1 && rightChild_poppedIdx >= heap.size()) {
			return true;
		}
		
		//CASE3: if there is left child and right child
		else {
			return true;
		}
		
		
	}

	public boolean moveUp(Integer index) {
		// TODO Auto-generated method stub
		int parentIndex = index/2;
		if (index <= 1) {
			return false;
		} else {
			if (heap.get(index) > heap.get(parentIndex)) {
				
				return true;
			}
			return false;
		}
	}

	public static void main(String[] args) {
		MyHeap myHeap = new MyHeap(15);
		myHeap.insertData(10);
		myHeap.insertData(8);
		myHeap.insertData(5);
		myHeap.insertData(4);
		myHeap.insertData(20);
		System.out.println(myHeap.heap);
		myHeap.pop();
		System.out.println(myHeap.heap);
		myHeap.pop();
		
		System.out.println(myHeap.heap);
		myHeap.pop();
		System.out.println(myHeap.heap);
		myHeap.pop();
		System.out.println(myHeap.heap);
		myHeap.pop();
		System.out.println(myHeap.heap);
	}
}
