package DP2;
//Time Complexity : o(m*n) - m rows and n cols
//Space Complexity :o(m*n) = m rows and n cols 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :No

//Your code here along with comments explaining your approach
//we can build a matrix since constraints here are two - no.of coins and ways to make target amt and logic remains same as recursion
// just fill in table accordingly for choosing and not choosing coin and result would total of case1 and case2

public class CoinChange2DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,2,5};
		int amount = 11;
		
		int minCoins = coinChangeWays(coins, amount);
		
		System.out.println(minCoins);
	}

	public static int coinChangeWays(int[] coins, int amount) {
		// TODO Auto-generated method stub
		//null case
		if(coins == null || coins.length == 0) return 0;
		
		int[][] dpMatrix = new int[coins.length+1][amount+1];
		
		//go over rows to fill first col
		for(int i = 0; i<dpMatrix.length;i++) {
			dpMatrix[i][0] = 1;
		}

		//fill in the table
		for(int i = 1; i<dpMatrix.length;i++) {
			for(int j = 1; j<dpMatrix[0].length;j++) {
				// if choosen denomination is less than amt
				if(coins[i-1] > j) {
					dpMatrix[i][j] = dpMatrix[i-1][j];
				}else {
					//zero and one
					dpMatrix[i][j] = dpMatrix[i-1][j] + dpMatrix[i][j - coins[i-1]];
				}
			}
		}
		//return value in last row and last col
		return dpMatrix[dpMatrix.length-1][dpMatrix[0].length-1];

	}

}
