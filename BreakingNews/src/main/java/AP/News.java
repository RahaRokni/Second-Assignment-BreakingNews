package AP;

public class News {
    private String title;
    private String author;
    private String description;
    private String url;
    private String sourceName;
    private String publishedAt;

    public News(String title, String author, String description, String url, String sourceName, String publishedAt) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.url = url;
        this.sourceName = sourceName;
        this.publishedAt = publishedAt;
    }
    public String getTitle() {
        return title;
    }
    public void displayNews ()
    {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Description: " + description);
        System.out.println("URL: " + url);
        System.out.println("Source: " + sourceName);
        System.out.println("Published At: " + publishedAt);
        System.out.println();
    }

}