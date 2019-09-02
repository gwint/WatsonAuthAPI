package aws;

import com.amazonaws.services.lambda.runtime.Context;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.HashSet;
import util.TokenRequester;
import java.net.MalformedURLException;
import java.io.IOException;
import java.net.ProtocolException;

public class RequestHandler {

    public String handleRequest(Context context)
        throws MalformedURLException, IOException, ProtocolException {
        return TokenRequester.getToken();
    }
}
