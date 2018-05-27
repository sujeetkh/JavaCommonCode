package in.iisc.csa.sujeet.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	public static Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

	public static void bfs(int source) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		boolean[] visited = new boolean[graph.size()];
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;
		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			System.out.println("traversed: " + currentNode);
			visited[currentNode] = true;
			for (int ele : graph.get(currentNode)) {
				if (!visited[ele]) {
					queue.add(ele);
					visited[ele] = true;
				}
			}
		}
	}

	public static void dfs(int source) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(source);
		boolean[] visited = new boolean[graph.size()];
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;

		while (!stack.isEmpty()) {
			int currentNode = stack.pop();
			visited[currentNode] = true;
			System.out.println("traversed: " + currentNode);
			for (int ele : graph.get(currentNode)) {
				if (!visited[ele]) {
					stack.push(ele);
					visited[ele] = true;
				}
			}
		}
	}

	public static boolean isCyclePresent() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[graph.size()];
		boolean[] currentStack = new boolean[graph.size()];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
			currentStack[i] = false;
		}

		for (int i = 0; i < graph.size(); i++) {
			if (visited[i] == false) {
				stack.push(i);
				for (int j = 0; j < visited.length; j++) {
					currentStack[j] = false;
				}

				while (!stack.isEmpty()) {
					int currentNode = stack.pop();
					visited[currentNode] = true;
					currentStack[currentNode] = true;
					System.out.println("traversed: " + currentNode);
					for (int ele : graph.get(currentNode)) {
						if (currentStack[ele] == true)
							return true;
						else if (!visited[ele]) {
							stack.push(ele);
							currentStack[ele] = true;
							visited[ele] = true;
						}
					}
				}
			}
		}
		return false;
	}

	public static void tpUtil(int vertex, Stack<Integer> stack, boolean[] visited) {
		visited[vertex] = true;
		for (int ele : graph.get(vertex))
			if (!visited[ele])
				tpUtil(ele, stack, visited);
		stack.push(vertex);
	}

	public static void topologicalsort() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[graph.size()];
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;
		for (int i = 0; i < graph.size(); i++)
			if (visited[i] == false)
				tpUtil(i, stack, visited);
		System.out.println("Topological sort:- ");
		while (!stack.isEmpty()) {
			System.out.println(stack.peek() + ",");
			stack.pop();
		}
	}

	public static void main(String[] args) {
		graph.put(0, new ArrayList<Integer>());
		graph.put(1, new ArrayList<Integer>());
		graph.put(2, new ArrayList<Integer>());
		graph.put(3, new ArrayList<Integer>());
		graph.put(4, new ArrayList<Integer>());
		graph.put(5, new ArrayList<Integer>());

		graph.get(5).add(0);
		graph.get(5).add(2);
		graph.get(4).add(0);
		graph.get(4).add(1);
		graph.get(2).add(3);
		graph.get(3).add(1);
		dfs(0);
		System.out.println("Is cycle Present: " + isCyclePresent());
		topologicalsort();
	}
}
