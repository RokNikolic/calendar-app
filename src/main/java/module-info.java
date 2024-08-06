module com.roknikolic.calendarapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.roknikolic.calendarapp to javafx.fxml;
    exports com.roknikolic.calendarapp;
}