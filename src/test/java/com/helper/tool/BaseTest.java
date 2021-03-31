package com.helper.tool;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseTest {
    @BeforeAll
    public static void testBefore() {
        System.out.println("-----------junit begin---------------");
    }

    @AfterAll
    public static void testAfter() {
        System.out.println("-----------junit end---------------");
    }
}
