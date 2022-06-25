package maven.prac;

public class AgeValidation {
private int age1;
public AgeValidation(int a) {
	age1=a;
}
public boolean ageTest() {
	if(age1>=18) {
		return true;
	}else {
		return false;
	}
}
}
