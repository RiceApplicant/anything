public class ShellSortAnimator implements SortAnimator {

    private int[] array;
    private int gap;
    private int i;
    private int j;
    private int temp;
    private boolean inserting = false;

    public ShellSortAnimator(int[] array) {

        this.array = array;
        gap = array.length / 2;
        i = gap;
        j = -1;
    }

    public boolean step() {

        if(gap == 0){
            return true;
        }

        if(!inserting){

            if(i >= array.length){
                gap /= 2;
                i = gap;
                return false;
            }

            temp = array[i];
            j = i;
            inserting = true;
        }

        if(j >= gap && array[j - gap] > temp){
            array[j] = array[j - gap];
            j -= gap;
        } 
        else{
            array[j] = temp;
            i++;
            inserting = false;
        }

        return false;
    }

    public int[] getArray() {
        return array;
    }
}