package hi.f6.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import hi.f6.models.Flight;

public class FlightDB {
    private Connection con;

    public FlightDB(Connection con) {
        this.con = con;
    }

    public List<Flight> search(String departureCity, String arrivalCity, LocalDate departureDate,
            LocalDate arrivalDate) {
        List<Flight> listeFlight = new ArrayList<>();

        String select = "SELECT id, ref, departure_city, destination_city, layover, departure_time, arrival_time, price, duration, carbon_footprint "
                +
                "FROM flights " +
                "WHERE departure_city = ? AND destination_city = ? " +
                "AND departure_time = ? AND arrival_time = ?";

        try (PreparedStatement pstmt = this.con.prepareStatement(select)) {

            pstmt.setString(1, departureCity);
            pstmt.setString(2, arrivalCity);
            pstmt.setString(3, departureDate.toString());
            pstmt.setString(4, arrivalDate.toString());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
                dtf = dtf.withLocale(Locale.FRENCH);

                int flightID = rs.getInt("id");
                String flightRef = rs.getString("ref");
                String departureCity_var = rs.getString("departure_city");
                String destinationCity_var = rs.getString("destination_city");
                int layovers = rs.getInt("layover");
                String departureTimeString = rs.getString("departure_time");
                LocalDate departureTime = LocalDate.parse(departureTimeString);
                String arrivalTimeString = rs.getString("arrival_time");
                LocalDate arrivalTime = LocalDate.parse(arrivalTimeString);
                float price = rs.getFloat("price");
                int duration = rs.getInt("duration");
                float carbonFootprint = rs.getInt("carbon_footprint");

                Flight flight = new Flight(flightID, flightRef, departureCity_var, destinationCity_var, departureTime,
                        arrivalTime, price, duration, layovers, carbonFootprint);
                listeFlight.add(flight);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listeFlight;
    }

    public List<Flight> searchWithoutDepartureCity(String departureCity, LocalDate departureDate,
            LocalDate ArrivalDate) {
        List<Flight> listeFlight = new ArrayList<>();

        return listeFlight;
    }

    public List<Flight> searchWithoutArrivalCity(String arrivalCity, LocalDate departureDate, LocalDate ArrivalDate) {
        List<Flight> listeFlight = new ArrayList<>();

        return listeFlight;
    }

    public List<Flight> searchWithoutDepartureAndArrivalCity(LocalDate departureDate, LocalDate ArrivalDate) {
        List<Flight> listeFlight = new ArrayList<>();

        return listeFlight;
    }
}
