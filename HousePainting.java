// Time Complexity :O(3n) where n is the length of the costs array and 3 is the no. of colors.
// Space Complexity :O(n) n where n is the length of the costs array and m is the amount.
// Did this code successfully run on Leetcode :Yes.
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach 


public class HousePainting {

    public static int housePainting(int[][]costs){
        if(costs == null || costs.length ==0) return 0;
        int n = costs.length-1;
        for(int i=1;i<costs.length;i++)
        {
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);

        }

        return Math.min(costs[n][0], Math.min(costs[n][1],costs[n][2]));

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(housePainting(arr));
        
    }

}