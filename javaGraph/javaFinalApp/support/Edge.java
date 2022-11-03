package support;

import support.*;

public class Edge
//connection between vertices
//contains: id(name), idFrom(Starting vertex)
//idTo(ending vertex), class1(type of connection)
//data(array of data classes), dataCap(maaximum amount of data allowed)
//dataCount(current amount of data held)
{
    protected String id;
    protected String idFrom;
    protected String idTo;
    protected String class1;
    protected Data[] data;
    protected int dataCap = 100;
    protected int dataCount;

    public Edge(String start, String end, String type, String name)
    //Constructor: Creates an edge with given inputs for idFrom, idTo, id, and class1
    {
        idFrom = start;
        idTo = end;
        class1 = type;
        id = name;
        data = new Data[dataCap];
        dataCount = 0;
    }

    public String getId()
    //returns id
    {
        return id;
    }

    public String getTo()
    //returns idTo
    {
        return idTo;
    }

    public String getFrom()
    //return idFrom
    {
        return idFrom;
    }

    public int getEdgeDataCount()
    //returns current amount of data held
    {
        return dataCount;
    }

    public String edgeGetClass()
    //returns class1
    {
        return class1;
    }

    public String getEdgeDataTag(int index)
    //returns the tag of specified index of data
    {
        return data[index].getTag();
    }

    public boolean edgeHasTag(String tag)
    {
        for (int i = 0; i < dataCount; i++)
        {
            if (data[i].getTag().equals(tag))
            {
                return true;
            }
        }
        return false;
    }
    public boolean hasEnd(String end)
    {
        if (idTo.equals(end))
        {
            return true;
        }
        return false;
    }

    public boolean hasStart(String start)
    {
        if (idFrom.equals(start))
        {
            return true;
        }
        return false;
    }

    public String getEdgeData(int index)
    //returns the tagInfo of specified index of data
    {
        return data[index].getTagInfo();
    }

    public void addData(String newTag, String newTagInfo)
    //constructs a data class and adds it to the data array
    {
        Data newEntry = new Data(newTag, newTagInfo);
        data[dataCount] = newEntry;
        dataCount++;
    }

    public void printData()
    //prints all data in data array
    {
        for (int i = 0; i < dataCount; i++)
        {
            System.out.println(data[i].getTag() + ", " + data[i].getTagInfo());
        }
    }
    
    public void removeData(String badTag)
    //removes data with given tag
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
        dataCount--;
    }
}