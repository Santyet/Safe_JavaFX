package com.example.safe_seg13.model;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Password {

    private static Password instance;

    private Password(String s){

        File file = new File("Password.txt");

        String out = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fis)
            );

            String line;

            while ((line = reader.readLine()) != null){
                out += line;
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.password = out;
    }


    public static Password getInstance(){
        if(instance==null){
            instance = new Password("000000");
        }
        return instance;
    }

    public String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        File file = new File("Password.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(password.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.password = password;
    }
}
