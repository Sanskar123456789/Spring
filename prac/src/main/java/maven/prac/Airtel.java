package maven.prac;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class Airtel implements sim{
	int datatype=24;
	String env="";
	public int getDatatype() {
		return datatype;
	}

	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}

	public void typeofSim() {
		// TODO Auto-generated method stub
		System.out.println(datatype+env);
		
	}

	public void datatypeofSim() {
		// TODO Auto-generated method stub
		System.out.println("hello airtel"+env);
	}

}

