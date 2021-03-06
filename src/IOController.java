
import java.io.*;
import java.nio.CharBuffer;
import java.util.*;


/**
 * IOController Class
 *
 * @author YangChen
 * @date 2018/4/3
 */
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
    
    public void writeFile(HashMap<String, Integer> wordMap)
    {
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(wordMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int count = 0;
        for(Map.Entry<String,Integer> element :list){
            if(count < 100)
            {
                try
                {
                    writer.append(element.getKey() + ' ' + element.getValue());
                    writer.append("\r\n");
                    count++;
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        try {
            writer.close();
            os.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }

}
