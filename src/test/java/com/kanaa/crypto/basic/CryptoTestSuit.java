package com.kanaa.crypto.basic;

import com.kanaa.crypto.basic.alphabet.AlphabetTestSuit;
import com.kanaa.crypto.basic.ariphmetic.ArithmeticTestSuit;
import com.kanaa.crypto.basic.substitution.SubstitutionTestSuit;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Alexander Kanunnikov
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AlphabetTestSuit.class,
        ArithmeticTestSuit.class,
        SubstitutionTestSuit.class
})
public class CryptoTestSuit {

}