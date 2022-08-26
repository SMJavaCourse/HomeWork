package org.course.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestInstanceExampleTest {
    private String name = null;

    @Test
    public void test1() {
        name = "test1";
        assertEquals("test1", name);
    }

    @Test
    public void test2() {
        assertNull(name);
    }

}
