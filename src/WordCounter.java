
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter
{
    public Map countList = new HashMap();

    void countWord(String input)
    {
        input = input.toLowerCase();
        String word;

        Pattern wordPattern = Pattern.compile("[a-zA-Z]+-?[a-zA-Z]*");
        Matcher m = wordPattern.matcher(input);

        while(m.find())
        {
            word = m.group();
            if(!countList.containsKey(word))
            {
                countList.put(word, 1);
            }
            else
            {
                int value = (int)countList.get(word) + 1;
                countList.put(word, value);
            }
        }


    }
}
