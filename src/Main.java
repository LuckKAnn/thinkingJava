import annotation.MyAnnotation;

import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        int []arr = {1,5,6,3,7,8,9,10,55};
        System.out.println("hello world");
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int []arr,int start,int end){
        if(start==end || end<start) return;
        int mid = start+(end-start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        swap(arr, start, mid, mid+1, end);
    }
    public static void swap(int []arr,int low,int lowEnd,int high,int highEnd ){
        int []tmp = new int[highEnd-low+1];
        int tmpIndex = 0;
        int tmpLow = low;
        int tmpHigh = highEnd;
        while(low<=lowEnd && high<=highEnd){
            if(arr[low] < arr[high]){
                tmp[tmpIndex++] = arr[low++];
            } else{
                tmp[tmpIndex++] = arr[high++];
            }
        }
        while(low<=lowEnd){
            tmp[tmpIndex++] = arr[low++];
        }
        while(high<=highEnd){
            tmp[tmpIndex++] = arr[high++];
        }

        for(int i=tmpLow,j=0;i<tmpHigh;i++,j++){
            arr[i] = tmp[j];
        }
    }



}
