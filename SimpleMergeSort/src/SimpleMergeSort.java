
public class SimpleMergeSort {

    public static void mergesort(int[] array) {
        mergesort(array,new int[array.length],0,array.length-1);
    }

    public static void mergesort(int[] array, int[] tmp, int startLeft,int rightEnd) {
        if(startLeft>= rightEnd) {
            return;
        }
        int middle = (startLeft + rightEnd) /2;
        mergesort(array,tmp,startLeft,middle);
        mergesort(array,tmp,middle+1,rightEnd);
        mergehalves(array,tmp,startLeft,rightEnd);
    }

    public static void mergehalves(int[] array, int[] tmp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd)/2;
        int rightStart = leftEnd+1;
        int index = leftStart;
        int size = rightEnd-leftStart +1;
        int left = leftStart;
        int right = rightStart;

        while(left <= leftEnd && right <= rightEnd) {
            if(array[left] <= array[right]) {
                tmp[index] = array[left];
                left++;
            }
            else {
                tmp[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array,left,tmp,index,leftEnd-left+1);
        System.arraycopy(array,right,tmp,index, rightEnd-right+1);
        System.arraycopy(tmp,leftStart,array,leftStart,size);
    }

    public static void print(int[] array) {
        for(int el : array) {
            System.out.print(el + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {5,2,4,88,9,12,3,4,5,8,1,12,32,65,33,3,2,9,10};
        mergesort(array);
        print(array);
    }
}
