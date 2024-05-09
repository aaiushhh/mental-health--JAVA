import java.util.Scanner;
import java.io.*;
import java.sql.*;

class Illness {
    protected int depression = 0;
    protected int anxiety = 0;
    protected int bipolar = 0;
    protected int schiz = 0;
    protected int ocd = 0;
    protected int checkupCounter = 0;

    public void checkup() {
        Scanner scanner = new Scanner(System.in);

        checkupCounter = 1;
        int d = 0;
        System.out.println("***********************************************");
        System.out.println("* Answer the following 15 questions on a      *");
        System.out.println("* scale of 1 to 10                            *");
        System.out.println("***********************************************");

        // Depression
        System.out.print(
                "Over the past 2 weeks, how often have you felt down, depressed, or hopeless? (0 = not at all, 10 = every day): ");
        d = scanner.nextInt();
        depression += d;

        System.out.print(
                "Over the past 2 weeks, how often have you lost interest or pleasure in doing things? (0 = not at all, 10 = every day): ");
        d = scanner.nextInt();
        depression += d;

        System.out.print(
                "Over the past 2 weeks, how often have you experienced difficulties sleeping, such as trouble falling asleep, staying asleep, or waking up too early? (0 = not at all, 10 = every day): ");
        d = scanner.nextInt();
        depression += d;

        if (depression > 21) {
            depression = 1;
        } else {
            depression = 0;
        }

        // Anxiety
        System.out.print(
                "Over the past 2 weeks, how often have you felt anxious, nervous, or on edge? (0 = not at all, 10 = every day): ");
        d = scanner.nextInt();
        anxiety += d;

        System.out.print(
                "Over the past 2 weeks, how often have you felt panicked or experienced sudden feelings of terror? (0 = not at all, 10 = every day): ");
        d = scanner.nextInt();
        anxiety += d;

        System.out.print(
                "Over the past 2 weeks, how often have you experienced physical symptoms of anxiety, such as sweating, trembling, or a racing heart? (0 = not at all, 10 = every day): ");
        d = scanner.nextInt();
        anxiety += d;

        if (anxiety > 21) {
            anxiety = 1;
        } else {
            anxiety = 0;
        }

        // Bipolar
        System.out.print(
                "Over the past 2 weeks, how often have you experienced an unusually elevated or irritable mood, with increased energy or activity levels? (0 = not at all, 10 = every day): ");
        d = scanner.nextInt();
        bipolar += d;

        System.out.print(
                "Over the past 2 weeks, how often have you experienced periods of depression, with feelings of sadness, hopelessness, or loss of interest in activities? (0 = not at all, 10 = every day): ");
        d = scanner.nextInt();
        bipolar += d;

        System.out.print(
                "Over the past 2 weeks, have you experienced a significant change in your sleep patterns, such as needing less sleep than usual or feeling rested after only a few hours of sleep? (0 = no change, 10 = significant change): ");
        d = scanner.nextInt();
        bipolar += d;

        if (bipolar > 21) {
            bipolar = 1;
        } else {
            bipolar = 0;
        }

        // Schizophrenia
        System.out.print("How often do you experience hallucinations or delusions? (rated on a scale of 1-10): ");
        d = scanner.nextInt();
        schiz += d;

        System.out.print(
                "Have you noticed changes in your ability to concentrate or remember things? (rated on a scale of 1-10): ");
        d = scanner.nextInt();
        schiz += d;

        System.out.print(
                "Have you experienced a decline in your ability to function at work or in social situations? (rated on a scale of 1-10): ");
        d = scanner.nextInt();
        schiz += d;

        if (schiz > 21) {
            schiz = 1;
        } else {
            schiz = 0;
        }

        // OCD
        System.out.print(
                "How often do you experience intrusive, unwanted, and repetitive thoughts or images that cause anxiety or distress? (rated on a scale of 1-10): ");
        d = scanner.nextInt();
        ocd += d;

        System.out.print(
                "How often do you feel compelled to perform certain behaviors or mental acts to reduce anxiety or prevent a feared outcome? (rated on a scale of 1-10): ");
        d = scanner.nextInt();
        ocd += d;

        System.out.print(
                "Have these obsessions and compulsions interfered with your daily life, relationships, or work? (rated on a scale of 1-10): ");
        d = scanner.nextInt();

        if (ocd > 21) {
            ocd = 1;
        } else {
            ocd = 0;
        }
    }

