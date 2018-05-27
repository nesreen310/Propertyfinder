package com.propertyfinder.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static boolean isStream(String input) {
        final Pattern pattern = Pattern.compile("([a-zA-Z0-9]+)-([a-zA-Z0-9]+)");
        final Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean getExcelFilesNames(String input) {
        final Pattern pattern = Pattern.compile("(\\w)+(.(xlsx|xlx|xls))");
        final Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static List<String> listFilesForFolder(final File folder) {
        List<String> list = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                if (getExcelFilesNames(fileEntry.getName())) {
                    list.add(fileEntry.getName());
                }
            }
        }
        return list;
    }

    public static String getFirstPartOfStream(String input) {
        final Pattern pattern = Pattern.compile("([a-zA-Z0-9]+)-([a-zA-Z0-9]+)");
        final Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return input;
    }

    public static void copyFileUsingApacheCommonsIO(String source, String dest) {
        try {
            FileUtils.copyFileToDirectory(new File(source), new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFirstPartOfPhrase(String input) {
        String string = "Empty";
        Pattern pattern1 = Pattern.compile("([a-zA-Z0-9]+)");
        Matcher matcher1 = pattern1.matcher(input);
        if (matcher1.find()) {
            string = matcher1.group(1);
        }
        return string;
    }
}