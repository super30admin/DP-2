
public class CoinChange2 {
	
	//	Time:  O(n) 
	//	Space O(1) recursive stack
	//	LeetCode: yes
	
	public int change(int amount, int[] coins) {
		if(coins == null) return 0;
		return helper(coins,0, amount);
	}

	private int helper(int[] coins, int i ,int amount){
		if (amount < 0 || i > coins.length - 1) return 0;
		if (amount == 0) return 1;
		// /case1 : chosen 
		int case1 = helper(coins,i, amount - coins[i]);
		//case2 not chosen
		int case2 = helper(coins,i+1 ,amount);
		int result = Math.min(case1, case2);

		if(case1 == -1 ) return case2;
		else  if(case2 == -1) return case1;
		//returning sum of both cases as our answer
		else return case1+case2;

	}
}
