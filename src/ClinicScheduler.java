import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ClinicScheduler {

    static Map<String, String> appointments = new HashMap<>();

    // Book an appointment
    static boolean book(String time, String patient) {
        if (!isValidTime(time) || !isWithinClinicHours(time) || appointments.containsKey(time)) {
            return false;
        }

        appointments.put(time, patient);
        return true;
    }

    // Cancel an appointment
    static boolean cancel(String time) {
        if (appointments.containsKey(time)) {
            appointments.remove(time);
            return true;
        }

        return false;
    }

    // Find a patient by appointment time
    static String findPatient(String time) {
        return appointments.get(time);
    }

    // Count appointments
    static int countAppointments() {
        return appointments.size();
    }

    static boolean reschedule(String oldTime, String newTime) {
        if (!isValidTime(oldTime) || !appointments.containsKey(oldTime) ) {
            return false;
        } else if (!isValidTime(newTime) || !isWithinClinicHours(newTime) || appointments.containsKey(newTime)) {
            return false;
        }
        String patient = findPatient(oldTime);
        appointments.remove(oldTime);
        appointments.put(newTime, patient);
        return true;
    }
    static boolean isValidTime(String time){
        boolean valid = time.matches("([01][0-9]|2[0-3]):[0-5][0-9]");
        return valid;
    }
    static boolean isWithinClinicHours(String time) {
        boolean allowed = time.compareTo("08:00") >= 0 && time.compareTo("18:00") < 0;
        return allowed;



    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== CLINIC APPOINTMENT SCHEDULER ===");
            System.out.println("1. Book appointment");
            System.out.println("2. Cancel appointment");
            System.out.println("3. Find patient appointment");
            System.out.println("4. Reschedule appointment");
            System.out.println("5. View appointments");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input");
                scanner.nextLine();

                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();


                switch (choice) {
                    case 1: {
                        while (true) {
                            System.out.println("Please enter the time you would like to schedule and appointment: ");
                            String time = scanner.nextLine();

                            if(!isValidTime(time)) {
                                System.out.println("Invalid input");
                                continue;
                            }
                            else if (!isWithinClinicHours(time)) {
                                System.out.println("Outside clinic hours! (08:00–18:00)");
                                continue;

                            }
                            System.out.println("Please enter your name: ");
                            String name = scanner.nextLine();
                            boolean succesfull = book(time, name);
                            if (succesfull == true) {
                                System.out.println("Booking successful!");
                            } else {
                                System.out.println("Booking failed!");
                            }
                            System.out.println("Would you like to book another appointment? (Y/N): ");
                            String answer = scanner.nextLine();


                            if (answer.equalsIgnoreCase("N")) {
                                break;
                            }
                        }
                        System.out.println("Appointments booked: " + appointments);
                        break;
                    }

                    case 2: {
                        System.out.println("Please enter the time you would like to cancel appointment: ");
                        String time = scanner.nextLine();

                        if(!isValidTime(time)) {
                            System.out.println("Invalid input");
                            continue;
                        }

                        boolean cancelation = cancel(time);
                        if (cancelation) {
                            System.out.println("Appointment cancelled!");
                            break;
                        } else {
                            System.out.println("Appointment not cancelled!");
                            break;
                        }

                    }
                    case 3: {
                        System.out.println("Please enter time of the patients appointment: ");

                        String time = scanner.nextLine();

                        if(!isValidTime(time)) {
                            System.out.println("Invalid input");
                            continue;
                        }

                        if (!appointments.containsKey(time)) {
                            System.out.println("Appointment does not exist!");
                        } else {
                            System.out.println(findPatient(time));
                        }

                        break;
                    }
                    case 4: {
                        System.out.println("Please enter the time of the patients appointment: ");
                        String Oldtime = scanner.nextLine();

                        if(!isValidTime(Oldtime)) {
                            System.out.println("Invalid input");
                            continue;
                        }

                        System.out.println("Please enter the time you would like to reschedule: ");
                        String time = scanner.nextLine();

                        if(!isValidTime(time)) {
                            System.out.println("Invalid input");
                            continue;
                        } else if (!isWithinClinicHours(time)) {

                            System.out.println("Outside clinic hours! (08:00–18:00)");
                            continue;
                        }

                        boolean succesfull = reschedule(Oldtime, time);
                        if (succesfull == true) {
                            System.out.println("Appointment rescheduled!");
                        } else {
                            System.out.println("Appointment not rescheduled!");
                        }
                        break;
                    }
                    case 5: {
                        System.out.println("Appointments scheduled: " + appointments);
                        break;
                    }
                    case 6:
                        return;

                        default:
                        System.out.println("Invalid menu option! Please choose 1-6.");

                }



            }

        }



    }

