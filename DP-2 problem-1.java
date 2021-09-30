// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    public int change(int amount, int[] coins) {
        int m=amount+1;
        int [] a=new int[m];
        a[0]=1;
        for(int r:coins){
            for(int i=0;i<m;i++){
                if((i-r)>=0){
                    a[i]=a[i]+a[i-r];
                }
            }
        }
    
        
return a[amount];}
}