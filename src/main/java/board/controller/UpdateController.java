package board.controller;

import board.BoardService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpdateController {
    private BoardService boardService;

    public UpdateController(BoardService boardService) {
        this.boardService = boardService;
    }

    public void updatePost() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("어떤 게시물을 수정할까요? ");
        int updateId = Integer.parseInt(br.readLine());

        if (boardService.findById(updateId).isEmpty()){
            System.out.println(updateId + "번 게시글은 존재하지 않습니다");
            return;
        }

        System.out.print("제목을 입력하세요: ");
        String title = br.readLine();
        System.out.print("내용을 입력하세요: ");
        String content = br.readLine();

        boardService.update(title, content, updateId);

    }
}
