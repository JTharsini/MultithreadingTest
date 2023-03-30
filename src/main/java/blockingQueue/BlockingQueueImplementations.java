package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueueImplementations
{
  public static void main(String[] args)
  {
    // BlockingQueue is an interface.
    BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
    BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
    BlockingQueue delayQueue = new DelayQueue();
    BlockingQueue linkedTranferQueue = new LinkedTransferQueue();
    BlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
    BlockingQueue synchronousQueue = new SynchronousQueue();
  }
}
