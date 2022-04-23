package disjointSet;

import java.util.Arrays;
import java.util.HashMap;

/*
 * X = {1, 2, 3, 4, 5} and Y = {6, 7, 8, 9, 10} are disjoint sets
   because they do not have any elements in common and we can write: X ∩ Y = ∅.
 * X = {1, 2, 3, 4, 5} and Y = {5, 6, 7, 8, 9} --> X ∩ Y = 5, not a disjointset
 * 
 * tree
 * 
 * makeSet
 * 
 * we give elements numbers -> ex) 1,2,3,4,5
 * initializing parents as their assigned numbers --> 1->1(parents), 2->2(parents), 3->3(parents), 4->4(parents), 5->5(parents)
 * 
 * 모두 각각 독립된 집합으로 분리하는 과정이다.
 * 서로소 집합은 대상 원소가 각각 어떤집합에 포함되어 있는지 번호를 주어 표시한다.
 * 자기 자신의 원소번호를 자신이 속해있는 집합으로 초기화 한다. 
 * 
 * Union (by rank)
 * 
 * it is a method to merge the sets. if they have different parents, they will be merged to have same parents.
 * 
 * 1. the value of parents which has smaller value will be the common parents. 
 * 
 * 
 * 2. by rank --> we put rank array []. Rank is like the depth of the tree. 
 * firstly, we use Find() method to find the parents.
 * if the parents have same rank, we put either of them as a parent.
 * if the parents do not have same rank, we assign their parent which have bigger rank. 
 * 
 * Find --> its purpose is to find the parent of the element
 * 
 * 2. path compression
 * we link all the child to one parent
 *     1              1
 *    /             /  \       
 *   2             2    3
 *  /
 * 3
 * */


public class DisjointSet {

	
	public int[] makeSet(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		return arr;
	}
	
	
	// path compression
	public int find(int parent[], int x) {
		if (x == parent[x]) {
			return x;
		}
		System.out.println("x="+x);
		System.out.println("parent[x]="+parent[x]);
		return parent[x] = find(parent, parent[x]);
		
	}
	
// path compression
//	public int find(int parent[], int x) {
//		if (x != parent[x]) {
//			parent[x] = find(parent, parent[x]);
//		} 
//		return parent[x];
//	}
	
	public void union(int parent[], int a, int b) {
		// find parents
		int o1 = find(parent,a);
		int o2 = find(parent,b);
		System.out.println("o1="+o1);
		System.out.println("o2="+o2);
		if (o1 > o2) {
			parent[o1] = o2;
		} else {
			parent[o2] = o1;
		}
		
	}
	public void union(int parent[], HashMap<Integer, Integer> rank, int a, int b) {
		int o1 = find(parent,a);
		int o2 = find(parent,b);
		if (rank.get(o1) > rank.get(o2)) {
			parent[o2] = o1;
		} else {
			parent[o1] = o2; 
			if (rank.get(o1) == rank.get(o2)) {
				rank.put(o2, rank.get(o2)+1);
			}
		}
	}
	public static void main(String[] args) {
		DisjointSet test = new DisjointSet();
		int parent[] = new int[5]; // parent => 0,1,2,3,4
		parent = test.makeSet(parent);
		
		HashMap <Integer, Integer> rank = new HashMap<>(); 
		for (int i = 0; i < parent.length; i ++ ) {
			rank.put(parent[i], 0);
		}
		System.out.println(rank);
		// each index (node) is directing themselves
		System.out.println(Arrays.toString(parent));
		
		System.out.println(test.find(parent,0));
		
		test.union(parent,rank, 0, 1);
		// 0-> 0, 1 -> 0
		System.out.println(Arrays.toString(parent));
		
		System.out.println(test.find(parent, 1));
		System.out.println(rank.get(1));
		test.union(parent,rank, 1, 2);
		// 1 -> 0, 2-> 0
		System.out.println(Arrays.toString(parent));
		
		test.union(parent,rank, 3, 4);
		System.out.println(Arrays.toString(parent));
		// 3 -> 3, 4->3
		
		test.union(parent,rank, 2, 4);
		System.out.println("--------------------");
		System.out.println(Arrays.toString(parent));
		System.out.println(test.find(parent, 4));
		System.out.println(rank);
	}
	
	
}
