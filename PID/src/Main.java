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

    public void checkup() throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        checkupCounter = 1;
        int d = 0;
        System.out.println("***********************************************");
        System.out.println("* Answer the following 15 questions on a      *");
        System.out.println("* scale of 1 to 10                            *");
        System.out.println("***********************************************");

        // Depression
        System.out.print(
                "Over the past 2 weeks, how often have you felt down, depressed, or hopeless? (0 = not at all, 10 = every day): ");
        d = Integer.parseInt(reader.readLine());
        depression += d;

        System.out.print(
                "Over the past 2 weeks, how often have you lost interest or pleasure in doing things? (0 = not at all, 10 = every day): ");
        d = Integer.parseInt(reader.readLine());
        depression += d;

        System.out.print(
                "Over the past 2 weeks, how often have you experienced difficulties sleeping, such as trouble falling asleep, staying asleep, or waking up too early? (0 = not at all, 10 = every day): ");
        d = Integer.parseInt(reader.readLine());
        depression += d;

        if (depression > 21) {
            depression = 1;
        } else {
            depression = 0;
        }

        // Anxiety
        System.out.print(
                "Over the past 2 weeks, how often have you felt anxious, nervous, or on edge? (0 = not at all, 10 = every day): ");
        d = Integer.parseInt(reader.readLine());
        anxiety += d;

        System.out.print(
                "Over the past 2 weeks, how often have you felt panicked or experienced sudden feelings of terror? (0 = not at all, 10 = every day): ");
        d = Integer.parseInt(reader.readLine());
        anxiety += d;

        System.out.print(
                "Over the past 2 weeks, how often have you experienced physical symptoms of anxiety, such as sweating, trembling, or a racing heart? (0 = not at all, 10 = every day): ");
        d = Integer.parseInt(reader.readLine());
        anxiety += d;

        if (anxiety > 21) {
            anxiety = 1;
        } else {
            anxiety = 0;
        }

        // Bipolar
        System.out.print(
                "Over the past 2 weeks, how often have you experienced an unusually elevated or irritable mood, with increased energy or activity levels? (0 = not at all, 10 = every day): ");
        d = Integer.parseInt(reader.readLine());
        bipolar += d;

        System.out.print(
                "Over the past 2 weeks, how often have you experienced periods of depression, with feelings of sadness, hopelessness, or loss of interest in activities? (0 = not at all, 10 = every day): ");
        d = Integer.parseInt(reader.readLine());
        bipolar += d;

        System.out.print(
                "Over the past 2 weeks, have you experienced a significant change in your sleep patterns, such as needing less sleep than usual or feeling rested after only a few hours of sleep? (0 = no change, 10 = significant change): ");
        d = Integer.parseInt(reader.readLine());
        bipolar += d;

        if (bipolar > 21) {
            bipolar = 1;
        } else {
            bipolar = 0;
        }

        // Schizophrenia
        System.out.print("How often do you experience hallucinations or delusions? (rated on a scale of 1-10): ");
        d = Integer.parseInt(reader.readLine());
        schiz += d;

        System.out.print(
                "Have you noticed changes in your ability to concentrate or remember things? (rated on a scale of 1-10): ");
        d = Integer.parseInt(reader.readLine());
        schiz += d;

        System.out.print(
                "Have you experienced a decline in your ability to function at work or in social situations? (rated on a scale of 1-10): ");
        d = Integer.parseInt(reader.readLine());
        schiz += d;

        if (schiz > 21) {
            schiz = 1;
        } else {
            schiz = 0;
        }

        // OCD
        System.out.print(
                "How often do you experience intrusive, unwanted, and repetitive thoughts or images that cause anxiety or distress? (rated on a scale of 1-10): ");
        d = Integer.parseInt(reader.readLine());
        ocd += d;

        System.out.print(
                "How often do you feel compelled to perform certain behaviors or mental acts to reduce anxiety or prevent a feared outcome? (rated on a scale of 1-10): ");
        d = Integer.parseInt(reader.readLine());
        ocd += d;

        System.out.print(
                "Have these obsessions and compulsions interfered with your daily life, relationships, or work? (rated on a scale of 1-10): ");
        d = Integer.parseInt(reader.readLine());

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
    protected String username;
    protected int age;
    protected String occ;
    protected String gender;
    protected String disease = " ";
    Scanner scanner = new Scanner(System.in);

    public String putUserName() {
        return username;
    }

    public int putAge() {
        return age;
    }

    public String putOcc() {
        return occ;
    }

    public String putGender() {
        return gender;
    }

    public void getName() {

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

    }

    public void getAge() {

        System.out.print("Enter your age: ");
        age = scanner.nextInt();

    }

    public void getGender() {
        // try (Scanner scanner = new Scanner(System.in)) {
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
        // }
    }

    public void getOcc() {
        // try (Scanner scanner = new Scanner(System.in)) {
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
        // }
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
    public static void disDepression() {
        System.out.println(
                "Depression: Symptoms may include persistent sadness, loss of interest in activities, feelings of hopelessness or worthlessness, sleep disturbances, fatigue, changes in appetite, and difficulty concentrating. To help reduce depression, individuals may benefit from therapy, medication, regular exercise, a healthy diet, and social support.");
    }

    public static void disAnxiety() {
        System.out.println(
                "Anxiety disorders: Symptoms may include excessive worry, restlessness, irritability, difficulty concentrating, and physical symptoms such as sweating or trembling. To help reduce anxiety, individuals may benefit from therapy, medication, mindfulness techniques such as meditation or deep breathing exercises, regular exercise, and limiting caffeine and alcohol intake.");
    }

    public static void disBipolar() {
        System.out.println(
                "Bipolar disorder: Symptoms may include mood swings between periods of high energy (mania) and periods of depression. To help reduce bipolar symptoms, individuals may benefit from therapy, medication, and developing a regular routine for sleep and exercise.");
    }

    public static void disSchizophrenia() {
        System.out.println(
                "Schizophrenia: Symptoms may include delusions, hallucinations, disordered thinking, and social withdrawal. To help reduce schizophrenia symptoms, individuals may benefit from medication, therapy, and support from family and friends.");
    }

    public static void disOcd() {
        System.out.println(
                "Obsessive-compulsive disorder (OCD): Symptoms may include intrusive, repetitive thoughts or urges (obsessions) that lead to compulsive behaviors or actions. To help reduce OCD symptoms, individuals may benefit from therapy, medication, and exposure and response prevention (ERP) techniques that gradually expose them to feared situations without engaging in compulsive behaviors.");
    }
}

