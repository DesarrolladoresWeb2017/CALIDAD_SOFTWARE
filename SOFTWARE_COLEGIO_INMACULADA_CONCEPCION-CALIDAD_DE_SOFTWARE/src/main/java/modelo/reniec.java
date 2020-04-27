
package modelo;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class reniec {
    public static String dni(String dni){
        try{
            
        String enlace = "https://api.reniec.cloud/dni/"+dni;
        URL url = new URL(enlace);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //indicamos por que verbo HTML ejecutaremos la solicitud
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) 
        {
            
            //si la respuesta del servidor es distinta al codigo 200 lanzaremos una Exception
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        //creamos un StringBuilder para almacenar la respuesta del web service
        StringBuilder sb = new StringBuilder();
  
        int cp;
        while ((cp = br.read()) != -1)
            
        {
          sb.append((char) cp);
        }

        //en la cadena output almacenamos toda la respuesta del servidor
        String output = sb.toString();
        //convertimos la cadena a JSON a traves de la libreria GSON
        JsonObject rootobj = new Gson().fromJson(output,JsonObject.class);
        
        conn.disconnect();
        return output;
            
        }catch(Exception e){
            return null;
        }
       
        
    }
}
