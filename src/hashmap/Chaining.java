package hashmap;


//updated. 
//objective:
//fixing the problem of collision by using LinkedList
//this is called Chaining

public class Chaining {
	// basic form
		Slot[] hashmap;
		// constructor
		public Chaining(int size){
			hashmap = new Slot[size];
		}
		
	
		public class Slot{
			String value;
			String key;
			
			Slot next = null;
			Slot prev = null;
			
			public Slot (String key, String value) {
				this.value = value;
				this.key = key;
			}
		}
		
		// 
		public Integer hashFunc(String key) {
			return (Integer)(key.charAt(0)%hashmap.length);
		}
		
	
	
		public Boolean put(String key, String value) {
			int address = hashFunc(key);
			
			if (hashmap.length == 0) {
				hashmap[address] = new Slot(key,value);
				return true;
			} else {
				if (hashmap[address] == null) {
					hashmap[address] = new Slot(key,value);
					return true;
				}
				
				Slot node = hashmap[address];
				while (node.next != null) {	
					node = node.next;
				}
				
				node.next = new Slot(key,value);
				node.next.prev = node;
				
				return true;	
			}
		}
		public String get(String key) {
			int address = hashFunc(key);
			if (hashmap.length == 0) {
				return null;
			} else {
				Slot node = hashmap[address];
				while (node != null) {
					if (key.equals(node.key)) {
						return node.value;						
					}
					node = node.next;
				}
				return null;
			}
			
			
		}
		public void checkSlot(String key) {
			int address = hashFunc(key);
			if (hashmap[address] == null) {
				System.out.println("no data");
			} else {
				Slot node = hashmap[address];
				while (node != null) {
					System.out.print(node.key+": "+node.value+"\t");
					node = node.next;
				}
			}
			
		}
	
	
	
	
	
	public static void main(String[] args) {
		Chaining ob = new Chaining(20);
		ob.put("abcMart", "111-222-333");
		ob.put("bart", "222-333-333");
		ob.put("zoo", "zoo-222-333");
		ob.put("cat", "cat-222-333");
		ob.put("zealot", "this is zealot");
		for (int i = 0; i < ob.hashmap.length; i ++) {
			System.out.println(i +" : " + ob.hashmap[i]);
		}
		System.out.println(ob.get("zealot"));
		System.out.println(ob.get("zoo"));
		ob.checkSlot("z");
	}
}
