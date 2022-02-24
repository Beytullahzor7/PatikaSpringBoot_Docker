package com.patika.unit;

import org.junit.jupiter.api.*;

public class _3_TestTrueFalse {

    @Test
    void trueAndFalseTutorialsTest(){
        _3_MainTrueFalse mainMerhabalar = new _3_MainTrueFalse();
        Assertions.assertTrue(mainMerhabalar.isTrue());
    }
}
