package com.lingjiancong.graphic;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.util.XMLResourceDescriptor;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.io.*;

/**
 * @author lingjiancong
 * @since 2018-08-16
 */
public class VectorGraphics {

    @Test
    public void test() throws IOException, FontFormatException {

        String uri = "image/logo.svg";
        ClassPathResource resource = new ClassPathResource(uri);


        String parser = XMLResourceDescriptor.getXMLParserClassName();
        SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
        Document document = f.createDocument(uri, resource.getInputStream());



        SVGGraphics2D graphics2D = new SVGGraphics2D(document);
        Font SourceHanSansSCNormal = getFont("fonts/SourceHanSansSC-Normal.ttf");
        graphics2D.setFont(SourceHanSansSCNormal.deriveFont(50));
        graphics2D.drawString("hello world", 9f, 9f);

        // The following populates the document root with the
        // generated SVG content.
        Element root = document.getDocumentElement();
        graphics2D.getRoot(root);

        graphics2D.stream("image.svg", true);

        String s = getStringFromDocument(document);


        Writer out = new OutputStreamWriter(new FileOutputStream("img.svg"), "UTF-8");
        out.write(s);
        System.out.println(s);
        out.close();

        // we want to use CSS style attributes
//        boolean useCSS = true;
//        Writer out = new OutputStreamWriter(System.out, "UTF-8");
//        graphics2D.stream(out, useCSS);







    }


    public String getStringFromDocument(Document doc)
    {
        try
        {
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            return writer.toString();
        }
        catch(TransformerException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    private Font getFont(String file) throws IOException, FontFormatException {
        ClassPathResource resource = new ClassPathResource(file);
        return Font.createFont(Font.TRUETYPE_FONT, resource.getInputStream());
    }
}
