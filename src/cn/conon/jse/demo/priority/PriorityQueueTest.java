package cn.conon.jse.demo.priority;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueueTest {

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		List<PID> list = new ArrayList<PID>();
		list.add(new PID("A", 1));
		list.add(new PID("B", 2));
		list.add(new PID("C", 3));
		list.add(new PID("D", 4));
		list.add(new PID("E", 1));
		list.add(new PID("F", 2));
		list.add(new PID("G", 3));
		list.add(new PID("H", 4));
		list.add(new PID("A", 1));
		list.add(new PID("B", 2));
		list.add(new PID("C", 3));
		list.add(new PID("D", 4));
		list.add(new PID("E", 1));
		list.add(new PID("F", 2));
		list.add(new PID("G", 3));
		list.add(new PID("H", 4));
		list.add(new PID("A", 1));
		list.add(new PID("B", 2));
		list.add(new PID("C", 3));
		list.add(new PID("D", 4));
		list.add(new PID("E", 1));
		list.add(new PID("F", 2));
		list.add(new PID("G", 3));
		list.add(new PID("H", 4));
		list.add(new PID("C", 3));
		list.add(new PID("D", 4));
		list.add(new PID("E", 1));
		list.add(new PID("F", 2));
		list.add(new PID("G", 3));
		list.add(new PID("H", 4));
		list.add(new PID("A", 1));
		list.add(new PID("B", 2));
		list.add(new PID("C", 3));
		list.add(new PID("D", 4));
		list.add(new PID("E", 1));
		list.add(new PID("F", 2));
		list.add(new PID("G", 3));
		list.add(new PID("H", 4));
		list.add(new PID("C", 3));
		list.add(new PID("D", 4));
		list.add(new PID("E", 1));
		list.add(new PID("F", 2));
		list.add(new PID("G", 3));
		list.add(new PID("H", 4));
		list.add(new PID("A", 1));
		list.add(new PID("B", 2));
		list.add(new PID("C", 3));
		list.add(new PID("D", 4));
		list.add(new PID("E", 1));
		list.add(new PID("F", 2));
		list.add(new PID("G", 3));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));
		list.add(new PID("H", 4));

		PriorityQueue<PID> queue = new PriorityQueue<PID>(list);
		System.out.println(queue.toString());
		int i = 0;
		while (i < 10000) {
			queue.poll();
			i++;
		}
		queue.logger();
	}

	public static class PID extends PriorityItemBase {
		private String PID;
		private int count;

		public PID(String pID, int count) {
			super();
			PID = pID;
			this.count = count;
		}

		@Override
		public int getCount() {
			return count;
		}

		@Override
		public String toString() {
			return "PID [PID=" + PID + ", count=" + count + "]\r\n"
					+ super.toString();
			// return "PID [PID=" + PID + ", count=" + count + "]\r\n";
		}
	}
}
