/**
 * Time Complexity: O(2^n) where n = number of denominations
 */

public class CoinChange2Recursive {
    public int change(int amount, int[] coins) {
        return helper(coins,amount,0);
    }
    
    private int helper(int[] coins, int amount, int index){
        //base case
    
        if(amount==0) return 1;
        if(amount<0||index == coins.length) return 0;
        
        //logic
        int case1 = helper(coins,amount-coins[index],index);
        int case2 = helper(coins,amount,index+1);
        return case1+case2;
        
    }
    public static void main(String args[]){
        int[] myArr = new int[]{1,2,5};
        int amount = 5;
        CoinChange2Recursive obj = new CoinChange2Recursive();
        System.out.println(obj.change(amount,myArr));

    }
}