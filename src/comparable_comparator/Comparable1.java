package comparable_comparator;

import java.util.Comparator;

class Student implements Comparable<Student>,Comparator<Student> {
	 
	int age;			// 나이
	int classNumber;	// 학급
	
	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}
	
	@Override
	public int compareTo(Student o) {
    /*
		// 자기자신의 age가 o의 age보다 크다면 양수
		if(this.age > o.age) {
			return 1;
		}
		// 자기 자신의 age와 o의 age가 같다면 0
		else if(this.age == o.age) {
			return 0;
		}
		// 자기 자신의 age가 o의 age보다 작다면 음수
		else {
			return -1;
		}
	}
	*/
		return this.age-o.age;
		
	}
	/*int 자료형은 32비트(4바이트) 자료형이며 표현 범위가 -2^31 ~ 2^31-1 으로, 이를 풀어쓰면 -2,147,483,648 ~ 2,147,483,647 이다.
	 * if the return value is 2^31+1----> -2,147,483,648(minimum value of int) UnderFlow
	 * -2^31-1 ->>> 2,147,483,647(maximum value of int) Overflow
	 * 
	 * [Comparable의 특징]
		1. 자기 자신과 매개변수를 비교한다.
		2. compareTo 메소드를 반드시 구현해야한다. 
	 * 
	 * 
	 * 
	 * */

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		
		// o1의 학급이 o2의 학급보다 크다면 양수
		if (o1.classNumber>o2.classNumber) {
			return 1;
			// o1의 학급이 o2의 학급보다 작다면 음수
		} else if (o1.classNumber < o2.classNumber) {
			return -1;
			// o1의 학급이 o2의 학급과 같다면 0
		} else {
			return 0;
		}
	}
}
public class Comparable1 {
	public static void main(String[] args) {
		
		Student a = new Student(17,2);
		Student b = new Student(15,3);
		int value = a.compareTo(b);
		if (value == 0 ) {
			System.out.println("same");
		} else if (value < 0) {
			System.out.println("b is older");
		} else if (value > 0) {
			System.out.println("a is older");
		}
		
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		System.out.println(min-1); // returns maximum value of integer
		System.out.println(max+1); // returns minimum value of integer
		
		
		
		
	}
	
	
}
