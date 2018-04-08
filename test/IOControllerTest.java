import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class IOControllerTest {
    @Test
    public void testReadLine()
    {
        IOController input = new IOController("case2.txt");
        String line = input.readLine();
        String expected = "a-b-c f s d d";
        assertEquals(expected, line);
    }

    @Test
    public void testWriteFile()
    {
        HashMap<String, Integer> map = new HashMap<>();
        IOController input = new IOController("result.txt");

        map.put("k",1);
        input.writeFile(map);
        String result = input.readLine();
        String expected = "k 1";
        assertEquals(expected, result);
    }


}