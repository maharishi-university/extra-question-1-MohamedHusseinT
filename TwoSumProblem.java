package Assign01;


import java.util.*;
import java.util.ArrayList;


public class TwoSumProblem {



    public static void main(String[] args) {
        int[] arr = {2,7,11,15};


        GetSum2(arr,9);
    }

    public static Dictionary<Integer,Integer> GetSum2(int[] arr, Integer target)
    {

        // O(n)
        Map<Integer, List<Integer>> dNum = new Hashtable<>();
        //HashMap<Integer, List<Integer>> dNumReverse = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        Dictionary<Integer, Integer> dNumFinal = new Hashtable<>();



        for(int i = 0; i < arr.length; i++) {
           List<Integer> lst= dNum.get(arr[i]);
           if(lst == null) {
               lst = new ArrayList<>();
               lst.add(i);
           }
           else
               lst.add(i);
            dNum.put(arr[i],lst);

            set.add(target-arr[i]);
        }


        for (Integer i : set) {
            //System.out.println(s);
            if(dNum.containsKey(i))
            {
                Integer indexElement= dNum.get(target-i).getFirst();
                Integer indexRemaining = dNum.get(i).getFirst();
                dNumFinal.put(indexElement,indexRemaining);
            }

        }

        return dNumFinal;

    }

    public static int[] GetSum1(ArrayList<Integer> arr, Integer target)

    {

        // o nlog n solution
        // Sort array
        arr.sort(Integer::compareTo);

        // loop on different directions
        for(int i=0,j=arr.size()-1;i<arr.size();i++,j--)
        {
            if(arr.get(i) + arr.get(j) ==  target)
            {
                return new int[]{i,j};
            }
        }
        return new int[]{};
    }
;;

}
