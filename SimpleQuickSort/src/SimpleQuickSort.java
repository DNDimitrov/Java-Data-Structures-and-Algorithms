public class SimpleQuickSort {

    public static void quicksort(int[] array) {
        quicksort(array,0,array.length-1);
    }

    public static void quicksort(int[] array, int left,int rigth) {
        if (left >= rigth) {
            return;
        }
        int pivot = array[(left+rigth)/2];
        int index = partition(array,left,rigth,pivot);
        quicksort(array,left,index-1);
        quicksort(array,index,rigth);
    }

    public static int partition(int[] array, int left, int right, int pivot) {
        while(left<=right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static final void swap (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void bubbleSort(int[] array) {
        for(int i=0;i<array.length;i++) {
            for(int j=i+1;j<array.length;j++) {
                if(array[i]>array[j]) {
                   swap(array,i,j);
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        int min = array[0];
        int minIndex;
        for(int i=0;i<array.length;i++) {
            min = array[i];
            minIndex = i;
            for(int j=i;j<array.length;j++) {

                if(min>= array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if(min < array[i]) {
                int tmp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tmp;
            }
        }
    }

    public static int binarySearch(int[] array,int element) {
      int left = 0;
      int right = array.length;
      while(left<=right) {
          int middle = left + ((right-left)/2);
          if(array[middle] == element) {
              System.out.print("The searched element is at position ");
              return middle;
          }
          else if(array[middle] > element) {
              right = middle -1;
          }
          else {
              left = middle +1 ;
          }
      }
      System.out.print("The element is not found! ");
      return  0;
    }

    public static void print(int[] array) {
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {5,6,3,1,4,10,2,4,1,10,5,9,6,7};
        quicksort(array);
        System.out.println(binarySearch(array,3));
        print(array);

    }
}
