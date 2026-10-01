# Lodge Booking REST API

A Spring Boot REST API to manage lodge room bookings, with full CRUD operations and a database that keeps data between restarts.

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (file-based)
- Maven

## Features
- Create, view, update and delete bookings
- Returns 404 Not Found when a booking does not exist
- Data is saved in a database, so it survives application restarts

## API Endpoints

| Method | URL | Description |
|---|---|---|
| POST | /bookings | Create a booking |
| GET | /bookings | Get all bookings |
| GET | /bookings/{id} | Get one booking |
| PUT | /bookings/{id} | Update a booking |
| DELETE | /bookings/{id} | Delete a booking |

## How to Run
1. Clone the repository
2. Open the project folder in a terminal
3. Run: `.\mvnw.cmd spring-boot:run` (Windows) or `./mvnw spring-boot:run` (Mac/Linux)
4. The API runs at `http://localhost:8080/bookings`

## Sample Request

POST /bookings

    {
      "guestName": "Vikas",
      "phone": "9876543210",
      "roomType": "Deluxe",
      "checkIn": "2026-10-01",
      "checkOut": "2026-10-03"
    }

Sample requests are available in `test.http`.

## Author
Vikas Kathiresan