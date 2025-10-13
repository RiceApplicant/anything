public class InsertionSortAnimator implements SortAnimator {

    private int[] array;
    private int i = 1;
    private int j = -1;
    private int key;
    private boolean inserting = false;


    public InsertionSortAnimator(int[] array) {
        this.array = array;
    }


    public boolean step() {
        if (i >= array.length) {
            return true;
        }

        if (!inserting) {
            key = array[i];
            j = i - 1;
            inserting = true;
        }

        if (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j--;
        } 
        else {
            array[j + 1] = key;
            i++;
            inserting = false;
        }

        return false;
    }

    public int[] getArray() {
        return array;
    }
}