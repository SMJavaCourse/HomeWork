package org.course;

import org.course.given.Given;
import org.course.util.EasyRandomTestUtils;
import org.jeasy.random.EasyRandom;

public abstract class TestBase {

    protected static Given given = new Given();
    protected static EasyRandom easyRandom = EasyRandomTestUtils.create();
}
