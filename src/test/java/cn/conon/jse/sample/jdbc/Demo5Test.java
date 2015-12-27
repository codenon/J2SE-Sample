package cn.conon.jse.sample.jdbc;

import org.junit.Test;

public class Demo5Test {

	@Test
	public void testInsert() {
		Demo5 dao = new Demo5();
		dao.insert();

	}

	@Test
	public void testDelete() {
		Demo5 dao = new Demo5();
		dao.delete();

	}

	@Test
	public void testUpdate() {
		Demo5 dao = new Demo5();
		dao.update();

	}

	@Test
	public void testFind() {
		Demo5 dao = new Demo5();
		dao.find();
	}

}
