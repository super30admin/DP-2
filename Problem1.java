
//Time complexity: O(n)
//Space Complexity O(1)  ie O(3)

public class Problem1 {

	public static int minCost(int[][] costs) {
        if(costs==null || costs.length==0)
            return 0;      
 
    int[] prev = costs[0];
        

        for(int i=1;i<costs.length;i++){
             
            int[] curr=costs[i];
             
           
         curr[0]+=Math.min(prev[1],prev[2]);
         curr[1]+=Math.min(prev[0],prev[2]);
         curr[2]+=Math.min(prev[0],prev[1]);
             
          
            prev=curr;
           
        }
          
     return   Math.min(prev[0],Math.min(prev[1],prev[2]));
    }
	
	public static void main(String[] args) {
		int[][] costs= new int[][] {
			{17,2,17},{16,16,5},{14,3,19}};
			
			int res= minCost(costs);
			
			System.out.println(res);
	}
}
