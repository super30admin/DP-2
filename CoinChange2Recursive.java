package DP2;
//Time Complexity : o(2^n) - n is no.of coins
//Space Complexity :o(n) 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :No

//Your code here along with comments explaining your approach
//trying greedy approach by taking max value always does not work here for all cases
//we can build a tree just making decision of choosing coin or not
//recursion - coin can be either choosen(case 1) or not chossen(Case 0)

public class CoinChange2Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,2,5};
		int amount = 11;
		
		int minCoins = coinChange(coins, amount);
		
		System.out.println(minCoins);
	}

	public static int coinChange(int[] coins, int amount) {
		// TODO Auto-generated method stub
       	//null case
		if(coins == null || coins.length == 0) return 0;
		return findMinCoins(coins,amount,0);
	}
	
	private static int findMinCoins(int[] coins, int amount, int index) {
		
		
		if(amount == 0) return 1;
		if(amount<0 || index == coins.length) return -1;
		//case 1 choose the coin
		int case1 = findMinCoins(coins,amount-coins[index],index);
		//case 2 not choose
		int case2 = findMinCoins(coins,amount,index+1);
		
		if(case1 == -1) return case2;
		if(case2 == -1) return case1;
		
		return case1+case2;
		
	} 

}
