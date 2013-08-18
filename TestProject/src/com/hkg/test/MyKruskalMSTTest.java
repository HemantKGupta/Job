package com.hkg.test;

import java.util.LinkedList;
import java.util.Queue;

public class MyKruskalMSTTest {
	private double weight; // weight of MST
	private Queue<Edge> mst = new LinkedList<Edge>(); // edges in MST

	// Kruskal's algorithm
	public MyKruskalMSTTest(EdgeWeightedGraph G) {
		// more efficient to build heap by passing array of edges
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : G.edges()) {
			pq.insert(e);
		}

		// run greedy algorithm
		UF uf = new UF(G.v);
		while (!pq.isEmpty() && mst.size() < G.v - 1) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if (!uf.connected(v, w)) { // v-w does not create a cycle
				uf.union(v, w); // merge v and w components
				mst.add(e); // add edge e to mst
				weight += e.weight();
			}
		}

		// check optimality conditions
		// assert check(G);
	}

	// edges in minimum spanning forest as an Iterable
	public Iterable<Edge> edges() {
		return mst;
	}

	// weight of minimum spanning forest
	public double weight() {
		return weight;
	}

	// check optimality conditions (takes time proportional to E V lg* V)
	private boolean check(EdgeWeightedGraph G) {

		// check total weight
		double total = 0.0;
		for (Edge e : edges()) {
			total += e.weight();
		}
		double EPSILON = 1E-12;
		if (Math.abs(total - weight()) > EPSILON) {
			System.err.printf(
					"Weight of edges does not equal weight(): %f vs. %f\n",
					total, weight());
			return false;
		}

		// check that it is acyclic
		UF uf = new UF(G.v);
		for (Edge e : edges()) {
			int v = e.either(), w = e.other(v);
			if (uf.connected(v, w)) {
				System.err.println("Not a forest");
				return false;
			}
			uf.union(v, w);
		}

		// check that it is a spanning forest
		for (Edge e : edges()) {
			int v = e.either(), w = e.other(v);
			if (!uf.connected(v, w)) {
				System.err.println("Not a spanning forest");
				return false;
			}
		}

		// check that it is a minimal spanning forest (cut optimality
		// conditions)
		for (Edge e : edges()) {
			int v = e.either(), w = e.other(v);

			// all edges in MST except e
			uf = new UF(G.v);
			for (Edge f : mst) {
				int x = f.either(), y = f.other(x);
				if (f != e)
					uf.union(x, y);
			}

			// check that e is min weight edge in crossing cut
			for (Edge f : G.edges()) {
				int x = f.either(), y = f.other(x);
				if (!uf.connected(x, y)) {
					if (f.weight() < e.weight()) {
						System.err.println("Edge " + f
								+ " violates cut optimality conditions");
						return false;
					}
				}
			}

		}

		return true;
	}

	public static void main(String[] args) {
		EdgeWeightedGraph G = new EdgeWeightedGraph();
		System.out.println(G);
		MyKruskalMSTTest mst = new MyKruskalMSTTest(G);
		for (Edge e : mst.edges()) {
			System.out.println(e);
		}
		System.out.printf("%.5f\n", mst.weight());
	}
}
