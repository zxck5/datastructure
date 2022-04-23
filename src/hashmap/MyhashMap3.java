package hashmap;

import java.util.Scanner;

// Objective:
// Another way to avoid collision.
// this is called Linear Probing

public class MyhashMap3 {
	
	Slot hashtable [] ;
	
	public MyhashMap3(int size) {
		hashtable = new Slot[size];
	}
	
	public class Slot {
		String key;
		String value;
	
		public Slot(String key, String value){
			this.key = key;
			this.value = value;
		}
	}
	// hash function. create address
	public int hashFunc(String key) {
		return (int)key.charAt(0)%hashtable.length;
		
//		int address = 0;
//		for (int i = 0; i < key.length(); i ++) {
//			address += (int)key.charAt(i);
//		}
//		return address%hashtable.length;
		
	}
	
	// put method
	// 1. if the key doesn't exist in the hashtable, put new 
	// 2. if the key exists, find it and change it.
	public boolean saveData(String key, String value) {
		int address = hashFunc(key);
		if (hashtable[address] == null) {
			hashtable[address] = new Slot(key,value);
			return true;
		} else {
//			if (hashtable[address].key.equals(key)) {
//				hashtable[address].value = value;
//				return true;
//			}
			// if address is duplicated. //key1: abc and  key2: cba  their address can be same. 
			int newAddress = (address)%hashtable.length;
			
			while (hashtable[newAddress] != null) {
				// update
				if (hashtable[newAddress].key.equals(key)) {
					hashtable[newAddress].value = value;
					return true;
				} else {
					newAddress ++;
					newAddress = newAddress%hashtable.length;
//					System.out.println(newAddress);
					if (newAddress == address) {
						// nope is just for checking 
						System.out.println("------------nope-----------");
						return false;
					}
					
				}
				
				
				//update
//				if (hashtable[newAddress].key.equals(key)) {
//					hashtable[newAddress].value = value;
//					return true;
//				} else {
//					newAddress ++;
//					if (newAddress >= hashtable.length) {
//						return false;
//					}
//				}
			}
			hashtable[newAddress] = new Slot(key,value);
			return true;
		}
		
	}
	
	public String getData(String key) {
		int address = hashFunc(key);
		System.out.println(address);
		if (hashtable[address] == null) {
			return null;
		} else {
			if (hashtable[address].key.equals(key)) {
				return hashtable[address].value;
			} else {
				int newAddress = (address+1)%hashtable.length;
				System.out.println(newAddress);
				while (hashtable[newAddress] != null) {
					if (hashtable[newAddress].key.equals(key)) {
						return hashtable[newAddress].value;
					} else {
						newAddress++;
						newAddress %= hashtable.length;
						if (newAddress == address) {
							return null;
						}
					}
				}
				return null;
			}
		}
	}
	public void printAll() {
		if (hashtable.length!=0) {
			
			for (Slot i : hashtable) {
				if (i != null) {
					System.out.println("key:"+i.key +"\tvalue:"+i.value +"\taddress"+hashFunc(i.key));					
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("helloWorld");
		MyhashMap3 mainObject = new MyhashMap3(10);
		mainObject.saveData("FaveLee", "01022223333");
		mainObject.saveData("fun-coding", "01033334444");
		mainObject.saveData("cavid", "01044445555");
		mainObject.saveData("cave", "01055556666");
		mainObject.saveData("Fave1", "01055556666");
		mainObject.saveData("Fave2", "01055556666");
		mainObject.saveData("Fave3", "01055556666");
		mainObject.saveData("Fave5", "11111111");
		mainObject.saveData("abc", "010101012222");
		mainObject.saveData("cba", "010102222222");
		mainObject.saveData("cba1", "010102222222");
//		System.out.println(mainObject.getData("cba"));
//
//		
		Scanner scan = new Scanner(System.in);
		String a = scan.next();//David 입력
		mainObject.saveData(a, "1111");
//		System.out.println(mainObject.getData("David"));
		mainObject.printAll();
		System.out.println("enter any key");
		String key = scan.next(); // enter any key
		System.out.println(mainObject.getData(key));
	}
}
