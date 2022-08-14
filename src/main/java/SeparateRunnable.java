public class SeparateRunnable
{
  static class MyObject
  {

  }

  static class MyRunnable implements Runnable
  {
    // this will be in heap along with the object
    // separate count fields for separate runnable
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
      System.out.println("fieldObject :" + fieldObject);

      // each thread has different reference in its stack
      // their actual object resides in heap
      MyObject myObject = new MyObject();
      System.out.println(myObject);

      // separate i is created in each thread stack
      for (int i = 0; i < 1_000_000; i++)
      {
        this.count++;
      }
      System.out.println(Thread.currentThread().getName() + " : " + this.count);
    }
  }

  public static void main(String[] args)
  {
    MyObject fieldObject = new MyObject();
    Runnable runnable1 = new MyRunnable(fieldObject);
    Runnable runnable2 = new MyRunnable(fieldObject);

    Thread thread1 = new Thread(runnable1, "Thread 1");
    Thread thread2 = new Thread(runnable2, "Thread 2");

    thread1.start();
    thread2.start();
  }
}
