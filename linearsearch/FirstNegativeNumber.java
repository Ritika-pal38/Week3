package org.example.linearsearch;
import java.util.*;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        int []array = {2,5,-4,8,2,9};
        FirstNegativeNumber number = new FirstNegativeNumber();
        int index = findIndex(array);
        System.out.println(index);

    }

    public static int findIndex(int []arr){
        int index;
        for(int i =0;i< arr.length;i++){
            if(arr[i]<0){
                index = i;

                return i;
            }
        }
        return -1;

    }
}
