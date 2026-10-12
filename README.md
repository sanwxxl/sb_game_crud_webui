# Game Manager - Spring Boot Web UI

## 1. 프로젝트 소개

### 프로젝트 주제
게임 정보를 등록하고 목록으로 조회하는 웹 프로그램이다.
5주차 Memory 기반 CRUD 프로젝트에 Thymeleaf Web UI와 HTML Form을 추가했다.

관리 데이터: `id`, `name`, `company`, `price`, `genre`, `playTime`

### Render 배포 URL
- https://sb-game-crud-webui.onrender.com

### 프로젝트 구조
```
src/main
+-- java/org/example/week06/sb_crud_webui
|   +-- controller
|   |   +-- GameWebController.java
|   +-- service
|   |   +-- GameService.java
|   +-- repository
|   |   +-- GameRepository.java
|   |   +-- MemoryGameRepository.java
|   +-- domain
|   |   +-- Game.java
|   +-- dto
|   |   +-- GameRequest.java
|   |   +-- GameResponse.java
|   +-- SbCrudWebuiApplication.java
+-- resources
    +-- templates/games
    |   +-- list.html
    |   +-- form.html
    +-- static/css
    |   +-- style.css
    +-- application.properties
```

### 실행 방법
1. IntelliJ에서 프로젝트를 연다.
2. `SbCrudWebuiApplication`을 실행한다.
3. 브라우저에서 `http://localhost:8080/games`에 접속한다.

### Web Endpoint
| HTTP Method | URL | 기능 |
|---|---|---|
| GET | `/` | 목록으로 이동 |
| GET | `/games` | 전체 목록 |
| GET | `/games/new` | 등록 Form |
| POST | `/games` | 데이터 등록 |

### 주요 화면
**목록 화면**

![목록 화면](![img_1.png](img_1.png))

**등록 화면**

![등록 화면](![img_2.png](img_2.png))

---

## 2. 이번 과제 키워드
`@Controller` `Thymeleaf` `Model` `@ModelAttribute` `HTML Form` `redirect:` `PRG Pattern` `Bootstrap` `Layered Architecture`

---

## 3. 핵심 내용 정리
1. **@Controller와 @RestController의 차이**: `@RestController`는 JSON 데이터를 반환하고, `@Controller`는 HTML 화면 이름을 반환한다.
2. **Model로 데이터 전달**: `model.addAttribute("games", ...)`로 넣은 데이터를 HTML에서 `${games}`로 사용한다.
3. **Thymeleaf로 Collection 출력**: `th:each`로 List를 반복하고 `th:text`로 값을 출력한다.
4. **@ModelAttribute로 Form 데이터 받기**: input의 `name`과 DTO 필드명이 같으면 값이 자동으로 들어간다.
5. **redirect:와 PRG Pattern**: 등록 후 `redirect:/games`로 이동하면 새로고침해도 중복 등록되지 않는다.

---

## 4. Weekly Report

### Key Learning
1. `@Controller`와 `Model`을 이용해 서버 데이터를 HTML에 출력하는 방법을 배웠다.
2. HTML Form의 데이터를 `@ModelAttribute`로 DTO에 받는 방법을 배웠다.
3. PRG Pattern으로 중복 등록을 막는 방법을 배웠다.

### Web UI Flow
```
Browser -> GameWebController -> GameService -> GameRepository -> Memory(Map)
        -> Model -> Thymeleaf -> list.html
```

### Form Flow
```
form.html -> POST /games -> GameWebController -> GameService -> GameRepository
          -> redirect:/games -> GET /games -> list.html
```

### Problem & Solution
- **문제**: `GET /games/new` 메서드를 추가했는데 브라우저에서 404 에러가 발생했다.
- **원인**: Java 코드를 수정한 뒤 애플리케이션을 재실행하지 않았다.
- **해결**: 애플리케이션을 재실행하니 정상적으로 등록 화면이 출력되었다.

### Code Review
```java
@PostMapping("/games")
public String create(@ModelAttribute GameRequest request) {
    gameService.create(request);
    return "redirect:/games";
}
```
Form 데이터를 DTO로 받고, 저장 후 redirect로 PRG Pattern을 완성하는 코드라서 가장 중요하다고 생각했다.

### AI Usage
- **AI 활용**: `list.html`, `form.html`의 Bootstrap UI를 AI로 생성했다.
- **직접 확인**: Model 변수명(`games`), Form action(`/games`), Method(`post`), input name이 Controller와 DTO에 맞는지 직접 확인했다.
- **직접 작성**: Controller 코드는 직접 작성했다.

### Reflection
`@ModelAttribute`가 record 타입의 DTO에도 값을 자동으로 넣어 주는 점이 새로웠다.
입력값이 잘못되었을 때 에러 메시지를 화면에 보여 주는 방법이 궁금하다.

### 건의사항
- 없음