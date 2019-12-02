//paint house without mutating
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.empty() || costs.size() == 0) return 0;

        int prevR = costs[0][0];
        int prevB = costs[0][1];
        int prevG = costs[0][2];



        for(int i =1; i<costs.size(); i++){
            int currR = costs[i][0] + std::min(prevB, prevG);
            int currB = costs[i][1] + std::min(prevR, prevG);
            int currG = costs[i][2] + std::min(prevR, prevB);

            prevR = currR;
            prevB = currB;
            prevG = currG;
        }

        return std::min(prevR, std::min(prevB, prevG));

    }
};

//Time Complexity : O(n)
//Space Complexity: O(1)
