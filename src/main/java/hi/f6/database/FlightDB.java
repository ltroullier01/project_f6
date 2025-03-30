package hi.f6.database;

import java.sql.Connection;
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

    public List<Flight> search(String departureCity, String arrivalCity, LocalDate departureDate, LocalDate ArrivalDate){
        List<Flight> listeFlight = new ArrayList<>();
        try (Statement stmt = this.con.createStatement()) {

            String select = "SELECT flightID, flightRef, departureCity, destinationCity, layovers, departureTime, arrivalTime, price, duration, carbonFootprint\r\n" + 
                                "FROM flights\r\n" + 
                                "WHERE departure = "+departureCity+" AND destination = "+arrivalCity+" \r\n" +
                                "AND departure_time = "+departureDate.toString()+" AND arrival_time = "+departureDate.toString()+";";
            
            ResultSet rs = stmt.executeQuery(select);
            
            while (rs.next()) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
                dtf = dtf.withLocale(Locale.FRENCH);

                int flightID = rs.getInt("flightID");
                String flightRef = rs.getString("flightRef");
                String departureCity_var = rs.getString("departureCity");
                String destinationCity_var = rs.getString("destinationCity");
                int layovers = rs.getInt("layovers");
                String departureTimeString = rs.getString("departureTime");
                LocalDate departureTime = LocalDate.parse(departureTimeString);
                String arrivalTimeString = rs.getString("arrivalTime");
                LocalDate arrivalTime = LocalDate.parse(arrivalTimeString);
                float price = rs.getFloat("price");
                int duration = rs.getInt("duration");
                float carbonFootprint = rs.getInt("carbonFootprint");
                
                Flight flight = new Flight(flightID, flightRef,departureCity_var,destinationCity_var,departureTime,arrivalTime,price,duration,layovers,carbonFootprint);
                listeFlight.add(flight);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listeFlight;
    }

    public List<Flight> searchWithoutDepartureCity(String departureCity, LocalDate departureDate, LocalDate ArrivalDate){
        List<Flight> listeFlight = new ArrayList<>();

        return listeFlight;
    }

    public List<Flight> searchWithoutArrivalCity(String arrivalCity, LocalDate departureDate, LocalDate ArrivalDate){
        List<Flight> listeFlight = new ArrayList<>();

        return listeFlight;
    }

    public List<Flight> searchWithoutDepartureAndArrivalCity(LocalDate departureDate, LocalDate ArrivalDate){
        List<Flight> listeFlight = new ArrayList<>();

        return listeFlight;
    }
}
