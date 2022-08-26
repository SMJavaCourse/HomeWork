package org.course.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMethodOrderExampleTest {

    @Test
    @Order(2)
    public void test1() {
        System.out.println("Execute test1");
    }

    @Test
    @Order(1)
    public void test2() {
        System.out.println("Execute test2");
    }
}
