package com.mycompany.calculater;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Main {


    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {



        ImageIcon image = new ImageIcon("src/com/company/icon1.png");
        Object[] options = {
                "Calculator", //0
                "Unit Converter", //1
                "Machine Converter", //2
                "Hash Encryption", //3
                "Hash Decryption ☠ 🐉", //4
                "Exit!" //5
        };

        boolean flag = true;
        while (flag) {


            int n = JOptionPane.showOptionDialog(null,
                    "Choose your type converter!",
                    "A Silly Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[5]);


            if (n == 0) {
                String[] cal_option = {"Calculator", "Square root", "Power", "Go Back"};

                String select_option = (String) JOptionPane.showInputDialog(null, "Choose please!",
                        "Calculator", JOptionPane.INFORMATION_MESSAGE, image, cal_option, cal_option[0]);


                System.out.println(select_option);
                if (select_option.equals("Calculator")) {
                    String num1 = JOptionPane.showInputDialog("Enter first number: ");
                    String operate = JOptionPane.showInputDialog("Enter operation ");
                    String num2 = JOptionPane.showInputDialog("Enter second number: ");
                    Double intNum1 = Double.parseDouble(num1);
                    Double intNum2 = Double.parseDouble(num2);

                    Double result = calculator(intNum1, intNum2, operate);
                    JOptionPane.showMessageDialog(null, "Result: " + result);

                } else if (select_option.equals("Square root")) {
                    String number = JOptionPane.showInputDialog("please Enter Number to find a square root : ");
                    Double intNumber = Double.parseDouble(number);
                    JOptionPane.showMessageDialog(null, "Result : " + SquarerRoot(intNumber));

                } else if (select_option.equals("Power")) {
                    String base = JOptionPane.showInputDialog("Enter base ");
                    String pow = JOptionPane.showInputDialog("Enter power ");
                    int baseInt = Integer.parseInt(base);
                    int powInt = Integer.parseInt(pow);
                    JOptionPane.showMessageDialog(null, "Result: " + power(baseInt, powInt));

                }

            }
            else if (n == 1) {
                String[] unit_option = {"Km to Meter", "Meter to Km", "Meter to CM", "CM to Meter", "Celsius To Fahrenheit", "Fahrenheit To Celsius", "Go Back"};

                String select_option = (String) JOptionPane.showInputDialog(null, "Choose please!",
                        "Unit", JOptionPane.INFORMATION_MESSAGE, image, unit_option, unit_option[0]);

                if (select_option.equals("Km to Meter")) {
                    String number = JOptionPane.showInputDialog("converting Km to Meter : ");
                    double DNumber = Double.parseDouble(number);
                    JOptionPane.showMessageDialog(null, "Result : " + KMtoM(DNumber) + " M");


                } else if (select_option.equals("Meter to Km")) {
                    String number = JOptionPane.showInputDialog("converting Meter to Km : ");
                    double DNumber = Double.parseDouble(number);
                    JOptionPane.showMessageDialog(null, "Result : " + MtoKM(DNumber) + " Km");

                } else if (select_option.equals("Meter to CM")) {
                    String number = JOptionPane.showInputDialog("converting Meter to CM : ");
                    double DNumber = Double.parseDouble(number);
                    JOptionPane.showMessageDialog(null, "Result : " + MtoCm(DNumber) + " CM");

                } else if (select_option.equals("CM to Meter")) {
                    String number = JOptionPane.showInputDialog("converting CM to Meter: ");
                    Double DNumber = Double.parseDouble(number);
                    JOptionPane.showMessageDialog(null, "Result : " + CmToM(DNumber) + " M");

                } else if (select_option.equals("Celsius To Fahrenheit")) {
                    String degree = JOptionPane.showInputDialog("Converting Celsius To Fahrenheit: ");
                    double DoubleDegree = Double.parseDouble(degree);
                    JOptionPane.showMessageDialog(null, "Degree = " + CtoF(DoubleDegree) + "°F");

                } else if (select_option.equals("Converting Fahrenheit To Celsius")) {
                    String degree = JOptionPane.showInputDialog("Converting Fahrenheit To Celsius: ");
                    double DoubleDegree = Double.parseDouble(degree);
                    JOptionPane.showMessageDialog(null, "Degree = " + FtoC(DoubleDegree) + "°C");

                }


            }
            else if (n == 2) {
                String[] machine_option = {"Number to Binary", "Binary to Number", "Number to Hexadecimal", "Hexadecimal to Number", "Go Back"};

                String select_option = (String) JOptionPane.showInputDialog(null, "Choose please!",
                        "Unit", JOptionPane.INFORMATION_MESSAGE, image, machine_option, machine_option[0]);

                if (select_option.equals("Number to Binary")) {
                    String number = JOptionPane.showInputDialog("pleas Enter a number for Converting to Binary: ");
                    int intNumber = Integer.parseInt(number);
                    JOptionPane.showMessageDialog(null, "Result : " + IntToBinary(intNumber));

                } else if (select_option.equals("Binary to Number")) {
                    String number = JOptionPane.showInputDialog("pleas Enter a Binary for Converting to Decimal: ");
                    JOptionPane.showMessageDialog(null, "Result : " + BinaryToInt(number));

                } else if (select_option.equals("Number to Hexadecimal")) {
                    String number = JOptionPane.showInputDialog("Converting Number to Hexadecimal: ");
                    int intNumber = Integer.parseInt(number);
                    JOptionPane.showMessageDialog(null, "Result : " + IntToHex(intNumber));

                } else if (select_option.equals("Hexadecimal to Number")) {
                    String number = JOptionPane.showInputDialog("Converting Hexadecimal to Number: ");
                    JOptionPane.showMessageDialog(null, "Result : " + HexToInt(number));

                }
            }
            else if (n == 3) {
                String[] machine_option = {"MD5 Encryption", "SHA-256 Encryption", "Go Back"};
                String select_option = (String) JOptionPane.showInputDialog(null, "Choose please!",
                        "Cryptography", JOptionPane.INFORMATION_MESSAGE, image, machine_option, machine_option[0]);

                if(select_option.equals("MD5 Encryption")){
                    String text = JOptionPane.showInputDialog("Encrypting text : ");
                    JOptionPane.showMessageDialog(null,  "Hash value: "+md5Encryption(text));

                }else if(select_option.equals("SHA-256 Encryption")){
                    String text = JOptionPane.showInputDialog("Encrypting text : ");
                    JOptionPane.showMessageDialog(null,  "Hash value: "+sha256Encryption(text));
                    System.out.println(sha256Encryption(text));

                }

            }
            else if (n == 4) {
                String[] machine_option = {"MD5 Decryption", "SHA-256 Decryption", "Go Back"};
                String select_option = (String) JOptionPane.showInputDialog(null, "Choose please!",
                        "Cryptography", JOptionPane.INFORMATION_MESSAGE, image, machine_option, machine_option[0]);

                if(select_option.equals("MD5 Decryption")){
                    String text = JOptionPane.showInputDialog("Decryption text : ");
                    long start = System.nanoTime();
                    String result = md5Decryption(text);
                    long end = System.nanoTime();

                    long elapsedTime = (end - start);
                    long second = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
                    JOptionPane.showMessageDialog(null,  "Decrypt: "+result + "      |Total time:"+ second + " second");


                }else if(select_option.equals("SHA-256 Decryption")){
                    String text = JOptionPane.showInputDialog("Decryption text : ");
                    long start = System.nanoTime();
                    String result = sha256Decryption(text);
                    long end = System.nanoTime();

                    long elapsedTime = (end - start);
                    long second = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
                    JOptionPane.showMessageDialog(null,  "Decrypt: "+result + "      |Total time:"+ second + " second");


                }
            }
            else if (n == 5) {
                flag = false;
            }
            else {
                break;
            }
        }


    }



    public static Double calculator(Double num1, Double num2, String operate) {
        return switch (operate) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> null;
        };

    }

    public static Double power(int base, int pow) {
        return Math.pow(base, pow);
    }

    public static Double SquarerRoot(Double sqrt) {
        return Math.sqrt(sqrt);
    }

    public static String IntToBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public static int BinaryToInt(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public static Double CmToM(Double cm) {
        return cm * 0.01;
    }

    public static Double MtoCm(Double M) {
        return M / 0.01;
    }

    public static double CtoF(double celsius) {
        return celsius * (9.0 / 5) + 32;
    }

    public static double FtoC(double fahrenheit) {
        return ((fahrenheit - 32) * (5.0 / 9));
    }

    private static double KMtoM(double km) {
        return km * 1000;
    }

    private static double MtoKM(double meter) {
        return meter * 0.001;
    }

    private static String IntToHex(int number) {
        return Integer.toHexString(number);

    }

    private static int HexToInt(String hex) {
        return Integer.parseInt(hex, 16);

    }

    public static String md5Encryption(String input) throws NoSuchAlgorithmException {

        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(input.getBytes(), 0, input.length());
        String passHash = new BigInteger(1, m.digest()).toString(16);
        return passHash;
    }

    public static String sha256Encryption(String input) throws NoSuchAlgorithmException {

        MessageDigest m = MessageDigest.getInstance("SHA-256");
        m.update(input.getBytes(), 0, input.length());
        String passHash = new BigInteger(1, m.digest()).toString(16);
        return passHash;
    }

    private static String md5Decryption(String input) throws IOException, NoSuchAlgorithmException {

        String data = "";
        File file = new File("password.txt");
        Scanner scanFile = new Scanner(file);

        String pass;
        while (scanFile.hasNext()) {

            pass = scanFile.nextLine();
            String encryptPass = md5Encryption(pass);

            if (encryptPass.equals(input)) {
                data += pass + "," + encryptPass + "," + "MD5" + "\n";
                FileWriter writer = new FileWriter("data.txt");
                writer.append(data);
                writer.close();
                return pass;

            }
        }

        return "password isn't in wordlist!";
    }

    private static String sha256Decryption(String input) throws IOException, NoSuchAlgorithmException {

        File file = new File("password.txt");
        Scanner scanFile = new Scanner(file);

        String data = "";
        String pass ;
        while(scanFile.hasNext()){
            pass = scanFile.nextLine();
            String encryptPass = sha256Encryption(pass);

            if(input.equals(encryptPass)){
                data += pass + "," + encryptPass + "," + "sha256\n";
                System.out.println(data);
                FileWriter writer = new FileWriter("data.txt");
                writer.append(data);
                writer.close();
                return pass;

            }
        }

        return "password isn't in wordlist!";

    }
}