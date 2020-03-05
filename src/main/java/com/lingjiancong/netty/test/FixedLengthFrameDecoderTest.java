package com.lingjiancong.netty.test;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import static org.junit.Assert.*;

/**
 * @author lingjiancong
 * @since 2018-11-26
 */
public class FixedLengthFrameDecoderTest {

    @Test
    public void testFramesDecoder() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; ++i) {
            buf.writeByte(i);
        }
        // duplicate need retain
        ByteBuf input = buf.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));
        assertTrue(channel.writeInbound(input.retain()));

        assertTrue(channel.finish());

        // read messages
        ByteBuf read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

    }
}
