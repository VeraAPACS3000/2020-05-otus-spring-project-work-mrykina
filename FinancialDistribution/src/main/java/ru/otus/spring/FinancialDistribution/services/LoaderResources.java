package ru.otus.spring.FinancialDistribution.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@PropertySource("classpath:application.yml")
@Component
public class LoaderResources {

    private final String nameFile;

    public LoaderResources(@Value("${application.fileCurrencies}") String inNameFile) {
        this.nameFile = inNameFile;
    }

    private File loadFileFromResources() {
        return new File(getClass().getClassLoader().getResource(nameFile).getFile());
    }

    private List<String> readFromFile(File file) {
        List<String> listResultStrings = new ArrayList<>();
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    listResultStrings.add(scanner.nextLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listResultStrings;
    }

    public List<String> getListStringsFromFile() {
        List<String> listResult = readFromFile(loadFileFromResources());
        return listResult;
    }
}
