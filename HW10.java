import java.util.concurrent.locks.*;

class print implements Runnable{
	private char[] array;
	private static ReentrantLock lock = new ReentrantLock(true);
	
	public print(){}
	
	public print(char[] arr){
		array = new char[arr.length];
		for(int i = 0; i < arr.length; i++){
			array[i] = arr[i];
		}
	}
	
	public void run(){
		try{
			for(int i = 0; i < array.length; i++){
				lock.lock();
				System.out.print(array[i] + "  ");
				lock.unlock();
				Thread.sleep(100);
			}
		}catch(Exception t){}
	}
	
}

class Letters{
	
	
	public static void main(String[] args) throws Exception{
		char[] array1 = {'A', 'E', 'I', 'M', 'Q', 'U', 'Y'};
		char[] array2 = {'B', 'F', 'J', 'N', 'R', 'V', 'Z'};
		char[] array3 = {'C', 'G', 'K', 'O', 'S', 'W'};
		char[] array4 = {'D', 'H', 'L', 'P', 'T', 'X'};
		
		Thread t1 = new Thread(new print(array1));
		Thread t2 = new Thread(new print(array2));
		Thread t3 = new Thread(new print(array3));
		Thread t4 = new Thread(new print(array4));
		
		t1.start();
		Thread.sleep(10);
		t2.start();
		Thread.sleep(10);
		t3.start();
		Thread.sleep(10);
		t4.start();
	}
}

