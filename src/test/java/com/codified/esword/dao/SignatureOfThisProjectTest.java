package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.codified.esword.util.BibleUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SignatureOfThisProjectTest {

    @Autowired
    SearchDAO searchDAO;

    /*
     * Isa 43:1  But now thus saith the LORD that created thee, O Jacob, and he that
     * formed thee, O Israel, Fear not: for I have redeemed thee,
     * I have called thee by thy name; thou art mine. 
     * 
     * Just like how I called out God's name (I AM times 3) and his number 
     * (23 times 3 = 69), he did the same with my name and number.
     */
    @Test
    void testDerivedMatch_1290_Test() {
        String name = "Roland Resurreccion San Luis";
        // https://www.gematrix.org/?word=Roland+Resurreccion+San+Luis
        int hebrewGematriaValue = BibleUtils.getHebrewGematriaValue(name);
        log.info("hebrew gematria value for {}: {}", name, hebrewGematriaValue);
        assertTrue(hebrewGematriaValue == 1290);
    }
}
