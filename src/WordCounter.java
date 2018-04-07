package src;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter
{
    HashMap<String, Integer> countList = new HashMap();

    void countWord(String input)
    {
        String word;
        Pattern wordPattern = Pattern.compile("[a-zA-Z]+(-[a-zA-z]+)*-?");
        Matcher m = wordPattern.matcher(input);

        while(m.find())
        {
            word = m.group();
            if(word.endsWith("-"))
                word = word.substring(0,word.length()-1);
            if(!countList.containsKey(word))
                countList.put(word, 1);
            else
            {
                int value = countList.get(word) + 1;
                countList.put(word, value);
            }
        }
    }

}
