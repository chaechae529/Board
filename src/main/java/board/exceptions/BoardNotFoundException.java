package board.exceptions;

public class BoardNotFoundException extends RuntimeException {
    public BoardNotFoundException(int postId) {
        super(postId + "번 게시판은 존재하지 않습니다.");
    }

    public BoardNotFoundException(String message) {
        super(message);
    }

    public BoardNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardNotFoundException(Throwable cause) {
        super(cause);
    }
}
