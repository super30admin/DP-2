 // Time Complexity :O(n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int change(int amount, int[] coins) {
        int[] temp=new int[amount+1];
        Arrays.fill(temp,0);
        temp[0]=1;
        for(int i=0;i<coins.length;i++)
        {
            for(int j=0;j<temp.length;j++)
            {
                if(j>=coins[i])
                {
                    temp[j]=temp[j]+temp[j-coins[i]];
                }
                    
            }
        }
        if(temp[amount]==0)
            return 0;
        return temp[amount];
        
    }
}