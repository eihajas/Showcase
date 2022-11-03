package support;

public class Data 
//Custom data class containing a tag(description of data)
//and tagInfo(actual data value)
{
    protected String tag;
    protected String tagInfo;

    public Data(String tag, String tagInfo)
    //Constructor: sets tag and taginfo based on given inputs
    {
        this.tag = tag;
        this.tagInfo = tagInfo;
    }

    public void setTag(String tag)
    //Allows user to set existing tag
    {
        this.tag = tag;
    }

    public void setTagInfo(String tagInfo)
    //Allows user to set existing tagInfo
    {
        this.tagInfo = tagInfo;
    }

    public String getTag()
    //returns tag
    {
        return tag;
    }

    public String getTagInfo()
    //returns tagInfo
    {
        return tagInfo;
    }

    protected String dataToString()
    //used by display, creates a string from tag and tagInfo
    {
        return tag + ": " + tagInfo;
    }

    public void display()
    //prints data in string format
    {
        System.out.println(this.dataToString());
    }
}