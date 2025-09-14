import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AssignmentProgram {

    private static final String PROPERTIES_FILE = "E:\\ValidRail – Admin & User Validation System (Java CLI)\\resources\\userLogin.properties";
    private static final String USERS_FILE = "E:\\ValidRail – Admin & User Validation System (Java CLI)\\resources\\users.txt";

    // the above addresses will be as per your saved file location, so change it accordingly

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayInitialMenu();
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    adminLogin(sc);
                    break;
                case 2:
                    System.out.println("View User Login: Coming Soon!");
                    break;
                case 3:
                    createNewAdmin(sc);
                    break;
                case 100:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void displayInitialMenu() {
        System.out.println("\n--- Welcome to ValidRail : Admin & User Validation System ---");
        System.out.println("Select one of the following options:");
        System.out.println("1. Admin User Login");
        System.out.println("2. View User Login");
        System.out.println("3. Create New Admin");
        System.out.println("100. Exit");
        System.out.print("Enter your choice [1,2,3,100]: ");
    }

    private static void adminLogin(Scanner sc) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Error loading properties file.");
            return;
        }

        String storedUserId = properties.getProperty("adminUserId");
        String storedPassword = properties.getProperty("adminPassword");

        System.out.print("Enter Admin User Id: ");
        String userId = sc.nextLine();

        System.out.print("Enter Admin Password: ");
        String password = sc.nextLine();

        if (storedUserId != null && storedPassword != null &&
            storedUserId.equals(userId) && storedPassword.equals(password)) {
            updateAdminCredentials(sc, properties);
            displayMainMenu(sc);
        } else {
            System.out.println("Credential not matched. Do you want to retry login?");
            System.out.println("Enter 1 to retry or 100 to go to main menu:");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                adminLogin(sc);
            } else if (choice == 100) {
                return;
            } else {
                System.out.println("Invalid choice. Returning to main menu.");
            }
        }
    }
    private static void createNewAdmin(Scanner sc) {
        Properties properties = new Properties();

        System.out.print("Enter new Admin User Id: ");
        String newUserId = sc.nextLine();

        System.out.print("Enter new Admin Password: ");
        String newPassword = sc.nextLine();

        properties.setProperty("adminUserId", newUserId);
        properties.setProperty("adminPassword", newPassword);

        try (FileOutputStream fos = new FileOutputStream(PROPERTIES_FILE)) {
            properties.store(fos, null);
            System.out.println("✅ New admin created successfully.");
        } catch (IOException e) {
            System.err.println("❌ Failed to create new admin. " + e.getMessage());
        }
    }

    private static void updateAdminCredentials(Scanner sc, Properties properties) {
        System.out.print("Enter new Admin User Id: ");
        String newUserId = sc.nextLine();
        System.out.print("Enter new Admin Password: ");
        String newPassword = sc.nextLine();

        properties.setProperty("adminUserId", newUserId);
        properties.setProperty("adminPassword", newPassword);

        try (FileOutputStream fos = new FileOutputStream(PROPERTIES_FILE)) {
            properties.store(fos, null);
            System.out.println("Admin credentials updated successfully.");
        } catch (IOException e) {
            System.err.println("Error updating properties file.");
        }
    }

    private static void displayMainMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- Admin Main Menu ---");
            System.out.println("1. User Registration Fields Validation");
            System.out.println("2. Railway Ticket Booking Input Validation (Coming Soon)");
            System.out.println("3. Passenger Details Input Validation (Coming Soon)");
            System.out.println("4. Selection of Payment Options and Validation (Coming Soon)");
            System.out.println("5. Display Masked User Input Details (Coming Soon)");
            System.out.println("10. Exit");
            System.out.print("Enter your choice [1-10]: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 10) {
                System.out.println("Returning to initial menu...");
                return;
            }
            switch (choice) {
                case 1:
                    userRegistration(sc);
                    break;
                default:
                    System.out.println("Option under development. Please try another.");
            }
        }
    }
    private static void userRegistration(Scanner sc) {
        while (true) {
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Date Of Birth [dd/mm/yyyy]: ");
            String dob = sc.nextLine();
            System.out.print("Gender [Male(M)/Female(F)]: ");
            String gender = sc.nextLine();
            System.out.print("Mobile no with ISD: ");
            String mobile = sc.nextLine();
            System.out.print("Email Id: ");
            String email = sc.nextLine();
            System.out.print("Address HouseNo: ");
            String houseNo = sc.nextLine();
            System.out.print("Street: ");
            String street = sc.nextLine();
            System.out.print("Post Office: ");
            String postOffice = sc.nextLine();
            System.out.print("PinCode: ");
            String pinCode = sc.nextLine();
            System.out.print("State: ");
            String state = sc.nextLine();
            System.out.print("Country Name: ");
            String country = sc.nextLine();

            StringBuilder errors = new StringBuilder();

            if (!nameValidation(name)) errors.append("Invalid name.\n");
            if (!dobValidation(dob)) errors.append("Invalid date of birth.\n");
            if (!genderValidation(gender)) errors.append("Invalid gender.\n");
            if (!mobileValidation(mobile)) errors.append("Invalid mobile number.\n");
            if (!emailValidation(email)) errors.append("Invalid email.\n");
            if (!addressValidation(houseNo)) errors.append("Invalid house number.\n");
            if (!addressValidation(street)) errors.append("Invalid street.\n");
            if (!addressValidation(postOffice)) errors.append("Invalid post office.\n");
            if (!pinCodeValidation(pinCode)) errors.append("Invalid pin code.\n");
            if (!addressValidation(state)) errors.append("Invalid state.\n");
            if (!addressValidation(country)) errors.append("Invalid country.\n");

            if (errors.length() > 0) {
                System.out.println("\nErrors:\n" + errors);
                System.out.println("Do you want to retry? Enter 1 to retry or 100 to return:");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) continue;
                else return;
            } else {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
                    writer.write(String.join("$", name, dob, gender, mobile, email, houseNo, street, postOffice, pinCode, state, country));
                    writer.newLine();
                    System.out.println("✅ User registration successful.");
                } catch (IOException e) {
                    System.err.println("Error writing to users file.");
                }
                return;
            }
        }
    }

    private static boolean nameValidation(String name) {
        return name != null && name.matches("^[A-Za-z ]+$");
    }

    private static boolean dobValidation(String dob) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date dateOfBirth = sdf.parse(dob);
            Date currentDate = new Date();
            return !dateOfBirth.after(currentDate);
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean genderValidation(String gender) {
        return gender != null && (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F") ||
                gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"));
    }

    private static boolean mobileValidation(String mobile) {
        return mobile != null && mobile.matches("^\\+?\\d{10,13}$");
    }

    private static boolean emailValidation(String email) {
        return email != null &&
               Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$").matcher(email).matches() &&
               !email.contains("..");
    }

    private static boolean addressValidation(String address) {
        return address != null && !address.trim().isEmpty();
    }

    private static boolean pinCodeValidation(String pinCode) {
        return pinCode != null && pinCode.matches("^\\d{6}$");
    }

    @Override
    public String toString() {
        return "AssignmentProgram []";
    }

    public static String getPropertiesFile() {
        return PROPERTIES_FILE;
    }

    public static String getUsersFile() {
        return USERS_FILE;
    }
}

// this assignment if from internship at Centre for Railway Information System (CRIS)
// here i worked on an internal CLI based application to streamline operations.
// open for contributions