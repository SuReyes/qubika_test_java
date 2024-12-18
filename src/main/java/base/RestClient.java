package base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class RestClient {
    abstract protected String getBaseUrl();

    private Map<String, Object> request(String path, Map<String, String> headers, String httpMethod, String jsonInputBody) {
        Map<String, Object> response = new HashMap<>();
        try {
            URL url = new URL(getBaseUrl() + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(httpMethod);
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            connection.setDoOutput(true);

            if(jsonInputBody != null) {
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = jsonInputBody.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }

            int code = connection.getResponseCode();
            StringBuilder message = new StringBuilder();
            JSONObject jsonResponse = new JSONObject();

            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    message.append(responseLine.trim());
                }
            }

            connection.disconnect();
            response.put("code", code);
            if (message.toString().length()>0) {
                jsonResponse = new JSONObject(message.toString());
            }
            response.put("message", jsonResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
    public Map<String, Object> get(String path, Map<String, String> headers){
        return request(path, headers, "GET", null);
    }

    public Map<String, Object> delete(String path, Map<String, String> headers) {
        return request(path, headers, "DELETE", null);
    }

    public Map<String, Object> post(String path, Map<String, String> headers, String jsonInputBody) {
        return request(path, headers, "POST", jsonInputBody);
    }

    public Map<String, Object> put(String path, Map<String, String> headers, String jsonInputBody) {
        return request(path, headers, "PUT", jsonInputBody);
    }

    public Map<String, Object> post(String path, Map<String, String> headers, JSONObject jsonInputBody) {
        return request(path, headers, "POST", jsonInputBody.toString());
    }

    public Map<String, Object> put(String path, Map<String, String> headers, JSONObject jsonInputBody) {
        return request(path, headers, "PUT", jsonInputBody.toString());
    }
}
