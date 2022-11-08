package S30_Codes.DP_2;
import java.util.Arrays;

// Time Complexity : O(house*color*color)
//Space Complexity :  O(house*color)


public class PaintHouse {
    public int minCost(int[][] costs) {
        int cache[][] = new int[costs.length][costs[0].length];
        for(int i=0; i<costs.length; i++){
            Arrays.fill(cache[i], -1);
        }

        int min = Integer.MAX_VALUE;
        for(int j=0; j<costs[0].length; j++){
            min = Math.min( min, findMinCost(costs, 0, j, cache));
        }
        return min;
    }

    // cache[i][j] represents min cost of painting ith to last house and painting ith house with jth color
    private int findMinCost(int[][] costs, int houseIdx, int colorIdx, int[][] cache) {
        if(houseIdx == costs.length || colorIdx == costs[0].length)
            return 0;

        if(cache[houseIdx][colorIdx] == -1) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < costs[0].length; j++) {
                if (j != colorIdx) {
                    min = Math.min(min, findMinCost(costs, houseIdx + 1, j, cache));
                }
            }
            cache[houseIdx][colorIdx] = min + costs[houseIdx][colorIdx];
        }
        return cache[houseIdx][colorIdx];
    }

    // cache[i][j] represents min cost of painting first house to ith house with paining ith hose with jth color
    public int minCostIterative(int[][] costs) {
        int prev[] = costs[0];

        for(int i=1; i<costs.length; i++){
            int cur[] = new int[costs[0].length];

            for(int j=0; j<costs[0].length; j++){
                int min = Integer.MAX_VALUE;
                for(int k=0; k<costs[0].length; k++) {
                    if(k != j) {
                        min = Math.min(min, prev[k]);
                    }
                }
                cur[j] = costs[i][j] + min;
            }
            prev = cur;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<prev.length; i++){
            min = Math.min( min, prev[i]);
        }
        return min;
    }
}

class main{
    public static void main(String args[]){
        PaintHouse ph = new PaintHouse();
        int[][] costs = {{17, 1, 17}, {2, 16, 15}, {4, 13, 9}};
        System.out.println(ph.minCost(costs));
        System.out.println(ph.minCostIterative(costs));
    }
}