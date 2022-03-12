public class PaintHouse {
  
  /**
   * Bottom - Up approach
   * 
   * Updating the input matrix in place.
   * 
   * Time Compelxity: O(n) where n -> number of houses.
   * Space complexity: O(1) - no extra space used.
   */

  public int minCost(int[][] costs) {
    for(int i = costs.length-2; i >= 0; i--){
            costs[i][0] = costs[i][0] + Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i+1][0], costs[i+1][1]);
    }
    
    return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
  }

  /**
   * Top - Down approach. Using only 3 variables. Same 3 variables can be used for a bottom up approach.
   * 
   * Time Complexity: O(n) where n -> number of houses.
   * Space Complexity: O(1) - no extra space used.
   */

  public int minCost(int[][] costs) {
        
    int costR = costs[0][0];
    int costB = costs[0][1];
    int costG = costs[0][2];
    
    for(int i = 1; i < costs.length; i++){
        int tempR = costR;
        int tempB = costB;
            
        costR = costs[i][0] + Math.min(costB, costG);
        costB = costs[i][1] + Math.min(tempR, costG);
        costG = costs[i][2] + Math.min(tempR, tempB);
    }
    
    
    return Math.min(costR, Math.min(costB, costG));
  } 
}
