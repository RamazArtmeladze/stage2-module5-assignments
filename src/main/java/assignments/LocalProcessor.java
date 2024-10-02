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
    private Long period = 10000000000000L;
    private String processorVersion; // Changed from `ProcessorVersion` to `processorVersion`
    private Integer valueOfCheap;
    private Scanner informationScanner; // Changed from `informationscanner` to `informationScanner`
    private static LinkedList<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion; // Changed to match field name
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner; // Changed to match field name
        LocalProcessor.stringArrayList = stringArrayList; // Static field access
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        processorName = ""; // Initialize to avoid appending on each call
        for (String name : stringList) {
            processorName += name + ' ';
        }
        return processorName.trim(); // Trim trailing space
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        StringBuilder versionBuilder = new StringBuilder();
        while (informationScanner.hasNextLine()) {
            versionBuilder.append(informationScanner.nextLine()).append(System.lineSeparator());
        }
        processorVersion = versionBuilder.toString().trim(); // Save version without trailing newline
    }

    public String getProcessorName() {
        return processorName;
    }

    public Long getPeriod() {
        return period;
    }

    public String getProcessorVersion() {
        return processorVersion;
    }

    public Integer getValueOfCheap() {
        return valueOfCheap;
    }

    public Scanner getInformationScanner() {
        return informationScanner;
    }

    public static LinkedList<String> getStringArrayList() {
        return stringArrayList;
    }
}