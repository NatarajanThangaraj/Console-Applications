package com.natarajanthangaraj.lambdaexpression;
@FunctionalInterface
interface Printable {
	void print();
}
public class Demo {

	public static void main(String[] args) {
		Printable print=new Printable() {

			@Override
			public void print() {
				System.out.println(" Hey, I  print");
			}
			
		};
		print.print();
	}

}

