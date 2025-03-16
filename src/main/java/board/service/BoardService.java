package board.service;

import board.domain.Board;
import board.domain.Post;
import board.exceptions.BoardNotFoundException;
import board.repository.MemoryBoardRepository;

import java.util.List;

public class BoardService {
    private MemoryBoardRepository memoryBoardRepository;

    public BoardService(MemoryBoardRepository memoryBoardRepository) {
        this.memoryBoardRepository = memoryBoardRepository;
    }

    public void createBoard(String boardName) {
        Board board = new Board(boardName);
        memoryBoardRepository.save(board);
        System.out.println("게시판이 생성되었습니다.");
    }

    public void update(int boardId, String boardName) {
        Board board = memoryBoardRepository.findById(boardId)
                .orElseThrow(() -> new BoardNotFoundException(boardId));
        board.setBoardName(boardName);
        memoryBoardRepository.update(board);
    }

    public void delete(int boardId) {
        Board board = memoryBoardRepository.findById(boardId)
                .orElseThrow(() -> new BoardNotFoundException(boardId));
        memoryBoardRepository.delete(board);
    }

    public List<Post> findByName(String boardName) {
        Board board = memoryBoardRepository.findByName(boardName)
                .orElseThrow(() -> new BoardNotFoundException(boardName + " 게시판은 존재하지 않습니다."));
        return board.getMemoryPostRepository().findAll();
    }
}
