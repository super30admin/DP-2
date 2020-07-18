# Time Complexity : O(n)
# Space Complexity : O(1)




class Solution {
public int minCost(int[][] costs) {
    if(costs==null||costs.length==0){
        return 0;
    }
    for(int i=1; i<costs.length; i++){
        costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
        costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
        costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
    }
    int n = costs.length-1;
    return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
}
}

//   red   blue  green
//     0     1    2
      
// 0   17    2    17
// 1   16    16   5
// 2   14    3    19
      
//      red green blue
//             17
//             red c  green blue
//                   17+5
//                   green c blue
                        
//                         22+ 19
//                         blue c  red
      
      
    

