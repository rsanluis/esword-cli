package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PropheticClock_60_and_12_over_25_Expiry {
    @Test
    public void testPattern_60_and_12_over_25_Expiry() {
        // Multiple (41 and 2/3) by (60 and 12/25)
        // Had to use Math.round because issues with comparing doubles
        long value = Math.round((41d + 2d/3d) * (60d + 12d/25d));
        log.info("val: {}", value);
        assertTrue(value == 2520);
    }
}
