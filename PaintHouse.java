public class PaintHouse {
    public static int paint (int[][] costs) {
        for(int i = costs.length - 2; i>= 0; i--) {
            for(int j = 0; j< 3; j++) {
                if(j == 0) 
                costs[i][j] = costs[i][j] + Math.min(costs[i+1][1],  costs[i+1][2]);
                if(j == 1) 
                costs[i][j] = costs[i][j] + Math.min(costs[i+1][0],  costs[i+1][2]);
                if(j == 2) 
                costs[i][j] = costs[i][j] + Math.min(costs[i+1][0],  costs[i+1][1]);
            }
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    public static void main(String[] args) {
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(paint(costs));
    }
}
