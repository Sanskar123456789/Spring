package maven.prac;

import static org.junit.Assert.*;

import org.junit.Test;

public class agetest {

	@Test
	public void test() {
		AgeValidation obj = new AgeValidation(17);
		assertEquals(true,obj.ageTest());
//		fail("Not yet implemented");
	}

}
