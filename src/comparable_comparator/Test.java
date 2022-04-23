package comparable_comparator;
// testing if int[] is class. 
// difference between int and int[] as a class
public class Test {
	public static void main(String[] args) {
		test(Test.class);
		test(int[].class);
		System.out.println("-----");
		test(int.class);
		}

		static void test(Class c) {
		System.out.println("class name:"+c.getName());
		System.out.println("c의 super class:"+c.getSuperclass());
		for (Class Interface : c.getInterfaces())
			System.out.println(Interface);
		}
}
