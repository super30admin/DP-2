// Time Complexity :O(n*n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if(costs.length==0)
            return 0;
        return helper(costs);
    }
    private int helper(int[][]matrix){
        int n=matrix.length-1;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<matrix[i].length;j++){
                int add=matrix[i+1][j];
                if(j==0) //if red
                    add=Math.min(matrix[i+1][j+1],matrix[i+1][j+2]);
                else if(j==matrix[i].length-1) //if green
                    add=Math.min(matrix[i+1][j-2],matrix[i+1][j-1]);
                else //if blue
                    add=Math.min(matrix[i+1][j+1],matrix[i+1][j-1]);
                matrix[i][j]+=add;
                    
            }
        }
        System.out.println(Arrays.toString(matrix[0]));
        int min=matrix[0][0];
        for(int i=1;i<matrix[0].length;i++)
            if(min>matrix[0][i])
                min=matrix[0][i];
        return min;
    }
}