package com.company.crypto.basic.substitution;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Alexander Kanunnikov
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AffineCipherTest.class,
        AtbashTest.class,
        CaesarCipherTest.class
})
public class SubstitutionTestSuit {

}