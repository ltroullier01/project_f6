package hi.f6.gui;

import java.sql.Connection;

import hi.f6.controllers.FlightController;
import hi.f6.database.Util;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {
    SearchDisplay sd;
    FlightDisplay fd;
    BookingDisplay bd;
    FlightController flightController;
    Util util;
    Connection conn;

    public MainView() {
        this.flightController = new FlightController();
        this.sd = new SearchDisplay(this);
        this.fd = new FlightDisplay(this);
        this.bd = new BookingDisplay(flightController);

        this.util = new Util();
        this.conn = this.util.getConnection();
        if (this.conn != null) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Échec de la connexion.");
        }

        this.setLeft(this.sd);
        this.setCenter(this.fd);
        this.setRight(this.bd);

        BorderPane.setMargin(this.bd, new Insets(0, 20, 0, 0));
    }

    // GETTERS
    public SearchDisplay getSd() {
        return sd;
    }

    public FlightDisplay getFd() {
        return fd;
    }

    public BookingDisplay getBd() {
        return bd;
    }

    public FlightController getFlightController() {
        return flightController;
    }

}
