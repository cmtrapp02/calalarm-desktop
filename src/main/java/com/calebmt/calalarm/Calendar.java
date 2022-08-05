package com.calebmt.calalarm;
//import java.net.*;

import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Connection;
import java.io.File;
import java.io.FileWriter;
import java.util.Base64;
import org.jsoup.helper.Validate;
import org.apache.http.impl.client.HttpClients;
import org.apache.jackrabbit.webdav.DavConstants;
import org.apache.jackrabbit.webdav.DavException;
import org.apache.jackrabbit.webdav.MultiStatus;
import org.apache.jackrabbit.webdav.client.methods.HttpPropfind;
import org.apache.http.RequestLine;
import java.io.InputStream;


import java.io.IOException;
//import java.net.http.HttpResponse;

import com.github.caldav4j.model.request.CalDAVProp;
import com.github.caldav4j.CalDAVCollection;
import java.net.http.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.w3c.dom.Document;
import org.apache.jackrabbit.webdav.WebdavResponse;
import org.w3c.dom.NamedNodeMap;

import com.github.caldav4j.methods.HttpPropFindMethod;

class Calendar {
    Calendar() {
       
    }

    public void getCalendarFromURL(String calendar) {

    }

    public void handleCalendarSignIn(String user, String pass, String uri) {
        
        String userCredentials = encodeCredentials(user, pass);
        try {

            HttpPropfind propFind = new HttpPropfind(uri, DavConstants.PROPFIND_ALL_PROP, DavConstants.DEPTH_INFINITY);
            String authorizationHeader = "Authorization";
            String authorizationValue = "basic " + userCredentials;
            propFind.addHeader(authorizationHeader, authorizationValue);
            
            Header[] headers = propFind.getAllHeaders();
            for (Header header : headers) {
                System.out.println(header);
            }
            
        } catch (IOException e){

       }
        
        // Get the status code of the HTTP request
        // try {
        //     String userCredentials = encodeCredentials(user, pass);
        //     System.out.println(userCredentials);
        //     int statusCode = getStatusCode(url);
        //     System.out.println(statusCode);
        //     Document serverDoc = connectWithBasicAuth(userCredentials, url);
        //     // Parse the document from the server
        //     //Document parsableDoc = Jsoup.parse(serverDoc.toString());
        //     getLinksFromDoc(serverDoc);

        // } catch (IOException e) {
        //     System.out.println(e.toString());
        // }
        
        
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
        System.out.println("Get links!");
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            System.out.println(" * a: <%s>  (%s)" + link.attr("abs:href") + link.text());
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