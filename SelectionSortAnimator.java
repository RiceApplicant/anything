public class SelectionSortAnimator implements SortAnimator {
    
    private int[] array;
    private int i = 0;
    private int j = 1;
    private int minIdx = 0;

    public SelectionSortAnimator(int[] array) {
        this.array = array;
        minIdx = 0;
    }

    public boolean step() {

        if(i >= array.length - 1){
            return true;
        }

        if(j < array.length){

            if(array[j] < array[minIdx]){
                minIdx = j;
            }
            j++;
        } 
        else{

            int temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
            i++;
            j = i + 1;
            minIdx = i;
        }

        return false;
    }

    public int[] getArray() {
        return array;
    }
}