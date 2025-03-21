package AP;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;

public class Infrastructure {

    private final String URL;
    private final String APIKEY;
    private final String JSONRESULT;
    private ArrayList<News> newsList;

    public Infrastructure(String APIKEY) {
        this.APIKEY = APIKEY;
        this.URL = "https://newsapi.org/v2/everything?q=tesla&from=" + LocalDate.now().minusDays(1) + "&sortBy=publishedAt&apiKey=";
        this.JSONRESULT = getInformation();
        this.newsList = new ArrayList<>();

        parseInformation();
    }

    public ArrayList<News> getNewsList() {
        return newsList;
    }

    private String getInformation() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL + APIKEY))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new IOException("HTTP error code: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("!!Exception : " + e.getMessage());
        }
        return null;
    }

    private void parseInformation() {
        if (JSONRESULT == null) {
            System.out.println("No data to parse.");
            return;
        }

        int startIndex = JSONRESULT.indexOf("\"articles\":[");
        if (startIndex == -1) {
            System.out.println("Invalid JSON format: 'articles' not found.");
            return;
        }

        int endIndex = JSONRESULT.indexOf("}]", startIndex);
        if (endIndex == -1) {
            System.out.println("Invalid JSON format: End of 'articles' not found.");
            return;
        }

        String articlesJson = JSONRESULT.substring(startIndex + 11, endIndex + 1);
        String[] articles = articlesJson.split("\\},\\{");

        for (int i = 0; i < Math.min(20, articles.length); i++) {
            String article = articles[i];
            if (i > 0) {
                article = "{" + article;
            }

            String title = extractField(article, "title");
            String description = extractField(article, "description");
            String url = extractField(article, "url");
            String sourceName = extractField(article, "name", "source");
            String author = extractField(article, "author");
            String publishedAt = extractField(article, "publishedAt");

            if (title != null && description != null && url != null && sourceName != null && author != null && publishedAt != null) {
                News news = new News(title, description, sourceName, author, url, publishedAt);
                newsList.add(news);
            }
        }
    }

    private String extractField(String json, String fieldName) {
        int startIndex = json.indexOf("\"" + fieldName + "\":");
        if (startIndex == -1) {
            return null;
        }

        startIndex = json.indexOf("\"", startIndex + fieldName.length() + 3) + 1;
        int endIndex = json.indexOf("\"", startIndex);
        return json.substring(startIndex, endIndex);
    }

    private String extractField(String json, String fieldName, String parentField) {
        int startIndex = json.indexOf("\"" + parentField + "\":");
        if (startIndex == -1) {
            return null;
        }

        startIndex = json.indexOf("\"" + fieldName + "\":", startIndex);
        if (startIndex == -1) {
            return null;
        }

        startIndex = json.indexOf("\"", startIndex + fieldName.length() + 3) + 1;
        int endIndex = json.indexOf("\"", startIndex);
        return json.substring(startIndex, endIndex);
    }

    public void displayNewsList() {
        if (newsList == null || newsList.isEmpty()) {
            System.out.println("No news to display.");
            System.out.println("JSON Result: " + JSONRESULT);
            return;
        }

        for (int i = 0; i < newsList.size(); i++) {
//            System.out.println(newsList.size());
            System.out.println((i + 1) + ". " + newsList.get(i).getTitle());
        }
    }
}
