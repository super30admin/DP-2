// Time Complexity : O(n) --> loop through the array once to get the minimum sum 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

/*

1. Basic approach is iterate from 2nd row, 1st column to the end by adding the minimum value for previous rows.
2. Add the minimum value for each case as per requirements
3. Handle the edge case for empty array by returning 0
4. Return the minimum sum of the three cases 

*/

#include <iostream>
#include <vector>

using namespace std;

class Solution {
    public:
        int minimumCost(vector<vector<int>>& nums){
            int size = nums.size();
            
            if(size == 0)
                return 0;

            for(int i = 1; i<size; i++)
            {   
                nums[i][0] +=  min(nums[i- 1][1], nums[i- 1][2]); // Start with (2nd row, 1st column) --> (1st row, 2nd column) and (1st row, 3rd column)
                nums[i][1] +=  min(nums[i- 1][0], nums[i- 1][2]); // Start with (2nd row, 2nd column) --> (1st row, 1st column) and (1st row, 3rd column)
                nums[i][2] +=  min(nums[i- 1][0], nums[i- 1][1]); // Start with (2nd row, 3rd column) --> (1st row, 1st column) and (1st row, 2nd column)
            }

            return min((nums[size - 1][0], nums[size - 1][1]), nums[size - 1][2]);
        }
};

int main(){
    Solution s;
    vector<vector<int>> vec{{3,6,4}, {1,7,6}, {4,7,1}, {9,9,1}, {2,2,1} };
    cout<<s.minimumCost(vec);
    return 0;
}
