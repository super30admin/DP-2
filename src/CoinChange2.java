/* This problem is about Coin change  In which I have 
 * used Dynamic Programming.
 * This algorithm creates a dp[][] matrix and place the values in 
 * it and in the end we get the desired value.
 * Complexity of algorithm is O(m * n), m- number of coins and n - amount need to calculated
 *  
 * */
public class CoinChange2 {
	
	
	 public int change(int amount, int[] coins) {
	        
	        if(coins== null )
	            return 0;
	        
	        int[][] dp= new int[coins.length+1][amount+1];
	        
	        for(int i=0;i< dp.length;i++){
	            dp[i][0]=1;
	        }
	        
	        for(int i=1;i<dp.length;i++){
	            for(int j=1;j< dp[0].length;j++){
	                
	                
	                if(j < coins[i-1]){
	                    dp[i][j]=dp[i-1][j];
	                    
	                }else{
	                    dp[i][j]= dp[i-1][j]+ dp[i][j- coins[i-1]];
	                }
	                
	            }
	        }
	        
	        return dp[dp.length-1][dp[0].length-1];
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int amount = 5;
		int[] coins = {1, 2, 5};
		
		CoinChange2 objIn= new CoinChange2();
		
		System.out.println(objIn.change(amount,coins));

	}

}
