class Solution{

  public static void main(String[] args){
    int[] val = {60};
    int[] weights = {10};
    System.out.println(test(val, weights, 60));
  }

public static int test(int[] val, int[] weights, int capacity){

int[][] dp = new int[weights.length+1][capacity+1];

for(int i=0;i<dp.length; i++){

  for(int j=0; j<dp[0].length; j++){

    if(i == 0 || j == 0 ){
      dp[i][j] = 0;
    }
    else if(weights[i-1] > j){
      dp[i][j] = dp[i-1][j] ;
    }
    else if(weights[i-1] <= j){
      dp[i][j] = Math.max(dp[i-1][j] , val[i-1] + dp[i-1][j-weights[i-1]]);
    }
  }
}
return dp[dp.length-1][dp[0].length-1];
}
}
