package hi.f6.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import hi.f6.models.Flight;
import hi.f6.models.Seat;

public class SeatDB {

    private Connection con;

    public SeatDB(Connection con) {
        this.con = con;
    }

    public List<Seat> getSeatOfFlight(Flight flight) {
        List<Seat> listeSeats = new ArrayList<>();

        String select = "SELECT * " +
                "FROM seats " +
                "WHERE flight_id = ? ";

        try (PreparedStatement pstmt = this.con.prepareStatement(select)) {

            pstmt.setInt(1, flight.getFlightID());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                listeSeats.add(new Seat(rs.getInt("id"), flight.getFlightID(), rs.getString("seat_number"),
                        rs.getBoolean("available"), rs.getString("class")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listeSeats;
    }

    public void bookSeat() {

    }

}
