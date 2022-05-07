// Time Complexity : O(2^N), N = Amount
// Space Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes with one exception Time  exceeded
// Any problem you faced while coding this : NO
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins.length  == 0 || coins == null)
            return 0;
        return helper(coins, amount, 0, 0);
    }

    private int helper(int[] arr,int amount, int index, int output) {
        //base case
        if(amount == 0)  return 1;
        if(index >= arr.length || amount < 0) return 0;
        //logic
        //decision 1
        int dec1 =  helper(arr, amount, index+1, output);
        //decision 2
        int dec2 = helper(arr, amount - arr[index], index, output);
        //if decisions1 is incorrect
        if(dec1 == -1) return dec2;
        //if decisions2 is incorrect
        if(dec2 == -1) return dec1;
        //if both decisions are correct
        return dec1 + dec2;
    }
}
