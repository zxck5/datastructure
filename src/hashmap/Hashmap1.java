package hashmap;
import java.util.Map;
import java.util.HashMap;
/*
 * Map은 HashMap의 상위 객체?
 * no. map is interface, and HashMap is implementing map interface. 
 * 
 * Hashmap is quick and less stable than hashtable
 * only <key,value> structure. And key should not be duplicated.
 * 
 * 
 * */
// map을 참조하여 hashmap을 형성하는 원리는 이와같다.
class Student implements Fightable{
	
}

public class Hashmap1 {
	public static void main(String[] args) {
		System.out.println(HashMap.class.getSuperclass());
		
		Fightable f = new Student(); // fightable type -> interface type. created as Student class.
		
		
		Map<String,Integer> map=new HashMap();	//<키 자료형, 값 자료형>
		map.put("A", 100);
		map.put("B", 101);
		map.put("C", 102);
		map.put("C", 103); //중복된 key가 들어갈때는 이전 키,값을 지금의 것으로 업데이트
		System.out.println(map);
		System.out.println(map.get("A"));
		System.out.println(map.get("B"));
		System.out.println(map.get("C"));
		
		//containsKey()
		map.clear();
		map.put("key1", 100);
		map.put("key2", 200);
		if (!map.containsKey("key2")) {
			map.put("key2", 300);
		}
		System.out.println(map);
		//containsValue()
		if (!map.containsValue(300)) {
			map.put("key3", 300);
		}
		System.out.println(map);
		//putAll()
		map.clear();
		Map<String, Integer> map2 = new HashMap();
		//map1 put
		map.put("map1-key1", 100);
		map.put("map1-key2", 200);
			
		//map2 put
		map2.put("map2-key3", 300);
		map2.put("map2-key4", 400);
			
		System.out.println("map:"+map);
		System.out.println("map2:"+map2);
		// map2 에 map1을 합치다
		map2.putAll(map);
		System.out.println("map2 includes map1:"+map2);
		map.put("map1-key1", 1000);
		// map2에는 영향없음.
		System.out.println("map2 includes map1:"+map2);		
		System.out.println("map:"+map);
		//생성과 동시에 맵넘겨주기
		Map <String,Integer> map1 = new HashMap<String,Integer>(map2);
		System.out.println();
		System.out.println("생성과 동시에 map2넘겨받기 "+map1);
		
		System.out.println("----------------------------");
		System.out.println("keyset");
		//keySet 
		System.out.println(map.keySet());
		
		for (String key : map.keySet()) {
			System.out.println("{"+key+","+map.get(key)+"}");
		}
		System.out.println("--------------");
		System.out.println();
		//Foreach()함수 
		//람다식 숙지해야함.
		Map<String,Integer> hm=new HashMap();
		hm.put("http",80);
		hm.put("ssh", 22);
		hm.put("dns", 53);
		hm.put("telnet",23);
		hm.put("ftp", 21);
	
		hm.forEach((key,value)->
		{
			System.out.println("{"+key+","+value+"}");
		});	
	
		// 내가 만든 객체를 Key로 사용하기(나의 객체를 같은 키로 판단하는 방법)
		
	
	
	}
}
