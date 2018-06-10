package com.lingjiancong.serialize.simple;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import static com.lingjiancong.print.Print.*;

/**
 * @author lingjiancong
 */
public class Worm implements Serializable {

    private static int ID = 10;

    private char c;
    private int id;

    private Worm next;

    Worm() {
        print("The default constructor!");
    }

    Worm(char c, int count) {
        this.c = c;
        id = ID++;

        if (--count > 0) {
            next = new Worm((char)(c + 1), count);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("-");
        sb.append(c);
        sb.append("--");
        sb.append(id);
        sb.append("\n");
        sb.append(next);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm worm = new Worm('a', 5);
        print(worm);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject("Worm Storage\n");
        out.writeObject(worm);
        out.flush();

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        String s = (String) in.readObject();
        Worm w = (Worm) in.readObject();
        print(s + w);
    }

}
