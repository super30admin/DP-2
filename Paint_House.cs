using System;

public class PaintHouse
{
    public int minCost(int[][] costs)
    {
        if (costs == null) return 0;
        int n = costs.Length;
        for (int i = n - 2; i >= 0; i--)
        {
            costs[i][0] = costs[i][0] + Math.Min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] = costs[i][1] + Math.Min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] = costs[i][2] + Math.Min(costs[i + 1][0], costs[i + 1][1]);
        }
        return Math.Min(costs[0][0], Math.Min(costs[0][1], costs[0][2]));
    }

    public static void Main(String[] args)
    {
        PaintHouse pH = new PaintHouse();

        int[][] costs = new int[][]{
            new int[] {17, 2, 17},
             new int[] {16, 16, 5},
            new int[] {14, 3, 9}
            };
        int r = pH.minCost(costs);
        Console.WriteLine(r);
    }
}