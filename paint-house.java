//Time complexity: O(2^N)
//Space complexity: O(N), because space is occupied by recursion stack
class Solution {
    public int minCost(int[][] costs) {
         if(costs == null || costs.length == 0) {
             return 0;
         }
         int caseRed = helperMethod(costs, 0, 0, 0);
         int caseBlue = helperMethod(costs, 0, 1, 0);
         int caseGreen = helperMethod(costs, 0, 2, 0);
         return Math.min(caseRed, Math.min(caseBlue, caseGreen));
     }
 
     private int helperMethod(int[][] costs, int house, int color, int minCost) {
         //base case
         if(house == costs.length) {
             return minCost;
         }
         //logic
         if(color == 0) {
             return Math.min(helperMethod(costs, house + 1, 1, minCost + costs[house][0]),
             helperMethod(costs, house + 1, 2, minCost + costs[house][0]));
         }
         if(color == 1) {
             return Math.min(helperMethod(costs, house + 1, 0, minCost + costs[house][1]),
             helperMethod(costs, house + 1, 2, minCost + costs[house][1]));
         }
         if(color == 2) {
             return Math.min(helperMethod(costs, house + 1, 0, minCost + costs[house][2]),
             helperMethod(costs, house + 1, 1, minCost + costs[house][2]));
         }
         return 0;
     }
 }