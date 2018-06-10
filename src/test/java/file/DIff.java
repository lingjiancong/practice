package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author lingjiancong
 */
public class DIff {

    @Test
    public void diff() throws IOException {

        Path filePath = new File("/Users/ling/company/ling/D/xfintech/JavaBase/total").toPath();
        Charset charset = Charset.defaultCharset();
        List<String> totalList = Files.readAllLines(filePath, charset);

       filePath = new File("/Users/ling/company/ling/D/xfintech/JavaBase/part").toPath();
       List<String> partList = Files.readAllLines(filePath, charset);

       for (String part : partList) {
           if (!totalList.contains(part)) {
               if (!part.isEmpty()) {
                   System.out.println(part);
               }
           }
       }

    }
}