    public int putDepression() {
        return depression;
    }

    public int putAnxiety() {
        return anxiety;
    }

    public int putBipolar() {
        return bipolar;
    }

    public int putSchiz() {
        return schiz;
    }

    public int putOcd() {
        return ocd;
    }

    public int putCount() {
        return checkupCounter;
    }
}

class Person extends Illness {
    protected String name;
    protected int age;
    protected String occ;
    protected String gender;
    protected String disease = " ";

    public void getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
    }

    public void getAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        age = scanner.nextInt();
    }

    public void getGender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select one of the options listed below");
        System.out.println("[1] Male");
        System.out.println("[2] Female");
        System.out.println("[3] Others:");
        int n = scanner.nextInt();
        if (n == 1) {
            gender = "Male";
        } else if (n == 2) {
            gender = "Female";
        } else {
            gender = "Others";
        }
    }

    public void getOcc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select one of the options listed below");
        System.out.println("[1] Student");
        System.out.println("[2] Earning individual");
        System.out.println("[3] Prefer not to disclose:");
        int n = scanner.nextInt();
        if (n == 1) {
            occ = "Student";
        } else if (n == 2) {
            occ = "Earning Individual";
        } else {
            occ = "Not Disclosed";
        }
    }

    public void result() {
        if (putDepression() == 1) {
            disease = disease + ", Depression";
        }

        if (putAnxiety() == 1) {
            disease = disease + ", Anxiety Disorder";
        }

        if (putBipolar() == 1) {
            disease = disease + ", Bipolar";
        }

        if (putSchiz() == 1) {
            disease = disease + ", Schizophrenia";
        }

        if (putOcd() == 1) {
            disease = disease + ", OCD";
        }
    }

    public void details() {
        System.out.println("Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nOccupation: " + occ);
    }

    public void showDis() {
        System.out.println(disease);
    }

    public String putName() {
        return name;
    }
}

class Data {
    public void disDepression() {
        System.out.println(
                "Depression: Symptoms may include persistent sadness, loss of interest in activities, feelings of hopelessness or worthlessness, sleep disturbances, fatigue, changes in appetite, and difficulty concentrating. To help reduce depression, individuals may benefit from therapy, medication, regular exercise, a healthy diet, and social support.");
    }

    public void disAnxiety() {
        System.out.println(
                "Anxiety disorders: Symptoms may include excessive worry, restlessness, irritability, difficulty concentrating, and physical symptoms such as sweating or trembling. To help reduce anxiety, individuals may benefit from therapy, medication, mindfulness techniques such as meditation or deep breathing exercises, regular exercise, and limiting caffeine and alcohol intake.");
    }

    public void disBipolar() {
        System.out.println(
                "Bipolar disorder: Symptoms may include mood swings between periods of high energy (mania) and periods of depression. To help reduce bipolar symptoms, individuals may benefit from therapy, medication, and developing a regular routine for sleep and exercise.");
    }

    public void disSchizophrenia() {
        System.out.println(
                "Schizophrenia: Symptoms may include delusions, hallucinations, disordered thinking, and social withdrawal. To help reduce schizophrenia symptoms, individuals may benefit from medication, therapy, and support from family and friends.");
    }

    public void disOcd() {
        System.out.println(
                "Obsessive-compulsive disorder (OCD): Symptoms may include intrusive, repetitive thoughts or urges (obsessions) that lead to compulsive behaviors or actions. To help reduce OCD symptoms, individuals may benefit from therapy, medication, and exposure and response prevention (ERP) techniques that gradually expose them to feared situations without engaging in compulsive behaviors.");
    }
}

class Service extends Person {
    public void display() {
        // Your display code here
    }

