package org.course.example;


import org.course.TestBase;
import org.course.entity.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EasyRandomExampleTest extends TestBase {
    @Test
    public void easyRandomExample() {
        var car = easyRandom.nextObject(Car.class);
        assertNotNull(car);

        var someDouble = easyRandom.nextDouble(3, 4);
        assertTrue(someDouble > 3);
        assertTrue(someDouble < 4);
    }

}
