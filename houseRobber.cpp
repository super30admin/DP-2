//T : O(N)
//S : O(1)
class Solution {
public:
    int rob(vector<int>& nums) {
        int C = 0, DC =0;
        for(int i=0;i<nums.size();i++){
            int prev = DC;
            DC = max(C,DC);
            C = prev+nums[i];
        }
        return max (C,DC);
    }
};