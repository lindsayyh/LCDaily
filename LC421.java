package Leetcode;
import java.util.*;

public class LC421 {
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int max = 0;

        for(int i = 31;i>=0;i--){
            mask = mask|(1<<i);
            Set<Integer> set = new HashSet<>();
            for(int num:nums){
                set.add(num & mask);
            }
            int maxTry = max|(1<<i);
            for(int num:set){
                if(set.contains(maxTry^num)){
                    max = maxTry;
                    break;
                }
            }

        }
        return max;
    }
}
