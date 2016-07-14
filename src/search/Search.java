package search;

import java.util.Scanner;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

public class Search {
    
    private static String field;
    private static String data;
    
    
    public static void findData(Client client) {
        // TODO Auto-generated method stub
        
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter field:");
        field = reader.next();
        System.out.println("Enter data");
        data = reader.next();

        SearchResponse response = client.prepareSearch("player")
                .setTypes("new").setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery(field, data)).execute()
                .actionGet();

        // Printing the Search Results
        SearchHit[] searchResult = response.getHits().hits();

        for (SearchHit sh : searchResult) {
            System.out.println(sh.getSource().toString());

        }

        
    }

}