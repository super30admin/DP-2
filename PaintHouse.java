// Time Complexity : O(number of houses * number of colors)
// Space Complexity : O(number of houses * number of colors)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Adjacent houses cannot have same color. 
//Minimum cost to paint at each house is calculated by considering color that is not in the same column. 
//The total min cost is obtained in the last row. 

public class PaintHouse {
    public static int minCost(int[][] costs) {
        
        if( costs == null || costs.length == 0) return 0;
        
        for(int i=1; i<costs.length; i++){
            for(int j=0; j<costs[0].length; j++){
                costs[i][j] += findMin(costs, i, j);              
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j=0; j<costs[0].length; j++){
          min = Math.min(min, costs[costs.length-1][j]);  
        }
        
        return min;
    }
    
    private static int findMin(int[][] costs, int i, int col){
        
        int min = Integer.MAX_VALUE;
        
        for(int j=0; j<costs[0].length; j++){
            if(j == col) continue;
            min = Math.min(min, costs[i-1][j]);
        }
        return min;
    }

    public static void main(String[] args){
        int[][] arr = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(arr));
    }
}