package com.lxl.lucenedemo;

import org.apache.lucene.util.AttributeImpl;
import org.apache.lucene.util.AttributeReflector;

import java.util.Random;

/**
 * @author lxl lukas
 * @description
 * @create 2018/4/28
 */
public class MyAttribute1Impl extends AttributeImpl implements MyAttribute1 {
    int value = 0;
    Random random = new Random();

    @Override
    public String getAttr() {
        return String.valueOf(value);
    }

    @Override
    public void clear() {
        value = random.nextInt(1000);
    }

    @Override
    public void reflectWith(AttributeReflector reflector) {

    }

    @Override
    public void copyTo(AttributeImpl target) {

    }
}
