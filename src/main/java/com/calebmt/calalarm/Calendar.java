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
import java.util.Base64;

import java.io.IOException;

class Calendar {
    Calendar() {
       
    }

    public void getCalendarFromURL(String calendar) {

    }

    public void handleCalendarSignIn(String user, String pass, String url) {
        
        // Get the status code of the HTTP request
        try {
            String userCredentials = encodeCredentials(user, pass);
            System.out.println(userCredentials);
            int statusCode = getStatusCode(url);
            System.out.println(statusCode);
            Document serverDoc = connectWithBasicAuth(userCredentials, url);
            // Parse the document from the server
            Document parsableDoc = Jsoup.parse(serverDoc.toString());
            

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

    private Document connectWithBasicAuth(String encodedCreds, String url) throws IOException {
        System.out.println("Test");
        Connection con = Jsoup.connect(url).header("Authorization", "basic " + encodedCreds);
        System.out.println(con.execute().statusCode());
        Document doc = con.get();
        return doc;
    }

    private void AuthResponse() {

    }

    private void addCalendarToFile(String calendar) {

    }

    private void parseError(IOException error) {
        System.out.println("Error: " + error);

    }

    private void getLinksFromDoc(Document doc) {
        Element content = doc.getElementById("content");
        Elements links = content.getElementsByTag("a");
        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();
        }
    }

    public String encodeCredentials(String user, String pass) {
        String credentials = user + ":" + pass;
        Base64.Encoder encoder = Base64.getEncoder();
        // Encode the credentials to base 64
        String encodedCreds = encoder.encodeToString(credentials.getBytes());
        return encodedCreds;
    }





}