import java.io.*;
import java.util.*;
class Io
{
//============Class data below========================
  //ArrayList<String[]> alContacts = new ArrayList<String[]>(); 
  private ArrayList<String> alLines = new ArrayList<String>();
  //ArrayList<Integer> alSearchIndex = new ArrayList<Integer>();
  //String[] aryContacts;
  //String[] arySearch;
  String[] aryStrings;
  //String[] aryWriteContacts;
  String header = "";
  File f;
  //int index = 0;
  //int searchIndex = 0;
  BufferedReader br;
  //BufferedWriter bw;
//==================== methods below ================
//==============Constructor for Io class=============
  /*
  Io(String s)
  {
    f = new File(s);
  }
  */
//===================================================  
  /**
   * = true when current file opens a buffered reader
   * = false otherwise
   */
  boolean getFile()
  {
    boolean status = false;
    try
    {
      br = new BufferedReader(new FileReader(f));
      status = true;
    }
    catch(Exception e)
    {
      System.out.println("Trouble reading file");
      status = false;
    }
    return status;
 }
//=========================================================
  /**
   * = true when all lines of the current file are read into alLines using getFile method
   */
  boolean getRecords()
  {
    boolean status = false;
    String line;    
    try
    {
      if(getFile())
      {
        status = true;
        if((header = br.readLine()) == null) return false;
        while((line = br.readLine())!= null)
        {
          alLines.add(line);
        }
        //fileToArrayList();
        //buildSearchArray();
      }
      else status = false;
      br.close();
    }
    catch(Exception e)
    {
      status = false;
    }
    return status;
 }
//==========================================
  /**
   * = array of record strings of the current file
   */
  public String[] getRecordsArray(String filepath)
  {
    try
    {
      f = new File(filepath);
      if(getRecords())
      {
        aryStrings = new String[alLines.size()];
        for(int i = 0; i < aryStrings.length; i++)
        {
          aryStrings[i] = alLines.get(i);
        }
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    return aryStrings;
  }
}