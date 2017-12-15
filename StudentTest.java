package com.scp.hibernate;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
	
	public enum SearchParam{
		ID,
		NAME,
		AGE,
		PERCENTAGE,
		ALL
		
	}

	
	public static void main(String[] args) throws MyException {
		Student s=null;
		StudentImplemen s1=new StudentImplemen();
		
		//Saving objects
		
		s=new Student(1, "Pravin", 27, 90);
		System.out.println(s1.add(s));
		s=new Student(2, "Chaitu", 26, 91);
		System.out.println(s1.add(s));
		s=new Student(3, "Sonu", 20, 88);
		System.out.println(s1.add(s));
		s=new Student(4, "priya", 25, 80);
		System.out.println(s1.add(s));
		s=new Student(5, "scooby", 50, 30);
		System.out.println(s1.add(s));
		s=new Student(6, "mooby", 22, 33);
		System.out.println(s1.add(s));
		
		// Retrieving object from DB
		
		System.out.println("retriving object");
		System.out.println(s1.get(3));
		System.out.println("Object retrived");
		
		//updating object
		
		System.out.println("updating object");
		s.setName("soobydooby");
		s1.update(s);
		System.out.println("Object updated");
		
		//deleting object
		
		System.out.println("deleting object");
		s1.delete(5);
		System.out.println("Object deleted");
		
		//Retiring all data from DB
		
		System.out.println("retriving list from DB");
		List<Student> list=new ArrayList<>();
		list=s1.getListofStudent();
		for(Student tempStudent: list)
			System.out.println(tempStudent);
		System.out.println("list finished");
		
		// Retrieving object with criteria
		
		System.out.println("getting list with criteria");
		List<Student> list1=new ArrayList<>();
		list1=s1.searchWithCriteria("20", SearchParam.AGE);
		for(Student tempStudent: list1)
			System.out.println(tempStudent);
		System.out.println("recieved list with criteria");
		
		
		
	}
}
