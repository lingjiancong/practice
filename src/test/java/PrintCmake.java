import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lingjiancong
 */
public class PrintCmake {


//    set(BUILD_010 main010)
//    set(SOURCE_FILES_010 010_RegularExpressionMatching.cpp)
//    add_executable(${BUILD_010} ${SOURCE_FILES_010})

    @Test
    public void printCMakeLists() throws IOException {

        Path path = Paths.get("leetcode");

        Files.walkFileTree(path, new PrintVisitor());

    }

    @Test
    public void testContain() {
        String a = "17安行1B1";

        if (a.contains("B") || a.contains("A") || a.contains("C")) {
            int d = a.indexOf('B');
        }

        ImmutableMap.of();
    }
}
