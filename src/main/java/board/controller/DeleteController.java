package board.controller;

import board.BoardService;
import board.Post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteController {
    private BoardService boardService;

    public DeleteController(BoardService boardService) {
        this.boardService = boardService;
    }

    public void deletePost() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("어떤 게시물을 삭제할까요? ");
        int deleteId = Integer.parseInt(br.readLine());


        if (boardService.findById(deleteId) == null){
            System.out.println(deleteId + "번 게시글은 존재하지 않습니다");
            return;
        }

        boardService.delete(deleteId);


    }
}
