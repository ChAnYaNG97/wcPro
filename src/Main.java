
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
        System.out.println(wc.countList.entrySet());
        controller.writeFile(wc.countList);

    }
}
