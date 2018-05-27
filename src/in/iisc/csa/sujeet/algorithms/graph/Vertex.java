package in.iisc.csa.sujeet.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	int value;
	List<Integer> edges;

	public Vertex() {
		edges = new ArrayList<Integer>();
	}

	public Vertex(int value) {
		this.value = value;
		edges = new ArrayList<Integer>();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Integer> getEdges() {
		return edges;
	}

	public void setEdges(List<Integer> edges) {
		this.edges = edges;
	}

	public void addEdge(int vertex) {
		edges.add(vertex);
	}
}
