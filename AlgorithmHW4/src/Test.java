
public class Test {

	public final int W = 5;

	public int oneZeroKnapsack(Vertex vertex) {
		int n = vertex.books.size();
		int[][] V = new int[n + 1][W + 1];

		for (int w = 0; w <= W; w++) {
			V[0][w] = 0;

		}
		for (int i = 1; i <= n; i++) {
			V[i][0] = 0;
		}
		for (int item = 1; item <= n; item++) {

			for (int weight = 1; weight <= W; weight++) {

				if (vertex.books.get(item - 1).weight <= weight) {

					V[item][weight] = Math.max(vertex.books.get(item - 1).value
							+ V[item - 1][weight - (vertex.books.get(item - 1).weight)], V[item - 1][weight]);

				}

				else {

					V[item][weight] = V[item - 1][weight];

				}

			}

		}

		return V[n][W];

	}

	public static void main(String[] args) {

		Graph g = new Graph();
		Test t = new Test();
		
		
		System.out.println("PRIM : \n");
		g.primMST(g);
		System.out.println("************************************");
		System.out.println("KNAPSACK : \n");
		for (int i = 0; i < g.vertex.length; i++) {
			int a = t.oneZeroKnapsack(g.vertex[i]);
			if(a!=0){
			System.out.println(g.vertex[i].name+" : "+a);
			}
		}
		
	}

}