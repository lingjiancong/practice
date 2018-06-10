package com.lingjiancong.io.bio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Thus if you explicitly write an object to a stream twice,
 * you're really writing only the reference twice
 *
 * @author lingjiancong
 */
public class ObjectStream {

    static class People implements Serializable {
        private String name;

        People(String name) {
            this.name = name;
        }

        void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return "name = " + name;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        People people = new People("me");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(baos);
        System.out.println("before: " + people);
        out.writeObject(people);

        people.setName("you");
        System.out.println("modify: " + people);
        out.writeObject(people);

        ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        People p1 = (People) in.readObject();

        // also me, did not write change
        People p2 = (People) in.readObject();

        System.out.println(p1);
        System.out.println(p2);
        in.close();

    }

}
