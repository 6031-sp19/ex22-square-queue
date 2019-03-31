package square;

import java.util.concurrent.BlockingQueue;

/**
 * Squares integers.
 */
public class Squarer {
    
    private final BlockingQueue<Integer> in;
    private final BlockingQueue<SquareResult> out;
    // Rep invariant: true
    
    /**
     * Make a squarer that will listen for requests and generate replies.
     * @param requests queue to receive requests from
     * @param replies queue to send replies to
     */
    public Squarer(BlockingQueue<Integer> requests, BlockingQueue<SquareResult> replies) {
        this.in = requests;
        this.out = replies;
    }
    
    /**
     * Start handling squaring requests.
     */
    public void start() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // TODO: we may want a way to stop the thread
                    try {
                        // block until a request arrives
                        int x = in.take();
                        // compute the answer and send it back
                        int y = x * x;
                        out.put(new SquareResult(x, y));
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
