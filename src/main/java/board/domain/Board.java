package board.domain;

import board.repository.MemoryPostRepository;

public class Board {
    private int boardId;
    private String boardName;
    private MemoryPostRepository memoryPostRepository;

    public Board(String boardName) {
        this.boardName = boardName;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public MemoryPostRepository getMemoryPostRepository() {
        return memoryPostRepository;
    }

    public void setMemoryPostRepository(MemoryPostRepository memoryPostRepository) {
        this.memoryPostRepository = new MemoryPostRepository();
    }
}
