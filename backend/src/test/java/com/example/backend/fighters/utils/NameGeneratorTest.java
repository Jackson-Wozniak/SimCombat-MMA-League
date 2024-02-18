package com.example.backend.fighters.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameGeneratorTest {

    @Test
    void randomNameCreation(){
        String[] randomName = NameGenerator.createRandomName().split(" ");
        assertEquals(randomName[0].substring(0, 1), randomName[0].substring(0, 1).toUpperCase());
        assertEquals(randomName[1].substring(0, 1), randomName[1].substring(0, 1).toUpperCase());
    }
}