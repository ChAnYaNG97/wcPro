import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        IOController controller = new IOController("case.txt");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("aaa",323);
        map.put("vvv",123);
        controller.writeFile(map);

    }
}
