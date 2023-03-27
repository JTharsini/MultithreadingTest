package deadlock;

public class DeadlockDemoBySynchronized
{
  public static void main(String[] args)
  {
    String object1 = "object1";
    String object2 = "object2";

    Runnable1WithSynchronized runnable1WithSynchronized = new Runnable1WithSynchronized(object1, object2);
    Runnable2WithSynchronized runnable2WithSynchronized = new Runnable2WithSynchronized(object1, object2);

    new Thread(runnable1WithSynchronized).start();
    new Thread(runnable2WithSynchronized).start();
  }
}
