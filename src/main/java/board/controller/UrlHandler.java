package board.controller;

import board.service.BoardService;
import board.url.Url;
import board.url.UrlParser;

import javax.security.auth.login.AccountNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UrlHandler {
    // 객체 변경 방지 final
    private final PostController postController;
    private final BoardController boardController;
    private final AccountController accountController;
    private final UrlParser urlParser;
    private final BufferedReader br;

    public UrlHandler(PostController postController, BoardController boardController, AccountController accountController, UrlParser urlParser) {
        this.postController = postController;
        this.boardController = boardController;
        this.accountController = accountController;
        this.urlParser = urlParser;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() throws IOException, AccountNotFoundException, IllegalAccessException {
        while (true) {
            System.out.print("a ");
            String url = br.readLine();

            if (url.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            handleRequest(url);
        }
    }

    private void handleRequest(String inputUrl) throws IOException, AccountNotFoundException, IllegalAccessException {
        Url url = urlParser.parse(inputUrl);

        switch (url.getCategory()) {
            case "accounts":
                handleAccountRequest(url);
                break;
            case "posts":
                handlePostRequest(url);
                break;
            case "boards":
                handleBoardRequest(url);
                break;
            default:
                throw new IllegalArgumentException("잘못된 요청입니다: " + inputUrl);
        }
    }

    private void handleBoardRequest(Url url) throws IOException {
        switch (url.getFunction()) {
            case "add":
                int addId = Integer.parseInt(url.getParameters().get("boardId"));
                boardController.addBoard(addId);
                break;
            case "remove":
                int removeId = Integer.parseInt(url.getParameters().get("boardId"));
                boardController.removeBoard(removeId);
                break;
            case "edit":
                int editId = Integer.parseInt(url.getParameters().get("boardId"));
                boardController.editBoard(editId);
                break;
            case "view":
                String boardName = url.getParameters().get("boardName");
                boardController.getBoardDetail(boardName);
                break;
            default:
                System.out.println("존재하지 않는 명령어입니다.");
        }
    }

    private void handleAccountRequest(Url url) throws IOException, AccountNotFoundException, IllegalAccessException {

        switch (url.getFunction()) {
            case "signup":
                accountController.signUp();
                break;
            case "signin":
                accountController.signIn();
                break;
            case "signout":
                accountController.signOut();
                break;
            case "detail":
                int accountId = Integer.parseInt(url.getParameters().get("accountId"));
                accountController.getAccountDetail(accountId);
                break;
            case "edit":
                int editId = Integer.parseInt(url.getParameters().get("accountId"));
                accountController.editAccount(editId);
                break;
            case "remove":
                int removeId = Integer.parseInt(url.getParameters().get("accountId"));
                accountController.removeAccount(removeId);
                break;
            default:
                System.out.println("존재하지 않는 명령어입니다.");
        }
    }

    private void handlePostRequest(Url url) throws IOException {

        switch (url.getFunction()) {
            case "add":
                int addId = Integer.parseInt(url.getParameters().get("boardId"));
                postController.addPost(addId);
                break;
            case "remove":
                int removeId = Integer.parseInt(url.getParameters().get("postId"));
                postController.removePost(removeId);
                break;
            case "edit":
                int editId = Integer.parseInt(url.getParameters().get("postId"));
                postController.editPost(editId);
                break;
            case "view":
                int postId = Integer.parseInt(url.getParameters().get("postId"));
                postController.getPostDetail(postId);
                break;
            default:
                System.out.println("존재하지 않는 명령어입니다.");
        }
    }
}
