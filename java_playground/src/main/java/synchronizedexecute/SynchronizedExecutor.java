package synchronizedexecute;

public class SynchronizedExecutor {
	public static void main(String[] args){
		ThreadUnsafeSharedData unsafeData = new ThreadUnsafeSharedData();
		ThreadSafeSharedData safeData = new ThreadSafeSharedData();
		for(int i = 0; i < 5; i++){
			UnsafeThread1 unsafethread = new UnsafeThread1(i, unsafeData);
			unsafethread.start();
		}

		for(int i = 0; i < 5; i++){
			SafeThread1 safethread = new SafeThread1(i, safeData);
			safethread.start();
		}

	}

	public static class ThreadUnsafeSharedData{
		private int x = 0;
		public void add(){
			int a = x;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			x = a + 1;
		}

		public int get(){
			return x;
		}

	}

	public static class UnsafeThread1 extends Thread{
		private int _number;
		private ThreadUnsafeSharedData _data;
		
		public UnsafeThread1(int number, ThreadUnsafeSharedData data){
			_number = number;
			_data = data;
		}

		@Override
		public void run(){
			_data.add();
			System.out.println("Unsafe:" + _number + ":" + _data.get());
		}
	}

	public static class ThreadSafeSharedData{
		private int x = 0;
		public synchronized void add(){
			int a = x;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			x = a + 1;
		}

		public int get(){
			return x;
		}

	}

	public static class SafeThread1 extends Thread{
		private int _number;
		private ThreadSafeSharedData _data;
		
		public SafeThread1(int number, ThreadSafeSharedData data){
			_number = number;
			_data = data;
		}

		@Override
		public void run(){
			_data.add();
			System.out.println("Safe:" + _number + ":" + _data.get());
		}
	}

	// TODO try ReentrantLock as well

}
