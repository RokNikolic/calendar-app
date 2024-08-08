package com.roknikolic.calendarapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    CalendarHelper calendarHelper = new CalendarHelper();
    // Currently displayed calendar month and year
    private int currentYear;
    private int currentMonth;
    // UI components
    @FXML
    private ChoiceBox<String> MonthChoiceBox;
    @FXML
    private TextField YearField;
    @FXML
    private Label ErrorLabel;
    @FXML
    private Label grid0;
    @FXML
    private Label grid1;
    @FXML
    private Label grid2;
    @FXML
    private Label grid3;
    @FXML
    private Label grid4;
    @FXML
    private Label grid5;
    @FXML
    private Label grid6;
    @FXML
    private Label grid7;
    @FXML
    private Label grid8;
    @FXML
    private Label grid9;
    @FXML
    private Label grid10;
    @FXML
    private Label grid11;
    @FXML
    private Label grid12;
    @FXML
    private Label grid13;
    @FXML
    private Label grid14;
    @FXML
    private Label grid15;
    @FXML
    private Label grid16;
    @FXML
    private Label grid17;
    @FXML
    private Label grid18;
    @FXML
    private Label grid19;
    @FXML
    private Label grid20;
    @FXML
    private Label grid21;
    @FXML
    private Label grid22;
    @FXML
    private Label grid23;
    @FXML
    private Label grid24;
    @FXML
    private Label grid25;
    @FXML
    private Label grid26;
    @FXML
    private Label grid27;
    @FXML
    private Label grid28;
    @FXML
    private Label grid29;
    @FXML
    private Label grid30;
    @FXML
    private Label grid31;
    @FXML
    private Label grid32;
    @FXML
    private Label grid33;
    @FXML
    private Label grid34;
    Label[] gridArray = new Label[34];
    // Month labels and lookup dict
    private final String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    private final Map<String, Integer> monthNumbers = new HashMap<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create months dictionary
        monthNumbers.put("January", 1);
        monthNumbers.put("February", 2);
        monthNumbers.put("March", 3);
        monthNumbers.put("April", 4);
        monthNumbers.put("May", 5);
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

        // An array of all the grid cells
        gridArray = new Label[] {grid0, grid1, grid2, grid3, grid4, grid5, grid6,
                grid7, grid8, grid9, grid10, grid11, grid12, grid13,
                grid14, grid15, grid16, grid17, grid18, grid19, grid20,
                grid21, grid22, grid23, grid24, grid25, grid26, grid27,
                grid28, grid29, grid30, grid31, grid32, grid33, grid34};

        // Display initial calendar
        updateCalendar();
    }
    public void updateCalendar() {
        System.out.printf("Updating calendar to month: %d, year: %d \n", currentMonth, currentYear);
        int firstDay = calendarHelper.getFirstDayOfMonth(currentMonth, currentYear);
        int numOfDays = calendarHelper.numOfDaysInMonth(currentMonth, currentYear);

        // Loop over cells and fill in the ones that are needed for the current month
        for (int i = 0; i < gridArray.length; i++) {
            if ((i >= firstDay) && ((i - firstDay) < numOfDays)) {
                gridArray[i].setText(String.valueOf(i - (firstDay - 1)));
            } else {
                gridArray[i].setText("");
            }
        }
    }
    public void getMonth(ActionEvent event) {
        // Gets chosen month from UI and updates calendar
        String month = MonthChoiceBox.getValue();
        currentMonth = monthNumbers.get(month);
        updateCalendar();
    }
    public void getYear() {
        // Gets chosen year from UI and updates calendar
        String year = YearField.getText();
        if (Objects.equals(year, "")) {
            ErrorLabel.setText("Please enter a year");
        }
        try {
            currentYear = Integer.parseInt(year);
            ErrorLabel.setText("");
            updateCalendar();
        } catch (NumberFormatException error) {
            ErrorLabel.setText("Please enter a valid year");
        }
    }
}
