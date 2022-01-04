// Time Complexity :o(2^n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approachclass Solution{
    public int minCost(int[][] costs){
        if(costs == null || costs.length == 0){
            return 0;

        }
        int case1 = helper(costs,0,0,0);//red
        int case2 = helper(costs,0,1,0);//blue
        int case3 = helper(costs0,2,0);//green
        return Math.min(case1, Math.min(case2, case3));
    }
    private int helper(int [][] costs , int row ,int color,int costSoFar ){//color of ther present row
        //base
        if(row == costs.length)return costSoFar;
        //logic
        if(color == 0)
        {
            return Math.min(helper(costs, row +1, 1, costSoFar + costs[row][0]), 
                            helper(costs, row + 1, 2, costSoFar + costs[row][0])
                        );
        }
        if(color == 1)
        {
            return Math.min(helper(costs, row +1, 0, costSoFar + costs[row][1]), 
                            helper(costs, row + 1, 2, costSoFar + costs[row][1])
                        );
        }
        if(color == 2)
        {
            return Math.min(helper(costs, row +1, 0, costSoFar + costs[row][2]), 
                            helper(costs, row + 1, 1, costSoFar + costs[row][2])
                        );
        }
        return 99999;
    }
}