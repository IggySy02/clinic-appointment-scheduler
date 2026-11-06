import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ClinicScheduler {

    static Map<String, String> appointments = new HashMap<>();

    // Book an appointment
    static boolean book(String time, String patient) {
        if (appointments.containsKey(time)) {
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
        if (appointments.containsKey(oldTime) != true) {
            return false;
        } else if (appointments.containsKey(newTime)) {
            return false;
        }
        String patient = findPatient(oldTime);
        appointments.remove(oldTime);
        appointments.put(newTime, patient);
        return true;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Please enter the time you would like to schedule and appointment: ");
            String time = scanner.nextLine();
            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();
            boolean succesfull = book(time, name);
            if (succesfull == true) {
                System.out.println("Booking successful!");
            } else {
                System.out.println("Booking failed!");
            }
            System.out.println("Would you like to book another appointment? (Y/N): ")   ;
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("N")) {
                break;
            }
        }
        System.out.println("Appointments booked: " + appointments);


    }
}
