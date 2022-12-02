// Time Complexity :O(N) Where N is the no of houses 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes

public class PaintHouse {
	
	
		public int minCost(int[][] costs) {
		    
	       int cr=costs[0][0],cb=costs[0][1],cg=costs[0][2];
	       for(int i=1;i<costs.length;i++)
	       {
	        int tempCr = cr;
	        cr = costs[i][0]+Math.min(cb,cg);

	        int tempcB = cb;
	        cb = costs[i][1]+Math.min(tempCr,cg);
	        cg = costs[i][2]+Math.min(tempCr,tempcB);
	    }
	      
	        return Math.min(cr,Math.min(cg,cb));
	    
	    }
}
