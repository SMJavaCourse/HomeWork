package org.course.hotels;

import org.course.hotels.given.Given;
import org.jeasy.random.EasyRandom;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class TestBase {

    protected static Given given = new Given();
    protected static EasyRandom easyRandom = given.getEasyRandom();

}