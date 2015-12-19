package junit.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonTest3 {

	private static Person p = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p = new Person();
	}

	@Test
	public void testEat() {
		p.eat();
	}

	@Test
	public void testRun() {
		p.run();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		p = null;
	}

}
