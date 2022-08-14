public class ExtendingThreadAndOverridingRun
{
  public static class JJThread extends Thread
  {
    public void run()
    {
      System.out.println("JJThread running");
      System.out.println("JJThread finished");
    }
  }

  public static void main(String[] args)
  {
    JJThread jjThread = new JJThread();
    jjThread.start();
  }
}
