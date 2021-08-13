//time complexity: O(n), its 3n where 3 is the number of rows and n is the number of houses or rows
//space complexity: O(1), manipulated the matrix already given in the question
//running on leetcode: yes
class Solution {
    public int minCost(int[][] costs) {
        //base case
        if(costs==null || costs.length==0)
        {
            return 0;
        }
        //stopping condition is when the costs matrix is empty
        //costs.length-2 because we are starting from last second row
          for (int i = costs.length-2; i>=0; i--)
          {
              costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
              costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
              costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
          }
        return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
    }
}
