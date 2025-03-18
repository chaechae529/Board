package board.controller;

import board.service.AccountService;

import javax.security.auth.login.AccountNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccountController {
    private final AccountService accountService;
    private final BufferedReader br;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void signUp() throws IOException {

        System.out.print("아이디를 입력하세요: ");
        String userid = br.readLine();

        System.out.print("비밀번호를 입력하세요: ");
        String password = br.readLine();

        System.out.print("닉네임을 입력하세요: ");
        String nickname = br.readLine();

        System.out.print("이메일을 입력하세요: ");
        String email = br.readLine();

        accountService.createAccount(userid,password,email,nickname);
        System.out.println("가입이 완료되었습니다.");

    }

    public void signIn() throws IOException, AccountNotFoundException, IllegalAccessException {
        System.out.print("아이디를 입력하세요: ");
        String userid = br.readLine();

        System.out.print("비밀번호를 입력하세요: ");
        String password = br.readLine();

        accountService.signin(userid, password);
        System.out.println("성공적으로 로그인하였습니다.");
    }

    public void signOut() throws IllegalAccessException {
        accountService.signout();
        System.out.println("성공적으로 로그아웃하였습니다.");
    }

    public void getAccountDetail(int accountId) throws AccountNotFoundException {
        System.out.println(accountService.getAccountDetail(accountId));
    }

    public void editAccount(int accountId) throws IOException, AccountNotFoundException {
        System.out.print("어떤 정보를 변경하시겠습니까? (비밀번호/이메일) ");
        String option = br.readLine();

        if (option.equals("비밀번호")) {
            System.out.print("새 비밀번호를 입력하세요: ");
            String newPassword = br.readLine();
            accountService.updatePassword(accountId, newPassword);
        } else if (option.equals("이메일")) {
            System.out.print("새 이메일을 입력하세요: ");
            String newEmail = br.readLine();
            accountService.updateEmail(accountId, newEmail);
        }

        System.out.println("성공적으로 변경되었습니다.");
    }

    public void removeAccount(int accountId) throws AccountNotFoundException {
        accountService.delete(accountId);
        System.out.println("성공적으로 계정이 삭제되었습니다.");
    }
}
