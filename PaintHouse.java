// Time Complexity :O(3*n) or O(n) where n is the number of house . Since three houses and three colors are there, hence O(1)
// Space Complexity : No extra space is required. Hence O(1) constant space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//       R G B 
//  H1 [[1,2,3],
//  H2  [4,5,6],
//  H3  [7,8,9]]

// for h2 if we select R then we can paint h1 with g or b so we choose the  4 + min(h1 g,h1 b) 
// for h2 if we select G then we can paint h1 with r or b so we choose the  5 + min(h1 r,h1 b) 
// for h2 if we select B then we can paint h1 with g or r so we choose the  6 + min(h1 r,h1 g)
// and we continue propagating the value for h3 in the same manner.
//  the min of last row is the answer since it takes into account all the minimum possible options

class Solution {

    public int minCost(int[][] costs) {

        if (costs == null || costs.length == 0) {
            return 0;
        }

        for (int i = 1; i < costs.length; i++) {
//So by this we add possible element from the row above to the current element            
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }


        return Math.min(Math.min(costs[costs.length - 1][0], costs[costs.length -][1]),costs[costs.length -1][2]);
    }
}