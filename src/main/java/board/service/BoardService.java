package board.service;

import board.domain.Board;
import board.domain.Post;
import board.exceptions.BoardNotFoundException;
import board.repository.BoardRepository;

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
    }

    private Board validateExistAccount(int boardId) throws BoardNotFoundException {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new BoardNotFoundException(boardId));
    }

    public void update(int boardId, String boardName) {
        Board board = validateExistAccount(boardId);
        board.setBoardName(boardName);
        boardRepository.update(board);

    }

    public void delete(int boardId) {
        Board board = validateExistAccount(boardId);
        boardRepository.delete(board);

    }

    public List<Post> findByName(String boardName) {
        Board board = boardRepository.findByName(boardName)
                .orElseThrow(() -> new BoardNotFoundException(boardName + " 게시판은 존재하지 않습니다."));
        return board.getPostRepository().findAll();
    }

    public String getBoardDetail(String boardName) {
        List<Post> postList = findByName(boardName);
        StringBuilder sb = new StringBuilder();

        for (Post post : postList) {
            sb.append(post.getId()).append(" / ")
                    .append(post.getTitle()).append(" / ").append(post.getContent());
            sb.append("\n");
        }

        return sb.toString();
    }

}
