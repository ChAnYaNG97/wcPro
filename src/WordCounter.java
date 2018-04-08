
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * WordCounter Class
 *
 * @author LiuQian
 * @date 2018/4/5
 */
public class WordCounter
{
    HashMap<String, Integer> countList = new HashMap();
    private static Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z]+(-[a-zA-Z]+)*-?");
    void countWord(String input)
    {
        input = input.toLowerCase();
        String word;
        Matcher m = WORD_PATTERN.matcher(input);

        while(m.find())
        {
            word = m.group();
            if(word.endsWith("-"))
            {
                word = word.substring(0,word.length()-1);
            }
            if(!countList.containsKey(word))
            {
                countList.put(word, 1);
            }
            else
            {
                int value = countList.get(word) + 1;
                countList.put(word, value);
            }
        }
    }

}
