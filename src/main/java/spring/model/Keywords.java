package spring.model;

/**
 * Created by pan on 16/8/23.
 */

public class Keywords {
    private int id;
    private String content;
    public Keywords(){
    }
    public Keywords(int id, String content){
        this.content = content;
        this.id = id;
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
}
