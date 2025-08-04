/**
 * time complexity: O(n) where n is the number of houses
 * space complexity: O(1)
 * did this code successfully run on Leetcode?  Yes
 * Any problems faced while running the code?  No
 */

/**
 * Here , m represents a number of houses and n the number of colors are 3.
 * We iterate through the houses in reverse order and for each house we calculate the minimum cost of painting the adjacent/following houses given that Red is chosen for cuurent house, Blue is chosen for current house and Green is chosen for current house. The total minimum cost when each color is chosen is obtained by adding the cost of painting the current house with current color and the minimum cost of painting the adjacent house with the other two colors.
 * Finally we return the minimum of the three costs obtained for the last house.
*/
class paintHouse {
    public int minCost(int[][] costs) {
        int m=costs.length;
        int[] dp=new int[3];

        dp[0]=costs[m-1][0];
        dp[1]=costs[m-1][1];
        dp[2]=costs[m-1][2];

        for(int i=m-2;i>=0;i--)
        {
            int tempR=dp[0];
            int tempB=dp[1];
            dp[0]=costs[i][0]+Math.min(dp[1],dp[2]);
            dp[1]=costs[i][1]+Math.min(tempR,dp[2]);
            dp[2]=costs[i][2]+Math.min(tempR,tempB);
        }
    return Math.min(dp[0],Math.min(dp[1],dp[2]));

        
    }
}