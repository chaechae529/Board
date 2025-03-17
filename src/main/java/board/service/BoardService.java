package board.service;

import board.domain.Account;
import board.domain.Board;
import board.domain.Post;
import board.exceptions.BoardNotFoundException;
import board.repository.BoardRepository;
import board.repository.MemoryBoardRepository;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void createBoard(String boardName) {
        Board board = new Board();
        board.setBoardName(boardName);
        boardRepository.save(board);
        System.out.println("게시판이 생성되었습니다.");
    }

    private Board validateExistAccount(int boardId) throws BoardNotFoundException {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new BoardNotFoundException(boardId));
    }

    public void update(int boardId, String boardName) {
        Board board = validateExistAccount(boardId);
        board.setBoardName(boardName);
        boardRepository.update(board);

        System.out.println("게시판이 수정되었습니다.");
    }

    public void delete(int boardId) {
        Board board = validateExistAccount(boardId);
        boardRepository.delete(board);

        System.out.println("게시판이 삭제되었습니다.");
    }

    public List<Post> findByName(String boardName) {
        Board board = boardRepository.findByName(boardName)
                .orElseThrow(() -> new BoardNotFoundException(boardName + " 게시판은 존재하지 않습니다."));
        return board.getPostRepository().findAll();
    }
}
