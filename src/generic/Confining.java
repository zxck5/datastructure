package generic;
// How will we restrict some of the types and pass only the types we want?
// Let's study about confined generic and wild card.

// we have to use[ extend, super ] terminology.
// This is quiet similar with polymorphism


/* B,D extends A . C extends B, E extends D;
<T extends B>	// B and C types only
<T extends E>	// E types only
<T extends A>	// A, B, C, D, E types allowed
 
<? extends B>	// B and C types only
<? extends E>	// E types only.
<? extends A>	// A, B, C, D, E types allowed

for example:
<T extends Integer> -> only sub types of Integer and Integer allowed
<T extends Number> -> all the sub types of Number and Number is allowed. 
*/

class ClassName5 <K extends Number> {
	
}
class ClassName6 <E extends Comparable<? super E>>{
	
}

class Person {

	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	}}

class Student2 extends Person implements Comparable<Person> {

	@Override
	public int compareTo(Person o) {//upcasting
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}

public class Confining {
	ClassName5<Double> a1 = new ClassName5<Double>(); //working
	
//	ClassName5<String> a2 = new ClassName5<String>();// not working.
	
	
	/*
	 	<K super B>	// B and A type
		<K super E>	// E, D, A type
		<K super A>	// A type
 
		<? super B>	// B and A types
		<? super E>	// E, D, A types
		<? super A>	// A type only
		this situation is can be used when we do upcasting.
		example: ClassName <E extends Comparable<? Super E>{} // this is the case when we need to compare E and upper types of E
		// this means E type or class should implement comparable method. 
	*/
	ClassName6<Student2> cn6 = new ClassName6<Student2>();
	// it can cause error if we leave class ClassName6 <E extends Comparable<E>>. When there is parent class of Person, 
	
	/*
	쉽게 말하면 Person을 상속받고 Comparable 구현부인 comparTo에서 Person 타입으로 업캐스팅(Up-Casting) 한다면 어떻게 될까?

	만약 <E extends Comparable<E>>라면 SoltClass<Student> a 객체가 타입 파라미터로 Student를 주지만,
 	Comparable에서는 그보다 상위 타입인 Person으로 비교하기 때문에
	Comparable<E>의 E인 Student보다 상위 타입 객체이기 때문에 제대로 정렬이 안되거나 에러가 날 수 있다.
	그렇기 때문에 E 객체의 상위 타입, 즉 <? super E> 을 해줌으로써 위와같은 불상사를 방지할 수가 있는 것이다.
	 */
	
	
	
}
