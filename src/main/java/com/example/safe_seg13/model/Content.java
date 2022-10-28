package com.example.safe_seg13.model;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Content {

    private static Content instance;

    private Content(){
        File file = new File("Content.txt");

        String out = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fis)
            );

            String line;

            while ((line = reader.readLine()) != null){
                out += line + "\n";
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.content = out;
    }

    public static Content getInstance(){
        if(instance==null){
            instance = new Content();
        }
        return instance;
    }

    public String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {

        File file = new File("Content.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.content = content;
    }
}
