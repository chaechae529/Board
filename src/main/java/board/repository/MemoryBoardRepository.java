package board.repository;


import board.domain.Board;
import board.domain.Post;
import board.exceptions.BoardNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MemoryBoardRepository implements BoardRepository{
    private int nextId = 1;
    private List<Board> boardList = new ArrayList<>();
    @Override
    public Board save(Board board) {
        board.setBoardId(nextId++);
        boardList.add(board);
        return board;
    }

    @Override
    public void update(Board board) {
        findById(board.getBoardId()).ifPresent(existingBoard -> {
            existingBoard.setBoardName(board.getBoardName());
        });

    }

    @Override
    public void delete(Board board) {
        boardList.remove(board);
    }

    @Override
    public Optional<Board> findById(int boardId) {
        return boardList.stream()
                .filter(board -> board.getBoardId() == boardId)
                .findFirst();
    }

    @Override
    public Optional<Board> findByName(String boardName) {
        return boardList.stream()
                .filter(board -> Objects.equals(board.getBoardName(), boardName))
                .findFirst();

    }
}
