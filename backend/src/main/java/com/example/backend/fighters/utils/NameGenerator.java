package com.example.backend.fighters.utils;

import com.example.backend.fighters.exception.NameGenerationException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/*
Utility class that generates random names from 2 text files.
First name is found randomly from first_names.txt
Last name is added after from last_names.txt
 */
public class NameGenerator {

    private static final String txtFirstNames = "backend/src/main/resources/text/first_names.txt";
    private static final String txtLastNames = "backend/src/main/resources/text/last_names.txt";
    private static final Random random = new Random();

    public static String createRandomName() {
        StringBuilder generatedName = new StringBuilder();
        generatedName.append(randomName(txtFirstNames));
        generatedName.append(" ");
        generatedName.append(randomName(txtLastNames));

        return generatedName.toString();
    }

    private static String randomName(String fileName){
        try{
            List<String> allNames = Files.readAllLines(Paths.get(fileName));
            int randomLine = random.nextInt(allNames.size());

            return allNames.get(randomLine);
        }catch (IOException ex){
            throw new NameGenerationException("Cannot read from file: " + fileName);
        }
    }
}
