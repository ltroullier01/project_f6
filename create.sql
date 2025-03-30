CREATE DATABASE IF NOT EXISTS team6F;
USE team6F;
CREATE TABLE IF NOT EXISTS flights (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    ref VARCHAR(255) NOT NULL,
    departure_city VARCHAR(255) NOT NULL,
    destination_city VARCHAR(255) NOT NULL,
    layover INTEGER DEFAULT NULL,
    departure_time DATE NOT NULL,
    arrival_time DATE NOT NULL,
    price REAL NOT NULL,
    duration INTEGER NOT NULL,
    carbon_footprint REAL NOT NULL
);
CREATE TABLE IF NOT EXISTS seats (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    flight_id INTEGER NOT NULL,
    seat_number VARCHAR(255) NOT NULL,
    class VARCHAR (255) CHECK(class IN ('eco', 'prem')) NOT NULL,
    available INTEGER DEFAULT 1 CHECK(available IN (0, 1)),
    FOREIGN KEY(flight_id) REFERENCES flights(id)
);
CREATE TABLE IF NOT EXISTS bookings (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    flight_id INTEGER NOT NULL,
    booking_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    payment_status VARCHAR (255) CHECK(
        payment_status IN ('Pending', 'Paid', 'Cancelled')
    ) DEFAULT 'Pending',
    FOREIGN KEY(flight_id) REFERENCES flights(id)
);