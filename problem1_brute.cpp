#include<iostream>
#include<vector>

using namespace std;

class Solution{

    int helper(vector<vector<int>> &costs, int i, int color, int amount){

        if(i == costs.size()) return amount;

        //logic for exhaustive 

        if(color == 0){
            int val_1 = helper(costs,i+1,1,amount + costs.at(i).at(0));
            int val_2 = helper(costs,i+1,1,amount + costs.at(i).at(0));
            return min(val_1,val_2);
        }

        if(color == 1){
            int val_1 = helper(costs,i+1,0,amount + costs.at(i).at(1));
            int val_2 = helper(costs,i+1,2,amount + costs.at(i).at(1));
            return min(val_1,val_2);
        }

        if(color == 2){
            int val_1 = helper(costs,i+1,0,amount + costs.at(i).at(2));
            int val_2 = helper(costs,i+1,2,amount + costs.at(i).at(2));
            return min(val_1,val_2);
        }

        return -1;

    }

    int minCost(vector<vector<int>>& costs){
        int costR = helper(costs,0,0,0); // 0
        int costB = helper(costs,1,0); // 1
        int costG = helper(costs,2,0); // 2

        return min(costR,costB,costG);
    }


}