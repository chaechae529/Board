package board.controller;

import board.BoardService;
import board.Post;
import board.exceptions.PostNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ReadController {
    private BoardService boardService;

    public ReadController(BoardService boardService) {
        this.boardService = boardService;
    }

    public void readPostbyId() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("어떤 게시물을 조회할까요? ");
        int readId = Integer.parseInt(br.readLine());

        Post findPost = boardService.findById(readId)
                .orElseThrow(() -> new PostNotFoundException(readId));

        System.out.println("제목: " + findPost.getTitle());
        System.out.println("내용: " + findPost.getContent());


    }

    public void readPostAll()  {
        List<Post> postList = boardService.findAll();
        StringBuilder sb = new StringBuilder();

        int cnt = postList.size();
        sb.append("총 게시글은 ").append(cnt).append("개 작성되어 있습니다.").append("\n");

        for (Post post : postList) {

            sb.append(post.getId()).append("번 게시글").append("\n");
            sb.append("제목: ").append(post.getTitle()).append("\n");
            sb.append("내용: ").append(post.getContent()).append("\n");

        }

        System.out.println(sb);

    }


}
