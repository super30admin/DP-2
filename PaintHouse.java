// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minCost(int[][] costs) {
       int[][] arr = new int[costs.length][costs[0].length];
       for(int i=0;i<costs.length;i++){
           for(int j=0;j<costs[0].length;j++){
               if(i==0){
                   arr[i][j] = costs[i][j];
               }
               else{
                   if(j==0){
                     arr[i][j] = costs[i][j] + Math.min(arr[i-1][1],arr[i-1][2]);  
                   }
                   if(j==1){
                     arr[i][j] = costs[i][j] + Math.min(arr[i-1][0],arr[i-1][2]);  
                   }
                   if(j==2){
                     arr[i][j] = costs[i][j] + Math.min(arr[i-1][0],arr[i-1][1]);  
                   }
               }
           }
       }
       return Math.min(arr[costs.length-1][0],Math.min(arr[costs.length-1][1],arr[costs.length-1][2])); 
    }
}