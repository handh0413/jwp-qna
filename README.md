# JPA

## 1단계 - 엔티티 매핑
* QnA 서비스를 만들어가면서 JPA로 실제 도메인 모델을 어떻게 구성하고 객체와 테이블을 어떻게 매핑해야 하는지 알아본다.
* 아래의 DDL(Data Definition Language)을 보고 유추하여 엔티티 클래스와 리포지토리 클래스를 작성해 본다.
* `@DataJpaTest`를 사용하여 학습 테스트를 해 본다.
    
## 기능 목록

- [X] 공통 정보를 표현한 BaseEntity 클래스

### Entity 클래스
- [X] 사용자를 표현한 User 엔티티 클래스
- [X] 질문을 표현한 Question 엔티티 클래스
- [X] 답변을 표현한 Answer 엔티티 클래스
- [X] 삭제 이력을 표현한 DeleteHistory 엔티티 클래스

### Repository 클래스
- [X] User 관련 CRUD 기능을 제공하는 UserRepository 클래스
- [X] Question 관련 CRUD 기능을 제공하는 QuestionRepository 클래스
- [X] Answer 관련 CRUD 기능을 제공하는 AnswerRepository 클래스
- [X] DeleteHistory 관련 CRUD 기능을 제공하는 DeleteHistoryRepository 클래스
