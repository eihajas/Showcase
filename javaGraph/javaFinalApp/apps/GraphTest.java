package apps;

import support.*;

public class GraphTest
{
	public static void main(String[] args)
	{
		Graph graph = new Graph();
		graph.addVertex("Herpes", "STD");
		graph.addVertex("Chlamydia", "STD");
		graph.addVertex("John", "Patient");
		graph.addVertex("Jane", "Patient");
		graph.addVertexData("John", "Age", "27");
		graph.addVertexData("John", "Height(inches)", "73");
		graph.addVertexData("Jane", "Age", "26");
		graph.addVertexData("Jane", "Height(inches)", "68");
		graph.addVertexData("Herpes", "Rash Location", "Lower back");
		graph.addVertexData("Chlamydia", "Symptoms", "Painful urination");

		graph.addEdge("Herpes", "John", "Positive Test", "HerpesJohn");
		graph.addEdge("Herpes", "Jane", "Positive Test", "HerpesJane");
		graph.addEdge("Chlamydia", "Jane", "Positive Test", "Chlamydia");
		graph.addEdge("John", "Jane", "Transmission", "John Sex with Jane");
		graph.addEdge("Jane", "John", "Transmission", "Jane Sex with John");
		graph.addEdgeData("HerpesJane", "Date Contracted", "2/2/2017");
		graph.addEdgeData("John Sex with Jane", "Date", "1/3/2017");
		graph.addEdgeData("Jane Sex with John", "Date", "1/4/2017");
		graph.addEdgeData("HerpesJohn", "Date Contracted", "1/1/2017");
		graph.addEdgeData("Chlamydia", "Date Contracted", "1/1/2016");

		graph.saveGraph();
		graph.adjMatrix();
		Graph graph2 = new Graph();
		graph2.loadGraph();
		System.out.println();
		graph2.adjMatrix();
	}
}