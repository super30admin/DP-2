#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int m {amount+1};
        int n {static_cast<int>(coins.size()+1)};
        vector<vector<int>> arr(n,vector<int> (m));
        arr.at(0).at(0) = 1;

        for(int i{1};i<=coins.size();++i){
            for(int j{0};j<=amount;++j){
                if(j<coins.at(i-1)){
                    arr.at(i).at(j) = arr.at(i-1).at(j);
                }
                else{
                    int val1{arr.at(i).at(j-coins.at(i-1))};
                    int val2{arr.at(i-1).at(j)};
                    arr.at(i).at(j) = val1+val2;
                }
            }
        }

        return arr.at(coins.size()).at(amount);
    }
};
