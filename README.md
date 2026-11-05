
# Clinic Appointment Scheduler

## About the Project

Clinic Appointment Scheduler is a Java console application designed to manage patient appointments.

This project was created as part of my journey toward becoming a software developer. Its purpose is to help me develop my Java programming skills, understand data structures, and practice solving real-world problems.

## Features

The application currently supports:

- **Book Appointments** - Schedule patients for available time slots.
- **Cancel Appointments** - Remove existing appointments.
- **Find Patients** - Search for patients using their appointment times.
- **Count Appointments** - Display the total number of scheduled appointments.
- **Reschedule Appointments** - Move appointments to available time slots without overwriting existing bookings.

## Technologies Used

- Java
- Java Collections Framework (HashMap)
- Git
- GitHub
- IntelliJ IDEA

## How to Run

### Requirements

- Java Development Kit (JDK) installed
- Terminal or Java IDE

### Instructions

1. Clone the repository:

```bash
git clone https://github.com/IggySy02/clinic-appointment-scheduler.git
```

2. Navigate to the project folder:

```bash
cd clinic-appointment-scheduler
```

3. Compile the Java program:

```bash
javac src/ClinicScheduler.java
```

4. Run the application:

```bash
java -cp src ClinicScheduler
```

## How It Works

The application uses a Java HashMap to store appointment information.

- **Key:** Appointment time
- **Value:** Patient name

Before booking or rescheduling an appointment, the program checks whether the requested time slot is already occupied.

Currently, appointments are created and managed through methods called in the program's `main()` method.

## Current Limitations

- Appointments are stored in memory and disappear when the program stops.
- The application does not yet have an interactive user menu.
- Appointment times are represented as strings.
- The application is intended for learning purposes, not real patient data.

## Future Improvements

- [ ] Add an interactive console menu using Scanner.
- [ ] Allow users to enter patient information.
- [ ] Add appointment date and time validation.
- [ ] Implement automated unit tests.
- [ ] Store appointments in a database.
- [ ] Develop a REST API using Spring Boot.
- [ ] Build a user interface.

## Project Status

**In Development**

This project will continue to evolve as I improve my Java skills and learn new software development technologies.

## Author

**Igor**

Computer Science Student | Aspiring Software Developer

GitHub: [IggySy02](https://github.com/IggySy02)
