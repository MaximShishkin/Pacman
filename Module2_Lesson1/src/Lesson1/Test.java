package Lesson1;

public class Test {
	
	private int a;
	private int b;
	private int c;
	private int r;
	/* Существует несколько модификаторов доступа:
	 * public
	 * (без модификатора)
	 * protected
	 * private
	 */
	
	// конструктор класса для площади
	public Test (int inputA, int inputB) {
		a = inputA;
		b = inputB;	
		outS();
	}
	
	// конструктор класса для объёма
	public Test (int inputA, int inputB, int inputC) {
		a = inputA;
		b = inputB;	
		c = inputC;	
		outV();
	}
	
	// конструктор класса  площади круга
	public Test (int inputR) {
		r = inputR;
		outSOval();
	}
	
	// считаем площадь
	private void outS () {
		System.out.println("Площадь фигуры = " + (a * b));
	}
	
	// считаем площадь
	private void outV () {
		System.out.println("Объём фигуры = " + (a * b * c));
	}
	
	// считаем площадь круга
	private void outSOval () {
		System.out.println("Площадь круга = " + (Math.PI * r * r));
	}
}
