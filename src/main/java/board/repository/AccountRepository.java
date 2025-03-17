package board.repository;

import board.domain.Account;

import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);

    void updateEmail(Account account);
    void updatePassword(Account account);


    void delete(Account account);

    Optional<Account> findById(int accountId);
    Optional<Account> findByUserId(String userId);


    Optional<Account> findByEmail(String email);

    Optional<Account> findLoggedInAccount();

    void setLoggedInAccount(Account account);

    void clearLoggedInAccount();
}
