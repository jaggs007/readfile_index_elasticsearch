package index;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

public class Index {
    
            
        public static void setData( Client client,String name,String age,String address) 
        {
     /*      IndexResponse resoo1 = client
                    .prepareIndex("player", "new")
                    .setSource(
                            putJsonDocument(
                                    name,age,
                                    address)).execute().actionGet();
*/
        }


    public static Map<String, Object> putJsonDocument(String name,
            String age, String address) {

        Map<String, Object> jsonDocument = new HashMap<String, Object>();

        jsonDocument.put("name", name);
        jsonDocument.put("age", age);
        jsonDocument.put("address", address);
        
        return jsonDocument;
    
    }

}

