package com.company.exbase;

import com.company.exbase.string.ExString;
import com.company.exbase.sysout.PrintableExString;

/**
 * @author Alexander Kanunnikov
 */
public class ExBaseTest {

    public static void main(String[] args) {
        ExString str = ExString.create("NewStr");
        print(str);

        PrintableExString prStr = new PrintableExString(str);
        prStr.print();
    }

    private static void print(ExBase<?> base) {
        System.out.println(base.value());
    }
}