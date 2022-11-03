package support;

import support.*;
/* Vertex class containing vertex id(human readable)
  vertex type, and vertex data of a seperate class*/
public class Vertex
{
    protected String id; // Vertex id
    protected String class1; // vertex type
    protected Data[] data;// vertex data
    protected int dataCap = 100;// vertex data cap
    protected int dataCount;// vertex datacount

    public Vertex()
    {
        id = "";
        class1 = "";
        data = new Data[dataCap];
        dataCount = 0;
    }
    // Vertex constructor
    public Vertex(String name, String type)
    {
        id = name;
        class1 = type;
        data = new Data[dataCap];
        dataCount = 0;
    }
    // Returns the id of the vertex
    public String getId()
    {
        return id;
    }
    // Returns the count of the data in the vertex
    public int getVertexDataCount()
    {
        return dataCount;
    }
    // Returns the type of the vertex (app specific)
    public String vertexGetClass()
    {
        return class1;
    }
    // Returns the data tag of the vertex data
    public String getVertexDataTag(int index)
    {
        return data[index].getTag();
    }
    // Returns the data contained in the vertex
    public String getVertexData(int index)
    {
        return data[index].getTagInfo();
    }
    // Adds data tag and data to a vertex
    public void addData(String newTag, String newTagInfo)
    {
        Data newEntry = new Data(newTag, newTagInfo);
        data[dataCount] = newEntry;
        dataCount++;
    }
    // Prints data to be human readable
    public void printData()
    {
        for (int i = 0; i < dataCount; i++)
        {
            data[i].display();
        }
    }
    // Removes data from a vertex
    public void removeData(String badTag)
    {
        for (int i = 0; i < dataCount; i++)
        {
            if (data[i].getTag().equals(badTag))
            {
                while (i < dataCount)
                {
                    data[i] = data[i+1];
                    i++;
                }
            }
        }
    }
}