package board.domain;

public class Post {
    private String title;
    private String content;
    private int id;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return id + "번 게시물" + "\n"
                + "제목: " + title + "\n"
                + "내용: " + content +"\n";
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }
}
