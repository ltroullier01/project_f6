package hi.f6.gui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class UserDisplay extends HBox {
    private Button b_login;
    private TextField tf_Username;
    private TextField tf_Password;

    public UserDisplay() {
        this.b_login = new Button();
        this.tf_Username = new TextField();
        this.tf_Password = new TextField();

        this.getChildren().addAll(tf_Username,tf_Password,b_login);
    }

}
