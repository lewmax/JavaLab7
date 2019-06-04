package ua.lvivl.iot.TextEditor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private List<String> resultsList;

    private String userInput;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public List<String> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<String> resultsList) {
        this.resultsList = resultsList;
    }

    public StringProcessor() {

    }

    public void readInputText() throws IOException {

        System.out.println("Print the text you want to process: ");

        Scanner scanner = new Scanner(System.in);

        this.userInput = scanner.nextLine();

        scanner.close();

    }

    public List<String> processText() {

        resultsList = new LinkedList<String>();

        Pattern pattern = Pattern.compile("[A-Z a-z]*[A-Z , : a-z]+[-]+[A-Z " +
                "a-z]+[-]+[A-Z a-z]+[-]+[A-Z a-z]*[!]+");

        Matcher matcher = pattern.matcher(this.getUserInput());

        while (matcher.find()) {

            resultsList.add(matcher.group());

        }

        return resultsList;

    }

    public void showResults() {

        System.out.println("Exclamation: " + resultsList);

    }

    public static void main(String[] args) throws IOException {

        StringProcessor sp = new StringProcessor();

        sp.readInputText();

        sp.processText();

        sp.showResults();

    }
}

    /*Pattern pattern = Pattern.compile("[A-Z a-z]*[A-Z , : a-z]+[-]+[A-Z " +
            "a-z]+[-]+[A-Z a-z]+[-]+[A-Z a-z]*[!]+");*/