package com.lingjiancong.algorithm;

/**
 * @author lingjiancong
 * @since 2018-07-11
 */
public class SkipListEntry
{
    public String key;
    public Integer value;

    // I added this to print the skiplist "nicely"
    public int pos;

    public SkipListEntry up, down, left, right;

    // -inf key value
    public static String negInf = new String("-oo");
    // +inf key value
    public static String posInf = new String("+oo");

    public SkipListEntry(String k, Integer v)
    {
        key = k;
        value = v;

        up = down = left = right = null;
    }

    public Integer getValue()
    {
        return value;
    }

    public String getKey()
    { return key;
    }

    public Integer setValue(Integer val)
    {
        Integer oldValue = value;
        value = val;
        return oldValue;
    }

    @Override
    public boolean equals(Object o)
    {
        SkipListEntry ent;

        try
        {   // Test if o is a SkipListEntry...
            ent = (SkipListEntry) o;
        }
        catch (ClassCastException ex)
        {
            return false;
        }

        return (ent.getKey() == key) && (ent.getValue() == value);
    }

    @Override
    public String toString()
    {
        return "(" + key + "," + value + ")";
    }
}
