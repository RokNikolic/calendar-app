package com.roknikolic.calendarapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainController implements Initializable {
    CalendarHelper calendarHelper = new CalendarHelper();
    FileReadHelper fileReadHelper = new FileReadHelper();
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
    private DatePicker dateJumpLabel;
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
    // Array of all the labels in the calendar grid
    Label[] gridArray = new Label[34];
    // Month labels and lookup dict
    private final String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    private final Map<String, Integer> monthNumbers = new HashMap<>();
    private final Map<String, Integer> holidayDates = new HashMap<>();

    // Constructor for UI components
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

        // Fill the array with all the grid labels
        gridArray = new Label[] {grid0, grid1, grid2, grid3, grid4, grid5, grid6,
                grid7, grid8, grid9, grid10, grid11, grid12, grid13,
                grid14, grid15, grid16, grid17, grid18, grid19, grid20,
                grid21, grid22, grid23, grid24, grid25, grid26, grid27,
                grid28, grid29, grid30, grid31, grid32, grid33, grid34};

        // Read holidays
        String filePath = "holidays.txt";
        List<String> readLines = fileReadHelper.readAllLines(filePath);

        // Make a dictionary of holidays that we can look up later, format -> {"day-month"=year}
        for (String holiday : readLines) {
            String[] dateAndRepeatFlag = holiday.split(":");
            String[] dayMonthYear = dateAndRepeatFlag[0].split("-");
            String[] dayAndMonth = Arrays.copyOfRange(dayMonthYear, 0, 2);

            // The day and month of the holiday, we use this as a key
            String shortDate = String.join("-", dayAndMonth[0], dayAndMonth[1]);

            // If the repeating flag is on we set the year to null, otherwise we use the provided year
            if (Boolean.parseBoolean(dateAndRepeatFlag[1])) {
                holidayDates.put(shortDate, null);
            } else {
                holidayDates.put(shortDate, Integer.valueOf(dayMonthYear[2]));
            }
        }

        // Display initial calendar
        updateCalendar();
    }
    public void updateCalendar() {
        System.out.printf("Updating calendar to month: %d, year: %d \n", currentMonth, currentYear);
        int firstDay = calendarHelper.getFirstDayOfMonth(currentMonth, currentYear);
        int numOfDays = calendarHelper.numOfDaysInMonth(currentMonth, currentYear);

        // Loop over cells and fill in the ones that are needed for the current month
        for (int i = 0; i < gridArray.length; i++) {
            // All cells are first set to blank
            gridArray[i].setText("");
            // We only operate on the cells that correspond to the current month
            if ((i >= firstDay) && ((i - firstDay) < numOfDays)) {
                // Convert the loop variable to a date number
                int dayNumber = i - (firstDay - 1);
                // Write numbers into labels and color them all black, special days are re-colored later
                gridArray[i].setText(String.valueOf(dayNumber));
                gridArray[i].setTextFill(Color.rgb(0, 0, 0));

                // Check if any date of current month is a holiday
                String keyDate = String.join("-", String.valueOf(dayNumber), String.valueOf(currentMonth));
                Integer holidayYear = holidayDates.get(keyDate);

                // If a day is a holiday and the year is repeating or current
                if ((holidayDates.containsKey(keyDate)) && ((holidayYear == null) || (holidayYear == currentYear))) {
                    gridArray[i].setTextFill(Color.rgb(0, 200, 0));
                }
                // If the day is a sunday
                else if ((i+1) % 7 == 0) {
                    gridArray[i].setTextFill(Color.rgb(73, 64, 255));
                }
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
        } catch (NumberFormatException ex) {
            ErrorLabel.setText("Please enter a valid year");
        }
    }
    public void jumpToDate() {
        // Gets chosen date and jumps to it
        LocalDate jumpDate = dateJumpLabel.getValue();
        if (jumpDate != null) {
            String formattedJumpDate = jumpDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String[] dayMonthYear = formattedJumpDate.split("-");
            String[] monthAndYear= Arrays.copyOfRange(dayMonthYear, 1, 3);
            // Set both new month and year
            currentMonth = Integer.parseInt(monthAndYear[0]);
            currentYear = Integer.parseInt(monthAndYear[1]);
            updateCalendar();
        }
    }
}
