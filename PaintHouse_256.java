package PaintHouse_256;
/*

//Using Auxiliary DP Matrix.
//@TimeComplexity - O(m), as number of colors is constant
//@Space Complexity - O(MN), as we are using auxiliary space to store the matrix
public class PaintHouse_256 {
	public int minCost(int[][] costs) {
        int m = costs.length; // Number of houses
        int  n = 3; //As it is given that number of colors will only be 3 always
        
        int[][] cost_matrix = new int[m][n];
        
        if(m==0 || costs ==null)
        {
            return 0;
        }
        
// Populating the first row of cost matrix with the same values that of given color costs using top dowm approach        
        
        cost_matrix[0][0] = costs[0][0];
        cost_matrix[0][1] = costs[0][1];
        cost_matrix[0][2] = costs[0][2];
        
        
        for (int i = 1; i<m; i++)
        {
        cost_matrix[i][0] = costs[i][0] + Math.min(cost_matrix[i-1][1],cost_matrix[i-1][2]);
        cost_matrix[i][1] = costs[i][1] + Math.min(cost_matrix[i-1][0],cost_matrix[i-1][2]);
        cost_matrix[i][2] = costs[i][2] + Math.min(cost_matrix[i-1][1],cost_matrix[i-1][0]);
        }
        
        return Math.min(Math.min(cost_matrix[m-1][0], cost_matrix[m-1][1]), cost_matrix[m-1][2]);
    }

	public static void main(String[] args) {
		
	      int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
	      PaintHouse_256 obj = new PaintHouse_256();
	      int min_cost = obj.minCost(costs);
	      System.out.println("The minum cost to paint 3 houses is :"+min_cost);
	}

}*/

//Without using extra space and mutating the cost matrix only.
//@TimeComplexity - O(m), as number of colors is constant
//@Space Complexity - O(1), as we are not using auxiliary space to store the matrix
public class PaintHouse_256 {
	public int minCost(int[][] costs) {
      int m = costs.length; // Number of houses
      int  n = 3; //As it is given that number of colors will only be 3 always
      
      //int[][] cost_matrix = new int[m][n];
      
      if(m==0 || costs ==null)
      {
          return 0;
      }
      
//Populating the first row of cost matrix with the same values that of given color costs using top dowm approach        
      
 
      
      for (int i = 1; i<m; i++)
      {
    	  costs[i][0] = costs[i][0] + Math.min(costs[i-1][1],costs[i-1][2]);
    	  costs[i][1] = costs[i][1] + Math.min(costs[i-1][0],costs[i-1][2]);
    	  costs[i][2] = costs[i][2] + Math.min(costs[i-1][1],costs[i-1][0]);
      }
      
      return Math.min(Math.min(costs[m-1][0], costs[m-1][1]), costs[m-1][2]);
  }

	public static void main(String[] args) {
		
	      int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
	      PaintHouse_256 obj = new PaintHouse_256();
	      int min_cost = obj.minCost(costs);
	      System.out.println("The minum cost to paint 3 houses is :"+min_cost);
	}

}
