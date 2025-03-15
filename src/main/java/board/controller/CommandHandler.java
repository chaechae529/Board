package board.controller;

import board.BoardService;

import java.io.BufferedReader;
import java.io.IOException;

public class CommandHandler {
    // 객체 변경 방지 final
    private final BoardService boardService;
    private final BufferedReader br;

    public CommandHandler(BoardService boardService, BufferedReader br) {
        this.boardService = boardService;
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
                new CreateController(boardService).createPost();
                break;
            case "조회":
                new ReadController(boardService).readPostbyId();
                break;
            case "수정":
                new UpdateController(boardService).updatePost();
                break;
            case "삭제":
                new DeleteController(boardService).deletePost();
                break;
            case "목록":
                new ReadController(boardService).readPostAll();
                break;
            default:
                System.out.println("존재하지 않는 명령어입니다.");
        }
    }
}
