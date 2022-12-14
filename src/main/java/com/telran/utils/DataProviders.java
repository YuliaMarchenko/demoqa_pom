package com.telran.utils;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> usingFile() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/data.csv")));

        List<Object[]> userData = new ArrayList();

        String line = reader.readLine();

        while (line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> usingFileTestBox() throws IOException {

        System.out.println(DataProviders.class.getResourceAsStream("/dataTestBox.csv"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/dataTestBox.csv")));

        List<Object[]> userData = new ArrayList();

        String line = reader.readLine();

        while (line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();

        return userData.iterator();
    }
}
