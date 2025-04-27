module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    // Open 'model.staff' package to javafx.base so it can be accessed reflectively
    opens model.staff to javafx.base;

    // Open specific packages to javafx.fxml for FXML usage
    opens interfacesController to javafx.fxml;

    // Export packages to make them accessible from other modules
    exports interfaces;
    exports interfacesController;
    requires javafx.base;
    opens model.statistiques to javafx.base;
}
