public class ThreadRunsEvenMainTerminated
{
  public static void main(String[] args)
  {
    Runnable runnable = () -> {
      while (true)
      {
        sleep(1000);
        System.out.println("Running");
      }
    };
    Thread thread = new Thread(runnable);
    thread.start();
    sleep(3000);
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
