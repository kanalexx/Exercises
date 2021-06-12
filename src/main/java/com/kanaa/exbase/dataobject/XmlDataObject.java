package com.kanaa.exbase.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Map;

public class XmlDataObject implements DataObject{

    private DataObject dataObject;

    public XmlDataObject(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public Element getXmlData() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DataObjectParser objectParser = new DataObjectParser(dataObject);
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            String elementName = objectParser.dataObjectName;
            Element result = doc.createElement(elementName);
            for (Map.Entry<String, String> field : objectParser.fields.entrySet()) {
                result.setAttribute(field.getKey(), field.getValue());
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
