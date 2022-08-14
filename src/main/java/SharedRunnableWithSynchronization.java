public class SharedRunnableWithSynchronization
{
  static class MyObject
  {

  }

  static class MyRunnable implements Runnable
  {
    // this will be in heap along with the object
    // this count field will be shared
    // by two threads in this case
    private int count = 0;

    // this is shared by threads if same reference is passed
    private MyObject fieldObject;

    MyRunnable(MyObject fieldObject)
    {
      this.fieldObject = fieldObject;
    }

    @Override
    public void run()
    {
      System.out.println("fieldObject : " + fieldObject);

      // each thread has different reference in its stack
      // their actual object resides in heap
      MyObject myObject = new MyObject();
      System.out.println(myObject);
      // separate i is created in each thread stack
      for (int i = 0; i < 1_000_000; i++)
      {
        // race condition and write visibility
        // problem is resolved now
        synchronized (this)
        {
          this.count++;
        }
      }
      System.out.println(Thread.currentThread().getName() + " : " + this.count);
    }
  }

  public static void main(String[] args)
  {
    MyObject myObject = new MyObject();
    Runnable runnable = new MyRunnable(myObject);

    Thread thread1 = new Thread(runnable, "Thread 1");
    Thread thread2 = new Thread(runnable, "Thread 2");

    thread1.start();
    thread2.start();
  }
}
