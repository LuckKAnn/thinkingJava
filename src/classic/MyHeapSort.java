package classic;

import java.security.PublicKey;
import java.util.Arrays;

/**
 * @FileName: HeapSort
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/14 20:51
 */
public class MyHeapSort {

    public  static class  minStrategy implements HeapStrategy{
        public    void adjustHeap(int i,int len,int []arr){
            while (i*2+1<len){
                int left = i*2+1;
                int right = i*2+2;
                int min = arr[i]<arr[left]?left:i;
                if(right<len) min = arr[min]<arr[right]?right:min;

                if(min==i) break;
                else {
                    swap(arr,min,i);
                    i = min;
                }
            }
        }
    }


    public  static  class maxStrategy implements HeapStrategy{
        public    void adjustHeap(int i,int len,int []arr){
            while (i*2+1<len){
                int left = i*2+1;
                int right = i*2+2;
                int max = arr[i]>arr[left]?left:i;
                if(right<len) max = arr[max]>arr[right]?right:max;

                if(max==i) break;
                else {
                    swap(arr,max,i);
                    i = max;
                }
            }
        }
    }

    HeapStrategy heapStrategy;

    MyHeapSort(){
        this.heapStrategy = new minStrategy();
    }

    MyHeapSort(HeapStrategy heapStrategy){
        this.heapStrategy = heapStrategy;
    }
    MyHeapSort(boolean desc){
        if(desc){
            this.heapStrategy= new maxStrategy();
        }
        else {
            this.heapStrategy = new minStrategy();
        }
    }
    public static void main(String[] args) {
        int[]arr = {0,1,2,3,4,5};
        MyHeapSort myHeapSort = new MyHeapSort();

        myHeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));


    }


    public void heapSort (int []arr){
        int len = arr.length;

        for (int i = len/2-1;i>=0;i--){
            this.heapStrategy.adjustHeap(i,len,arr);
        }
        System.out.println(Arrays.toString(arr));
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            this.heapStrategy.adjustHeap(0,j,arr);//重新对堆进行调整
        }
        for (int i : arr) {
            System.out.print(i+",");
        }
        System.out.println();
    }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
