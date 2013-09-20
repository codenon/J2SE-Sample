package cn.conon.jse.demo.priority;

import java.util.ArrayList;

/**
 * 优先级队列item基类
 * 
 * @author DDC
 * @date 2013-9-8 上午12:14:02
 */
public abstract class PriorityItemBase implements Comparable<PriorityItemBase> {
	/* 两次执行这个Item的 间隔 */
	private int space;
	/* 优先级 */
	private int priority;
	/* 同级别优先级的元素个数 */
	private int size;

	/**
	 * 获取优先级，每个周期内应该执行的次数
	 * 
	 * @return
	 */
	public abstract int getCount();

	public int getSpace() {
		return space;
	}

	/**
	 * 
	 * @param space
	 */
	public void setSpace(int space) {
		this.space = space;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int compareTo(PriorityItemBase o) {
		if (o instanceof PriorityItemBase) {
			return (getPriority() > o.getPriority()) ? 1 : -1;
		}
		return 0;
	}

	// ===========================测试用=========================================
	/** 这个Item 被执行了多少次 */
	private int times = 0;
	/** 在执行这个Item时，整个队列总共执行多少次 */
	private ArrayList<Long> totalTimes = new ArrayList<Long>();;
	/** 两次执行这个Item的 间隔 */
	private ArrayList<Long> spaces = new ArrayList<Long>();;

	/**
	 * 增加执行次数
	 * 
	 * @param total
	 *            队列执行的总次数
	 */
	public void increaseTimes(long total) {
		times++;
		totalTimes.add(total);
		if (totalTimes.size() == 0) {
			spaces.add(0L);
			return;
		}
		if (totalTimes.size() == 1) {
			spaces.add(total - totalTimes.get(0));
			return;
		}
		spaces.add(total - totalTimes.get(totalTimes.size() - 2));
	}

	@Override
	public String toString() {
		return "space=" + space + ", priority=" + priority + ", size=" + size
				+ "\r\ntimes=" + times + "\r\ntotalTimes=" + totalTimes
				+ "\r\nspaces=" + spaces
				+ "\r\n------------------------------------------\r\n";
	}
	// ===========================测试用=========================================
}
