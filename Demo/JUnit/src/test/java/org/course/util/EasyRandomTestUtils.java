package org.course.util;

import lombok.experimental.UtilityClass;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.range.IntegerRangeRandomizer;
import org.jeasy.random.randomizers.range.LongRangeRandomizer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@UtilityClass
public class EasyRandomTestUtils {
    public static final Long DEFAULT_SEED = 123L;
    private static final Random RANDOM = new Random();
    private static final int MIN_STRING_LENGTH = 5;
    private static final int MAX_STRING_LENGTH = 20;
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    public EasyRandom create() {
        return create(DEFAULT_SEED);
    }

    public EasyRandom create(Long seed) {
        return new EasyRandom(defaultParameters(seed));
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        return randomEnum(RANDOM, clazz);
    }

    static <T extends Enum<?>> T randomEnum(Random random, Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public EasyRandomParameters defaultParameters(Long seed) {
        return new EasyRandomParameters()
                .seed(seed)
                .objectPoolSize(100)
                .randomizationDepth(4)
                .charset(CHARSET)
                .stringLengthRange(MIN_STRING_LENGTH, MAX_STRING_LENGTH)
                .collectionSizeRange(1, 4)
                .randomize(Integer.class, new IntegerRangeRandomizer(0, Integer.MAX_VALUE))
                .randomize(Long.class, new LongRangeRandomizer(0L, Long.MAX_VALUE))
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(true)
                .ignoreRandomizationErrors(true);
    }
}
