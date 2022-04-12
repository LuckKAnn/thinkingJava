package classic;

import java.util.Arrays;

/**
 * @FileName: QuickSort
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/16 19:28
 */
public class QuickSort {


    public  static void  quickSort(int []arr,int low,int high){

        if (low<high){
            int pivot = partion(arr,low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
    }

    public static  int  partion(int []arr,int low,int high){
        int p  =arr[low];

        while (low<high){
            while (low<high&&arr[high]<=p) high--;
                arr[low] = arr[high];
            while (low<high&&arr[low]>=p) low++;
                arr[high] =arr[low];
        }
        arr[low] = p ;
     return  low;
    }

    public static void main(String[] args) {
        int []arr = {156,54,31,231,54,330};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

}
