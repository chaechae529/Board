package board.controller;

import board.BoardService;
import board.Post;
import board.exceptions.PostNotFoundException;

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

        try {
            boardService.delete(deleteId);
        } catch (PostNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
