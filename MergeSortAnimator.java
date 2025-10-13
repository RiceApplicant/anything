public class MergeSortAnimator implements SortAnimator {

    private int[] array;
    private int[] aux;
    private int width = 1;
    private int i = 0;


    public MergeSortAnimator(int[] array) {
        this.array = array;
        this.aux = new int[array.length];
    }


    public boolean step() {

        if(width >= array.length) {
            return true;
        }

        if(i < array.length) {
            int left = i;
            int mid = Math.min(i + width, array.length);
            int right = Math.min(i + 2 * width, array.length);
            merge(left, mid, right);
            i += 2 * width;
        } 
        else{
            width *= 2;
            i = 0;
        }

        return false;
    }


    private void merge(int left, int mid, int right) {

        for(int k = left; k < right; k++){
            aux[k] = array[k];
        }

        int i = left, j = mid, k = left;
        while (i < mid && j < right) {
            if (aux[i] <= aux[j]) {
                array[k++] = aux[i++];
            } else {
                array[k++] = aux[j++];
            }
        }
        while(i < mid){
            array[k++] = aux[i++];
        }
        while(j < right){
            array[k++] = aux[j++];
        }
    }

    public int[] getArray() {
        return array;
    }
}