// Time Complexity : O(2^mn) m:is the amount, n is the number of coins
//Space  Complexity : O(2^mn)
class Solution {
public:
    int ways=0;
    int change(int amount, vector<int>& coins) {
        //edge
         if(amount==0)
            return 1;
        if(coins.size()==0)
            return 0;
        
        //recurse
        return recurse(coins, 0, 0, amount);
    }
    
    
    int recurse(vector<int>& coins, int index, int curr_amount, int amount, ){
        //edge
        if(curr_amount == amount){
            return 1;
        }else if(curr_amount> amount || index >= coins.size()){
            return 0;
        }
        //choose + //dont_choose
        int curr_ways = recurse(coins, index, curr_amount+coins[index], amount) + recurse(coins, index+1, curr_amount, amount);
        return curr_ways;
    }
};

//Memoization solution
// Time Complexity : O(2^mn) m:is the amount, n is the number of coins
//Space  Complexity : O(2^mn)
class Solution {
public:
    int ways=0;
    int change(int amount, vector<int>& coins) {
        //edge
         if(amount==0)
            return 1;
        if(coins.size()==0)
            return 0;
        
        //recurse
        vector<vector<int>> memo(coins.size()+1, vector<int>(amount+1,0));
        memo[0][0]=1;
        return recurse(coins, 0, 0, amount, memo);
    }
    
    
    int recurse(vector<int>& coins, int index, int curr_amount, int amount, vector<vector<int>> &memo){
        //edge
        if(curr_amount == amount){
            return 1;
        }else if(curr_amount>amount || index >= coins.size()){
            return 0;
        }
        
        if(memo[index+1][curr_amount+1] !=0){
            return memo[index+1][curr_amount+1];
        }
        //choose + //dont_choose
        int curr_ways = recurse(coins, index, curr_amount+coins[index], amount, memo) + recurse(coins, index+1, curr_amount, amount,memo);
        memo[index+1][curr_amount+1] = curr_ways;
        return curr_ways;
    }
};

// Time Complexity : O(mn) m:is the amount, n is the number of coins

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : maintaining one array and solving it was a bit tricky


// Your code here along with comments explaining your approach
//1.Edge cases
//A. return when amount is 0
//B.return when size is zero
//C. Return when an element is present on whether the amount is possible or not

//2.Calculating the ways
//A. for index 0 of coin array fill the denomination array with whether 1 way is possible or nor
//B  From index 1 of coin array fill the denomination array by counting the previous ways and current ways

class Solution {
    int number_of_ways_to_attain_amount(int amount, vector<int>& coins){
        vector<int> number_of_ways_to_attain_denomination(amount+1 , 0);
        number_of_ways_to_attain_denomination[0] = 1;
        
        int i=0,j=1;
        while(i<coins.size()){
            for(j=1; j<=amount;j++){
                if(j<coins[i]){
                    continue;
                }
                if(i==0){
                    //2.A
                    if(j%coins[i] == 0){
                        number_of_ways_to_attain_denomination[j]= 1;
                    }
                }//2.B
                else{
                    number_of_ways_to_attain_denomination[j] = number_of_ways_to_attain_denomination[j]+number_of_ways_to_attain_denomination[j-coins[i]];
                }
            }
            i++;
        }
        return number_of_ways_to_attain_denomination[amount];
    }
    
public:
    int change(int amount, vector<int>& coins) {
        //1.A
        if( amount==0 ){
            return 1;
        }
        //1.B
        if(coins.size()==0 ){
            return 0;
        }
        //1.C
        if(coins.size()==1){
            return !(amount%coins.at(0));
        }
        
        return number_of_ways_to_attain_amount( amount, coins);
    }
};


// Time Complexity : O(mn) m:is the amount, n is the number of coins
// Space Complexity : O(n)
//Simple recursive solution

class Solution {
public:
    int ways=0;
    int change(int amount, vector<int>& coins) {
        //edge
         if(amount==0)
            return 1;
        if(coins.size()==0)
            return 0;
        
        //recurse
        vector<vector<int>> memo(coins.size()+1, vector<int>(amount+1,0));
        memo[0][0]=1;
        int rows = coins.size()+1;
        int cols = amount+1;
        
        for(int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(coins[i-1]>j){
                    memo[i][j] = memo[i-1][j];
                }else{
                    memo[i][j] = memo[i-1][j] + memo[i][j-coins[i-1]];
                }
                //cout<<memo[i][j]<<"\t";
            }
           // cout<<"\n";
        }
        
        return memo[rows-1][cols-1];
    }
    
};
