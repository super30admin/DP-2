//https://leetcode.com/problems/paint-house/

public class PaintHouse {

	public static void main(String args[]) {
		int cost[][] = {{1,2,3,4},{2,3,4,5},{3,4,5,6},{5,6,7,8}};
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(" "+cost[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------");

		System.out.println(minCost(cost));
		System.out.println(minCost1(cost));
		System.out.println(minCost2(cost));
	}
  // Time Complexity : O(m)
  // Space Complexity : O(mn)
  //using 2D array
	private static int minCost(int cost[][]) {
		int m=cost.length;
		int dp[][] = new int[m][3];
		for(int i=0;i<3;i++) {
			dp[m-1][i]=cost[m-1][i];
		}
		for(int i=m-2;i>=0;i--) {
			dp[i][0]= cost[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
			dp[i][1]= cost[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
			dp[i][2]= cost[i][2] + Math.min(dp[i+1][1], dp[i+1][0]);
		}
		return Math.min(dp[0][0],Math.min(dp[0][1], dp[0][2]));
	}
	
  // Time Complexity : O(m)
  // Space Complexity : O(m)
  //Using 1D array
	private static int minCost1(int cost[][]) {
		int m=cost.length;
		int dp[] = new int[3];
		for(int j=0;j<3;j++) {
			dp[j] = cost[m-1][j];
		}
		for(int i=m-2;i>=0;i--) {
			int tempR=dp[0];
			dp[0] = cost[i][0] + Math.min(dp[1],dp[2]);
			int tempB=dp[1];
			dp[1] = cost[i][1] + Math.min(tempR,dp[2]);
			dp[2] = cost[i][2] + Math.min(tempB,tempR);
		}
		return Math.min(dp[0],Math.min(dp[1],dp[2]));
	}
  
	// Time Complexity : O(m)
  // Space Complexity : O(1)
  //Using variables
	private static int minCost2(int cost[][]) {
		int m=cost.length;
		int valR = cost[m-1][0];
		int valB = cost[m-1][1];
		int valG = cost[m-1][2];
		
		for(int i=m-2;i>=0;i--) {
			int tempR=valR;
			valR = cost[i][0] + Math.min(valB,valG);
			int tempB=valB;
			valB = cost[i][1] + Math.min(tempR,valG);
			valG = cost[i][2] + Math.min(tempB,tempR);
		}
		return Math.min(valR,Math.min(valB,valG));
	}
}
