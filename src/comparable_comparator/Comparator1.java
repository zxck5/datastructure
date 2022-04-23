package comparable_comparator;
import java.util.Comparator;
//두 매개변수 객체를 비교.

//출처:https://st-lab.tistory.com/243

class ClassName implements Comparator<Student> {

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

public class Comparator1 {
	// 익명 객체 방법 2 class Comparator1의 attribute으로 설정. 전역변수로 설정.
	public static Comparator<Student> comp2 = new Comparator<Student>() {
		
		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o1.classNumber-o2.classNumber;
		}
		
	};
	public static Comparator<Student> comp3 = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return o1.age-o2.age;
		}
	};
	// 외부에서 익명 객체로 Comparator가 생성되기 때문에 클래스에서 Comparator을 구현 할 필요가 없어진다.
	
	
	
	public static void main(String[] args) {
		
		Student a = new Student(17,2);
		Student b = new Student(16,1);
	
		ClassName cn = new ClassName();
		if (cn.compare(a,b) == 1) {
			System.out.println("a가 b보다 크다");
		} else if (cn.compare(a, b) == 0) {
			System.out.println("a와b가 같다");
		} else {
			System.out.println("b가 a보다 크다");
		}
		
		Student c = new Student(18,3);
		c.compare(a, b); // a랑b를 비교하기위해선 c를 생성해야 하기도한다. 
		a.compare(a, b); // 이런 방법도 있음.
		// 무분별하게 c를 생성해서 둘을 비교하는것보다 더 효율적인 방법이 있을까?
		//"익명 객체(클래스)를 활용한다"-> '이름이 정의되지 않은 객체'
		/*
		 *  그럼 이름이 정의되지 않는다는 것은 무엇일까?
			우리가 클래스를 생성할 때 class 키워드 다음에 이름을 정의했다. 하지만, 이름 없이 class를 정의할 수 있는가? 불가능 하다.
			하지만, 우리의 고민처럼 특정 구현 부분만 따로 사용한다거나, 부분적으로 기능을 일시적으로 바꿔야 할 경우가 생길 때가 있다. 이럴 때 사용할 수 있는 것이 바로 익명객체
		 * 
		 * */
		// 익명 객체 방법 1: main함수 안에 지역변수로 설정
		Comparator<Student> comp1 = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.classNumber-o2.classNumber;
			}
		};
		
		if (comp2.compare(a,b) >0) {
			System.out.println("a가 b보다 크다");
		} else if (comp2.compare(a, b) == 0) {
			System.out.println("a와b가 같다");
		} else {
			System.out.println("b가 a보다 크다");
		}
		/*
		 *  익명 객체를 사용하면 좋은 점이 하나 더 있다. 다시 한 번 복기해보자. 익명 객체는 이름이 정의되지 않은 하나의 새로운 클래스와 같다고 보면 된다.
			클래스를 상속(구현)할 때, 이름만 다르게 하면 몇 개던 여러개를 생성할 수 있듯이, 익명 객체 또한 마찬가지다. 다만, 이름이 없을 뿐이라는 것이다.
			즉, 익명 객체를 가리키는 변수명만 달리하면 몇 개든 자유롭게 생성할 수 있다. 위 예제에서는 학급을 기준으로 대소 비교를 했지만, 만약 나이를 기준으로도
			대소 비교를 하고 싶다면 다음과 같이 하나의 또다른 익명 객체를 생성 할 수 있다는 것이다.
		 * */
		
		
	}
	
}
