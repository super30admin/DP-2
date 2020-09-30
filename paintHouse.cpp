//time complexity:O(n)
//space complexity:O(1)
//executed on leetcode: yes
//approach:using dp
//any issues faced? no
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.size()==0)
        {
            return 0;
        }
        int lastR=costs[0][0];
        int lastB=costs[0][1];
        int lastG=costs[0][2];
        int curR,curB,curG;
        for(int i=1; i<costs.size(); i++)
        {
            curR=costs[i][0]+min(lastB,lastG);
            curB=costs[i][1]+min(lastR,lastG);
            curG=costs[i][2]+min(lastR,lastB);
            lastR=curR;
            lastB=curB;
            lastG=curG;
        }
        return min(lastR,min(lastB,lastG));
    }
};