package generic;


class ClassName3<E>{
	
	private E element;
	
	public void setElement(E e) {
		this.element=e;
	}
	public E getElement() {
		return element;
	}
}
class ClassName4<T,K>{
	private T element;
	private K element2;
	
	public T getElement() {
		return element;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
	
	public K getElement2() {
		return element2;
	}
	public void setElement2(K element2) {
		this.element2 = element2;
	}
	
	public <V> V genericMethod1(V o) {
		return o;
	}
	// it works. because <>generic-> K type is independent type from K in className4
	public static <K> K genericMethod2(K o) {
		return o;
	}
	// error.
//	public static T genericMethod3(T o) {
//		return o;
//	}
	
	
}

public class Basic {
	public static void main(String[] args) {
		
		///선언부///
		ClassName2<String,Integer> a = new ClassName2<String, Integer>();
		// T는 string. K 는 Integer. ClassName2 는 public class ClassName2<T,K> {}로 정의 되어있음.
		
		// type parameter -> primitive X wrapper class O. Reference Type only. int, double, char X
		
		
		///제네릭 클래스///
		
		ClassName<String> b = new ClassName<String>(); // b라는 className 객체 생성.  
		
		System.out.println("b의 해당 클래스:"+b.getClass().getName());
		
		
		ClassName3<String> cn = new ClassName3<String>(); // 클래스 네임3 생성.
		cn.setElement("이녀석은 문자입니다");
		System.out.println("cn의 element:"+cn.getElement());
		System.out.println("해당 element의 타입:"+cn.getElement().getClass().getName());
		System.out.println("--------------------------");
		//cn.setElement(10); 오류. 해당 인스턴스 cn은 String 문자가 쓰였기 때문에 함수 사용 불가.
		
		ClassName3<Integer> cn2 = new ClassName3<Integer>(); // 정수를 element로 하기위해선 새로운 인스턴스 생성하고 그녀석의 타입을 지정해줘야한다.
		cn2.setElement(10);
		System.out.println("cn2의 element"+cn2.getElement());
		System.out.println("해당 element의 타입:"+cn2.getElement().getClass().getName());
		System.out.println("--------------------------");
		
		// 만약 하나의 인스턴스에 두가지타입을 담고 다루고 싶다면?
		ClassName4<Integer,String> cn3 = new ClassName4<Integer,String>();
		cn3.setElement(10);// Integer
		System.out.println("cn3의 T element:"+cn3.getElement());
		System.out.println("cn3의 T element의 타입:"+cn3.getElement().getClass().getName());
		cn3.setElement2("this is string");// String
		System.out.println("cn3의 K element:"+cn3.getElement2());
		System.out.println("cn3의 K element의 타입:"+cn3.getElement2().getClass().getName());
		//for example, hashmap<Key,Value> is same case.
		
		
		//제네릭 메소드//
		System.out.println("--------------------------------------------");
		System.out.println("this is generic method.");
		// can return generic type 
		System.out.println("returning V value:"+cn3.genericMethod1(10));
		System.out.println("returning V type:"+cn3.genericMethod1(10).getClass().getName());
		System.out.println("--------------------------------------------");
		System.out.println("returning V value:"+cn3.genericMethod1("helloWorld"));
		System.out.println("returning V type:"+cn3.genericMethod1("helloWorld").getClass().getName());
		System.out.println("--------------------------------------------");		
		System.out.println("returning V value:"+cn3.genericMethod1(cn));
		System.out.println("returning V type:"+cn3.genericMethod1(cn).getClass().getName());
		
		//즉, 클래스에서 지정한 제네릭유형과 별도로 메소드에서 독립적으로 제네릭 유형을 선언하여 쓸 수 있다.
		//therefore, we can declare any generic type aside from the types that are defined in the class by using this return generic method.
		/*
		 * now here is a problem. This kind of method is commonly used as static method. But when we use static method, when program start,
		 * the memory is going to be appeared in static as this program begins. So if the type is not declared at the beginning, it will
		 * cause an error.
		 * So how do we make it into static method? How will we able to declare a type for generic for static memory? 
		 * 
		 * 그렇기 때문에 제네릭이 사용되는 메소드를 정적메소드로 두고 싶은 경우 제네릭 클래스와 별도로 독립적인 제네릭이 사용되어야 한다는 것이다.public static <E> E returnValue(E e){}
		 * 
		 * */
		System.out.println("test1: returning static method Vtype:"+ClassName4.genericMethod2("helloWorld"));
		// it is working. However, if we don't set <>generic at first, and want to return the type T, it has initial error.
//		System.out.println("test2: returning static method Ttype:"+ClassName4.genericMethod3(3));
	}
}
