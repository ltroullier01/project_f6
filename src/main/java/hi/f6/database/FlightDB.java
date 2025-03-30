package hi.f6.database;

import java.sql.Connection;

public class FlightDB {
    private Connection con;

    public FlightDB(Connection con) {
        this.con = con;
    }
}
