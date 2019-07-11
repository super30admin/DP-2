//
// Created by shazmaan on 7/11/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <set>


//{6, 7, 1, 3, 8, 2, 4}
//{5, 3, 4, 11, 2}

using namespace std;

class Solution{
public:
    int coinChange(vector<int>& coins, int amount){
        int array[coins.size()+1][amount+1];
        for(int j = 0;j<coins.size()+1;j++){
            array[j][0] = 1;
        }
        for(int i =1; i<amount+1; i++){
            array[0][i] = 0;
        }
        for(int j =1; j<coins.size()+1; j++){
            for(int i =1; i<amount+1; i++){
                if(i<coins[j-1]){
                    array[j][i] = array[j-1][i];
                }else{
                    array[j][i] = array[j-1][i] + array[j][i-coins[j-1]];
//                            + min(array[j-1][i],array[j][i-coins[j-1]]+1);
                }
            }
        }
//        if(array[coins.size()][amount]>=(INT_MAX-1)){return -1;}
        return array[coins.size()][amount];
    }
};

int main(){
    Solution s;
    vector<int> vec{};
    cout<<s.coinChange(vec,5)<<endl;
    return 0;
}