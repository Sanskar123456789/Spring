package maven.hib;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Emp_main {
public static void main(String[] args) {
	ApplicationContext ac=new ClassPathXmlApplicationContext("spring2.xml");
	Employee e=ac.getBean(Employee.class);
	Empdao dao=ac.getBean(Empdao.class);
	if(dao.insert(e)>0) {
	System.out.println("insertion done");	
	}
	else {
		System.out.println("insertion failed");
	}
	
	List<Employee> list=dao.getall();
	for(Employee e1:list) {
		System.out.println(e1.getEid()+"  "+e1.getEname()+" "+e1.getEemail());
	}
}
}



