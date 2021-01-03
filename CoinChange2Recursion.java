// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Brute force solution involves creating a tree which either accepts or rejects the coin in calculating the total amount, iteratively, to find all the valid paths. 

public class CoinChange2Recursion {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        
        return calculate(amount, coins, 0);
    }
    
    private int calculate(int amount, int[] coins, int index ){
        //base case
        if(amount == 0) return 1;
        if(index > coins.length -1 || amount < 0 ) return 0;
        
        //recursive case
        int case1 = calculate(amount, coins, index+1);
        
        int case2 = calculate(amount - coins[index], coins, index );
        
        return case1 + case2;
    }
}