class Service extends Person {
    public void display() {
        System.out.println("======================RESULT======================");
        details();
        System.out.println("==================================================");
        System.out.print("Illness Diagnosed: ");
        showDis();
        System.out.println("\n==================================================");

        if (putDepression() == 1) {
            Data.disDepression();
            System.out.println();
        }

        if (putAnxiety() == 1) {
            Data.disAnxiety();
            System.out.println();
        }

        if (putBipolar() == 1) {
            Data.disBipolar();
            System.out.println();
        }

        if (putSchiz() == 1) {
            Data.disSchizophrenia();
            System.out.println();
        }

        if (putOcd() == 1) {
            Data.disOcd();
            System.out.println();
        }
    }

    Service(String dbUserName, String dbname, int dbAge, String dbgender, String dbocc, int dbanxiety, int dbocd,
            int dbschiz,
            int dbbipolar,
            int dbdepression) {
        username = dbUserName;
        name = dbname;
        age = dbAge;
        occ = dbocc;
        gender = dbgender;
        anxiety = dbanxiety;
        ocd = dbocd;
        schiz = dbschiz;
        bipolar = dbbipolar;
        depression = dbdepression;

        if (anxiety == -1 || ocd == -1 || schiz == -1 || bipolar == -1 || depression == -1) {
            checkupCounter = 0;
        } else {
            checkupCounter = 1;
        }
    }

    public void save() throws NumberFormatException, IOException {
        if (putCount() == 0) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("To save data you must take the test\nWould you like to take the test now? (y/n): ");
                char ch = scanner.next().charAt(0);

                if (ch == 'y') {
                    checkup();
                    save();
                }
            }
        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(putUserName() + ".txt"));
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

class Main {
    public static void main(String[] args) throws SQLException, IOException {
        login_PAGE();
    }

