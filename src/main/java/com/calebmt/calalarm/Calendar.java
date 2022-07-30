package com.calebmt.calalarm;
//import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection.Response;
import org.jsoup.Connection;
import java.io.File;
import java.io.FileWriter;

import java.io.IOException;

class Calendar {
    Calendar() {
       
    }

    public void getCalendarFromURL(String calendar) {

    }

    public void handleCalendarSignIn(String user, String pass, String url) {
        
        // Get the status code of the HTTP request
        try {
            int statusCode = getStatusCode(url);
            System.out.println(statusCode);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        
        
    }

    private int getStatusCode(String url) throws IOException {
        Connection con = Jsoup.connect(url);
        con.ignoreHttpErrors(true);
        return con.execute().statusCode();
    }

    private void getCalendarAuth(String calendar) throws IOException{
        System.out.println(calendar);
        Document doc = Jsoup.connect(calendar).get();
        System.out.println(doc.title());
        
    }

    private void AuthResponse() {

    }

    private void addCalendarToFile(String calendar) {

    }

    private void parseError(IOException error) {
        System.out.println("Error: " + error);

    }





}