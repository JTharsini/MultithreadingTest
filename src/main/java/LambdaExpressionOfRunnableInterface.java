public class LambdaExpressionOfRunnableInterface
{
  public static void main(String[] args)
  {
    Thread thread = new Thread(() -> {
      System.out.println("JJRunnable running");
      System.out.println("JJRunnable finished");
    });
    thread.start();
  }
}
