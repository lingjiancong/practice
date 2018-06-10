package com.lingjiancong.regex;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo 2016/8/21.
 */
public class Regex {

    @Test
    public void readClassNameFromJavaFile() {

        String fileName = "test";

        String s = fileToString(fileName);

        String packageName = getPackageName(s);

        System.out.println(packageName);

        List<String> classNames = getClassName(s);

        for (int i = 0; i < classNames.size(); ++i) {
            System.out.println(packageName + "." + classNames.get(i));
        }


    }

    /*
     * why not create yourself tools class?
     * @param name file name
     */
    public String fileToString(String name) {

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bd = new BufferedReader(new FileReader(new File(name)));
            String line = null;
            try {
                while ((line = bd.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
            } finally {
                // close file
                bd.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return sb.toString();

    }
    /*
     * @param s primitive, a java file to primitive
     */
    public String getPackageName(String s) {

        String regex = "\\s*package\\s+((\\w+[.])*\\w+);";

        Matcher m = Pattern.compile(regex).matcher(s);

        if (m.find()) {
            return m.group(1);
        } else {
            return "";
        }
    }

    public ArrayList<String> getClassName(String s) {
        String classRegex = "(?s)\\s*public\\s+class\\s+(\\w+)\\s+.*\\}";

        Matcher m = Pattern.compile(classRegex).matcher(s);

        ArrayList<String> as = new ArrayList<>();

        if (m.find()) {
            String prefix = m.group(1);
            as.add(prefix);
        }
        return as;

    }

    public ArrayList<String> fileToArray(String name) {
        String s = fileToString(name);
        return new ArrayList<>(Arrays.asList(s.split("\n")));
    }


    @Test
    public void booksAnswer() {

        String fileName = "test";
        // we want all class names:
        Pattern p = Pattern.compile("class \\w+\\s+");
        // not including those in comment lines:
        Pattern q = Pattern.compile("^(//|/\\*|\\*)");
        System.out.println("classes in " + fileName + ":");
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher(""); // creates emtpy Matcher object
        Matcher n = q.matcher("");
        for(String line : fileToArray(fileName)) {
            m.reset(line);
            n.reset(line);
            while(m.find() && !n.find())
                System.out.println(index++ + ": " + m.group());
        }
    }

    @Test
    public void testObject() {
        Objects.requireNonNull(new String());
    }

}
