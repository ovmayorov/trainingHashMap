package org.example;

import java.util.*;

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


    // WRITE FIRSTNONREPEATINGCHAR METHOD HERE //
    public static Character firstNonRepeatingChar(String testString){
        Map<Character, Integer> myHashMap = new HashMap<>();

        char[] charArray = testString.toCharArray();

        for(int i = 0; i < charArray.length; i++){
            myHashMap.put(charArray[i], myHashMap.getOrDefault(charArray[i], 0) + 1);
        }
        for(int i = 0; i < charArray.length; i++){
            //int a = myHashMap.get(charArray[i]);
            if(myHashMap.get(charArray[i]) == 1) return charArray[i];
        }
        return null;
    }
    /////////////////////////////////////////////

    // WRITE GROUPANAGRAMS METHOD HERE //
    public static List<List<String>> groupAnagrams(String[] strings){
        HashMap<String, List<String>> myHashMap = new HashMap<>();

        for(int i = 0; i < strings.length; i++ ){
            String tempString = strings[i];
            char[] charArray = tempString.toCharArray();
            Arrays.sort(charArray);
            String canonical = new String(charArray);
            if(myHashMap.containsKey(canonical)){
                myHashMap.get(canonical).add(tempString);
            }else{
                List<String> group = new ArrayList<>();
                group.add(tempString);
                myHashMap.put(canonical, group);
            }
        }
        return new ArrayList<>(myHashMap.values());
    }

    //////////////////////////////////////

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
    /////////////////////////////////////////////////////////////
    // WRITE THE TWOSUM MEHTOD HERE //
    //    Problem: Given an array of integers nums and a target integer target, find the indices of two numbers
    //    in the array that add up to the target.
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> myHashMap = new HashMap<>();
        int[] result = {};
        //result= new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (myHashMap.containsKey(complement)) {
                result = new int[]{myHashMap.get(complement), i};
                return result;
            } else {
                myHashMap.put(num, i);
            }
        }
        return result;
    }

//        for(int i = 0; i < nums.length - 1; i++){
//            for(int j = 1; j < nums.length; j++ ){
//                if(nums[i] + nums[j] == target){
//                    result = new int[]{i,j};
////                    result[0] = i;
////                    result[1] = j;
//                }
//            }
//        }
//        return result;
//    }
    //////////////////////////////////////////////////////////////

    public static int[] subarraySum(int[] nums, int target){
        Map<Integer, Integer> myHashTable = new HashMap<>();
        myHashTable.put(0, -1);
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++){
            currentSum = currentSum + nums[i];
            if(myHashTable.containsKey(currentSum - target)){
                return new int[] {myHashTable.get(currentSum - target) +1, i};
            }else{
                myHashTable.put(currentSum, i);
            }
        }
        return new int[]{};
    }


    //////////////////////////////////////////////////////////////
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

        System.out.println("---------------------------------");
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [0, 1]
            [1, 2]
            [0, 1]
            []
            [2, 3]
            [0, 1]
            []

        */

        //---------------------------------------
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;
        int[] result2 = subarraySum(nums2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {2, 3, 4, 5, 6};
        int target3 = 3;
        int[] result3 = subarraySum(nums3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] nums4 = {};
        int target4 = 0;
        int[] result4 = subarraySum(nums4, target4);
        System.out.println("[]");

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 3]
            [0, 3]
            [1, 1]
            []

        */
    }
}