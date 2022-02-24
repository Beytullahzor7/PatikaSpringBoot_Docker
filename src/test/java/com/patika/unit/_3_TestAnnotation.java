package com.patika.unit;

import org.junit.jupiter.api.*;

public class _3_TestAnnotation {

    @BeforeAll
    static void herSeydenOnce(){
        System.out.println("Her seyden once");
    }

    @BeforeEach
    void testtenHemenOnce(){
        System.out.println("Testten hemen once");
    }


    @Test
    void birinciTest(){
        _1_MainMerhabalar mainMerhabalar = new _1_MainMerhabalar();
        Assertions.assertEquals("Merhabalar44",mainMerhabalar.success(),"iki kelime aynı değildir");
    }

//    @Test
//    void hataOlsun(){
//        Assertions.fail("Fail olustur !!!");
//    }

    @AfterEach
    void testtenHemenSonra(){
        System.out.println("Testten hemen sonra");
    }

    @AfterAll
    static void herSeydenSonra(){
        System.out.println("Her seyden sonra");
    }
}
