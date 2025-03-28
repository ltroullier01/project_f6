package hi.f6.gui;

import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane{
    SearchDisplay sd;
    FlightDisplay fd;
    BookingDisplay bd;

    public MainView (){
        this.sd = new SearchDisplay();
        this.fd = new FlightDisplay();
        this.bd = new BookingDisplay();
        
        this.setLeft(this.sd);
        this.setCenter(this.fd);
        this.setRight(this.bd);      
    }

}
