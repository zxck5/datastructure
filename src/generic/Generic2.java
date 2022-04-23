package generic;
//출처:https://st-lab.tistory.com/153
//제한된 Generic(제네릭)과 와일드 카드
public class Generic2 {
	
/*지금까지는 제네릭의 가장 일반적인 예시들을 보여주었다.
 * 예로들어 타입을 T라고 하고 외부클래스에서 Integer을 파라미터로 보내면 T 는 Integer가 되고,
 *  String을 보내면 T는 String이 된다. 만약 당신이 Student 라는 클래스를 만들었을 때 T 파라미터를 Student로 보내면 T는 Student가 된다.
 *   즉, 제네릭은 참조 타입 모두 될 수 있다. 

근데, 만약 특정 범위 내로 좁혀서 제한하고 싶다면 어떻게 해야할까? */
	
//이 때 필요한 것이 바로 extends 와 super, 그리고 ?(물음표)다. ? 는 와일드 카드라고 해서 쉽게 말해 '알 수 없는 타입'이라는 의미다.	
	
/*<K extends T>	// T와 T의 자손 타입만 가능 (K는 들어오는 타입으로 지정 됨)
<K super T>	// T와 T의 부모(조상) 타입만 가능 (K는 들어오는 타입으로 지정 됨)
 
<? extends T>	// T와 T의 자손 타입만 가능
<? super T>	// T와 T의 부모(조상) 타입만 가능
<?>		// 모든 타입 가능. <? extends Object>랑 같은 의미

extends T : 상한 경계
? super T : 하한 경계
<?> : 와일드 카드(Wild card)


이 때 주의해야 할 게 있다. K extends T와 ? extends T는 비슷한 구조지만 차이점이 있다.

'유형 경계를 지정'하는 것은 같으나 경계가 지정되고 K는 특정 타입으로 지정이 되지만, ?는 타입이 지정되지 않는다는 의미다.
*/
	
	/*
	 * Number와 이를 상속하는 Integer, Short, Double, Long 등의
	 * 타입이 지정될 수 있으며, 객체 혹은 메소드를 호출 할 경우 K는
	 * 지정된 타입으로 변환이 된다.
	 */
	//<K extends Number>
	
	
	/*
	 * Number와 이를 상속하는 Integer, Short, Double, Long 등의
	 * 타입이 지정될 수 있으며, 객체 혹은 메소드를 호출 할 경우 지정 되는 타입이 없어
	 * 타입 참조를 할 수는 없다.
	 */
	//<? extends T>	 T와 T의 자손 타입만 가능
	
	/* Class A,B,C,D,E
	 * B extends A
	 * D extends A
	 * C extends B
	 * E extends D
	<T extends B>	// B 와 C
	<T extends E>	// E 와 E의자손
	<T extends A>	// A 와 B,D,C,E
	 
	<? extends B>	// B와 C
	<? extends E>	// E와 E의자손
	<? extends A>	// A와 BDCE
	*/
	
	/*
	 * 상한 관계. 즉 extends 뒤에 오는 타입이 최상위 타입으로 한계가 정해진다.
	 * 대표적으로 제네릭 클래스에서 수를 표현하는 클래스만 받고 싶은 경우가 있다. 대표적으로 Integer,Long,Double,Byte,Float,Short 같은 
	 * 래퍼 클래스들은 Number Class를 상속받는다.
	 * 즉, Integer,Long,Byte,Double,Float,Short 같은 수를 표현하는 래퍼 클래스 만으로 제한하고싶은경우 다음과같이 쓸수있다.
	 * Public class ClassName <K extends Number>{}
	 * 이렇게 특정 타입 및 그 하위 타입만 제한 하고 싶을 경우 쓰면 된다.
	 * 좀 더 구체적으로 예로 들자면, 다음과 같다. Integer는 Number 클래스를 상속받는 클래스라 가능하지만,
	 * String은 Number클래스와는 완전 별개의 클래스이기 때문에 에러(Bound mismatch)를 띄운다.
	 * */
	
	/* <K super T>, <? super T>
	 * 이 것은 T 타입의 부모(조상) 타입만 가능하다는 의미다. 즉, 다음과 같은 경우들이 있다.
	 *<K super B>	// B와 A타입만 올 수 있음
	  <K super E>	// E, D, A타입만 올 수 있음
      <K super A>	// A타입만 올 수 있음
 
      <? super B>	// B와 A타입만 올 수 있음
      <? super E>	// E, D, A타입만 올 수 있음
      <? super A>	// A타입만 올 수 있음
      
      주석에 썼듯이 보면 알겠지만, 하한 한계. 즉 super 뒤에 오는 타입이 최하위 타입으로 한계가 정해지는 것이다.
	대표적으로는 해당 객체가 업캐스팅(Up Casting)이 될 필요가 있을 때 사용한다.
	예로들어 '과일'이라는 클래스가 있고 이 클래스를 각각 상속받는 '사과'클래스와 '딸기'클래스가 있다고 가정해보자.
	이 때 각각의 사과와 딸기는 종류가 다르지만, 둘 다 '과일'로 보고 자료를 조작해야 할 수도 있다. 
	(예로들면 과일 목록을 뽑는다거나 등등..) 그럴 때 '사과'를 '과일'로 캐스팅 해야 하는데, 과일이 상위 타입이므로 업캐스팅을 해야한다. 이럴 때 쓸 수 있는 것이 바로 super라는 것이다.
	조금 더 현실성 있는 예제라면 제네릭 타입에 대한 객체비교가 있다.
      public class ClassName <E extends Comparable<? super E> { ... }
      
      
	 */
	
	
	
	
	class ClassName <K extends Number> { // Number와 Number의 자식만 파라미터로 들어오고 참조 타입 포함.
		
	}
	
	public static void main(String[] args) {
		
		
		
//		ClassName<Double> cn = new ClassName<Double>(); // okay
//		ClassName<String> cn2 = new ClassName<String>(); //error
	/*Bound mismatch: The type String is not a valid substitute for the bounded parameter <K extends Number> of the type Generic2.ClassName<K>
	*/
//		System.out.println(cn.getClass().getName());
//		System.out.println(cn2.getClass().getName());
	}
}














