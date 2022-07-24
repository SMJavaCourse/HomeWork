package org.course.generics;

import org.course.generics.items.Water;

public class Cistern<T extends Water> extends Box<T> {

    public Cistern(Size size) {
        super(size);
    }

}
