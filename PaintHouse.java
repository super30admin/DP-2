/** Time Complexity: O(number of houses)
 * Space Complexity : O(1)
 * Executed on Leetcode: yes
 * issues faced : no
 * Approach: 
 * red: 0 , blue: 1,green: 2
 * dp[house_number][chosen_color] represents the min cost taken to paint the house with house_number with color chosen_color.
 * 
 * dp[1][0] means the min cost to paint house number 1 with red color
 * = cost of painting house1 with red color (6)
 *  + min cost of ((cost of painting house 0 with blue color),(cost of painting house 0 with green color));
 * 
 * dp[2][0] means the min cost to paint house number 2 with red color
 * 
 * = cost of cost of painting house1 with red color (4) 
 *   + min cost of ((cost of painting house 1 with blue color),(cost of painting house 1 with green color));
 * 
 * cost of painting house 1 with blue color here already is computed taking into consideration that house 0 would have been painted with color green or red.
 * 
 * 
 * 
 * 
 */




class paintHouse {
    public static int minCost(int[][] costs) {
        if(costs.length==0) return 0;
        int[][] dp = new int[costs.length][3];
        for(int i=0;i<3;++i) dp[0][i] = costs[0][i];
        for(int house_number=1;house_number<costs.length;++house_number)
        {
                // chosen color is red = 0
                    dp[house_number][0] = costs[house_number][0]
                        +
                        Math.min(dp[house_number-1][1],dp[house_number-1][2]);
                   
                
                // chosen color is blue = 1
            
                    dp[house_number][1] = costs[house_number][1]
                        +
                        Math.min(dp[house_number-1][0],dp[house_number-1][2]);
            
                // chosen color is green = 2
            
                    dp[house_number][2] = costs[house_number][2]
                        +
                        Math.min(dp[house_number-1][1],dp[house_number-1][0]);
                
        }
        
        return Math.min(dp[costs.length-1][0],Math.min(dp[costs.length-1][1],dp[costs.length-1][2]));
        
        
    }
    public static void main(String[] args) {
        int[][] costs = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        System.out.println("min costs to paint all houses="+minCost(costs));
    }

}