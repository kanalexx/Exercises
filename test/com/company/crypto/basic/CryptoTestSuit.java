package com.company.crypto.basic;

import com.company.crypto.basic.alphabet.AlphabetTestSuit;
import com.company.crypto.basic.ariphmetic.ArithmeticTestSuit;
import com.company.crypto.basic.substitution.SubstitutionTestSuit;
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