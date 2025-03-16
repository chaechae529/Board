package board.repository;

import board.domain.Board;
import board.domain.Post;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);

    void update(Board board);

    void delete(Board board);

    Optional<Board> findById(int boardId);

    Optional<Board> findByName(String boardName);
}
