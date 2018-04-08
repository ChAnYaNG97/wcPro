import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class WordCounterTest
{
    WordCounter wc;
    HashMap<String, Integer> expected;
    @Before
    public void before()
    {
        wc = new WordCounter();
        expected = new HashMap<>();
    }

    //test1:无连字符，无常见字符和数字
    @Test
    public void testCountWord1()
    {
        wc.countWord("this is a test a a a ");
        expected.put("this",1);
        expected.put("is",1);
        expected.put("a",4);
        expected.put("test",1);
        assertEquals(expected, wc.countList);
    }

    //test2：无连字符，带常见字符和数字
    @Test
    public void testCountWord2()
    {
        wc.countWord("this]]'$'is'a123test");
        expected.put("this",1);
        expected.put("is",1);
        expected.put("a",1);
        expected.put("test",1);
        assertEquals(expected, wc.countList);
    }

    //test3：带连字符，无常见字符和数字
    @Test
    public void testCountWord3()
    {
        wc.countWord("this-is-a-test is is");
        expected.put("this-is-a-test",1);
        expected.put("is",2);
        assertEquals(expected, wc.countList);
    }

    //test4：带连字符且位于单词间，无常见字符和数字
    @Test
    public void testCountWord4()
    {
        wc.countWord("this is a test this-is-a-test");
        expected.put("this",1);
        expected.put("is",1);
        expected.put("a",1);
        expected.put("test",1);
        expected.put("this-is-a-test",1);
        assertEquals(expected, wc.countList);
    }

    //test5：带连字符且位于单词后，无常见字符和数字
    @Test
    public void testCountWord5()
    {
        wc.countWord("this-  is a-test");
        expected.put("this",1);
        expected.put("is",1);
        expected.put("a-test",1);
        assertEquals(expected, wc.countList);
    }

    //test6：带连字符且位于数字间，无常见字符
    @Test
    public void testCountWord6()
    {
        wc.countWord("this  is1-2 a-test");
        expected.put("this",1);
        expected.put("is",1);
        expected.put("a-test",1);
        assertEquals(expected, wc.countList);
    }

    //test7：带连字符,带常见字符和数字
    @Test
    public void testCountWord7()
    {
        wc.countWord("(see Box 3–2).8885d_c01_016");
        expected.put("see",1);
        expected.put("box",1);
        expected.put("d",1);
        expected.put("c",1);
        assertEquals(expected, wc.countList);
    }

    //test8：输入为空
    @Test
    public void testCountWord8()
    {
        wc.countWord("");
        assertEquals(expected, wc.countList);
    }


}