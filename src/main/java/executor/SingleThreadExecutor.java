package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor
{
  public static void main(String[] args)
  {
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    singleThreadExecutor.execute(() -> System.out.println("Hello world!"));
    singleThreadExecutor.shutdown();
  }
}
