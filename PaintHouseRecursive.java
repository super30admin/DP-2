//Time Complexity: O(n*2^n) where n is the number of colors, multilying with n because we will have n binary trees depending on what color we choose first
//Space Complexity : O(n) length of the longest branch of a binary tree
//executed on leetcode: yes , but Time Limit Exceeded for the below mentioned case  : 
/**
 * [[8,12,18],[14,6,8],[10,9,13],[2,17,14],[18,18,6],[2,1,15],[19,20,2],[18,15,16],[20,18,18],[15,10,10],[2,20,18],[14,5,15],[18,10,12],[9,17,19],[9,1,6],[4,4,10],[7,8,15],[16,17,4],[16,16,13],[12,7,10],[14,13,8],[16,6,18],[10,5,10],[3,5,11],[9,9,6],[10,15,19],[4,5,19],[12,17,17]]
 */
//issues faced: none
//approach: we take different cases based on what color we choose for house number zero and take the minimum cost of all three cases.

class paintHouseRecursive {
    public static int minCost(int[][] costs) {
        //choose variables are the colors chosen for house number 0;
        int choose_red = helper(costs,0,0);
        int choose_blue = helper(costs,1,0);
        int choose_green = helper(costs,2,0);
        return Math.min(choose_red,Math.min(choose_blue,choose_green));
    }
    public static int helper(int[][]costs,int chosen_color,int house_number)
    {
        if(house_number==costs.length) return 0;
        //case1: if chosen color is red,ie,0
        if(chosen_color==0)
        {
            return costs[house_number][0] + Math.min(helper(costs,1,house_number+1),helper(costs,2,house_number+1));
            
        }
        //case2 : chosen color is blue
        else if(chosen_color==1)
        {
            return costs[house_number][1] + 
                Math.min(helper(costs,0,house_number+1),helper(costs,2,house_number+1));
        }
        else //chosen color is green
        {
            return costs[house_number][2] +      Math.min(helper(costs,0,house_number+1),helper(costs,1,house_number+1));
        }
    }
    public static void main(String[] args) {
        int[][] costs = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        System.out.println("minimum cost of painting all houses="+minCost(costs));
    }
}