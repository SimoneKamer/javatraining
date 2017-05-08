package com.github.shmvanhouten;

import java.io.*;

public class HelloWorld {
    public static void main(String[] args) {
//        writeTheFile();
        readTheFile();
        readFromTerminalInput();

        int number = new Integer(4);
        pi(number);

        int smallNumber = 6563;
        long largeNumber = smallNumber;
        short extraSmall = (short) smallNumber;

        boolean wantFruit = true;

        String s = wantFruit ? "Appel" : "MarsBar"; //ternary / conditional operator

        if (wantFruit) { // uitgebreide schrijfwijze van wat de regel hierboven ook doet.
            s = "Appel";
        } else {
            s = "MarsBar";
        }
    }

    public static void pi (Integer i) {
        System.out.println(i);
    }
    private static void readFromTerminalInput() {
        InputStream in = System.in; //hieronder demonstratie dat je een cursor krijgt in je terminal
        InputStreamReader isr = new InputStreamReader(in);
        try(BufferedReader reader = new BufferedReader(isr)){
            String readLine = reader.readLine();
            while(readLine != null){
                System.out.println(readLine);
                readLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] readTheFile() {
        File inputFile = new File ("C:\\users\\s_kam\\documents","simone.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
            String readLine = reader.readLine();
            while (readLine !=null){
                System.out.println(readLine);
                readLine = reader.readLine();

            }
        } catch (IOException e){
            e.printStackTrace();
        } return null;
    }



    public static void writeTheFile() {
        PrintStream out = System.out;
        out.println("Simone");

        File file = new File ("C:\\users\\s_kam\\documents","simone.txt");
        try (FileOutputStream fos = new FileOutputStream(file); PrintWriter pw = new PrintWriter(fos);){
            file.createNewFile();
            fos.write("Hello World!".getBytes());
            pw.println(" hier ben ik!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
