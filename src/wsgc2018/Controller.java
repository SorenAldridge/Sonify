/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package wsgc2018;

import com.opencsv.CSVReader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    FileChooser fileChooser;
    File openFile;
    private final String defaultDirectoryString = "";
    File defaultDirectory;
    ClassLoader classLoader;
    List<HeaderType> headerTypeList;
    String[] header;

    @FXML
    private MenuItem openItem;

    @FXML
    private VBox graphBox;

    @FXML
    private void openFile(){
        openFile = fileChooser.showOpenDialog(null);
        try{
            System.out.println(openFile.toURI().toString());
            parseCSV(openFile);
        }catch (Exception e){
            System.out.println("ParseCSV Exception: " + e);
        }
        //HeaderType = new HeaderType();

    }

    private void parseCSV(File file){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(file.toURI()));
            CSVReader csvReader = new CSVReader(reader);
            //Identify Header for creating HeaderType objects
            header = csvReader.readNext();
            //Create HeaderType Objects
            for (int i = 0; i < header.length;i++){
                headerTypeList.add(new HeaderType(i, header[i]));
            }
            System.out.println(headerTypeList.size());
            for (int i =0;i<headerTypeList.size();i++){
                System.out.println(headerTypeList.get(i).getDataName());
                System.out.println(headerTypeList.get(i).getIndex());
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("File IO Exception: " + e);
        }


    }

    private void populateGraphs(){
        for (int i =0;i<headerTypeList.size();i++){

        }

    }

    public void initialize(URL location, ResourceBundle resources) {
        classLoader = ClassLoader.getSystemClassLoader();
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files (.csv)",  "*.csv", ".CSV"),
                new FileChooser.ExtensionFilter("Text Files (.txt)", "*.txt", ".TXT"));
        defaultDirectory = new File(classLoader.getResource(defaultDirectoryString).getFile());
        fileChooser.setInitialDirectory(defaultDirectory);
        fileChooser.setTitle("Open Data");
        headerTypeList = new ArrayList<HeaderType>();


    }
}
