// Time Complexity :O(n*size_of_coins)
// Space Complexity : O(n*size_of_coins)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Beginnning of DP... Building the idea is hard as this point..


// Here we used a DP approach to solve the problem.
// Forming a 2D matrix with coints vs amount.
// when checking for min number of coins for a particular amount we can check the value for 
// amount - coin value as we will then have a single definitive case which we can add to it.
// 
// We will add the  values because we are finding the total number of pssibilitied for without the coin denomination and with that coin (val for [amount - coin])



class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int> > mytable(coins.size()+1,vector<int> (amount+1, 0));
        
        
        for (int k =0; k< coins.size()+1; k++){
                mytable[k][0] = 1;
            }
            for (int k =1; k< amount+1; k++){
                mytable[0][k] = 0;
               
            }
        for (int i =1; i < coins.size()+1; i++){
            for ( int j = 1; j < amount+1; j++){
               if (j < coins[i-1]){
                   mytable[i][j] = mytable[i-1][j];
               } 
                else {
                    mytable[i][j] =  mytable[i-1][j] + mytable[i][j-coins[i-1]];
                }
            }
            
            
        }
        return  mytable[coins.size()][amount] ;
    }
};