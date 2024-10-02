package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;

public class LocalProcessor {
    private String processorName;
    private Long period;
    private String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private LinkedList<String> stringArrayList;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
        this.period = 10000000000000L; // Default value
        this.stringArrayList = new LinkedList<>(); // Initialize list
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList.clear(); // Clear existing list before populating
        stringArrayList.addAll(stringList); // Use addAll for clarity
        for (int i = 0; i < Math.min(period, stringArrayList.size()); i++) { // Ensure no index out of bounds
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator() {
        StringBuilder fullName = new StringBuilder();
        for (String name : stringArrayList) { // Enhanced for-loop for readability
            fullName.append(name).append(' ');
        }
        processorName = fullName.toString().trim(); // Trim trailing whitespace
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        try (Scanner scanner = new Scanner(file)) { // Use try-with-resources for automatic resource management
            StringBuilder versionBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                versionBuilder.append(scanner.nextLine()).append(System.lineSeparator()); // Append new line for clarity
            }
            processorVersion = versionBuilder.toString().trim(); // Trim trailing whitespace
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage()); // Basic error handling
        }
    }
}