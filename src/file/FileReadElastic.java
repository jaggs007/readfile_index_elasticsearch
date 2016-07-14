package file;

import index.Index;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import search.Search;

public class FileReadElastic {

     public static void main(String[] args) throws ParseException {
         
         Settings settings = ImmutableSettings.settingsBuilder()
                    .put("cluster.name", "elasticsearch").build();
            TransportClient tc = new TransportClient(settings);

            // now try to connect with the TransportClient
            Client client = tc.addTransportAddress(new InetSocketTransportAddress(
                    "localhost", 9300));
         
         
        JSONParser parser = new JSONParser();
        BufferedReader br=null;
 
        try 
        {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("/home/jwala/workspace/json.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                Object obj = parser.parse(sCurrentLine);
                 
                JSONObject jsonObject = (JSONObject) obj;
     
                String name = (String) jsonObject.get("name");
                String age = (String) jsonObject.get("age");
                String address = (String) jsonObject.get("address");
                
                
                Index.setData(client,name,age,address);
                
     
            }                
                      
        } catch (IOException e) {
            e.printStackTrace();
     }  
        
        Search.findData(client);
}
     
    

}