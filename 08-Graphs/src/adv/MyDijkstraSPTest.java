package adv;

import advanced.DirectedEdge;

import java.util.Stack;

public class MyDijkstraSPTest {
	private double[] distTo; // distTo[v] = distance of shortest s->v path
	private advanced.DirectedEdge[] edgeTo; // edgeTo[v] = last edge on shortest s->v
									// path
	private IndexMinPQ<Double> pq; // priority queue of vertices

	public MyDijkstraSPTest(advanced.EdgeWeightedDigraph G, int s) {
		distTo = new double[G.v];
		edgeTo = new advanced.DirectedEdge[G.v];
		for (int v = 0; v < G.v; v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;

		// relax vertices in order of distance from s
		pq = new IndexMinPQ<Double>(G.v);
		pq.insert(s, distTo[s]);
		while (!pq.isEmpty()) {
			int v = pq.delMin();
			for (advanced.DirectedEdge e : G.adj(v))
				relax(e);
		}

		// check optimality conditions
		assert check(G, s);
	}

	// relax edge e and update pq if changed
	private void relax(advanced.DirectedEdge e) {
		int v = e.from(), w = e.to();
		if (distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			if (pq.contains(w))
				pq.change(w, distTo[w]);
			else
				pq.insert(w, distTo[w]);
		}
	}

	// length of shortest path from s to v
	public double distTo(int v) {
		return distTo[v];
	}

	// is there a path from s to v?
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	// shortest path from s to v as an Iterable, null if no such path
	public Iterable<advanced.DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<advanced.DirectedEdge> path = new Stack<advanced.DirectedEdge>();
		for (advanced.DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}

	// check optimality conditions:
	// (i) for all edges e: distTo[e.to()] <= distTo[e.from()] + e.weight()
	// (ii) for all edge e on the SPT: distTo[e.to()] == distTo[e.from()] +
	// e.weight()
	private boolean check(advanced.EdgeWeightedDigraph G, int s) {

		// check that edge weights are nonnegative
		for (advanced.DirectedEdge e : G.edges()) {
			if (e.weight() < 0) {
				System.err.println("negative edge weight detected");
				return false;
			}
		}

		// check that distTo[v] and edgeTo[v] are consistent
		if (distTo[s] != 0.0 || edgeTo[s] != null) {
			System.err.println("distTo[s] and edgeTo[s] inconsistent");
			return false;
		}
		for (int v = 0; v < G.v; v++) {
			if (v == s)
				continue;
			if (edgeTo[v] == null && distTo[v] != Double.POSITIVE_INFINITY) {
				System.err.println("distTo[] and edgeTo[] inconsistent");
				return false;
			}
		}

		// check that all edges e = v->w satisfy distTo[w] <= distTo[v] +
		// e.weight()
		for (int v = 0; v < G.v; v++) {
			for (advanced.DirectedEdge e : G.adj(v)) {
				int w = e.to();
				if (distTo[v] + e.weight() < distTo[w]) {
					System.err.println("edge " + e + " not relaxed");
					return false;
				}
			}
		}

		// check that all edges e = v->w on SPT satisfy distTo[w] == distTo[v] +
		// e.weight()
		for (int w = 0; w < G.v; w++) {
			if (edgeTo[w] == null)
				continue;
			advanced.DirectedEdge e = edgeTo[w];
			int v = e.from();
			if (w != e.to())
				return false;
			if (distTo[v] + e.weight() != distTo[w]) {
				System.err.println("edge " + e + " on shortest path not tight");
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		advanced.EdgeWeightedDigraph G = new advanced.EdgeWeightedDigraph();

		// compute shortest paths
		int s = 0;
		MyDijkstraSPTest sp = new MyDijkstraSPTest(G, s);

		// print shortest path
		for (int t = 0; t < G.v; t++) {
			if (sp.hasPathTo(t)) {
				System.out.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
				if (sp.hasPathTo(t)) {
					for (DirectedEdge e : sp.pathTo(t)) {
						System.out.print(e + "   ");
					}
				}
				System.out.println();
			} else {
				System.out.printf("%d to %d         no path\n", s, t);
			}
		}
	}
}
