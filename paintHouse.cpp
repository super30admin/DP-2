//Brute Force Recursion 
//Time complexity = O(3*2^(n-1))
//Space = size of recursion stack 

//Optimized DP
//Time complexity = O(3*N) 
//Space complexity = O(1)
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.size() ==0) return 0;
        int m=costs.size(); //rows
        int costR = costs[m-1][0];
        int costB = costs[m-1][1];
        int costG = costs[m-1][2];
        
        for(int i=m-2;i>=0;i--){
            int prevR = costR;
            int prevB = costB;
            costR = costs[i][0] + std::min(costB,costG);
            costB = costs[i][1] + std::min(prevR,costG);
            costG = costs[i][2] + std::min(prevR,prevB);
        }
        return std::min(costR, std::min(costB,costG));
    }
};
