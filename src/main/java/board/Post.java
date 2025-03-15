package board;

public class Post {
    public String title;
    public String content;
    public int id;

    public Post(String title, String content, int id) {
        this.title = title;
        this.content = content;
        this.id = id;
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
