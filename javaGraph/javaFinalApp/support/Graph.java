package support;

import support.*;
import java.io.*;
import java.util.Scanner;

public class Graph
//collection of vertices and edges
//contains current number of vertices and max number allowed
//current number of edges and max number allowed
//DEFCAP preset max number allowed
//two arrays, one for vertices and one for edges
{
	private int numVertices;
	private int maxVertices;
	private int numEdges;
	private int maxEdges;
	private static final int DEFCAP = 100;
	private static final int EDGECAP = 1000;
	private Vertex[] vertices;
	private Edge[] edges;

	public Graph()
	//constructor
	//sets current numbers to zero and max numbers to DEFCAP
	//initializes arrays for vertices and edges
	{
		numVertices = 0;
		maxVertices = DEFCAP;
		numEdges = 0;
		maxEdges = DEFCAP;
		vertices = new Vertex[DEFCAP];
		edges = new Edge[EDGECAP];
	}

	public void addVertex(String name, String type)
	//checks if vertex with same name exists and if not
	//constructs a vertex with that name and adds it to the graph
  	{
		if (this.hasVertex(name))
		{
			System.out.println("Vertex already exists");
		}
		else
		{
			Vertex temp = new Vertex(name, type);
			vertices[numVertices] = temp;
			numVertices++;
		}
  	}

	public void addVertexData(String name, String vTag, String vTagData)
	//using given name, finds vertex with that name and allows user to add a tag and tagInfo to it
	{
		for (int i = 0; i < numVertices; i++)
		{
			if (vertices[i].getId() == name)
			{
				vertices[i].addData(vTag, vTagData);
			}
		}
	}

  	public boolean hasVertex(String vertex)
	//checks if vertex with given name exists in the graph
  	{
	  int vertexMatch = 0;
	  for (int i = 0; i < numVertices; i++)
	  {
	    if (vertices[i].getId() == vertex) 
	      {
	        vertexMatch++;
	      }
	  }
	  if (vertexMatch > 0) {return true;}
	  else {return false;}
	}

	//private int indexIs(Vertex vertex)
	//// Returns the index of vertex in vertices.
	//{
	//  int index = 0;
	//  while (!vertex.equals(vertices[index]))
	//    index++;
	//  return index;
	//}

	public void addEdge(String fromVertex, String toVertex, String type, String name)
	// Adds an edge with given idTo, idFrom, class1, and id and adds it to graph
	{
	  	Edge newEdge = new Edge(fromVertex, toVertex, type, name);
		edges[numEdges] = newEdge;
		numEdges++;
	}

	public void addEdgeData(String name, String vTag, String vTagData)
	//allows user to add tag and taginfo to edge with given name 
	{
		for (int i = 0; i < numEdges; i++)
		{
			if (edges[i].getId() == name)
			{
				edges[i].addData(vTag, vTagData);
			}
		}
	}
	
	public void adjMatrix()
	//prints out an adjacency matrix of the graph
	{
		System.out.format("%15s|", " ");
		for (int i = 0; i < numVertices; i++)
		{
			System.out.format("%-15s|", vertices[i].getId());
		}
		System.out.println();
		//prints the first row which starts with an empty space and then each of the vertices in the graph

		for (int i = 0; i <= numVertices; i++)
		{
			System.out.format("---------------|");
		}
		//prints table lines

		String toId;//string to hold the toId of edges
		int[] y = new int[100];//array to hold connections
		int ySize = 0;// number of connections
		boolean connect = false;//true if there is a connection otherwise false
		for (int i = 0; i < numVertices; i++)
		//loop through vertices in the graph and print them along the left column
		{
			System.out.println();
			System.out.format("%-15s|", vertices[i].getId());//print table line
			y = new int[100];//reset y array and size
			ySize = 0;

			for (int j = 0; j < numEdges; j++)
			{	
				for (int z = 0; z < numVertices; z++)
				//loop through edges and check the idFrom against the id of the current vertex row
				//and finds the end point for that edge and adds that index to y array
				{
					if (edges[j].getFrom().equals(vertices[i].getId()) && edges[j].getTo().equals(vertices[z].getId()))
					{
						y[ySize] = z;
						ySize++;
					}
				}
			}
			for (int k = 0; k < numVertices; k++)
			//loops through vertices and if the index is in the y array sets connect to true
			{
				for (int z = 0; z < ySize; z++)
				{
					if (y[z] == k)
					{
						connect = true;
					}
				}
				//after, if connect is true, prints out an X indicating connection otherwise prints empty and resets connect to false
				if (connect == true)
				{
					System.out.format("%8s%8s", "X", "|");
				}
				else
				{
					System.out.format("%15s|", " ");
				}
				connect = false;
			}
			
			System.out.println();
			for (int j = 0; j <= numVertices; j++)
			//Print table lines
			{
				System.out.format("---------------|");
			}
		}
	}
	// Saves current graph data to files stored on computer
	// Serves to retain information from current graph
	// Uses semicolons(;) as delimiters
	public void saveGraph()
	{
		try
		{
			File vertexFile = new File("support/gameVertices.txt"); // file that will contain vertex parameters and data
			FileWriter fw = new FileWriter(vertexFile); // filewriter object that writes the data into the file
			for (int i = 0; i < numVertices; i++)
			{
				fw.write(vertices[i].getId());// writes vertex id to file
				fw.write(";"); // adds our delimiting character
				fw.write(vertices[i].vertexGetClass()); // writes vertex type to file
				fw.write(";");
				for (int j = 0; j < vertices[i].getVertexDataCount(); j++) // for loop to write the vertex data tag and data to file
				{
					fw.write(vertices[i].getVertexDataTag(j)); // writes vertex data tag to file
					fw.write(";");
					fw.write(vertices[i].getVertexData(j)); // writes vertex data to file
					fw.write(";");
				}
				fw.write("\n");
			}
			fw.close();
		}

		catch (IOException e)
		{
			System.out.println("An error occurred. Could not open file."); // error if file can't be opened
		}

		try
		{
			File edgeFile = new File("support/gameEdges.txt"); // file that will contain edge parameters and data
			FileWriter fw = new FileWriter(edgeFile);
			for (int i = 0; i < numEdges; i++)
			{
				fw.write(edges[i].getId()); // writes edge id to file
				fw.write(";");
				fw.write(edges[i].getFrom()); // writes edge from vertex to file
				fw.write(";");
				fw.write(edges[i].getTo()); // writes edge to vertex to file
				fw.write(";");
				fw.write(edges[i].edgeGetClass()); // writes edge type to file
				fw.write(";");
				for (int j = 0; j < edges[i].getEdgeDataCount(); j++) // writes all edge data to file
				{
					fw.write(edges[i].getEdgeDataTag(j)); // writes edge data tag to file
					fw.write(";");
					fw.write(edges[i].getEdgeData(j)); // writes edge data to file
					fw.write(";");
				}
				fw.write("\n");
			}
			//edgeFile.close();
			fw.close();
		}

		catch (IOException e)
		{
			System.out.println("An error occurred. Could not open file."); // error if file can't be opened
		}
	}
	// Loads in vertices, edges, and data from files stored on computer
	// Uses File and Scanner objects to locate and read in data
	public void loadGraph(String filepath)
	{
		try
		{
			File vertexFile = new File("support/gameVertices.txt");
			Scanner fs = new Scanner(vertexFile);
			String newVI; // string for new vertex individual
			numVertices = 0;
			vertices = new Vertex[DEFCAP];
			String[] newV; // String array for temp storage of vertex parameters
			String[] newData; // String array for temp storage of vertex data
			Vertex temp; // instantiation for each vertex to be added to graph

			while (fs.hasNextLine()) // while scanner object has more to read
			{
				newVI = fs.nextLine(); // reads each line of file as individual vertex
				newV = newVI.split(";",3); // splits on first semicolons, leaves the trailing data of line as third element
										   // and stores the tokens temporarily in array
				temp = new Vertex(newV[0], newV[1]); // takes the first two elements of the array as parameters and assigns to vertex object
				newData = newV[2].split(";"); // splits the third element of array into tokens
				for (int i = 0; i < newData.length; i++)
				{
					temp.addData(newData[i], newData[i + 1]); // adds data tag and data to vertex
					i++;
				}
				vertices[numVertices] = temp; // stores vertex object in the graph
				numVertices++; // increments number of vertices
			}
			fs.close();
		}

		catch (IOException e)
		{
			System.out.println("An error occurred. Could not open file."); // error if file can't be opened
		}

		try
		{
			File edgeFile = new File(filepath);
			Scanner fs = new Scanner(edgeFile);
			String newEI; // string for new edge individual
			numEdges = 0;
			edges = new Edge[EDGECAP];
			String[] newE; // String array for storing edge parameters
			String[] newEData; // String array for storing edge data
			Edge tempEdge; // instantiation of each edge object to be added to graph

			while (fs.hasNextLine())
			{
				newEI = fs.nextLine();
				newE = newEI.split(";",5); // splits on the first five semicolons and stores them
				tempEdge = new Edge(newE[1], newE[2], newE[3], newE[0]); // assigning parameters to edge object
				newEData = newE[4].split(";"); // splits rest of the semicolons into the data
				for (int i = 0; i < newEData.length; i++)
				{
					tempEdge.addData(newEData[i], newEData[i + 1]); // adds the data to the edge object
					i++;
				}
				edges[numEdges] = tempEdge; // stores the edge object in the graph
				numEdges++;
			}
			fs.close();
		}

		catch (IOException e)
		{
			System.out.println("An error occurred. Could not open file."); // error if file can't be opened
		}
	}

	public void showTag(String tag)
	//Finds edges with given tag and displays all information about them
	{
		for (int i = 0; i < numEdges; i++)
		{
			if (edges[i].edgeHasTag(tag) == true)
			{
				System.out.println(edges[i].getFrom() + " is related to " + edges[i].getTo() + " with the given tag " + tag);
				System.out.println("Data: ");
				System.out.println(edges[i].edgeGetClass());
				edges[i].printData();
				System.out.println();
			}
		}
	}

	public void showEndPoint(String end)
	//Finds edges that end of given vertex id and displays all info about them
	{
		for (int i = 0; i < numEdges; i++)
		{
			if (edges[i].hasEnd(end) == true)
			{
				System.out.println(edges[i].getFrom() + " has end point " + edges[i].getTo());
				System.out.println("Data: ");
				System.out.println(edges[i].edgeGetClass());
				edges[i].printData();
				System.out.println();
			}
		}
	}

	public void showStartPoint(String start)
	//Finds edges that start on given vertex id and displays all info about them
	{
		for (int i = 0; i < numEdges; i++)
		{
			if (edges[i].hasStart(start) == true)
			{
				System.out.println(edges[i].getTo() + " has start point " + edges[i].getFrom());
				System.out.println("Data: ");
				System.out.println(edges[i].edgeGetClass());
				edges[i].printData();
				System.out.println();
			}
		}
	}

	public void showClass(String type)
	// Finds all edges with given classes and finds all info about thems
	{
		for (int i = 0; i < numEdges; i++)
		{
			if (edges[i].edgeGetClass().equals(type))
			{
				System.out.println(edges[i].getFrom() + " is related to " + edges[i].getTo() + " by the given class " + type);
				System.out.println("Data: ");
				System.out.println(edges[i].edgeGetClass());
				edges[i].printData();
				System.out.println();
			}
		}
	}

	public void showClassEdge(String type)
	//Finds all edges with given class and displays all info in them
	{
		for (int i = 0; i < numEdges; i++)
		{
			if (edges[i].edgeGetClass().equals(type))
			{
				System.out.println(edges[i].getFrom() + " is related to " + edges[i].getTo() + " by the given class " + type);
				System.out.println("Data: ");
				System.out.println(edges[i].edgeGetClass());
				edges[i].printData();
				System.out.println();
			}
		}
	}
	public void showClassVertex(String type)
	//Finds all vertices with given class and displays all info in them
	{
		for (int i = 0; i < numVertices; i++)
		{
			if (vertices[i].vertexGetClass().equals(type))
			{
				System.out.println(vertices[i].getId() + " has the given class " + type);
				System.out.println("Data: ");
				System.out.println(vertices[i].vertexGetClass());
				vertices[i].printData();
				System.out.println();
			}
		}
	}
}