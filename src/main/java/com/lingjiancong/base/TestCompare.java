package com.lingjiancong.base;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * @author lingjiancong
 * @since 2018-11-28
 */
public class TestCompare {

    public static void main(String[] args) {
        Long value = new Long(0);
        boolean res = (value == 0);
        System.out.println(res);
    }

    @Test
    public void testJson() throws JsonProcessingException {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(4, 2);

        Gson gson = new Gson();
        System.out.println(gson.toJson(map));

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(map));

    }
}
