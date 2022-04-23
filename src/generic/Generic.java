package generic;
//출처:https://st-lab.tistory.com/153
class ClassName <E> { // 클래스의 경우 
	private E element; // 제네릭 타입 변수
	
	void set(E element) {
		this.element = element;
	}
	E get() {
		return element;
	}
	//제네릭 메소드
	//[접근 제어자] <제네릭타입> [반환타입] [메소드명]([제네릭타입] [파라미터])
	<T> T genericMethod(T o) {
		return o;
	}
	/*
	 * 클래스와 같은 E 타입이더라도
	 * static 메소드는 객체가 생성되기 이전 시점에
	 * 메모리에 먼저 올라가기 때문에
	 * E 유형을 클래스로부터 얻어올 방법이 없다.
	 */
//	static E genericMethod2(E o){
//		return 0;
//	}
	/* 제네릭이 사용되는 메소드를 정적메소드로 두고 싶은 경우 제네릭 클래스와 별도로 독립적인 제네릭이 사용되어야 한다는 것이다.*/
	
	// 아래 메소드의 E타입은 제네릭 클래스의 E타입과 다른 독립적인 타입이다.
	static <E> E genericMethod1(E o){
		return o;
	} 
	static <T> T genericMethod2(T o) {
		return o;
	}
	
	
	
}
//또한 여기서 더 나아가 제네릭 타입을 두 개로 둘 수도 있다. (대표적으로 타입 인자로 두 개 받는 대표적인 컬렉션인 HashMap을 생각해보자.)
class ClassName2 <K,V> {
	private K first; // K 타입 (제네릭)
	private V second; // T 타입 (제네릭)
	
	void set(K first, V second) {
		this.first=first;
		this.second=second;
	}
	K getFirst() {
		return first;
	}
	V getSecond() {
		return second;
	}
	
}
//Interface InterfaceName<T>{} 인터페이스의 경우

class Student{}

class HashMap <K,V>{}
/*
 * 이렇듯 데이터 타입을 외부로부터 지정할 수 있도록 할 수 있다.
 * 그럼 이렇게 생성된 제네릭 클래스를 사용하고 싶을 것이다. 즉, 객체를 생성해야 하는데 이 때 구체적인 타입을 명시를 해주어야 하는 것이다.* 
 */


/*3. 제네릭 메소드

위 과정까지는 클래스 이름 옆에 예로들어 <E>라는 제네릭타입을 붙여 해당 클래스 내에서 사용할 수 있는 E 타입으로 일반화를 했다.

그러나 그 외에 별도로 메소드에 한정한 제네릭도 사용할 수 있다.

일반적으로 선언 방법은 다음과 같다. 
genericMethod()는 파라미터 타입에 따라 T 타입이 결정된다.
*즉, 클래스에서 지정한 제네릭유형과 별도로 메소드에서 독립적으로 제네릭 유형을 선언하여 쓸 수 있다.

그럼 위와같은 방식이 왜 필요한가? 바로 '정적 메소드로 선언할 때 필요'하기 때문이다.

생각해보자. 앞서 제네릭은 유형을 외부에서 지정해준다고 했다. 즉 해당 클래스 객체가 인스턴스화 했을 때, 쉽게 말해 new 생성자로 클래스 객체를 생성하고
 <> 괄호 사이에 파라미터로 넘겨준 타입으로 지정이 된다는 뜻이다.

하지만 static 은 무엇인가? 정적이라는 뜻이다. static 변수, static 함수 등 static이 붙은 것들은 기본적으로 프로그램 실행시 메모리에 이미 올라가있다.
이 말은 객체 생성을 통해 접근할 필요 없이 이미 메모리에 올라가 있기 때문에 클래스 이름을 통해 바로 쓸 수 있다는 것이다.

근데, 거꾸로 생각해보자면 static 메소드는 객체가 생성되기 전에 이미 메모리에 올라가는데 타입을 어디서 얻어올 수 있을까? 
*
*/





public class Generic {
	
	public static void main(String[] args) {
		
		ClassName2<String, Integer> a = new ClassName2<String, Integer>();
		// 외부에서 타입을 지정해주는 방식.
		/*이 때 주의해야 할 점은 타입 파라미터로 명시할 수 있는 것은 참조 타입(Reference Type)밖에 올 수 없다.
		 *  즉, int, double, char 같은 primitive type은 올 수 없다는 것이다.
		 *   그래서 int형 double형 등 primitive Type의 경우
		 *    Integer, Double 같은 Wrapper Type으로 쓰는 이유가 바로 위와같은 이유다.*/
		
		//또한 바꿔 말하면 참조 타입이 올 수 있다는 것은 사용자가 정의한 클래스도 타입으로 올 수 있다는 것이다.
		ClassName<Student> a1 = new ClassName<Student>();
		
		
		ClassName<String> m = new ClassName<String>();
		ClassName<Integer>n = new ClassName<Integer>();
		
		m.set("10");
		n.set(10);
		System.out.println("m data: "+ m.get());
		//반환된 변수타입 출력
		System.out.println("m의 E type: "+m.get().getClass().getName());
		
		System.out.println("n data: "+n.get());
		//반환된 변수타입 출력
		System.out.println("n의 E type: "+n.get().getClass().getName());
		
		System.out.println("--------------------------------------");
		ClassName2<String, Integer> b = new ClassName2<String,Integer>();
		b.set("10", 10);
		
		System.out.println("first data : "+b.getFirst());
		//반환된 변수타입 출력
		System.out.println("K type : "+b.getFirst().getClass().getName());
		System.out.println("second data :"+b.getSecond());
		//반환된 변수타입 출력
		System.out.println("V type: "+b.getSecond().getClass().getName());
		
		//이렇게 외부 클래스에서 제네릭 클래스를 생성할 때 <> 괄호 안에 타입을 파라미터로 보내 제네릭 타입을 지정해주는 것. 이 것이 바로 제네릭 프로그래밍이다.
		
		//제네릭 메소드 Integer
		System.out.println("<E> returnType: "+ m.genericMethod(3).getClass().getName());
		//제네릭 메소드 String
		System.out.println("<E> returnType: "+ m.genericMethod("ABCD").getClass().getName());
		//제네릭 메소드 ClassName b
		System.out.println("<T> returnType: "+m.genericMethod(n).getClass().getName());
		//제네릭 메소드 double
		System.out.println("<E> returnType: "+ClassName.genericMethod1(3.0).getClass().getName());
		
	}
}
