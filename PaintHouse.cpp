//Time Complexity - O(N)
//Space Complexity - O(1)
//I am not geting how to memoize the recursive code of this problem.
class Solution {
public:
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    int minCost(vector<vector<int>> &costs) {
        // write your code here
        if(costs.size()==0)
            return 0;
        for(int i=costs.size()-2;i>=0;i--){
            costs[i][0]=min(costs[i+1][1],costs[i+1][2])+costs[i][0];
            costs[i][1]=min(costs[i+1][0],costs[i+1][2])+costs[i][1];
            costs[i][2]=min(costs[i+1][0],costs[i+1][1])+costs[i][2];
        }
        return min(costs[0][0],min(costs[0][1],costs[0][2]));
    }