package noGraphic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

    public class ReadWriteFile {
        public static ArrayList <Users> ReadUsers() {
            ArrayList <Users> users = new ArrayList <>();
            try {
                File myObj = new File("Users.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String[] data = myReader.nextLine().split("\\s");
                    Users addUsers = new Users(data[0], data[1], Integer.parseInt(data[2]));
                    users.add(addUsers);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return users;
        }

        public static void WriteUsers(Users user) {
            try {
                ArrayList <Users> usersArrayList;
                usersArrayList = ReadUsers();
                usersArrayList.add(user);
                FileWriter myWriter = new FileWriter("Users.txt");
                for (int i = 0; i < usersArrayList.size(); i++) {
                    myWriter.write(usersArrayList.get(i).getUserName());
                    myWriter.write(" ");
                    myWriter.write(usersArrayList.get(i).getPassWord());
                    myWriter.write(" ");
                    myWriter.write(String.valueOf(usersArrayList.get(i).getMaxLevel()));
                    myWriter.write("\r\n");
                }
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void addMaxLevel(Users user) {
            try {
                ArrayList <Users> usersArrayList;
                usersArrayList = ReadUsers();
                FileWriter myWriter = new FileWriter("Users.txt");
                for (int i = 0; i < usersArrayList.size(); i++) {
                    if (usersArrayList.get(i).getUserName().equals(user.getUserName())){
                        myWriter.write(usersArrayList.get(i).getUserName());
                        myWriter.write(" ");
                        myWriter.write(usersArrayList.get(i).getPassWord());
                        myWriter.write(" ");
                        myWriter.write(String.valueOf(usersArrayList.get(i).getMaxLevel())+1);
                        myWriter.write("\r\n");
                    }else{
                    myWriter.write(usersArrayList.get(i).getUserName());
                    myWriter.write(" ");
                    myWriter.write(usersArrayList.get(i).getPassWord());
                    myWriter.write(" ");
                    myWriter.write(String.valueOf(usersArrayList.get(i).getMaxLevel()));
                    myWriter.write("\r\n");

                    }
                }
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        public static ArrayList <String> ReadLogger() {
            ArrayList <String> loggers = new ArrayList <>();
            try {
                File myObj = new File("Logger.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String logger = myReader.nextLine();
                    loggers.add(logger);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return loggers;

        }

        public static void WriteLogger(Boolean info, String action) {
            ArrayList <String> loggers = new ArrayList <>();
            loggers = ReadLogger();
            try {

                String Error = "Error";
                if (info) {
                    Error = "Info";
                }

                LocalDateTime localDateTime = LocalDateTime.now();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy - HH:mm:ss");
                String formattedDate = localDateTime.format(dateTimeFormatter);

                loggers.add("[" + Error + "], " + formattedDate + ", " + action);

                FileWriter myWriter = new FileWriter("Logger.txt");
                for (int i = 0; i < loggers.size(); i++) {
                    myWriter.write(loggers.get(i));
                    myWriter.write("\r\n");
                }
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        public static HashMap <String, Integer> ReadMissionsAnimals(int mission) {
            HashMap <String, Integer> missionAnimal = new HashMap <>();
            try {
                File myObj = new File("Mission.txt");
                Scanner myReader = new Scanner(myObj);

                while (myReader.hasNextLine()) {
                    String[] data = myReader.nextLine().split("\\s");
                    if (data[0].startsWith("Animal"))
                        missionAnimal.put(data[1], Integer.parseInt(data[2 + mission]));
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return missionAnimal;
        }

        public static HashMap <String, Integer> ReadMissionsProducts(int mission) {
            HashMap <String, Integer> missionProduct = new HashMap <>();
            try {
                File myObj = new File("Mission.txt");
                Scanner myReader = new Scanner(myObj);

                while (myReader.hasNextLine()) {
                    String[] data = myReader.nextLine().split("\\s");
                    if (data[0].startsWith("Product"))
                        missionProduct.put(data[1], Integer.parseInt(data[2 + mission]));
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return missionProduct;
        }

        public static int ReadMissionsCoin(int mission) {
            int coin = 0;
            try {
                File myObj = new File("Mission.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String[] data = myReader.nextLine().split("\\s");
                    if (data[0].startsWith("Coin"))
                        coin = Integer.parseInt(data[1 + mission]);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            }
            return coin;
        }

        public static HashMap <String, ArrayList <Integer>> ReadMissionWildAnimal(int mission) {
            HashMap <String, ArrayList <Integer>> wildAnimals = new HashMap <>();
            try {
                File myObj = new File("Mission.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String[] data = myReader.nextLine().split("\\s");
                    if (data[0].startsWith("WildAnimals")) {
                        ArrayList <Integer> numbers = new ArrayList <>();
                        for (int i = 0; i < Integer.parseInt(data[3]); i++) {
                            numbers.add(Integer.parseInt(data[4 + i]));
                        }
                        wildAnimals.put(data[1], numbers);
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return wildAnimals;
        }

        public static int[] ReadMissionTime(int mission) {
            int[] missionTime = new int[2];
            try {
                File myObj = new File("Mission.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String[] data = myReader.nextLine().split("\\s");
                    if (data[0].startsWith("Time")) {
                        missionTime[0] = Integer.parseInt(data[2 * (mission - 1) + 1]);
                        missionTime[1] = Integer.parseInt(data[2 * (mission - 1) + 2]);
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return missionTime;
        }

        public static int ReadMissions() {
            int missions = 0;
            try {

                File myObj = new File("Mission.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String[] data = myReader.nextLine().split("\\s");
                    if (data[0].startsWith("Missions")) {
                        missions = Integer.parseInt(data[2]);
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return missions;
        }
    }
