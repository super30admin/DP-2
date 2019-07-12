//
// Created by shazmaan on 7/12/2019.
//
// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Confusing to figure the logic out but easy once you do.
// Approach:
// [[17,5,17]] -> find min element from current index and save in minVal. and update the dirtyIndex to point to
// minVal. next iteration, avoid the dirty index while calculating minVal and update dirtyIndex for the next iteration and
// repeat.


#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
//[ [17,2,17] , [[16,16,5]] , [[14,3,19]] ]
class Solution{
public:
    int prob(vector<vector<int>>& nums){
        if(nums.size()==0){
            return 0;
        }
        int minVal; int retSum = 0; int first; int second; int index;
        for(int i = 0; i<nums.size(); i++){
            minVal=INT_MAX;
            if(i==0){
                minVal=nums[i][0]; index = 0;
                for(int j = 1; j<3; j++){
                    if(nums[i][j]<minVal){minVal=nums[i][j];index = j;}
                }
            }else{
                int prevIndex = index;
//                cout<<index<<" minVal\n";
                for(int j = 0; j<3; j++){
                    if(prevIndex!=j && nums[i][j]<minVal){
                        minVal=nums[i][j]; index = j;
                    }
                }
//                cout<<index<<" index After\n";
            }
            retSum += minVal;
        }
        return retSum;
    }
};

int main(){
    Solution s;
    vector<vector<int>> vec{{17,2,17} , {16,5,16} , {14,3,19} };
    cout<<s.prob(vec);
    return 0;

}

//if(i==0){
//                minVal = *min_element(nums[0].begin(),nums[0].end()); retSum+=minVal;
//                index = find(nums[0])
//            }else{
//                if(nums[i][0]==minVal){
//                    first = nums[i][1]; second = nums[i][2];
//                }else if(nums[i][1]==minVal){
//                    first = nums[i][0]; second = nums[i][2];
//                }else{
//                    first = nums[i][0]; second = nums[i][1];
//                }
//                minVal = *min_element(nums[0].begin(),nums[0].end()); retSum+=minVal;
//            }