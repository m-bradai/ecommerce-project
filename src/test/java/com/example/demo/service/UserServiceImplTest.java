package com.example.demo.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;


class UserServiceImplTest {

    @BeforeAll
    public static void  setupAll(){
        System.out.println("Cette méthode est appelée avant tout !");
    }

    @BeforeEach
    public void  setupEach() {
        System.out.println("Cette méthode est appelée avant chaque méthode de @Test !");
    }

    @Test
    public void shouldAddWork(){
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
        System.out.println(" shouldAddWork() is called !");
        Assertions.assertThrows(RuntimeException.class, ()-> System.out.println(1/0) );
    }

    @Test
    @DisabledOnOs(value = OS.LINUX, disabledReason = "Disactivated Test on Windows")
    public void shouldAddWork2(){
        System.out.println(" shouldAddWork2() is called !");
        Assertions.assertThrows(RuntimeException.class, ()-> System.out.println(1/0) );
    }

    @AfterEach
    public void setupAfterEach() {
        System.out.println("AfterEach is Executed !");
    }

    @AfterAll
    public static void setupAfterAll() {
        System.out.println("AfterAll is Executed !");
    }

}