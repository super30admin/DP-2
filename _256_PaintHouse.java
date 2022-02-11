// space complexity - o(n)
    	//time - o(n)
      //Ran on leeetcode successfully : Yes
      // Problem faced  : No
    	//Approach : brute force using back tracking 3^n

      class Solution {

          int minCost = Integer.MAX_VALUE;

          public int minCost(int[][] costs) {
              minCost(costs, 0,-1, 0);
              return minCost;
          }

          public void minCost(int[][] costs, int house, int color, int cost) {
              if(house ==  costs.length){
                  minCost  = Math.min(minCost, cost);
                  return;
              }

              for(int j=0 ; j< costs[0].length; j++){
                  if(j != color){
                      minCost(costs, house+1, j ,  cost + costs[house][j]);
                  }
              }


          }
      }
