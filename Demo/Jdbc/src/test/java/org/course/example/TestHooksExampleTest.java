package org.course.example;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestHooksExampleTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("->Execute command BEFORE ALL tests\n");
    }

    @BeforeEach
    void setUp() {
        System.out.println("-->Execute command BEFORE EACH test");
    }

    @Test
    public void test1() {
        System.out.println("--->Execute test 1");
    }

    @Test
    public void test2() {
        System.out.println("--->Execute test 2");
    }

    @AfterEach
    void tearDown() {
        System.out.println("-->Execute command AFTER EACH test\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("->Execute command AFTER ALL tests");
    }
}
