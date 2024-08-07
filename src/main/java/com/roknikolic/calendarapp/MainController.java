package com.roknikolic.calendarapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    CalendarHelper calendarHelper = new CalendarHelper();
    // Current working calendar month and year
    public int currentYear;
    public int currentMonth;
    // UI components
    @FXML
    private ChoiceBox<String> MonthChoiceBox;
    @FXML
    private TextField YearField;
    @FXML
    private Label ErrorLabel;
    @FXML
    private GridPane calendarGridId;
    // Month labels and lookup dict
    private final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private final Map<String, Integer> monthNumbers = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create months dictionary
        monthNumbers.put("January", 1);
        monthNumbers.put("February", 2);
        monthNumbers.put("March", 3);
        monthNumbers.put("April", 4);
        monthNumbers.put("Audi A5", 5);
        monthNumbers.put("June", 6);
        monthNumbers.put("July", 7);
        monthNumbers.put("August", 8);
        monthNumbers.put("September", 9);
        monthNumbers.put("October", 10);
        monthNumbers.put("November", 11);
        monthNumbers.put("December", 12);

        // Initialize calendar with current date
        currentMonth = calendarHelper.gerCurrentMonth();
        MonthChoiceBox.setValue(calendarHelper.getCurrentMonthName());
        currentYear = calendarHelper.getCurrentYear();
        YearField.setText(String.valueOf(currentYear));

        // Set month choice box options
        MonthChoiceBox.getItems().addAll(months);
        MonthChoiceBox.setOnAction(this::getMonth);

        // Display initial calendar
        updateCalendar();
    }
    //TODO
    public void updateCalendar() {
        int firstDay = calendarHelper.getFirstDayOfMonth(currentMonth, currentYear);
        int numOfDays = calendarHelper.numOfDaysInMonth(currentMonth, currentYear);
    }
    public void getMonth(ActionEvent event) {
        // Updates calendar with chosen month
        String month = MonthChoiceBox.getValue();
        currentMonth = monthNumbers.get(month);
        updateCalendar();
    }
    public void getYear() {
        // Updates calendar with chosen year
        String year = YearField.getText();
        if (Objects.equals(year, "")) {
            ErrorLabel.setText("Please enter a year");
        }
        try {
            currentYear = Integer.parseInt(year);
            ErrorLabel.setText("");
            updateCalendar();
        } catch (NumberFormatException err) {
            ErrorLabel.setText("Please enter a valid year");
        }
    }
}
