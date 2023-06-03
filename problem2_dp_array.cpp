#include<iostream>
#include<vector>

using namespace std;


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {

        vector<int> arr(amount+1);
        const int max_val{INT_MAX - 147483647};

        arr.at(0) = 1;

        for(int i{1};i<=coins.size();i++){
            for (int j{};j<=amount;j++){
                // case where values are less than the coin value
                if(j>=coins.at(i-1)){
                    int val_1{arr.at(j-coins.at(i-1))};
                    int val_2{arr.at(j)};
                    arr.at(j) = val_2 + val_1;
                }
            }
        }
        
        return arr.at(amount);
    
    }
};