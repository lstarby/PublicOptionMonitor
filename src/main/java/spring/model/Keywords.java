package spring.model;

/**
 * Created by pan on 16/8/23.
 */

public class Keywords {
    private int id;
    private String content;
    private String title;
    public Keywords(){
    }
    public Keywords(int id, String content, String title){
        this.content = content;
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
