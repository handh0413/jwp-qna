package qna.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@EnableJpaAuditing
@DataJpaTest
class DeleteHistoryTest {
    public static final DeleteHistory H1 = new DeleteHistory(ContentType.QUESTION, 1L, 1L, LocalDateTime.now());
    public static final DeleteHistory H2 = new DeleteHistory(ContentType.QUESTION, 2L, 2L, LocalDateTime.now());

    @Autowired
    private DeleteHistoryRepository repository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void 삭제_이력_저장() {
        final DeleteHistory expected = repository.save(H1);
        assertThat(expected).isNotNull();
    }

    @Test
    void 삭제_이력_조회() {
        final DeleteHistory expected = repository.save(H1);
        final Optional<DeleteHistory> actual = repository.findById(expected.getId());
        assertThat(actual).isNotEmpty();
    }

    @Test
    void 질문_삭제_이력() {
        final Question question = questionRepository.save(QuestionTest.Q1);
        repository.save(new DeleteHistory(ContentType.QUESTION, question.getId(), 1L, LocalDateTime.now()));

        Optional<DeleteHistory> actual = repository.findByContentId(question.getId());
        assertThat(actual).isNotEmpty();
    }

    @Test
    void 댓글_삭제_이력() {
        final Answer answer = answerRepository.save(new Answer(UserTest.JAVAJIGI, QuestionTest.Q1, "댓글 내용"));
        repository.save(new DeleteHistory(ContentType.ANSWER, answer.getId(), 1L, LocalDateTime.now()));

        Optional<DeleteHistory> actual = repository.findByContentId(answer.getId());
        assertThat(actual).isNotEmpty();
    }
}