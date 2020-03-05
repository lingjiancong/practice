package com.lingjiancong.serialize.complete;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import io.netty.buffer.Unpooled;

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

        byte bytes[] = new byte[10];
        Unpooled.copiedBuffer(bytes);

        System.out.println(Arrays.toString(list.toArray()));
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class User {

        @JsonSerialize(using = JdySerializer.class)
        @JsonProperty("hello")
        public String name;
    }

    public static class JdySerializer extends JsonSerializer<Object> {

        @Override
        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            Map<String, Object> maps = new HashMap<>();
            maps.put("value", o);
            jsonGenerator.writeObject(maps);
        }
    }


    @Test
    public void testParentNode() throws JsonProcessingException {

        User user = new User();
        user.name = "ljc";

        ObjectMapper mapper = new ObjectMapper();
//        SimpleModule testModule = new SimpleModule("MyModule", new Version(1, 0, 0, null));
//        testModule.addSerializer(new JdySerializer());
//        // assuming serializer declares correct class to bind to
//        mapper.registerModule(testModule);

//        StdSerializerProvider sp = new StdSerializerProvider();
//        sp.setNullValueSerializer(new NullSerializer());

        DefaultSerializerProvider.Impl impl = new DefaultSerializerProvider.Impl();
        impl.setDefaultKeySerializer(new JdySerializer());
        mapper.setSerializerProvider(impl);


        System.out.println(mapper.writeValueAsString(user));
    }



}
