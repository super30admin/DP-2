// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode :  yes


// Your code here along with comments explaining your approach
import java.util.*;
class Main{
  public static void main(String []args){
    int [][]costs={{17,2,17}, {16,16,5},{14,3,19}};
    System.out.println("The minimum cost is : "+findMin(costs));
  }
  private static int findMin(int [][]costs){
    if(costs==null || costs.length==0){
      return 0;
    }
    for(int i=1;i<costs.length;i++){
      costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
      costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
      costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);
    }
    return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
  }
}
