package com.example.backend.fighters.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameGeneratorTest {

    @Test
    void noEmptyNames(){
        for(int i = 0; i < 1000; i++){
            assertNotEquals("", NameGenerator.createRandomName());
        }
    }

    @Test
    void firstLetterCapitalized(){
        String[] randomName = NameGenerator.createRandomName().split(" ");
        assertEquals(randomName[0].substring(0, 1), randomName[0].substring(0, 1).toUpperCase());
        assertEquals(randomName[1].substring(0, 1), randomName[1].substring(0, 1).toUpperCase());
    }

    @Test
    void onlyFirstLetterCapitalized(){
        String[] randomName = NameGenerator.createRandomName().split(" ");
        assertEquals(randomName[0].substring(0, 1), randomName[0].substring(0, 1).toUpperCase());
        assertEquals(randomName[1].substring(0, 1), randomName[1].substring(0, 1).toUpperCase());

        assertEquals(randomName[0].substring(1), randomName[0].substring(1).toLowerCase());
        assertEquals(randomName[1].substring(1), randomName[1].substring(1).toLowerCase());
    }

    @Test
    void fileRead(){
        assertDoesNotThrow(NameGenerator::createRandomName);
    }
}