/* 
 * This algorithm creates a dp[][] matrix and place the values in 
 * it and in the end we get the desired value.
 * Complexity of algorithm is O(m * n), m- number of coins and n - amount need to calculated
 *  
 * */
public class PaintHouse {
	
	
	   public int minCost(int[][] costs) {
	        
	         if(costs==null || costs.length==0)
	            return 0;
	        
	        
	        int cr= costs[costs.length-1][0];
	        int cb= costs[costs.length-1][1];
	        int cg= costs[costs.length-1][2];
	        
	        for(int i=costs.length-2;i>=0;i--){
	            int tempr=cr,tempb=cb,tempg=cg;
	            
	            cr= costs[i][0]+ Math.min(cb,cg);
	            cb= costs[i][1]+ Math.min(tempr,cg);
	            cg= costs[i][2]+ Math.min(tempr,tempb);
	        }
	        
	        
	        return Math.min( cr,Math.min(cb,cg));
	        
	        
	    }
	        
	        
//	         if(costs==null || costs.length==0)
//	             return 0;
	        
//	         int case1= helper(costs,0,0,0);
//	         int case2= helper(costs,0,1,0);
//	         int case3= helper(costs,0,2,0);
	        
//	         return Math.min(case1, Math.min(case2,case3));
	        
	        
//	     }
	    
//	     private int helper(int[][] costs,int row,int color,int min){
	        
	        
//	         //base
//	         if(row== costs.length)
//	             return min;
	        
//	         //logic
	        
//	         if(color==0){
	            
//	             return Math.min(
//	             helper(costs,row+1,1,min+costs[row][0]),helper(costs,row+1,2,min+costs[row][0])                
//	             );
//	         }
//	         if(color==1){
	            
//	             return Math.min(
//	             helper(costs,row+1,0,min+costs[row][1]),helper(costs,row+1,3,min+costs[row][1])                
//	             );
//	         }
	     
	            
//	             return Math.min(
//	             helper(costs,row+1,0,min+costs[row][2]),helper(costs,row+1,1,min+costs[row][2])                
//	             );
	        
	        
//	     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] costs = {{17,2,17},{16,16,5},{14,3,19}};
		
		PaintHouse objIn= new PaintHouse();
		
		System.out.println(objIn.minCost(costs));

	}

}
