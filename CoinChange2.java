// Time Complexity : O(n.m); where n is length of coins array and m is amount
// Space Complexity : O(n.m); where n is length of coins array and m is amount
public class CoinChange2 {
	public int change(int amount, int[] coins) {
		if(coins == null || coins.length==0) return 0;
		int[][] dp = new int[coins.length+1][amount+1];
		
		//Fill 1st column
        for(int i=0; i<dp.length; i++){
            dp[i][0]=1;
        }
        
        //DP- Top to bottom
        //Fill rest of the matrix
        //Start from second row as first row is always 0 except first column, so no need to fill
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                //Zero Case
                if(coins[i-1] > j){
                    dp[i][j]= dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
	
	// Driver code to test above 
    public static void main(String args[]) 
    { 
    	CoinChange2 ob = new CoinChange2();  
    	int[] coins= {1,2,5};
    	int amount= 5;
        System.out.println("Max amount of money can be robbed is: "+ob.change(amount, coins));
    } 
}
