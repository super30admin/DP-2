#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    int minCost(vector<vector<int>> &costs) {
        // write your code here

        int num_colours{static_cast<int>(costs.at(0).size())};
        int num_houses{static_cast<int>(costs.size())};
        
        vector<vector<int>> dp (num_houses,vector<int> (num_colours));

        for(int i{0};i<num_colours;++i){
            dp.at(num_houses-1).at(i) = costs.at(num_houses-1).at(i);
        }

        for(int i{num_houses -2};i>=0;i--){
            dp.at(i).at(0) = costs.at(i).at(0) + min(costs.at(i+1).at(1),costs.at(i+1).at(2));
            dp.at(i).at(1) = costs.at(i).at(1) + min(costs.at(i+1).at(0),costs.at(i+1).at(2));
            dp.at(i).at(2) = costs.at(i).at(2) + min(costs.at(i+1).at(1),costs.at(i+1).at(0));
        }

        return min(dp.at(0).at(0),dp.at(0).at(1),dp.at(0).at(2));

    }
};
