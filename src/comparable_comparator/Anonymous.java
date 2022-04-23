package comparable_comparator;

class Rectangle implements Shape {
//	int width = 20;
//	int height = 10;
	int depth = 40;
	public int get(){
		return depth;
	}
	public void get(int a) {}
	
}
/*
 *   말 자체는 어렵지만 쉽게 생각해보면 위 Rectangle 클래스처럼 일반적인 클래스 구현 방식과,
 *   interface 클래스를 implements 하여 interface의 메소드를 재정의하거나,
 *   class 를 상속(extends)하여 부모의 메소드, 필드를 사용 또는 재정의 하는 것들 모두 객체를 구현하는 것이다.
 *   즉, 쉽게 생각하여 'Rectangle을 상속받은 하나의 새로운 class라는 것이다.' 분명 새로운 class인데 이름이 정의되지 않고 있다.
 *   이는 거꾸로 말하면, 이름이 정의되지 않기 때문에 특정 타입이 존재하는 것이 아니기 때문에 반드시 익명 객체의 경우는 상속할 대상이 있어야 한다는 것이다.
 *   이 때, 상속이라 함은 class의 extends 뿐만 아니라 interface의 implements 또한 마찬가지다.
 *   */

interface Shape{
	int width = 10;
	int height = 20;
	int get();
}

public class Anonymous {
	public static void main(String[] args) {
		Rectangle a = new Rectangle();
		
		// anonymous instance1
		Shape anonymous = new Shape() {
			int depth = 40;
			@Override
			public int get() {
				return width*height*depth;
			}
		};
		
		System.out.println(a.get()); // 40
		System.out.println(anonymous.get()); // 10*20*40
		
		
		
	}
}




