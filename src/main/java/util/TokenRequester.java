package util;

import java.net.URL;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import java.net.MalformedURLException;
import java.io.IOException;
import java.net.ProtocolException;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;

public class TokenRequester {

    private static String API_KEY = "t6dFCXw5GdOrTrCS8sM7iTaED0GCJmS93ksh-6VLJFyu";

    public static String getToken()
        throws MalformedURLException, IOException, ProtocolException {

        try {
        URL url = new URL("https://iam.cloud.ibm.com/identity/token");
        String urlParameters = String.format("grant_type=urn:ibm:params:oauth:grant-type:apikey&apikey=%s", TokenRequester.API_KEY);
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postData.length));
        conn.setUseCaches(false);

        try(DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData);
        }

        String responseString = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = br.readLine();
        while(line != null) {
            responseString = responseString + line;
            line = br.readLine();
        }

        JSONObject json = new JSONObject(responseString);
        return json.getString("access_token");

        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public String toString() {
        return "Token Requester";
    }
}
