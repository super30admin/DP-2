// Time Complexity : O(m * n) m is number of coins and n is amount
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.Arrays;
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] arr = new int[amount+1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for(int i = 0; i< coins.length; i++){
            for(int j = 1; j< arr.length; j++){
                if(j >= coins[i]){
                    arr[j] = arr[j] + arr[j - coins[i]];
                }
            }
        }
        int res = arr[amount];
        return res;
    }
}