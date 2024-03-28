package internal.mma_league.fighters.utils;

import internal.mma_league.fighters.exception.NameGenerationException;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
            ClassPathResource resource = new ClassPathResource(filename);
            InputStreamReader streamReader = new InputStreamReader(resource.getInputStream());

            return new BufferedReader(streamReader).lines().collect(Collectors.toList());
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
