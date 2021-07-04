

import java.net.URL;

import   java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Analyze {
    public static String getHtml() {
        // write your code here
        String resp = "";
        String url = "https://www.simbirsoft.com/";
        HttpURLConnection connection = null;
        try {
            // URL obj = new URL(url);
            connection = (HttpURLConnection) new URL(url).openConnection();

            connection.setRequestMethod("GET");
            connection.connect();
            if(HttpURLConnection.HTTP_OK==connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println(response.toString());
                resp += response.toString();
            }
            else {
                System.out.println("fail: "+connection.getResponseCode() + "," + connection.getResponseMessage());
            }
        } catch (Throwable cause) {
            cause.printStackTrace();
        }
        finally {
            if(connection!=null){
                connection.disconnect();
            }
        }
    return resp;
    }
}
