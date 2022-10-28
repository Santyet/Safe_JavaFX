module com.example.safe_seg13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.safe_seg13 to javafx.fxml;
    exports com.example.safe_seg13;
    exports com.example.safe_seg13.control;
    opens com.example.safe_seg13.control to javafx.fxml;
}