package com.lingjiancong.graphic;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.util.XMLResourceDescriptor;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.DOMImplementation;
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

//        String uri = "image/sz_front.svg";
        String uri = "image/front_1.svg";
        ClassPathResource resource = new ClassPathResource(uri);

        String parser = XMLResourceDescriptor.getXMLParserClassName();
        SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
        Document document = f.createDocument(uri, resource.getInputStream());

        DOMImplementation domImpl =
                GenericDOMImplementation.getDOMImplementation();

        // Create an instance of org.w3c.dom.Document.
        String svgNS = "http://www.w3.org/2000/svg";
//        Document document = domImpl.createDocument(svgNS, "svg", null);

        SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(document);
        ctx.setEmbeddedFontsOn(true);

        SVGGraphics2D graphics2D = new SVGGraphics2D(ctx, true);
        Font SourceHanSansSCNormal = getFont("fonts/SourceHanSansSC-Normal.ttf");
        graphics2D.setFont(SourceHanSansSCNormal.deriveFont(80f));
        graphics2D.drawString("hello world", 70f, 70f);

//        Font SourceHanSansSCBold = getFont("fonts/SourceHanSansSC-Bold.ttf");
//        graphics2D.setFont(SourceHanSansSCBold.deriveFont(80f));
//        graphics2D.drawString("hello world", 70f, 140f);

        // The following populates the document root with the
        // generated SVG content.
        Element root = document.getDocumentElement();
        graphics2D.getRoot(root);

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
