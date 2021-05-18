package com.kanaa.crypto.basic.alphabet;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Alexander Kanunnikov
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AlphabetImplTest.class,
        AlphabetCp1251Test.class,
        AlphabetUnicodeTest.class
})
public class AlphabetTestSuit {

}