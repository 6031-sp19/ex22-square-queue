package square;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SquareOneNumber {
    
    /**
     * Create and use a squarer.
     * @param args unused
     */
    public static void main(String[] args) {
        
        BlockingQueue<Integer> requests = new LinkedBlockingQueue<>();
        BlockingQueue<SquareResult> replies = new LinkedBlockingQueue<>();
        
        Squarer squarer = new Squarer(requests, replies);
        squarer.start();
        
        try {
            // make a request
            requests.put(42);
            
            // maybe do something concurrently...
            
            // read the reply
            System.out.println(replies.take());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("done");
        System.exit(0); // ends the program, including Squarer
    }
}
