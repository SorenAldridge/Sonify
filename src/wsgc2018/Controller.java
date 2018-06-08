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
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    //Filechooser
    FileChooser fileChooser;
    File openFile;
    private final String defaultDirectoryString = "";
    File defaultDirectory;
    ClassLoader classLoader;

    @FXML
    private MenuItem openItem;

    @FXML
    private void openFile(){
        openFile = fileChooser.showOpenDialog(null);


        String n = "1";
        HeaderType = new HeaderType();

    }

    private static void parseCSV(File file) throws Exception{
        try (
                Reader reader = new BufferedReader(file);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("Name : " + nextRecord[0]);
                System.out.println("Email : " + nextRecord[1]);
                System.out.println("Phone : " + nextRecord[2]);
                System.out.println("Country : " + nextRecord[3]);
                System.out.println("==========================");
            }
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        classLoader = ClassLoader.getSystemClassLoader();
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files (.csv)", "*.csv", ".CSV"),
                new FileChooser.ExtensionFilter("Text Files (.txt)", "*.txt", ".TXT"));
        defaultDirectory = new File(classLoader.getResource(defaultDirectoryString).getFile());
        fileChooser.setInitialDirectory(defaultDirectory);
        fileChooser.setTitle("Open Data");
    }
}
