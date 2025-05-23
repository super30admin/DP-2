// TC : O(2^n+m)
// SC : O(N+M) -- Max depth can reach M+N 

class Solution {
public:
    int total =0;
    void helper(int amount, vector<int>& coins,int index){
        if(amount == 0) {
            total += 1;
            return;
        }
        if(amount < 0 || index >= coins.size()) return;
        helper(amount,coins,index+1);
        helper(amount-coins[index],coins,index);
        return;
    }

    int change(int amount, vector<int>& coins) {
        helper(amount,coins,0);
        return total;
    }
};
