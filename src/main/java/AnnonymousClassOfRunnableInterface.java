public class AnnonymousClassOfRunnableInterface
{
  public static void main(String[] args)
  {
    Thread thread = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        System.out.println("JJRunnable running");
        System.out.println("JJRunnable finished");
      }
    });
    thread.start();
  }
}
