package board.domain;

import java.time.LocalDateTime;

public class Account {
    private int accountId;
    private String userId;
    private String password;
    private String nickname;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isLoggedIn;

    public Account(String userId, String password, String nickname, String email) {
        this.accountId = 0;
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = null;
        this.isLoggedIn = false;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public int getAccountId() {
        return accountId;
    }


    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.updatedAt = LocalDateTime.now();
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.updatedAt = LocalDateTime.now();
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void login(String inputPassword) throws IllegalAccessException {
        if (!isLoggedIn) {
            if (this.password.equals(inputPassword)) {
                this.isLoggedIn = true;
            } else {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
            }
        } else {
            throw new IllegalAccessException("이미 로그인 된 사용자입니다.");
        }

    }

    public void logout() {
        if (isLoggedIn) {
            this.isLoggedIn = false;
        } else {
            throw new IllegalStateException("로그인 되어 있지 않은 사용자입니다.");
        }
    }
}
