package apps;

import support.*;
import java.util.Scanner;

public class GraphApp
{
	public static void main(String[] args)
	{
		Graph graph1 = new Graph();
		Graph graph2 = new Graph();
		Graph graph3 = new Graph();
		graph1.loadGraph("support/gameEdgesQuality.txt");
		graph2.loadGraph("support/gameEdgesGenre.txt");
		graph3.loadGraph("support/gameEdgesDev.txt"); // Creates three different graphs for the three different edge types
		Scanner scn = new Scanner(System.in);
		System.out.println("Welcome to the videogame database!");

		System.out.print("This first table shows the similarity of videogame quality based on ratings");
		System.out.print("\n\n\n");
		graph1.adjMatrix();
		System.out.print("\n\n\n");
		System.out.print("This next table shows the similarity based on genre of game");
		System.out.print("\n\n\n");
		graph2.adjMatrix();
		System.out.print("\n\n\n");
		System.out.print("The last table shows which games are made by the same developer");
		System.out.print("\n\n\n");
		graph3.adjMatrix();
		System.out.print("\n\n\n");
		graph1.showEndPoint("Skyrim");
		System.out.print("\n\n\n");
		graph2.showStartPoint("Elden Ring");
		System.out.print("\n\n\n");
		graph3.showClass("Publisher");
		graph2.showTag("Genre");
		graph1.showClassEdge("Quality");
		graph2.showClassVertex("RPG");
		graph1.saveGraph();
		graph2.saveGraph();
		graph3.saveGraph();


	}
}