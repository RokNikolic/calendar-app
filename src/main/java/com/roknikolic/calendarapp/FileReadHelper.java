package com.roknikolic.calendarapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReadHelper {
    public List<String> readAllLines(String filePath) {
            Path path = Paths.get(filePath);
            try {
                return Files.readAllLines(path);
            } catch (IOException e) {
                System.out.println(e);
                return new ArrayList<>();
            }
    }
}
