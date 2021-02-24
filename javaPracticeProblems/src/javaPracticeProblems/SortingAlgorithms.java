package javaPracticeProblems;

public class SortingAlgorithms {
    static void swap(int[] a,int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    static void mergeSort(int[] a){
        if(a.length<2)
            return;
        int mid=a.length/2;
        int[] left=new int[mid];
        int[] right=new int[a.length-mid];
        for(int i=0;i<mid;i++)
            left[i]=a[i];
        for(int i=mid;i<a.length;i++)
            right[i-mid]=a[i];
        mergeSort(left);
        mergeSort(right);
        merge(a,left,right);
    }
    private static void merge(int[] result,int[] left,int[] right){
        int i=0,j=0,k=0;
        while(i<left.length && j<right.length){
            if(left[i]<right[j])
                result[k++]=left[i++];
            else
                result[k++]=right[j++];
        }
        while(i< left.length)
            result[k++]=left[i++];
        while(j< right.length)
            result[k++]=right[j++];
    }
    static void bubbleSort(int[] a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1])
                    swap(a,j,j+1);
            }
        }
    }
    static void selectionSort(int[] a){
        int n=a.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[minIndex])
                    minIndex=j;
            }
            swap(a,minIndex,i);
        }
    }
    static void insertionSort(int[] a){
        int n=a.length;
        for(int i=1;i<n;i++) {
            int current=a[i];
            int j=i-1;
            while(j>=0 && a[j]>current){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=current;
        }
    }
    static void quickSort(int[] a,int start,int end){
        if(start>=end)
            return;
        int b=partition(a,start,end);
        quickSort(a,start,b-1);
        quickSort(a,b+1,end);
    }
    private static int partition(int[] a,int start, int end){
        int pivot=a[end];
        int b=start-1;
        for(int i=start;i<=end;i++){
            if(a[i]<=pivot)
                swap(a,i,++b);
        }
        return b;
    }

}
