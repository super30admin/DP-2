//time - O(mn) - m -> number of houses, n number ofcolours, n = 3 here
//space - O(1) - modifying the input array

class Main {
  public static void main(String[] args) {
    int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
    System.out.println(paintHouse(costs));
  }

  public static int paintHouse(int[][] costs) {
    //the cost to paint the first house either with red, green or blue is same as input..
    //...if we consider only the first house
    if(costs == null || costs.length == 0)
    {
      return 0; //edge case
    }
    //from second to last house
    for(int i = 1; i < costs.length; i++)
    {
      //cost to paint the house with colour i is min of the costs for other 2 colours for previous house plus the current cost
      costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
      costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
      costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
    }

    int result = Integer.MAX_VALUE;

    //return the min value in last row
    for(int i = 0; i < 3; i++)
    {
      int current = costs[costs.length - 1][1];
      result = (result < current) ? result : current;
    }

    return result;
  }
}
