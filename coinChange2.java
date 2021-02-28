// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this approach we build a 2-d array and maintain the number of possibilities in a cell.
// To get this number of ways to have a target , if the target is less than the highest denomination then we simply get the value from the above
// cell if not then we add the value at above cell and go back steps that's equivalent to the highest denomination value currently.
class Solution {
    public int change(int amount, int[] coins) {
        
    	
        int n = coins.length +1 ;
        int m = amount + 1;
        
        int[][] matrix = new int[n][m];
        
        //putting the first cell as 1 as there is one way to have 0 value with 0 value coin
        matrix[0][0]= 1;
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {	
            	//get value from above
                if(j < coins[i-1])
                {
                    matrix[i][j] = matrix[i-1][j];
                }
                //cell above + go back highest denomination no.of steps
                else
                {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j - coins[i-1]];
                }
            }
        }
        return matrix[n-1][m-1];
    }
}