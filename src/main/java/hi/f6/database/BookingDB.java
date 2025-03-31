package hi.f6.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import hi.f6.models.Flight;
import hi.f6.models.Seat;

public class BookingDB {

    private Connection con;

    public BookingDB(Connection con) {
        this.con = con;
    }

    public void createBooking(Flight flight, Seat seat) {

        try (PreparedStatement pt = con
                .prepareStatement("INSERT INTO bookings (flight_id,seat_id,booking_date) VALUES (?,?,?)")) {
            pt.setInt(1, flight.getFlightID());
            pt.setInt(2, seat.getId());
            pt.setString(3, LocalDateTime.now().toString());
            System.out.println(flight.getFlightID() + " " + seat.getId() + " " + LocalDateTime.now().toString());
            pt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
