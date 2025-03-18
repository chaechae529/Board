package board.controller;

import board.service.BoardService;
import board.service.PostService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardController {
    private final BoardService boardService;
    private final BufferedReader br;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void addBoard(int boardId) throws IOException {

        System.out.print("제목을 입력하세요: ");
        String name = br.readLine();

        boardService.createBoard(name);
        System.out.println("게시판이 생성되었습니다.");

    }

    public void removeBoard(int boardId)  {
        boardService.delete(boardId);
        System.out.println("게시판이 삭제되었습니다.");
    }

    public void editBoard(int boardId) throws IOException {
        System.out.print("제목을 입력하세요: ");
        String name = br.readLine();

        boardService.update(boardId, name);
        System.out.println("게시판이 수정되었습니다.");
    }

    public void getBoardDetail(String boardName) {
        System.out.println(boardService.getBoardDetail(boardName));
    }

}
