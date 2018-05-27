package in.iisc.csa.sujeet.algorithms.contest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import in.iisc.csa.sujeet.algorithms.graph.Vertex;

public class FrequencyBasedDFS {
	static int getCount(int u, int l, int r, List<Vertex> vertices) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(u - 1);

		boolean[] visited = new boolean[vertices.size()];
		Arrays.fill(visited, false);

		while (!stack.isEmpty()) {
			Integer key = stack.pop();
			visited[key] = true;
			if (map.containsKey(vertices.get(key).getValue())) {
				int oldValue = map.get(vertices.get(key).getValue());
				map.put(vertices.get(key).getValue(), oldValue + 1);
			} else
				map.put(vertices.get(key).getValue(), 1);

			for (int ele : vertices.get(key).getEdges()) {
				if (!visited[ele]) {
					stack.push(ele);
					visited[ele] = true;
				}
			}
		}

		for (Map.Entry<Integer, Integer> val : map.entrySet()) {
			if (val.getValue() >= l && val.getValue() <= r)
				count++;
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		int n, q;
		List<Vertex> vertices = new ArrayList<Vertex>();
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		q = in.nextInt();

		for (int i = 0; i < n; i++)
			vertices.add(new Vertex());

		for (int i = 0; i < n - 1; i++) {
			int v1, v2;
			v1 = in.nextInt();
			v2 = in.nextInt();
			vertices.get(v1 - 1).addEdge(v2 - 1);
		}

		for (int i = 0; i < n; i++) {
			vertices.get(i).setValue(in.nextInt());
		}
		for (int i = 0; i < q; i++) {

			int u, l, r;
			u = in.nextInt();
			l = in.nextInt();
			r = in.nextInt();

			System.out.println(getCount(u, l, r, vertices));
		}
	}

}
