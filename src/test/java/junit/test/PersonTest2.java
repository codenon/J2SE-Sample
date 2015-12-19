package junit.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest2 {

	@Before
	public void setUp() throws Exception {
		System.out.println("hahah");
	}

	@Test
	public void testEat() {
		Person p = new Person();
		p.eat();

	}

	@Test
	public void testRun() {
		Person p = new Person();
		p.run();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("wowow");
	}

}