    Service(String dbname, int dbAge, String dbgender, String dbocc, int dbanxiety, int dbocd, int dbschiz,
            int dbbipolar,
            int dbdepression) {
        name = dbname;
        age = dbAge;
        occ = dbocc;
        gender = dbgender;
        anxiety = dbanxiety;
        ocd = dbocd;
        schiz = dbschiz;
        bipolar = dbbipolar;
        depression = dbdepression;

        if (anxiety == 1 && ocd == 1 && schiz == 1 && bipolar == 1 && depression == 1) {
            checkupCounter = 1;
        }
    }

    public void save() {
        if (putCount() == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("To save data you must take the test\nWould you like to take the test now? (y/n): ");
            char ch = scanner.next().charAt(0);

            if (ch == 'y') {
                checkup();
                save();
            }
        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(putName() + ".txt"));
                writer.write("=================RESULT=================\n");
                writer.write("Name: " + name + "\nAge: " + age + "\nGender: " + gender + "\nOccupation: " + occ + "\n");
                writer.write("========================================\n");
                writer.write("Illness Diagnosed: " + disease + "\n");
                writer.write("========================================\n");

                if (putDepression() == 1) {
                    writer.write(
                            "Depression: Symptoms may include persistent sadness, loss of interest in activities, feelings of hopelessness or worthlessness, sleep disturbances, fatigue, changes in appetite, and difficulty concentrating. To help reduce depression, individuals may benefit from therapy, medication, regular exercise, a healthy diet, and social support.\n\n");
                }

                if (putAnxiety() == 1) {
                    writer.write(
                            "Anxiety disorders: Symptoms may include excessive worry, restlessness, irritability, difficulty concentrating, and physical symptoms such as sweating or trembling. To help reduce anxiety, individuals may benefit from therapy, medication, mindfulness techniques such as meditation or deep breathing exercises, regular exercise, and limiting caffeine and alcohol intake.\n\n");
                }

                if (putBipolar() == 1) {
                    writer.write(
                            "Bipolar disorder: Symptoms may include mood swings between periods of high energy (mania) and periods of depression. To help reduce bipolar symptoms, individuals may benefit from therapy, medication, and developing a regular routine for sleep and exercise.\n\n");
                }

                if (putSchiz() == 1) {
                    writer.write(
                            "Schizophrenia: Symptoms may include delusions, hallucinations, disordered thinking, and social withdrawal. To help reduce schizophrenia symptoms, individuals may benefit from medication, therapy, and support from family and friends.\n\n");
                }

                if (putOcd() == 1) {
                    writer.write(
                            "Obsessive-compulsive disorder (OCD): Symptoms may include intrusive, repetitive thoughts or urges (obsessions) that lead to compulsive behaviors or actions. To help reduce OCD symptoms, individuals may benefit from therapy, medication, and exposure and response prevention (ERP) techniques that gradually expose them to feared situations without engaging in compulsive behaviors.\n\n");
                }

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class DatabaseConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/PID";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";

    private static Connection connection;

    public static Connection connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner Sc = new Scanner(System.in);
        Service Obj;
        int startPageSelection, flag = 1;
        Connection connection = DatabaseConnector.connect();
        Statement insertStatement = connection.createStatement();
        Statement selectStatement = connection.createStatement();
        Statement statement = connection.createStatement();
        String username, password, query;
        int contactNo;
        do {
            Intro();
            System.out.println("[1]To Login");
            System.out.println("[2]To Signup");
            System.out.println("[0]To Exit:");
            startPageSelection = Sc.nextInt();
            switch (startPageSelection) {

                case 1:
                    System.out.print("Enter Username:");
                    username = Sc.nextLine();
                    System.out.println("Enter Password:");
                    password = Sc.nextLine();
                    query = "SELECT 1 FROM mentalHealthDatabase WHERE username=" + username + "AND password="
                            + password;
                    ResultSet resultSet = selectStatement.executeQuery(query);
                    int check = resultSet.getInt("1");
                    if (check == 1) {
                        query = "Select * from mentalHealthDatabase where username=" + username;
                        resultSet = selectStatement.executeQuery(query);
                        Obj = new Service(resultSet.getString("Name"), resultSet.getInt("Age"),
                                resultSet.getString("Gender"), resultSet.getString("Occupation"),
                                resultSet.getInt("Anxiety"), resultSet.getInt("Ocd"), resultSet.getInt("Schiz"),
                                resultSet.getInt("Bipolar"), resultSet.getInt("Depression"));
                        app(Obj, 1, insertStatement);
                    } else {
                        System.out.println("Invalid Username or Password :(");
                        System.out.println("Forgot password?(y/n):");
                        char fp = Sc.next().charAt(0);
                        if (fp == 'y') {
                            System.out.print("Enter Username:");
                            username = Sc.nextLine();
                            query = "Select 1 from mentalHealthDatabase where username=" + username;
                            resultSet = selectStatement.executeQuery(query);
                            check = resultSet.getInt("1");
                            if (check == 1) {
                                System.out.println("Enter Contact Number:");
                                contactNo = Sc.nextInt();
                                query = "Select 1 from mentalHealthDatabase where username=" + username
                                        + "and contactNo=" + contactNo;
                                resultSet = selectStatement.executeQuery(query);
                                check = resultSet.getInt("1");
                                if (check == 1) {
                                    query = "Select password from mentalHealthDatabase where username=" + username;
                                    resultSet = selectStatement.executeQuery(query);
                                    password = resultSet.getString("password");
                                    System.out.println("Your password is '" + password + "'");
                                }

                            } else {
                                System.out.println("Invalid Contact No !");

                            }

                        }

                    }
                    break;

                case 2:
                    System.out.print("Enter Username:");
                    username = Sc.nextLine();
                    query = "Select Name from mentalHealthDatabase";
                    resultSet = selectStatement.executeQuery(query);
                    int innerflag = 0;
                    while (resultSet.next()) {
                        String name = resultSet.getString("Name");
                        if (name.equals(username)) {
                            innerflag = 1;
                        }
                    }
                    if (flag == 1) {
                        System.out.println("Username already exists!");
                    } else {
                        System.out.print("Enter password:");
                        password = Sc.nextLine();
                        query = "insert into mentalHealthDatabase(Name, Password) values (" + username + "," + password
                                + ")";
                        insertStatement.executeUpdate(query);
                    }
                    break;

                case 0:
                    flag = 0;
                    break;

                default:
                    System.out.println("Invalid");
                    break;

            }
        } while (flag == 1);

    }

