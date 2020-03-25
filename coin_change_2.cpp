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
        if(  coins.size()==0 ){
            return 0;
        }
        //1.C
        if(coins.size()==1){
            return !(amount%coins.at(0));
        }
        
        return number_of_ways_to_attain_amount( amount, coins);
    }
};

