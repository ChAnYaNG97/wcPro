
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
        long st = System.nanoTime();
        if(args.length < 1)
        {
            System.err.println("Please set the file name.");
        }
        IOController controller = new IOController(args[0]);
        WordCounter wc = new WordCounter();
        String line;
        while((line = controller.readLine()) != null)
        {
            wc.countWord(line);
        }
        System.out.println(wc.countList.entrySet());
        controller.writeFile(wc.countList);
        System.out.println((System.nanoTime()-st) / 1e9);
    }
}
