import java.util.Stack;

public class QuickSortAnimator implements SortAnimator {

    private int[] array;
    private Stack<int[]> stack = new Stack<>();
    private int low, high, pivot, i, j;
    private boolean partitioning = false;
    private boolean done = false;
    private int stepsPerTick = 10; // Adjust this for speed

    public QuickSortAnimator(int[] array) {
        this.array = array;
        stack.push(new int[]{0, array.length - 1});
    }


    public boolean step() {

        if(done){
            return true;
        }

        for(int s = 0; s < stepsPerTick; s++){

            if(!partitioning){

                if(stack.isEmpty()){
                    done = true;
                    return true;
                }

                int[] range = stack.pop();
                low = range[0];
                high = range[1];
                if(low >= high){
                    continue;
                }

                pivot = array[high];
                i = low;
                j = low;
                partitioning = true;
            }

            if(j < high){
                if(array[j] < pivot){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                }

                j++;
            } 
            else {
                int temp = array[i];
                array[i] = array[high];
                array[high] = temp;

                stack.push(new int[]{low, i - 1});
                stack.push(new int[]{i + 1, high});
                partitioning = false;
            }
        }

        return false;
    }

    public int[] getArray() {
        return array;
    }
}