package com.kanaa.exbase;

import com.kanaa.exbase.dataobject.XmlDataObject;
import com.kanaa.exbase.string.ExString;
import com.kanaa.exbase.sysout.PrintableExString;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;

/**
 * @author Alexander Kanunnikov
 */
public class ExBaseTest {

    public static void main(String[] args) {
        ExString str = ExString.create("NewStr");
        print(str);

        PrintableExString prStr = new PrintableExString(str);
        prStr.print();

        UserObject user = new UserObject();
        user.name = "Александр";

        XmlDataObject xmlUser = new XmlDataObject(user);
        Element userElement = xmlUser.getXmlData();

        System.out.println(((DOMImplementationLS)userElement.getOwnerDocument().getImplementation()).createLSSerializer().writeToString(userElement));
    }

    private static void print(ExBase<?> base) {
        System.out.println(base.value());
    }
}