    public static void login_PAGE() {
        try (
                Connection connection = DatabaseConnector.connect();
                Statement insertStatement = connection.createStatement();
                Statement selectStatement = connection.createStatement();
                Statement statement = connection.createStatement();) {

            try (Scanner sc = new Scanner(System.in)) {
                Service obj;
                int startPageSelection, check;
                String username, password, query;
                int contactNo;
                Intro();
                System.out.println("[1]To Login");
                System.out.println("[2]To Signup");
                System.out.println("[0]To Exit:");
                startPageSelection = sc.nextInt();
                sc.nextLine();

                switch (startPageSelection) {
                    case 1:
                        System.out.print("Enter Username:");
                        username = sc.nextLine();
                        System.out.print("Enter Password:");
                        password = sc.nextLine();
                        query = "SELECT 1 FROM mentalHealthDatabase WHERE username=? AND password=?";
                        try (PreparedStatement loginStatement = connection.prepareStatement(query)) {
                            loginStatement.setString(1, username);
                            loginStatement.setString(2, password);
                            try (ResultSet resultSet = loginStatement.executeQuery()) {
                                if (resultSet.next()) {
                                    check = resultSet.getInt(1);
                                } else {
                                    check = 0;
                                }

                                if (check == 1) {
                                    query = "SELECT * FROM mentalHealthDatabase WHERE username=?";
                                    try (PreparedStatement selectUserStatement = connection
                                            .prepareStatement(query)) {
                                        selectUserStatement.setString(1, username);
                                        try (ResultSet userResultSet = selectUserStatement.executeQuery()) {
                                            if (userResultSet.next()) {
                                                obj = new Service(userResultSet.getString("username"),
                                                        userResultSet.getString("Name"),
                                                        userResultSet.getInt("Age"),
                                                        userResultSet.getString("Gender"),
                                                        userResultSet.getString("Occupation"),
                                                        userResultSet.getInt("Anxiety"),
                                                        userResultSet.getInt("Ocd"),
                                                        userResultSet.getInt("Schiz"),
                                                        userResultSet.getInt("Bipolar"),
                                                        userResultSet.getInt("Depression"));
                                                app(obj, connection);
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Invalid Username or Password :(");
                                    System.out.println("Forgot password?(y/n):");
                                    char fp = sc.next().charAt(0);
                                    if (fp == 'y') {
                                        sc.nextLine();
                                        System.out.print("Enter Username:");
                                        username = sc.nextLine();
                                        query = "SELECT 1 FROM mentalHealthDatabase WHERE username=? ";
                                        try (PreparedStatement forgotPasswordStatement = connection
                                                .prepareStatement(query)) {
                                            forgotPasswordStatement.setString(1, username);
                                            try (ResultSet forgotPasswordResultSet = forgotPasswordStatement
                                                    .executeQuery()) {
                                                if (forgotPasswordResultSet.next()) {
                                                    check = forgotPasswordResultSet.getInt(1);
                                                } else {
                                                    check = 0;
                                                }
                                                if (check == 1) {
                                                    System.out.print("Enter Contact Number:");
                                                    contactNo = sc.nextInt();
                                                    query = "SELECT 1 FROM mentalHealthDatabase WHERE username=? AND contactNo=?";
                                                    try (PreparedStatement contactCheckStatement = connection
                                                            .prepareStatement(query)) {
                                                        contactCheckStatement.setString(1, username);
                                                        contactCheckStatement.setInt(2, contactNo);
                                                        try (ResultSet contactCheckResultSet = contactCheckStatement
                                                                .executeQuery()) {
                                                            if (contactCheckResultSet.next()) {
                                                                check = contactCheckResultSet.getInt(1);
                                                            } else {
                                                                check = 0;
                                                            }
                                                            if (check == 1) {
                                                                query = "SELECT password FROM mentalHealthDatabase WHERE username=?";
                                                                try (PreparedStatement getPasswordStatement = connection
                                                                        .prepareStatement(query)) {
                                                                    getPasswordStatement.setString(1, username);
                                                                    try (ResultSet passwordResultSet = getPasswordStatement
                                                                            .executeQuery()) {
                                                                        if (passwordResultSet.next()) {
                                                                            password = passwordResultSet
                                                                                    .getString("password");
                                                                            System.out.println("Your password is '"
                                                                                    + password + "'");
                                                                            login_PAGE();
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                System.out.println("Invalid Contact No!");
                                                                login_PAGE();
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Invalid Username!");
                                                }
                                            }
                                        }
                                    } else {
                                        login_PAGE();
                                    }
                                }
                            }
                        }
                        break;

                    case 2:
                        signup(selectStatement, connection);

                        break;

                    case 0:
                        System.exit(0);
                        // main(args);
                        break;

                    default:
                        System.out.println("Invalid");
                        login_PAGE();
                        break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void signup(Statement selectStatement, Connection connection) throws SQLException {
        System.out.print("Enter Username:");
        try (Scanner sc = new Scanner(System.in)) {
            String username = sc.nextLine();
            String query = "Select username from mentalHealthDatabase";
            ResultSet resultSet = selectStatement.executeQuery(query);
            int innerflag = 0;
            while (resultSet.next()) {
                String name = resultSet.getString("username");
                if (name.equals(username)) {
                    innerflag = 1;
                }
            }
            if (innerflag == 1) {
                System.out.println("Username already exists!");
                login_PAGE();
            } else {
                System.out.print("Enter password:");
                String password = sc.nextLine();

                System.out.print("Enter Contact No.:");
                String contactInput = sc.nextLine();
                try {
                    int contactNo = Integer.parseInt(contactInput);

                    query = "INSERT INTO mentalHealthDatabase(username, Password, contactNo) VALUES (?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, username);
                        preparedStatement.setString(2, password);
                        preparedStatement.setInt(3, contactNo);
                        preparedStatement.executeUpdate();
                    }
                    login_PAGE();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for Contact No.");
                    login_PAGE();
                }
            }
        }
    }

    public static void app(Service obj, Connection connection) {
        int appSelection, exist = 0;
        String query = "SELECT Name FROM mentalHealthDatabase WHERE username=?";

        try (PreparedStatement nameCheckStatement = connection.prepareStatement(query)) {
            nameCheckStatement.setString(1, obj.putUserName());

            try (ResultSet nameCheck = nameCheckStatement.executeQuery()) {
                if (nameCheck.next()) {
                    if ("-".equals(nameCheck.getString("Name"))) {
                        exist = 0;
                    } else {
                        exist = 1;
                    }
                }
            }

            try (Scanner scanner = new Scanner(System.in)) {

                System.out.println("[1]To fill user details");
                System.out.println("[2]To take the test");
                System.out.println("[3]To display the result");
                System.out.println("[4]To Save it");
                System.out.println("[0]To logout");
                appSelection = scanner.nextInt();

                switch (appSelection) {
                    case 1:
                        if (exist == 0) {
                            objInfoFill(obj);
                            exist = 1;
                        } else {
                            System.out.println("Your details already exist\n Would you like to update it?");
                            char ch = scanner.next().charAt(0);
                            if (ch == 'y') {
                                objInfoFill(obj);
                            } else {
                                app(obj, connection);
                            }
                        }
                        query = "UPDATE mentalHealthDatabase SET Name=?, Age=?, Gender=?,Occupation=? where username=?";
                        try (PreparedStatement infoFillStatement = connection.prepareStatement(query)) {
                            infoFillStatement.setString(1, obj.putName());
                            infoFillStatement.setInt(2, obj.putAge());
                            infoFillStatement.setString(3, obj.putGender());
                            infoFillStatement.setString(4, obj.putOcc());
                            infoFillStatement.setString(5, obj.putUserName());
                            infoFillStatement.executeUpdate();
                        }
                        app(obj, connection);
                        break;

                    case 2:
                        check_and_save(obj, connection);
                        app(obj, connection);
                        break;

                    case 3:
                        obj.result();
                        obj.display();
                        app(obj, connection);
                        break;

                    case 4:
                        obj.save();
                        app(obj, connection);
                        break;

                    case 0:
                        System.out.println("Logging out...");
                        login_PAGE();
                        break;

                    default:
                        System.out.println("Invalid Choice !");
                        app(obj, connection);
                        break;
                }
            }
        }

        catch (

        Exception e) {

            e.printStackTrace();
        }
    }

    private static void check_and_save(Service obj, Connection connection) throws NumberFormatException, IOException {
        obj.checkup();
        obj.result();
        String query = "UPDATE mentalHealthDatabase SET anxiety=?, depression=?, schiz=?, ocd=?,bipolar=? where username=?";
        try (PreparedStatement disfillStatement = connection.prepareStatement(query)) {
            disfillStatement.setInt(1, obj.putAnxiety());
            disfillStatement.setInt(2, obj.putDepression());
            disfillStatement.setInt(3, obj.putSchiz());
            disfillStatement.setInt(4, obj.putOcd());
            disfillStatement.setInt(5, obj.putBipolar());
            disfillStatement.setString(6, obj.putUserName());
            disfillStatement.executeUpdate();
            app(obj, connection);
        } catch (Exception e) {
            e.printStackTrace();

        }
        // obj.display();
    }

    public static void objInfoFill(Service obj) {
        obj.getName();
        obj.getAge();
        obj.getGender();
        obj.getOcc();
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