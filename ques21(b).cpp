Time Complexity-O(n)
Space Complexity-O(1) *constant space*
Did the code run on Leetcode? Yes

#include<vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int compare(int a,int b,int c)
    {
        if(a<=b && a<=c)
            return a;
        else if(b<=a && b<=c)
            return b;
        else
            return c;
    }
    int minCost(vector<vector<int>>& costs) {
        int result1=0,result2=0,result3=0;
	    for(int i=0;i<costs.size();i++)
	    {
            int result4=result1;
            int result5=result2;
            int result6=result3;
            result1=costs[i][0]+min(result5,result6);
	        result2=costs[i][1]+min(result4,result6);
	        result3=costs[i][2]+min(result4,result5);   
	    }
        int result=compare(result1,result2,result3);
        return result;
    }
};

int main() {
    vector<vector<int>>m={{17,2,17},{16,16,5},{14,3,19}};
    Solution soln;
    int res=soln.minCost(m);
    cout<<res;
	return 0;
}