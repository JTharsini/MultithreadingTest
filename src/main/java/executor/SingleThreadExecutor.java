package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor
{
  public static void main(String[] args)
  {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    // fixedThreadPool is same as singleThreadExecutor
    ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    singleThreadPool.execute(() -> System.out.println("Hello world!"));

    singleThreadPool.shutdown();
  }
}
