package in.iisc.csa.sujeet.algorithms.graph;

public class UnionFind {
	int[] parent, rank;
	int size;

	public UnionFind(int n) {
		rank = new int[n];
		parent = new int[n];
		this.size = n;
		makeSet();
	}

	// Creates n sets with single item in each
	void makeSet() {
		for (int i = 0; i < size; i++) {
			// Initially, all elements are in
			// their own set.
			parent[i] = i;
		}
	}

	public int find(int i) {
		// If i is the parent of itself
		if (parent[i] == i) {
			// Then i is the representative of
			// this set
			return i;
		} else {
			// Else if i is not the parent of
			// itself, then i is not the
			// representative of his set. So we
			// recursively call Find on its parent
			return find(parent[i]);
		}
	}

	public void union(int i, int j) {
		// Find the representatives
		// (or the root nodes) for the set
		// that includes i

		int irep = this.find(i);
		// And do the same for the set
		// that includes j
		int jrep = this.find(j);

		// Make the parent of i’s representative
		// be j’s representative effectively
		// moving all of i’s set into j’s set)
		this.parent[irep] = jrep;
	}

	// Returns representative of x's set
	int findCompression(int x) {
		// Finds the representative of the set
		// that x is an element of
		if (parent[x] != x) {
			// if x is not the parent of itself
			// Then x is not the representative of
			// his set,
			parent[x] = find(parent[x]);

			// so we recursively call Find on its parent
			// and move i's node directly under the
			// representative of this set
		}

		return parent[x];
	}

	// Unites the set that includes x and the set
	// that includes x
	void unionCompression(int x, int y) {
		// Find representatives of two sets
		int xRoot = find(x), yRoot = find(y);

		// Elements are in the same set, no need
		// to unite anything.
		if (xRoot == yRoot)
			return;

		// If x's rank is less than y's rank
		if (rank[xRoot] < rank[yRoot])

			// Then move x under y so that depth
			// of tree remains less
			parent[xRoot] = yRoot;

		// Else if y's rank is less than x's rank
		else if (rank[yRoot] < rank[xRoot])

			// Then move y under x so that depth of
			// tree remains less
			parent[yRoot] = xRoot;

		else // if ranks are the same
		{
			// Then move y under x (doesn't matter
			// which one goes where)
			parent[yRoot] = xRoot;

			// And increment the the result tree's
			// rank by 1
			rank[xRoot] = rank[xRoot] + 1;
		}
	}

	public static void main(String[] args) {

	}

}
