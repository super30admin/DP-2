//paint house recursive approach
class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        if(costs.empty() || costs.size() == 0) return 0;

        int amount = std::numeric_limits<int>::max();

        for (int j = 0; j < 3; j++){
            amount = std::min(amount, helper(costs, 0,j,0));
        }
            return amount;
    }

    int helper(vector<vector<int>>& costs, int i, int j, int amount){
        //base case
        if(i == costs.size()) return amount;


        int case1 = 0, case2 = 0;

        if(j == 0){
           case1 = helper(costs, i+1, 1, amount+costs[i][1]) ;
           case2 = helper(costs, i+1, 2, amount+costs[i][2]);
        }

        if (j == 1){
            case1 = helper(costs, i+1, 0, amount+costs[i][0]) ;
            case2 = helper(costs, i+1, 2, amount+costs[i][2]);
        }

        if(j == 2){
            case1 = helper(costs, i+1, 0, amount+costs[i][0]) ;
            case2 = helper(costs, i+1, 1, amount+costs[i][1]);
        }

        return std::min(case1, case2);

    }
};

//Time Complexity: O(3*2^n) = O(2^n)
//Space Compelxity: O(2^n)
//Time limit exceeded on leetcode
