package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static boolean itemInCommon(int[] array1, int[] array2){
        Map<Integer, Boolean> myHashMap = new HashMap<>();

        for(int i: array1){
            myHashMap.put(i, true);
        }

        for(int j : array2){
            if(myHashMap.get(j) != null) return true;
            //if(myHashMap.containsKey(j) ) return true;
        }

        return false;


    }

    public static List<Integer> findDuplicates(int[] nums){
        List<Integer> duplicates = new ArrayList<>();
        HashMap<Integer, Boolean> myHashMap = new HashMap<>();

        for(int i : nums){
            if( myHashMap.get(i) != null ){
                boolean exist = false;
                for(int j = 0; j < duplicates.size(); j++ ){
                    if(duplicates.get(j) == i) exist = true;
                }
                if(!exist)
                    //if(duplicates.get)
                    duplicates.add(i);
            }else{
                myHashMap.put(i, true);
            }
        }
        return duplicates;
    }

    ////
    /*
    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }
    */

    ////

    public static void main(String[] args) {

        System.out.printf("Working with HashMap");
        System.out.println("---------------------");

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));

        /*
            EXPECTED OUTPUT:
            ----------------
            true

        */
        System.out.println("----------------------------------");
        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        for(int i: nums){
            System.out.print(i + " , ");
        }
        System.out.println(nums);
        System.out.println("Duplicates: ");
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);


    }
}