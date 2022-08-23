package ru.shishkin.javaLessonModule2.lesson1;

public class Test {
	
	private int a;
	private int b;
	private int c;
	private int r;
	/* ���������� ��������� ������������� �������:
	 * public
	 * (��� ������������)
	 * protected
	 * private
	 */
	
	// ����������� ������ ��� �������
	public Test (int inputA, int inputB) {
		a = inputA;
		b = inputB;	
		outS();
	}
	
	// ����������� ������ ��� ������
	public Test (int inputA, int inputB, int inputC) {
		a = inputA;
		b = inputB;	
		c = inputC;	
		outV();
	}
	
	// ����������� ������  ������� �����
	public Test (int inputR) {
		r = inputR;
		outSOval();
	}
	
	// ������� �������
	private void outS () {
		System.out.println("������� ������ = " + (a * b));
	}
	
	// ������� �������
	private void outV () {
		System.out.println("����� ������ = " + (a * b * c));
	}
	
	// ������� ������� �����
	private void outSOval () {
		System.out.println("������� ����� = " + (Math.PI * r * r));
	}
}
