package board;

import board.controller.AccountController;
import board.controller.BoardController;
import board.controller.PostController;
import board.controller.UrlHandler;
import board.exceptions.BoardNotFoundException;
import board.exceptions.PostNotFoundException;
import board.repository.*;
import board.service.AccountService;
import board.service.BoardService;
import board.service.PostService;
import board.url.UrlParser;

import javax.security.auth.login.AccountNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, AccountNotFoundException, IllegalAccessException {
        AccountRepository accountRepository = new MemoryAccountRepository();
        BoardRepository boardRepository = new MemoryBoardRepository();
        PostRepository postRepository = new MemoryPostRepository();

        AccountService accountService = new AccountService(accountRepository);
        BoardService boardService = new BoardService(boardRepository);
        PostService postService = new PostService(postRepository);


        AccountController accountController = new AccountController(accountService);
        BoardController boardController = new BoardController(boardService);
        PostController postController = new PostController(postService);

        UrlParser urlParser = new UrlParser();

        UrlHandler urlHandler = new UrlHandler(postController, boardController, accountController, urlParser);
        urlHandler.start();
    }
}
