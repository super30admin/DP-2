#include<iostream>
#include<vector>

using namespace std;

class Solution {
    int helper(vector<int>&coins, int idx, int amount){
        if(amount == 0) return 1;
        if(amount<0 || idx == coins.size()) return 0;

        int case0 = helper(coins,idx,amount - coins.at(idx));
        int case1 = helper(coins,idx+1,amount);

        return case0+case1;
    }
public:
    int change(int amount, vector<int>& coins) {
        return helper(coins,0,amount);
    }
};