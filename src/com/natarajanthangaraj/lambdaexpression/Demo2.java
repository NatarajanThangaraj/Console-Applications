package com.natarajanthangaraj.lambdaexpression;

@FunctionalInterface
interface Workable{
	int Add(int num1,int num2);
}

public class Demo2 {

	public static void main(String[] args) {
		Workable work=new Workable() {

			@Override
			public int Add(int num1, int num2) {
				return num1+num2;
			}
			
		};
     System.out.println( " The sum is "+work.Add(20,7));
	}

}
