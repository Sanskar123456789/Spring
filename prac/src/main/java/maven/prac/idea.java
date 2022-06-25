package maven.prac;
import org.springframework.stereotype.Component;

//@Component
public class idea implements sim{
	int datatype=23;
	String env="";
	public int getDatatype() {
		return datatype;
	}
	
	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}
	
	public void typeofSim() {
		System.out.println(datatype+env);
	}
	
	public void datatypeofSim() {
		// TODO Auto-generated method stub
		System.out.println("Hello idea"+env);
		
	}
}