    public static void app(Service Obj, int exist, Statement st) {
        int flag = 1, appSelection;
        Scanner Sc = new Scanner(System.in);

        do {
            System.out.println("[1]To fill user details");
            System.out.println("[2]To take test");
            System.out.println("[3]To display the result");
            System.out.println("[4]To Save it");
            System.out.println("[0]To logout");
            appSelection = Sc.nextInt();

            switch (appSelection) {
                case 1:
                    if (exist == 0) {
                        Obj.getName();
                        Obj.getAge();
                        Obj.getGender();
                        Obj.getOcc();
                    } else {
                        System.out.println("Your details already exists\n Would you like to update it?");
                        char ch;
                        ch = Sc.next().charAt(0);
                        if (ch == 'y') {
                            Obj.getName();
                            Obj.getAge();
                            Obj.getGender();
                            Obj.getOcc();

                        }
                    }
                    break;

                case 2:
                    Obj.checkup();
                    Obj.result();
                    break;

                case 3:
                    Obj.result();
                    Obj.display();
                    break;

                case 0:
                    Obj.save();
                    flag = 0;
                    break;

                default:
                    System.out.println("Invalid Choice !");
                    break;
            }

        } while (flag == 1);

    }

    public static void Intro() {
        System.out.println("**********************************************************************");
        System.out.println("*                                                                    *");
        System.out.println("*             SELF IDENIFYING MENTAL HEALTH STATUS                   *");
        System.out.println("*                 AND GET GUIDANCE FOR SUPPORT                       *");
        System.out.println("*                    bY AAYUSH SRIVASTAVA                            *");
        System.out.println("*                                                                    *");
        System.out.println("**********************************************************************");
    }

}
