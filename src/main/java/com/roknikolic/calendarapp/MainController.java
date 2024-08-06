package com.roknikolic.calendarapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label testId;

    @FXML
    private void testButtonPress() {
        testId.setText("Test!");
    }
   
}
