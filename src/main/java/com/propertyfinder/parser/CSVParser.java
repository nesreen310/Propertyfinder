package com.propertyfinder.parser;


import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;

public class CSVParser {

    public void writeCsvFromBean(Path path, List list) {
        try {
            Writer writer = new FileWriter(path.toString());

            StatefulBeanToCsv sbc = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                    .build();

            sbc.write(list);
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
