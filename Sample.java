// Time Complexity :2^n
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        return helper(coins,0,amount);
    }
    private int helper(int[]coins,int index, int amount){
        //base or terminating condition 
        if(amount == 0) return 1;
        if(amount < 0||index == coins.length) return 0;
        //logic
        //choose
        int case1=helper(coins,index,amount-coins[index]);
        //not choose
        int case2 = helper(coins,index+1,amount);
        return(case1+case2);
    }
}
/////////////////////////////////////////////////////////////////
// Time Complexity :m*n(m is coins and n is amount)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
       int [][] dp = new int[coins.length+1][amount+1];
        //dp[0][0] = 0;
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //untill my denomination is greaterthan to amount i will get values from row above
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
   
}
////////////////////////////////////////////
// Time Complexity :Exponantial 3*2^n
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class paintHouse {
	public int pHouse(int[][]Costs) {
		int case1=pMin(Costs,0,0,0);//red color
		int case2 =pMin(Costs,0,1,0);//blue color 
		int case3 =pMin(Costs,0,2,0);//Green 
		return Math.min(case1,Math.min(case2,case3));
		
	}
	public int pMin(int [][]Costs,int rowindex,int color,int minamount) {
		//base or ternmination case
		if(rowindex == Costs.length) return minamount;
		//logic
		//choose
		if(color == 0) {
			return Math.min(pMin(Costs,rowindex+1,1,minamount+Costs[rowindex][0]),
					pMin(Costs,rowindex+1,2,minamount+Costs[rowindex][0]));
		}if(color==1) {
			return Math.min(pMin(Costs,rowindex+1,0,minamount+Costs[rowindex][1]), 
					pMin(Costs,rowindex+1,2,minamount+Costs[rowindex][1]));
		}if(color==2) {
			return Math.min(pMin(Costs,rowindex+1,1,minamount+Costs[rowindex][2]), 
					pMin(Costs,rowindex+1,0,minamount+Costs[rowindex][2]));
		}
		
		return 9900;
	}
	

}
