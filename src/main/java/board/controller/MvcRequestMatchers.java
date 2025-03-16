package board.controller;

public class MvcRequestMatchers {
    private String path;
    private String role;

    public MvcRequestMatchers(String path) {
        this.path = path;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
