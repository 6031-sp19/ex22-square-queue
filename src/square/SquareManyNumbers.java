package square;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SquareManyNumbers {
    private static final int QUEUE_SIZE = 100;
    private static final int N = 100;
    
    /**  Use a SquareServer to square all the integers from 1 to N. */
    public static void main(String[] args) throws IOException {
        // make request and reply queues big enough to hold QUEUE_SIZE messages each
        BlockingQueue<Integer> requests = new ArrayBlockingQueue<>(QUEUE_SIZE);
        BlockingQueue<SquareResult> replies = new ArrayBlockingQueue<>(QUEUE_SIZE);
        
        Squarer squarer = new Squarer(requests, replies);
        squarer.start();
        
        try {
            // send the requests to square 1...N
            for (int x = 1; x <= N; ++x) {
                requests.put(x);
                System.out.println(x + "^2 = ?");
            }
            // collect the replies
            for (int x = 1; x <= N; ++x) {
                System.out.println(replies.take());
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("done");
        System.exit(0); // ends the program, including Squarer
    }
}
