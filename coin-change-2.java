// Time Complexity :    O(N*M)      //itirating through matrix (amount*coins)
// Space Complexity :   O(N*M)      //Because creating matrix of cells N*M
// Did this code successfully run on Leetcode : YES


// Your code here along with comments explaining your approach
//DP SOLUTION
import java.util.*;
class Main {
  public static int maxWays(int []coins, int amount){
    if(amount==0){
      return 0;
    }
    if(coins==null || coins.length==0){
      return 0;
    }
    int [][]dp=new int[coins.length+1][amount+1];           //adding 0th row  and 0th column 
    for(int i=0;i<dp.length;i++){                           //initializing first column of each row to 1 because 1 possibility of getting 0 with (0),(0,1),(0,1,2),(0,1,2,5)
      dp[i][0]=1;
    }
    for(int i=1;i<dp.length;i++){                       
      for(int j=1;j<dp[0].length;j++){
        if(j<coins[i-1]){                                   //if j < previous coin value then taking previous occurances
          dp[i][j]=dp[i-1][j];
        }else{
          dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];          // if j is greater, then adding previous occurances with the occurance at amount-coins[i-1]
        }
      }
    }
    return dp[coins.length][amount];                        //display last cell which contains the maximum possible ways
  }
  public static void main(String[] args) {
    int []coins={1,2,5};
    int amount=11;
    System.out.println("Maximum number of ways amount can be formed using coins is: "+maxWays(coins, amount));
  }
}


//RECUSIVE SOLUTION
 class Main {
  private static int maxWays(int []coins, int amount, int index){
    if(amount==0){
      return 1;
    }
    if(amount<=0 || index==coins.length){
      return 0;
    }
    //if choose
    int case1=maxWays(coins, amount-coins[index], index);
    //if not choose
    int case2=maxWays(coins, amount, index+1);

    return case1+case2;
  }
  public static void main(String[] args) {
    int []coins={1,2,5};
    int amount=11;
    System.out.println("Maximum possible ways to get amount is: " +maxWays(coins, amount, 0));
  }
}   