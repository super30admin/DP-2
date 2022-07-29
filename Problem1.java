// Time Complexity : O (n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : I have not tested, don't have leetcode premium
// Any problem you faced while coding this : No

class Problem1 {
    public static void main(String args[]) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,9}};
        // This optimization of colors and storing the last array was beneficial
        int red = costs[costs.length-1][0];
        int blue = costs[costs.length-1][1];
        int green = costs[costs.length-1][2];
            for(int i = costs[0].length-2; i >=0; i--) {
                int tempr = red;
                red = costs[i][0] + Math.min(blue, green);
                int tempb = blue;
                blue = costs[i][1] + Math.min(tempr, green);
                green = costs[i][2] + Math.min(tempb, green);
            }

            System.out.println(Math.min(red,Math.min(blue,green)));

    }


}