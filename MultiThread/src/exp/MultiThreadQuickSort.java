package exp;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @FileName: MultiThreadQuickSort
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/11/6 17:00
 */

/**
 * 实现并行的快速排序，采用多线程的方式进行
 * 同时将多线程的快速排序与单线程的快速排序进行了对比
 */
public class MultiThreadQuickSort {

	static int[] arr = { 5, 52, 6, 3, 4 };
	//利用线程池的方式复用线程
	static ExecutorService pool = Executors.newCachedThreadPool();

	/**
	 * 普通快速排序
	 * @param arr
	 */
	public static void quickSort(int[] arr) {
		qsort(arr, 0, arr.length - 1);
	}

	/**
	 * 多线程快速排序
	 * @param arr
	 * @throws InterruptedException
	 */
	public static void pQuickSort(int[] arr) throws InterruptedException {
		multiThreadQucikSort(arr, 0, arr.length - 1);
	}

	//将快排的子任务实现为Runnable，可以创建新线程并行处理
	public static class QuickSortTask implements Runnable {
		int start, end;

		public QuickSortTask(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public void run() {
			try {
				multiThreadQucikSort(arr, start, end);
			} catch (InterruptedException e) {
			}
		}

	}

	/**
	 *  通过线程池创建线程进行并发的快速排序
	 * @param arr
	 * @param low
	 * @param high
	 * @throws InterruptedException
	 */
	private static void multiThreadQucikSort(int[] arr, int low, int high)  throws InterruptedException {
		if (low < high) {
			int pivot = partition(arr, low, high);
			pool.submit(new QuickSortTask(low, pivot - 1));
			pool.submit(new QuickSortTask(pivot + 1, high));
		}
	}

	/**
	 * 普通的快速排序，递归调用处理
	 * @param arr
	 * @param low
	 * @param high
	 */
	private static void qsort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			qsort(arr, low, pivot - 1);
			qsort(arr, pivot + 1, high);
		}
	}

	/**
	 * 获取到枢轴的位置，比枢轴小的放左边，比枢轴大的放右边
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(int arr[],int low,int high){
		int pivot = arr[low];
		while(low<high){
			//从右边开始找比枢轴大的
			while(arr[high]>=pivot&&low<high) high--;  //满足条件则跳过
			arr[low]= arr[high]; //不满足条件则往低处排
			//从左边开始找比枢轴小的
			while(arr[low]<=pivot&&low<high) low++; //同上理
			arr[high]= arr[low];
		}
		arr[low]= pivot;
		return low;
	}

	public static void main(String[] args) throws InterruptedException {
		arr=new int[1000000];
		//随机生成数据
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*10000);
		}
		int []arr2 = Arrays.copyOfRange(arr,0,arr.length);
		long startTime = System.currentTimeMillis();
		pQuickSort(arr);
		//基准时间，为了让多线程能够全部完成
		Thread.sleep(1000);
		long endTime = System.currentTimeMillis();
		//100000数据量----costTime: 1012 毫秒
		//1000000数据量----costTime: 1058 毫秒
		System.out.println(arr.length+"数据量----costTime: "+(endTime - startTime) +" 毫秒");

		startTime = System.currentTimeMillis();
		quickSort(arr2);
		//基准时间，为了让多线程能够全部完成
		Thread.sleep(1000);
		endTime = System.currentTimeMillis();
		//100000数据量----costTime: 1017 毫秒
		//1000000数据量----costTime: 1399 毫秒
		System.out.println(arr.length+"数据量----costTime: "+(endTime - startTime) +" 毫秒");
		pool.shutdown();
	}

}
