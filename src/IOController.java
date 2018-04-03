import java.io.*;
import java.util.*;

public class IOController {

    private String filepath;
    private File inputFile;
    private File outputFile;

    private BufferedInputStream bis;
    private BufferedReader reader;
    private FileOutputStream os;
    private OutputStreamWriter writer;


    IOController(String fileName)
    {
        filepath = fileName;
        inputFile = new File(fileName);
        try{
            bis = new BufferedInputStream(new FileInputStream(inputFile));
            reader = new BufferedReader(new InputStreamReader(bis, "utf8"), 5*1024*1024);
            outputFile = new File("result.txt");
            os = new FileOutputStream(outputFile);
            writer = new OutputStreamWriter(os, "UTF-8");

        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public String readLine()
    {
        try {
            return reader.readLine();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    




}
