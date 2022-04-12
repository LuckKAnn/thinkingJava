package exp;

import java.util.concurrent.locks.ReentrantLock;
/**
 * @author : LuckKAnn
 * @date : 20:06 2021/9/21
 * @email: 1546165200@qq.com
 */

/**
 * 模拟十字路口车辆行驶产生死锁的例子
 * 本例子情景如下:
 * 		1.往北走的车辆会让往东走的车辆停止行驶
 * 		2.往东走的车辆会让往南走的车辆停止行驶
 * 		3.往南走的车辆会让往西走的车辆停止行驶
 * 		4.往西走的车辆会让往北走的车辆停止行驶
 */
public class DeadLockCar extends Thread{
	protected Object myDirect;
	static ReentrantLock south = new ReentrantLock();
	static ReentrantLock north = new ReentrantLock();
	static ReentrantLock west = new ReentrantLock();
	static ReentrantLock east = new ReentrantLock();

	public DeadLockCar(Object obj){
		this.myDirect=obj;
		if(myDirect==south){
			this.setName("south");
		}
		if(myDirect==north){
			this.setName("north");
		}
		if(myDirect==west){
			this.setName("west");
		}
		if(myDirect==east){
			this.setName("east");
		}
	}
	@Override
	public void run() {
		if (myDirect == south) {
			try {
				west.lockInterruptibly();
				System.out.println(Thread.currentThread().getName()+"已经让往西的车辆停止，正在试图往南走");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				south.lockInterruptibly();
				System.out.println(Thread.currentThread().getName()+"正在往南走");
			} catch (InterruptedException e1) {
				System.out.println(Thread.currentThread().getName()+"往南走的车辆被取消");
			}finally{
				if(west.isHeldByCurrentThread())
					west.unlock();
				if(south.isHeldByCurrentThread())
					south.unlock();
			}

		}
		if (myDirect == north) {
			try {
				east.lockInterruptibly();
				System.out.println(Thread.currentThread().getName()+"已经让往东的车辆停止，正在试图往北走");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				north.lockInterruptibly();
				System.out.println(Thread.currentThread().getName()+"正在往北走");
			} catch (InterruptedException e1) {
				System.out.println(Thread.currentThread().getName()+"往北走的车辆被取消");
			}finally{
				if(north.isHeldByCurrentThread())
					north.unlock();
				if(east.isHeldByCurrentThread())
					east.unlock();
			}

		}
		if (myDirect == west) {
			try {
				north.lockInterruptibly();
				System.out.println(Thread.currentThread().getName()+"已经让往北的车辆停止，正在试图往西走");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				west.lockInterruptibly();
				System.out.println(Thread.currentThread().getName()+"正在往西走");
			} catch (InterruptedException e1) {
				System.out.println(Thread.currentThread().getName()+"往西走的车辆被取消");
			}finally{
				if(north.isHeldByCurrentThread())
					north.unlock();
				if(west.isHeldByCurrentThread())
					west.unlock();
			}

		}
		if (myDirect == east) {
			try {
				south.lockInterruptibly();
				System.out.println(Thread.currentThread().getName()+"已经让往南的车辆停止，正在试图往东走");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				east.lockInterruptibly();
				System.out.println(Thread.currentThread().getName()+"正在往东走");
			} catch (InterruptedException e1) {
				System.out.println(Thread.currentThread().getName()+"往东走的车辆被取消");
			}finally{
				if(south.isHeldByCurrentThread())
					south.unlock();
				if(east.isHeldByCurrentThread())
					east.unlock();
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		DeadLockCar car2south = new DeadLockCar(south);
		DeadLockCar car2north = new DeadLockCar(north);
		DeadLockCar car2west = new DeadLockCar(west);
		DeadLockCar car2east = new DeadLockCar(east);
		car2south.start();
		car2north.start();
		car2west.start();
		car2east.start();
		//north已经让往东的车辆停止，正在试图往北走
		//south已经让往西的车辆停止，正在试图往南走
		//west已经让往北的车辆停止，正在试图往西走
		//east已经让往南的车辆停止，正在试图往东走
		//产生死锁，存在循环等待，互斥，请求保持，不可剥夺的条件，每个车辆都在等待另外一辆车先行
		Thread.sleep(1000);
		car2north.interrupt();
		//解除死锁的方法，破圈法，停止某个线程
		//north往北走的车辆被取消
		//east正在往东走
		//south正在往南走
		//west正在往西走
	}
}