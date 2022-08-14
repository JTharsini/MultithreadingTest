public class OtherThreadsWaitUntilAParticularThreadTerminates
{
  public static void main(String[] args)
  {
    Runnable runnable = () -> {
      for (int i = 0; i < 5; i++)
      {
        sleep(1000);
        System.out.println("Running...");
      }
    };
    Thread thread = new Thread(runnable);
    thread.setDaemon(true);
    thread.start();
    join(thread);
  }

  private static void join(Thread thread)
  {
    try
    {
      thread.join();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  private static void sleep(long millis)
  {
    try
    {
      Thread.sleep(millis);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
