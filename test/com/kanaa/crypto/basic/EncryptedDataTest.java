package com.kanaa.crypto.basic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * @author Alexander Kanunnikov
 */
public class EncryptedDataTest {

    private static final String PLAIN_TEXT = "абра кадабра";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        EncryptingMethod method = mock(EncryptingMethod.class);
        EncryptedData encryptedData = new EncryptedData(PLAIN_TEXT, method);
        Assert.assertNull(encryptedData.value());
    }
}