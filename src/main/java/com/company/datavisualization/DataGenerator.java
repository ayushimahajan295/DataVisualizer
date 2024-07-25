package com.company.datavisualization;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<Integer> generateLargeDataset(int size) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            data.add((int) (Math.random() * 100));
        }
        return data;
    }

    public static List<Integer> convertStringArrayToIntList(String[] dataStrings) {
        List<Integer> dataList = new ArrayList<>();
        for (String s : dataStrings) {
            try {
                dataList.add(Integer.parseInt(s.trim()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return dataList;
    }
}
