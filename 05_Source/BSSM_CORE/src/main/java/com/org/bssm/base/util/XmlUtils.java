package com.org.bssm.base.util;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlUtils extends BaseUtils{
    /**
     * XML转成object
     * 
     * @param xml
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T xml2obj(String xml, Class<T> classOfT) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(classOfT);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (T)jaxbUnmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException ex) {
            log.error(ex);
            return null;
        }
    }

    public static String obj2xml(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller =  context.createMarshaller();
            StringWriter writer = new StringWriter();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (JAXBException ex) {
            log.error(ex);
            return null;
        }
    }
}
