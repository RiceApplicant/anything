public class BubbleSortAnimator implements SortAnimator {
    
    private int[] array;
    private int i = 0;
    private int j = 0;


    public BubbleSortAnimator(int[] array) {
        this.array = array;
    }


    public boolean step() {

        if (i >= array.length - 1) {
            return true;
        }


        if (j < array.length - i - 1) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
            j++;
        } 
        else {
            j = 0;
            i++;
        }


        return false;
    }

    public int[] getArray() {
        return array;
    }
}