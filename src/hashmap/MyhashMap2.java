package hashmap;

import java.util.Scanner;

// updated. 
// objective:
// fixing the problem of collision by using LinkedList
// this is called Chaining

public class MyhashMap2 {
	
	Slot hashtable [] ;
	
	MyhashMap2 (int size) {
		hashtable = new Slot[size];
	}
	
	public class Slot{
		String key;
		String value;
		
		// linked list
		Slot next = null;
		Slot prev = null;
		
		public Slot(String key, String value){
			this.key = key;
			this.value = value;
			
		}
	}
	
	public int hashFunc(String key) {
		return (int)key.charAt(0)%hashtable.length;
	}
	
	public boolean saveData (String key, String value) {
		int address = hashFunc(key);
		// if the key is not in the table
		if (hashtable[address] == null) {
			hashtable[address] = new Slot(key, value);
			
			return true;
		} else {
			// if the key is in the table
			// check if there is same key in this linked list.
			Slot node = hashtable[address];
			Slot prevPointer = null;
			while (node != null) {
				// finds the same key and changes the value
				//update
				if (node.key.equals(key)) {
					node.value = value;
					return true;
				}
				
				prevPointer = node; 
				node = node.next;
			}
			prevPointer.next = new Slot(key,value);
			prevPointer.next.prev = prevPointer;
			return true;
		}
	}
	public void checkSlot(String key) {
		int address = hashFunc(key);
		if (hashtable[address] != null) {
			
			Slot node = hashtable[address];
			
			while (node.next != null) {
				System.out.println("key:"+node.key+"\tvalue"+node.value );
				node = node.next;
			}
			System.out.println("key:"+node.key+"\tvalue"+node.value);
		}
	}
	
	
	public String getData(String key) {
		int address = hashFunc(key);
		if (hashtable[address] == null) {
			return null;
		} else {
			Slot node = hashtable[address];
			
			while (node != null) {
				if (node.key.equals(key)) {
					return node.value;
				}
				node = node.next;
			}
			return null;
			
		}
	}
	
	
	public static void main(String[] args) {
		MyhashMap2 mainObject = new MyhashMap2(20);
		mainObject.saveData("DaveLee", "01022223333");
		mainObject.saveData("fun-coding", "01033334444");
		mainObject.saveData("David", "01044445555");
		mainObject.saveData("Dave", "01055556666");
//		mainObject.getData("Dave");
//		mainObject.saveData("David", "010444455551");
		System.out.println(mainObject.getData("Dave"));
		mainObject.checkSlot("David");
		
		Scanner scan = new Scanner(System.in);
		String a = scan.next();//David 입력
		mainObject.saveData(a, "1111");
//		mainObject.checkSlot("Dave");
		mainObject.checkSlot("David");
		System.out.println(mainObject.getData("David"));
		for (Slot i : mainObject.hashtable) {
			if (i != null) {
				System.out.println(i.key+i.value);
				while(i.next != null) {
					System.out.println("key="+i.next.key+"value="+i.next.value);
					i = i.next;
				}
			}
		}
//		System.out.println(mainObject.hashtable);
		
	}
}
