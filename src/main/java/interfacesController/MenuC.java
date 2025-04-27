package interfacesController;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuC {
        @FXML
        private Button managerSpaceButton;
        @FXML
        private Button dataebgineerspacebutton;
        @FXML
        private Button accountantspacebutton;
    public Scene getMenuscene() throws IOException {javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
        Scene scene = new Scene(loader.load());
        return scene;}
        @FXML
        public void initialize() {


                managerSpaceButton.setOnAction(event -> {
                     Stage stage = (Stage) managerSpaceButton.getScene().getWindow();
                        LoginManagerC loginManagerC = new LoginManagerC();
                    try {
                        stage.setScene(loginManagerC.getManagerLoginscene());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                        stage.show();     });
            dataebgineerspacebutton.setOnAction(event -> {
                Stage stage = (Stage) dataebgineerspacebutton.getScene().getWindow();
                LoginDataIngC loginDataIngC = new LoginDataIngC();
                try {
                    stage.setScene(loginDataIngC.getDataIngLoginscene());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                stage.show();     });
            accountantspacebutton.setOnAction(event -> {
                Stage stage = (Stage) dataebgineerspacebutton.getScene().getWindow();
                LoginComptableC loginComptableC = new LoginComptableC();
                try {
                    stage.setScene(loginComptableC.getComptableLoginscene());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                stage.show();     });



        }



        }
