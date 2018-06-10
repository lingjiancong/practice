package com.lingjiancong.serialize.complete;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lingjiancong
 */
public class CompleteTest {

    @Test
    public void testSerializable() throws Exception {
        File file = new File("p.dat");
        Person p = new Person("xiaoming", 10);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(p);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object newPerson  = ois.readObject();
        ois.close();
        System.out.println(newPerson);
    }

    @Test
    public void testModify() {
        Person p1 = new Person("p1", 10);
        Person p2 = new Person("p2", 11);

        List<Person> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);

        for (Person p : list) {
            p.setAge(12);
        }

        System.out.println(Arrays.toString(list.toArray()));
    }

}
