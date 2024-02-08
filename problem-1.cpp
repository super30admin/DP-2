// 256. Paint House
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
    
Iterating through the houses starting from the second to last one, updating the cost of painting each house 
with the minimum cost of painting the next house with a different color. Finally, returns the minimum cost 
among the options of painting the first house with each color.

*/

int minCost(vector<vector<int>>& costs) {
    for(int i = costs.size()-2; i >= 0; i--)
    {
        for(int j = 0; j < 3; j++)
        {
            if(j == 0)
                costs[i][j] = costs[i][j] + min(costs[i+1][1],costs[i+1][2]);
            else if(j == 1)
                costs[i][j] = costs[i][j] + min(costs[i+1][0],costs[i+1][2]);
            else
                costs[i][j] = costs[i][j] + min(costs[i+1][1],costs[i+1][0]);
        }
    }
    return min(costs[0][2],min(costs[0][0],costs[0][1]));
}


