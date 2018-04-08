
import java.util.HashMap;
import java.util.Map;
/**
 * Main Class
 *
 * @author TangLongxuan ShiXing
 * @date 2018/4/6
 */
public class Main {
    public static void main(String[] args)
    {
        if(args.length < 1)
        {
            System.err.println("Please set the file name.");
        }
        if(!args[0].endsWith(".txt"))
        {
            System.err.println("Wrong File Format!");
            System.exit(1);
        }
        IOController controller = new IOController(args[0]);
        WordCounter wc = new WordCounter();
        String line = "";
        while((line = controller.readLine()) != null)
        {
            wc.countWord(line);
        }
        System.out.println(wc.countList.entrySet());
        controller.writeFile(wc.countList);

    }
}
