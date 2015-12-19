package cn.conon.j2se.sample.priority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

import cn.conon.j2se.sample.utils.MathUtils;

/**
 * 
 * @param <T>
 *
 * @author DDC
 * @date 2013-9-8 上午12:13:45
 */
public class PriorityQueue<T extends PriorityItemBase> {

	private PriorityBlockingQueue<T> mPriorityBlockingQueue;

	// private LinkedList<T> mQueueTiptop;
	// private Map<Integer, List<T>> mQueueMap;

	/** 一个周期总共执行的次数 */
	private int mPeriodTotal;

	/** 总共执行了多少次，测试用 */
	private long mTotalTimes;

	public PriorityQueue() {
		mPriorityBlockingQueue = new PriorityBlockingQueue<T>();
	}

	public PriorityQueue(List<T> list) {
		init(list);
	}

	public void init(List<T> list) {
		list = initParameter(generate(list));
		mPriorityBlockingQueue = new PriorityBlockingQueue<T>(list.size());
		mPriorityBlockingQueue.addAll(list);
		// System.out.println(list.toString());
	}

	public T poll() {
		mTotalTimes++;
		T item = mPriorityBlockingQueue.poll();
		if (item != null) {
			item.setPriority(item.getPriority() + item.getSpace()
					* item.getSize());
			item.increaseTimes(mTotalTimes);
			mPriorityBlockingQueue.offer(item);
		}
		return item;
	}

	/**
	 * 按优先级分类
	 * 
	 * @param list
	 * @return
	 */
	private Map<Integer, List<T>> generate(List<T> list) {
		Map<Integer, List<T>> map = new HashMap<Integer, List<T>>();

		if (list == null) {
			list = new ArrayList<T>();
		}

		for (T item : list) {
			if (item == null) {
				continue;
			}
			// ------------------------------------------------------------
			int key = item.getCount();
			List<T> mapList = map.get(key);
			if (mapList == null) {
				mapList = new ArrayList<T>();
				map.put(key, mapList);
			}
			mapList.add(item);
		}
		return map;
	}

	/**
	 * 初始化优先级参数
	 */
	private List<T> initParameter(Map<Integer, List<T>> map) {
		int periodTotalCount = 0;// 一个周期内总共执行的次数
		int[] periodClassify = new int[map.size() + 1];
		int i = 0;
		for (Integer key : map.keySet()) {
			List<T> mapList = map.get(key);
			periodClassify[i] = key * mapList.size();
			periodTotalCount += periodClassify[i];
			i++;
		}
		periodClassify[i] = periodTotalCount;
		// ------------------------------------------------------------
		mPeriodTotal = MathUtils.commonMultiple(periodClassify);
		// ------------------------------------------------------------
		List<T> list = new ArrayList<T>();
		for (Integer key : map.keySet()) {
			List<T> mapList = map.get(key);
			int size = mapList.size();
			for (int j = 0; j < size; j++) {
				T item = mapList.get(j);
				item.setSpace(mPeriodTotal / (size * key));
				item.setPriority((j + 1) * item.getSpace());
				item.setSize(size);
			}
			list.addAll(mapList);
		}
		return list;
	}

	@Override
	public String toString() {
		return "PidPriorityBlockingQueue [mPeriodTotal=" + mPeriodTotal + "]";
	}

	/**
	 * 打印测试信息
	 */
	public void logger() {
		System.out.println(Arrays.asList(mPriorityBlockingQueue.toArray())
				.toString());
		mPriorityBlockingQueue.clear();
	}
}
