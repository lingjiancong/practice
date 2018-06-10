import com.alibaba.fastjson.JSONObject;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.imageio.ImageIO;

/**
 * @author lingjiancong
 */
public class Test1 {

    @Test
    public void test() {
        InputStreamReader reader;

        Map<String, String> map;

        Collections collections;

        ObjectOutputStream objectOutputStream;

        JSONObject jsonObject;
    }


    @Test
    public void testImageDownload() throws IOException, InterruptedException {
        String path = "/Users/ling/vagrant/synced/spider/view";
        ExecutorService service = Executors.newCachedThreadPool();

        final AtomicInteger count = new AtomicInteger(0);

        List<String> list = readOneLine(path);

        List<Callable<Object>> tasks = new ArrayList<>();
        for (final String target : list) {
           tasks.add(new Callable<Object>() {
               @Override
               public Object call() throws Exception {
                   configureDownload(target);
                   System.out.println(count.addAndGet(1));
                   return true;
               }
           });
        }

        service.invokeAll(tasks);

    }

    public void configureDownload(String target) {
        URL url = null;
        InputStream inputStream = null;
        try {
            url = new URL(target);

            URLConnection uc = url.openConnection();
            uc.setRequestProperty("Accept", "*/*");

            inputStream = url.openStream();
            directDownload(inputStream, target);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }


    public void directDownload(InputStream inputStream, String target) throws IOException {

        String fileName = target.substring(target.lastIndexOf('/') + 1);
        String path = "/Users/ling/vagrant/synced/spider/0630/" + fileName;

        Files.copy(inputStream, Paths.get(path));

    }

    public List readOneLine(String path) {

        List<String> list = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = null;
            while ( (line = reader.readLine()) != null) {
                list.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }


    @Test
    public void testServiceShutdown() {
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; ++i) {
            final int finalI = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                    try {
                        TimeUnit.MINUTES.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 10; i < 20; ++i) {
            final int finalI = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                    try {
                        TimeUnit.MINUTES.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
