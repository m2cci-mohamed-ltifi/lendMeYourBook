package com.education.lendmeyourbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.logging.Logger;

@SpringBootApplication
public class LendMeYourBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(LendMeYourBookApplication.class, args);

        Logger logger = Logger.getLogger("Ayoub's");
        try {
            File file = new File("C:/Users/Ltifi/Documents/gouv.txt");
            FileWriter writer = new FileWriter(file.getPath()+"GouvsTempF.txt");
            Scanner scanner = new Scanner(file);
            Set<String> set = new TreeSet<>();

            logger.info(scanner.next());
            while (scanner.hasNextLine()){
                String[] line= scanner.nextLine().split("Gouvernorat");
                String[] restOfLine=line[1].split("[0-9]");
                set.add(restOfLine[0].substring(3).trim());
            }

            for(String s: set){
                writer.write("{\"name\":\""+s+"\"},\n");
            }
            writer.close();
            scanner.close();
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }


    }

}
