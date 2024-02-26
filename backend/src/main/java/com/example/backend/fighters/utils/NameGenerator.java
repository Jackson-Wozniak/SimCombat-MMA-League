package com.example.backend.fighters.utils;

import com.example.backend.fighters.exception.NameGenerationException;
import com.sun.tools.javac.Main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/*
Utility class that generates random names from 2 text files.
First name is found randomly from resources/first_names.txt
Last name is added after from resources/last_names.txt
 */
public class NameGenerator {

    private static final String txtFirstNames = "text/first_names.txt";
    private static final String txtLastNames = "text/last_names.txt";
    private static final Random random = new Random();

    public static String createRandomName() {
        StringBuilder generatedName = new StringBuilder();
        String firstname = randomName(getAllNames(txtFirstNames));
        String lastname = randomName(getAllNames(txtLastNames));
        generatedName.append(firstname);
        generatedName.append(" ");
        generatedName.append(lastname);

        return generatedName.toString();
    }

    private static List<String> getAllNames(String filename){
        try{
            return Files.readAllLines(Paths.get(Main.class.getClassLoader().getResource(filename).toURI()));
        }catch (Exception ex){
            throw new NameGenerationException("Cannot read from file: " + filename);
        }
    }

    private static String randomName(List<String> names){
        int randomLine = random.nextInt(names.size());

        return formatName(names.get(randomLine));
    }

    //ensures only first letter is upper case
    private static String formatName(String rawName){
        rawName = rawName.toLowerCase().trim();
        rawName = rawName.substring(0, 1).toUpperCase() + rawName.substring(1).toLowerCase();

        return rawName;
    }
}
