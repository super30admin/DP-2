/**
 * time complexity : O(n)
 * space complexity : O(n)
 * leet code execution : haven't executed, It's part of premium subscription which i dont have.
 * Steps: given the array of mxn size, For every given elements there's a option to chose and not to chose, here came up with logic to calculate min combination for each row
 *         which classify matrix into m1x1,m2x1,m3x1 and if one lement is chosen, the min of neighbouring elemnts is calculated to arrive at solution at last index of matrix.
 */

class HousePaint {

    public int paint(int[][] costs){
        if(costs==null || costs.length==0) return -1;
        int n = costs.length-1;
        for(int i=1;i<costs.length;i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][2], costs[i-1][0]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }

        return Math.min(costs[n][0],Math.min(costs[n][1],costs[n][2]));

    }

    public static void main(String[] args) {
        
        HousePaint hp = new HousePaint();
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(hp.paint(costs));
    }
}