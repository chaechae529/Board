package board.exceptions;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(int postId) {
        super(postId + "번 게시글은 존재하지 않습니다.");
    }

    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostNotFoundException(Throwable cause) {
        super(cause);
    }
}
