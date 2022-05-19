import com.sun.deploy.net.HttpRequest;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import sun.net.www.http.HttpClient;
import views.MainView;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            // handle exception
        }
//        MainView.showScreen();


        URLConnection connection = new URL("https://viacep.com.br/ws/88047655/json").openConnection();
        connection.setRequestProperty("header1", "header1");
        connection.setRequestProperty("header2", "header2");
//Get Response
        InputStream is = connection.getInputStream();
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();

        String inputStr;
        while ((inputStr = streamReader.readLine()) != null)
            responseStrBuilder.append(inputStr);
        JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
        System.out.println(jsonObject);
    }

}
