// Time complexity- O(n), n= number of houses
// Space complecity - O(1)
function minCostToPaintHouses(costs: number[][]): number {
	if (costs.length === 0) {
		return 0;
	}
	const m = costs.length;

	// minimum costs to paint the last house (m-1) with each color
	let minCostRed = costs[m - 1][0];
	let minCostBlue = costs[m - 1][1];
	let minCostGreen = costs[m - 1][2];

	for (let i = m - 2; i >= 0; i--) {
		// temporary store the previous house's minimum costs to ensure correct calculation for the current house
		const prevMinCostRed = minCostRed;
		const prevMinCostBlue = minCostBlue;
		const prevMinCostGreen = minCostGreen;

		// calculate the minimum cost to paint the current house at "i" index for each color
		minCostRed = costs[i][0] + Math.min(prevMinCostBlue, prevMinCostGreen);
		minCostBlue = costs[i][1] + Math.min(prevMinCostRed, prevMinCostGreen);
		minCostGreen = costs[i][2] + Math.min(prevMinCostRed, prevMinCostBlue);
	}

	return Math.min(minCostRed, minCostBlue, minCostGreen);
}
