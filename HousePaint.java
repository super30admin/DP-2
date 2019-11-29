
public class HousePaint {
	public static int minCost(int[][] costs) {
		
		
		//	Time:  O(n) 
		//	Space O(1) 
		//	LeetCode: yes

		   if(costs==null||costs.length==0)

		       return 0;

		   //for column zero, choosing, 1 and 2, and so on
		   for(int i=1; i<costs.length; i++){

		       costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);

		       costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);

		       costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);

		   }

		   int m = costs.length-1;

		   return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);

		}
}
