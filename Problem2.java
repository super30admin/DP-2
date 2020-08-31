
public class Problem2 {
	   public static int change(int amount, int[] coins) {
	       /* int[][] dp= new int[coins.length+1][amount+1];  
	       dp[0][0]=1;
	        for(int i=1;i<=coins.length;i++)
	        {
	              dp[i][0]=1;
	            for(int j=1;j<=amount;j++){
	                if(coins[i-1]>j)
	                {
	                    dp[i][j]=dp[i-1][j];
	                }else{
	                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
	                }
	            }
	        }
	     return dp[coins.length][amount];*/
	        int[] dp = new int[amount+1];
	        dp[0]=1;
	        for(int i :coins){
	                for(int j=i;j<amount+1;j++){
	                    dp[j]+=dp[j-i];
	                }
	        }
	        return dp[amount];
	    }
	   
	   public static void main(String args[]) {
		   int[] coin = new int[] {1,2,5};
		   int res= change(7,coin);
		   System.out.println(res);
	   }
}
