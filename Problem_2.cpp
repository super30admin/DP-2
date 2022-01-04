//Time complexity is O(n*amount) where n is the size of the given array
//Space complexity is O(amount)

/*
Approach: First we tried the exhaustive approach. That approach caused TLE.
So we looked for subproblems and tried dp solution using a tabular method.
We found that if the amount is less than the current denomination then we
can copy the result of the previous denomination for the current amount. But
when the amount is greater than the current denomination then the reuslt is the
sum of the result in the previous row and the result calculated denomination number
of steps back in the current row. The final result is obtained in the last row and
last column
*/


//The code ran perfectly on leetcode




class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int>> mat(coins.size() +1, vector <int> (amount + 1));
        for(int i =0; i<mat.size(); i++){
            mat[i][0] = 1;
        }
        for(int j = 1; j < mat.size(); j++){
            for(int k =1; k<mat[0].size(); k++){
                if(k < coins[j-1]){
                    mat[j][k] = mat[j-1][k];
                } else {
                    mat[j][k] = mat[j-1][k] + mat[j][k-coins[j-1]];
                }
            }
        }
        
        return mat[mat.size()-1][mat[0].size()-1];
    }
};