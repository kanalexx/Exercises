package com.kanaa.crypto.basic.cryptanalysis;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class SymbolReplacerTest {

    @Test
    public void CommandParseTest() {
        SymbolReplacer.Command command = SymbolReplacer.Command.parse("replace Д->Ю");
        assertTrue(command instanceof SymbolReplacer.Replace);
    }

}