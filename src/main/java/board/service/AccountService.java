package board.service;

import board.domain.Account;
import board.repository.AccountRepository;
import board.repository.MemoryAccountRepository;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(String userId, String password, String email, String nickname) {
        if (accountRepository.findByUserId(userId).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }
        if (accountRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        Account account = new Account(userId, password, nickname, email);
        accountRepository.save(account);
        System.out.println("가입이 완료되었습니다.");
    }

    private Account validateExistAccount(int accountId) throws AccountNotFoundException {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("해당하는 계정이 없습니다."));
    }

    public void updateEmail(int accountId, String inputEmail) throws AccountNotFoundException {
        Account account = validateExistAccount(accountId);

        if (accountRepository.findByEmail(inputEmail).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        account.setEmail(inputEmail);
        accountRepository.updateEmail(account);
        System.out.println("이메일 변경이 완료되었습니다.");
    }
    public void updatePassword(int accountId, String inputPassword) throws AccountNotFoundException {
        Account account = validateExistAccount(accountId);
        account.setPassword(inputPassword);
        accountRepository.updatePassword(account);
        System.out.println("비밀번호 변경이 완료되었습니다.");
    }

    public void delete(int accountId) throws AccountNotFoundException {
        Account account = validateExistAccount(accountId);

        accountRepository.delete(account);
        System.out.println("계정이 삭제되었습니다.");
    }
}
