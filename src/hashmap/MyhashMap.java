package hashmap;

public class MyhashMap {
	
	
	Slot hashtable[];
	
	MyhashMap (Integer size){
		hashtable = new Slot[size];
	}
	
	public class Slot {
		String value;
		
		Slot(String value) {
			this.value = value;
		}
		
	}
	//division
	public int hashFunc(String key) {
		return (int)key.charAt(0)%hashtable.length;
			
	}
	// mapping put method
	public boolean saveData(String key, String value) {
		int address = hashFunc(key);
		if (hashtable[address] == null) {
			hashtable[address] = new Slot(value);
			return true;
			
		} else {
			hashtable[address] = new Slot(value);
			return true;
		}
	}
	public String getData(String key) {
		int address = hashFunc(key);
		if (hashtable[address] == null) {
			return null;
		} else {
			return hashtable[address].value;
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		MyhashMap mainObject = new MyhashMap(20);
		mainObject.saveData("DaveLee", "01022223333");
		mainObject.saveData("fun-coding", "01033334444");
		System.out.println(mainObject.getData("Da"));
		System.out.println(mainObject.getData("DaveLee"));
		System.out.println(mainObject.getData("fun-coding"));
		
	}
}
