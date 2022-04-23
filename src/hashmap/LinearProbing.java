package hashmap;
//Objective:
//Another way to avoid collision.
//this is called Linear Probing
public class LinearProbing {
	
	Slot[] hashmap ;
	int size;
	
	public LinearProbing(int size) {
		hashmap = new Slot[size];
		this.size = size;
	}
	
	public class Slot {
		String key;
		String value;
		
		Slot(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public Integer hashFunc(String key) {
		return (int)(key.charAt(0)%hashmap.length);
	}
	
	public boolean putData(String key,String value) {
		int address = hashFunc(key);
		if (hashmap.length == 0) {
			hashmap[address] = new Slot(key,value);
			return true;
		} else {
			int firstAddress = address;
			while (hashmap[address] != null) {
				// if the key is same
				if (hashmap[address].key.equals(key)) {
					hashmap[address].value = value;
					return true;
				}
				
				address += 1;
				address %= hashmap.length;
				if (address == firstAddress) {
					System.out.println("full data");
					return false;
				}
			}
			// if the address is null
			System.out.println("address="+address);
			System.out.println("create new address data");
			hashmap[address] = new Slot(key,value);
			return true;
			
		}
	}
	public String getData(String key) {
		int address = hashFunc(key);
		if (hashmap.length == 0) {
			return null;
		} else {
			int firstAddress = address;
			while (hashmap[address] != null) {
				if (hashmap[address].key.equals(key)) {
					return hashmap[address].value;
				}
				
				address ++;
				address %= hashmap.length;
				if (address == firstAddress) {
					System.out.println("no data");
					return null;
				}
			}
			
			return null;
		}
	}
	
	public void clearData() {
		hashmap = new Slot[size];
	}
	
	
	public static void main(String[] args) {
		LinearProbing ob = new LinearProbing(20);
		ob.putData("abc", "123");
		ob.putData("abc1", "123");
		ob.putData("abc2", "123");
		ob.putData("abc3", "123");
		ob.putData("abc4", "123");
		ob.putData("abc5", "123");
		ob.putData("abc6", "123");
		ob.putData("abc7", "123");
		ob.putData("abc8", "123");
		ob.putData("abc9", "123");
		ob.putData("abc10", "123");
		ob.putData("abc11", "123");
		ob.putData("abc12", "123");
		ob.putData("abc13", "123");
		ob.putData("abc14", "123");
		ob.putData("abc15", "123");
		ob.putData("abc16", "123");
		ob.putData("abc17", "123");
		ob.putData("abc18", "123");
		ob.putData("abc19", "123");
		ob.putData("abc1", "1234");
		
		for (int i = 0; i < ob.hashmap.length; i++) {
			System.out.println(ob.hashmap[i] + ": "+ "key:"+ ob.hashmap[i].key + ": " + "value" + ob.hashmap[i].value);
		}
		// no data
		System.out.println(ob.getData("abc20"));
		// full data
		ob.putData("abc20", "full");
		// clear data
		System.out.println("-----------------");
		ob.clearData();
		ob.putData("abc", "123");
		ob.putData("bc", "123");
		ob.putData("c2", "123");
		ob.putData("c3", "123");
		ob.putData("c4", "123");
		ob.putData("Z5", "123");
		for (int i = 0; i < ob.hashmap.length; i++) {
			if (ob.hashmap[i] != null) {
				System.out.println(ob.hashmap[i] + ": "+ "key:"+ ob.hashmap[i].key + ": " + "value" + ob.hashmap[i].value);				
			} else {
				System.out.println("null");
			}
		}
		
	}
}
