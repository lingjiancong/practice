import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

/**
 * @author lingjiancong
 */
public class TestConcurrency {

    @Test
    public void testList() {
        List<Integer> list = new CopyOnWriteArrayList<>();

        Object[] objects = Arrays.asList("1", "2").toArray();
        System.out.println(objects.getClass());

        String[] strings;

        List<Integer> list1 = new ArrayList<>();

        Map<String, String> map = new ConcurrentHashMap<>();

    }

    @Test
    public void test() {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,16}");
        System.out.println(pattern.matcher("12qw34er5").matches());
    }

}
