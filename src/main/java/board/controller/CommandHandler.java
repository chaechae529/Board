package board.controller;

import board.service.PostService;

import java.io.BufferedReader;
import java.io.IOException;

public class CommandHandler {
    // 객체 변경 방지 final
    private final PostService postController;
    private final BufferedReader br;

    public CommandHandler(PostService postController, BufferedReader br) {
        this.postController = postController;
        this.br = br;
    }

    public void start() throws IOException {
        while (true) {
            System.out.print("명령어 > ");
            String command = br.readLine();

            if (command.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            handleCommand(command);
        }
    }

    private void handleCommand(String command) throws IOException {
        switch (command) {
            case "작성":
                new CreateController(postController).createPost();
                break;
            case "조회":
                new ReadController(postController).readPostbyId();
                break;
            case "수정":
                new UpdateController(postController).updatePost();
                break;
            case "삭제":
                new DeleteController(postController).deletePost();
                break;
            case "목록":
                new ReadController(postController).readPostAll();
                break;
            default:
                System.out.println("존재하지 않는 명령어입니다.");
        }
    }
}
