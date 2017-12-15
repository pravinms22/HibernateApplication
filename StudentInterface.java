package com.scp.hibernate;

import java.util.List;

public interface StudentInterface {

	public boolean add(Student s) throws Exception;
	public Student get(int id) throws Exception;
	public boolean update(Student s) throws Exception;
	public boolean delete(int id) throws Exception;
	public List<Student> getListofStudent();
	public List<Student> searchWithCriteria(String s,StudentTest.SearchParam param) throws Exception;
}
