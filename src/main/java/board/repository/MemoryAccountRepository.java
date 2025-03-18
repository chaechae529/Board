package board.repository;

import board.domain.Account;
import board.exceptions.AccountNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MemoryAccountRepository implements AccountRepository {
    private static int nextId = 1;
    private final List<Account> accountList = new ArrayList<>();
    private Account loggedInAccount = null;

    @Override
    public Account save(Account account) {
        account.setAccountId(nextId++);
        accountList.add(account);
        return account;
    }

    @Override
    public void updatePassword(Account account) {
        findById(account.getAccountId()).ifPresent(existingAccount -> {
            existingAccount.setPassword(account.getPassword());
            existingAccount.setUpdatedAt(LocalDateTime.now());
        });
    }
    @Override
    public void updateEmail(Account account) {
        findById(account.getAccountId()).ifPresent(existingAccount -> {
            existingAccount.setEmail(account.getEmail());
            existingAccount.setUpdatedAt(LocalDateTime.now());
        });
    }

    @Override
    public void delete(Account account) {
        accountList.remove(account);

    }

    @Override
    public Optional<Account> findById(int accountId) {
        return accountList.stream()
                .filter(account -> account.getAccountId() == accountId)
                .findFirst();
    }

    @Override
    public Optional<Account> findByUserId(String userId) {
        return accountList.stream()
                .filter(account -> Objects.equals(account.getUserId(), userId))
                .findFirst();
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return accountList.stream()
                .filter(account -> Objects.equals(account.getEmail(), email))
                .findFirst();
    }

    @Override
    public Optional<Account> findLoggedInAccount() {
        return Optional.ofNullable(loggedInAccount);
    }

    @Override
    public void signinAccount(Account account) {
        this.loggedInAccount = account;

    }

    @Override
    public void signoutAccount() {
        this.loggedInAccount = null;
    }
}
