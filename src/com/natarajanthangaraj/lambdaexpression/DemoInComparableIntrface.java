package com.natarajanthangaraj.lambdaexpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DemoInComparableIntrface {

	public static void main(String[] args) {
		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student(28, "Alen"));
		stuList.add(new Student(88, "Rahul"));
		stuList.add(new Student(68, "Fill"));
		stuList.add(new Student(45, "Raja"));
		stuList.add(new Student(56, "Ricky"));
		stuList.add(new Student(98, "Sharif"));
		System.out.println("      Before using Comparator");
		printer(stuList);
		Collections.sort(stuList,new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.mark==o2.mark)
				return 0;
				else if(o1.mark>o2.mark)
					return 1;
				else
					return-1;
			}
			
		});
		System.out.println("      After using Comparator");
		printer(stuList);

	}

	static void printer(List<Student> list) {

		for (Student stu : list) {
			System.out.println(stu.name + "  " + stu.mark);
		}
	}

}

class Student  {
	int mark;
	String name;

	Student(int mark, String name) {
		this.mark = mark;
		this.name = name;
	}

//	@Override
//	public int compareTo(Student obj) {
//		if (mark == obj.mark)
//			return 0;
//		else if (mark > obj.mark)
//			return 1;
//		else
//			return -1;
//	}
//	list.forEach(
//	(Student stu)->System.out.println(stu.name + "  " + stu.mark));
}
