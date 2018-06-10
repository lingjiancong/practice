package com.lingjiancong.primitive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lingjiancong
 */
public class MineString {

    static final String II = "123";

    private String inner;

    public MineString(String inner) {
        this.inner = inner;
    }

    public void anonymous() {
        List<String> list = new ArrayList<>();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return II.compareTo(o1);
            }
        });

    }

    public void addCollection(Collection collection, Object object) {
        collection.add(object);
    }

    public void add(Collection<Object> collection, Object object) {
        collection.add(object);
    }

    public void addUnlimited(Collection<? super Object> collection, Object object) {
        collection.add(object);
    }

    public String trim() {
        String s = inner;

        int pre = 0, size = s.length(), post = size - 1;
        for (int i = 0; i < size; ++i) {
            if (s.charAt(i) == ' ') {
                pre++;
            } else {
                break;
            }
        }
        for (int i = size - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                post--;
            } else {
                break;
            }
        }
        int trimLength = post - pre + 1;
        if (trimLength > 0) {
            return s.substring(pre, post + 1);
        } else {
            return "";
        }
    }


    public String getInner() {
        return inner;
    }

    public void setInner(String inner) {
        this.inner = inner;
    }
}
