package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequests {

    public static void main(String[] args) {
        // GET USERS:
        getHttpUrlConnection();
    }

    public static void getHttpUrlConnection() {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            httpURLConnection = (HttpURLConnection) url.openConnection();

            // Request setup
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000); //
            httpURLConnection.setReadTimeout(5000);

            // get response from server
            System.out.println(httpURLConnection.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
