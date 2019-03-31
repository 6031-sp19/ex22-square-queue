package square;

/**
 * An immutable squaring result message.
 */
public class SquareResult {
    private final int input;
    private final int output;
    // Rep invariant: true
    
    /**
     * Make a new result message.
     * @param input input number
     * @param output square of input
     */
    public SquareResult(int input, int output) {
        this.input = input;
        this.output = output;
    }
    
    // TODO: we will want more observers, but for now...
    
    @Override public String toString() {
        return input + "^2 = " + output;
    }
}
