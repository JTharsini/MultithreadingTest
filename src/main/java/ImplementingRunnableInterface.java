public class ImplementingRunnableInterface
{
  public static class JJRunnable implements Runnable
  {
    public void run()
    {
      System.out.println("JJRunnable running");
      System.out.println("JJRunnable finished");
    }
  }

  public static void main(String[] args)
  {
    JJRunnable jjRunnable = new JJRunnable();
    Thread thread = new Thread(jjRunnable);
    thread.start();
  }
}
