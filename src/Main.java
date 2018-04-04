package src;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args)
    {
        IOController controller = new IOController("case.txt");
        WordCounter wc = new WordCounter();
        String line;
        while((line = controller.readLine()) != null)
            wc.countWord(line);


        String keyStr;
        int value;
        HashMap<String, Integer> newCountList = new HashMap();
        //去掉单词横杠
        for(Object key : wc.countList.keySet())
        {
            keyStr = key.toString();
            if(keyStr.endsWith("-"))
            {
                value = Integer.parseInt(wc.countList.get(key).toString());
                keyStr = keyStr.replace("-", "");
                newCountList.put(keyStr, value);
            }
            else
                newCountList.put(keyStr, Integer.parseInt(wc.countList.get(key).toString()) );
        }

        System.out.println(newCountList.entrySet());
        controller.writeFile(newCountList);

    }
}
