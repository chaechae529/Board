# 과제물

## 1. 개요 및 요구사항

### 1-1. 개요

사용자로부터 URL로 구성된 명령어를 입력받아 게시글을 작성할 수 있는 프로그램을 구성하려고 합니다. 게시글은 영구적으로 저장되지 않으며, 프로그램을 시작할 때마다 새롭게 저장되고 종료하면 삭제됩니다.

### 1-2. 요구사항

각 단계별 문제를 해결하면 됩니다. 순서는 중요하지 않으며, 해결할 수 있는 요구사항부터 진행하면 됩니다. 높은 단계의 요구사항은 낮은 단계의 요구사항을 포함할 수 있습니다.

<details>
  <summary>단계 1</summary>

  1. 명령어를 입력받아 출력할 수 있는 프로그램 작성
     - 명령어는 `명령어 >` 형식으로 입력받음
     ```
     명령어 > 안녕하세요!
     안녕하세요!
     명령어 >
     ```
  2. 특정 명령어 입력 시 프로그램 종료
     - `종료` 또는 `exit` 입력 시 종료
     ```
     명령어 > 종료
     프로그램이 종료됩니다.
     ```
     - 존재하지 않는 명령어 입력 시 메시지 출력
     ```
     명령어 > 잘못된명령어
     존재하지 않는 명령어 입니다.
     ```
  3. 게시글 관련 기능 추가
     - 작성: 제목과 내용을 입력받아 게시글 생성
     - 조회: 마지막 게시글 확인
     - 삭제: 마지막 게시글 삭제
     - 수정: 마지막 게시글 제목과 내용 수정
  4. 여러 개의 게시글 작성 가능하도록 수정
     - 게시글은 번호를 갖고, 삭제 시 번호 재정렬
  5. 명령어 상세 개선
     - 조회, 삭제, 수정 시 게시글 번호 입력 방식으로 변경
  6. 존재하지 않는 게시글 조회/수정/삭제 시 예외 처리
  7. 게시글 목록 확인 기능 추가

</details>

<details>
  <summary>단계 2</summary>

  1. 명령어를 URL 형식으로 변경
     - 입력 형식을 `/구분/기능?파라미터...` 형태로 변경
     - URL 파라미터 처리 기능 구현
  2. 게시판 기능 구현
     - `/boards/add`: 게시판 추가
     - `/boards/edit?boardId=`: 게시판 수정
     - `/boards/remove?boardId=`: 게시판 삭제
     - `/boards/view?boardName=`: 특정 게시판 게시글 목록 조회
  3. 게시물 기능 수정 및 개선
     - 게시글 객체에 작성일, 수정일, 게시판 정보 추가
     - URL 형식 적용
  4. 회원 기능 추가
     - `/accounts/signup`: 회원가입
     - `/accounts/signin`: 로그인
     - `/accounts/signout`: 로그아웃
     - `/accounts/detail?accountId=`: 회원 정보 조회
     - `/accounts/edit?accountId=`: 회원 정보 수정
     - `/accounts/remove?accountId=`: 회원 탈퇴
  5. 요청(Request) 객체 생성 및 세션(Session) 객체 분리

</details>

<details>
  <summary>단계 3</summary>

  1. 회원 등급 추가 (관리자/일반 회원)
     - 관리자만 게시판 생성 가능
     - 로그인한 회원만 게시글 작성 가능
     - 본인 게시글만 수정/삭제 가능 (관리자는 모든 게시글 관리 가능)
     - 게시물 열람은 로그인 없이 가능
  2. 컨테이너 객체 도입
     - 객체 생성 및 관리 책임을 컨테이너 객체로 이동
  3. 필터(Filter) 기능 추가
     - URL별 인증 및 권한 검사 적용
  4. 프로그램을 MVC 패턴으로 구조화

</details>

<details>
  <summary>추가 요구사항</summary>
  
  1. MVC(Model-View-Controller) 패턴 적용
     - 게시판, 게시물, 회원 기능에 MVC 패턴 적용
     - 각 기능을 독립적으로 실행 가능하도록 설계
</details>
