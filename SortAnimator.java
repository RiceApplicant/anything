public interface SortAnimator {
    boolean step();       // Performs one step of the algorithm, returns true if done
    int[] getArray();     // Returns the current state of the array
}