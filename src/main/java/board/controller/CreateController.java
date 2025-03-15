package board.controller;

import board.BoardService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateController {
    private BoardService boardService;

    public CreateController(BoardService boardService) {
        this.boardService = boardService;
    }

    public void createPost() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("제목을 입력하세요: ");
        String title = br.readLine();
        System.out.print("내용을 입력하세요: ");
        String content = br.readLine();

        boardService.create(title, content);
    }
}
