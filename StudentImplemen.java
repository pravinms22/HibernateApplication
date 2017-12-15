package com.scp.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.scp.hibernate.StudentTest.SearchParam;



public class StudentImplemen implements StudentInterface {
	
	@Override
	public boolean add(Student s) throws MyException {
		checkNulls(s);
		
		Session session=(Session) SessionUtil.genarateFacrory().openSession();
		try {
		Transaction t=session.beginTransaction();
		session.save(s);
		t.commit();
		}
		catch(Exception e){
			System.out.println("error while communicating to DB");
			e.printStackTrace();
		}
		finally {
		session.close();
		}
		
		return true;
	}

	private void checkNulls(Student s) throws MyException {
		if(null == s || null==s.getName()  )
			throw new MyException("Object or its fields can not be Null");
			if (s.getAge()<=0 || s.getId()<=0 || s.getPercentage()<=0)
				throw new MyException("Values can not be negative");
	}

	@Override
	public Student get(int id) throws MyException {
		if(id<=0 )
			throw new MyException("id can not be zero or negative");
		Student s=null;
		Session session=(Session) SessionUtil.genarateFacrory().openSession();
		try {
		Transaction t=session.beginTransaction();
		s=session.get(Student.class, id);
		t.commit();
		}catch(Exception e){
			System.out.println("error while communicating to DB");
			e.printStackTrace();
		}
		finally {
		session.close();
		}
		return s;
	}

	@Override
	public boolean update(Student s) throws MyException {
		checkNulls(s);
		Session session=(Session) SessionUtil.genarateFacrory().openSession();
		try {
		Transaction t=session.beginTransaction();
		session.update(s);
		t.commit();
		}
		catch(Exception e){
			System.out.println("error while communicating to DB");
			e.printStackTrace();
		}
		finally {
		session.close();
		}
		
		return true;
	}

	@Override
	public boolean delete(int id) throws MyException {
	
		Session session=(Session) SessionUtil.genarateFacrory().openSession();
		try {
		Transaction t=session.beginTransaction();
		session.delete(get(id));
		t.commit();
		}
		catch(Exception e){
			System.out.println("error while communicating to DB");
			e.printStackTrace();
		}
		finally {
		session.close();
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getListofStudent() {
		List<Student> theStudent=null;
		Session session=(Session) SessionUtil.genarateFacrory().openSession();
		try {
		Transaction t=session.beginTransaction();
		theStudent=session.createQuery("from Student").getResultList();	
		t.commit();
		}
		catch(Exception e){
			System.out.println("error while communicating to DB");
			e.printStackTrace();
		}
		finally {
		session.close();
		}
		return theStudent;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> searchWithCriteria(String s, SearchParam param) throws MyException {
		if (null==s)
			throw new MyException("dont send object null");
		List<Student> theStudent=null;
		String temp="'"+s+"'";
		Session session=(Session) SessionUtil.genarateFacrory().openSession();
		Transaction t=session.beginTransaction();
		switch(param) {
		case ID:
			theStudent=session.createQuery("from Student s where s.id="+temp).getResultList();	
			break;
		case NAME:
			theStudent=session.createQuery("from Student s where s.name="+temp).getResultList();	
			break;
		case AGE:
			theStudent=session.createQuery("from Student s where s.age="+temp).getResultList();	
			break;
		case PERCENTAGE:
			theStudent=session.createQuery("from Student s where s.percentage="+temp).getResultList();	
			break;
		case ALL:
			theStudent=session.createQuery("from Student").getResultList();	
			break;
		default :
			throw new MyException("Invalid search criteria..!");
	}
		t.commit();
		session.close();
		
		return theStudent;
	}

}
