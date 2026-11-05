
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

        book("09:00", "Alex");
        book("10:00", "Sam");
        book("11:00", "Michael");

        System.out.println("Appointments: " + appointments);

        System.out.println("Patient at 09:00: "
                + findPatient("09:00"));

        //cancel("10:00");

        System.out.println("Remaining appointments: "
                + countAppointments());

        boolean result = reschedule("09:00", "12:00");

        System.out.println(result);
        System.out.println("Updated schedule: " + appointments);
    }
}
