import org.junit.Test;
import org.springframework.cache.annotation.Cacheable;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author lingjiancong
 */
public class PrintVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        Objects.requireNonNull(file);
        Objects.requireNonNull(attrs);

        String fn = file.getFileName().toString();
        if (fn.endsWith("cpp") || fn.endsWith("c++")) {

            String format = "set(BUILD_%s main%s)%n" +
                    "set(SOURCE_FILES_%s %s_%s)%n" +
                    "add_executable(${BUILD_%s} ${SOURCE_FILES_%s})%n";

            String num = fn.substring(0, 3);
            String name = fn.substring(4);
            String formatString = String.format(format, num, num, num, num, name, num, num);
            System.out.println(formatString);
            System.out.println();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
            throws IOException {
        Objects.requireNonNull(dir);
        Objects.requireNonNull(attrs);
        return FileVisitResult.CONTINUE;
    }

    @Test
    public void test() {
        Map<String, Integer> maps = new HashMap<>();
        int i = 1;
        maps.put("1", i = 0);
        System.out.println(maps.get("1"));


        Double d = 111111111212.1211111211111;
        System.out.println(d);

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        System.out.println(decimalFormat.format(d));

        BigDecimal bigDecimal = new BigDecimal(d);
        String result = bigDecimal.toString();
        System.out.println(result);


        int year =  Calendar.getInstance().get(Calendar.YEAR);
        System.out.println(year);

    }

    @Test
    public void testSubList() {
        List<Integer> list = new ArrayList<>();
        list = list.subList(0, 0);
        System.out.println(list.size());
    }
}
