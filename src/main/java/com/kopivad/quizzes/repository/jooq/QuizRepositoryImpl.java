package com.kopivad.quizzes.repository.jooq;

import com.kopivad.quizzes.domain.Quiz;
import com.kopivad.quizzes.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

import static com.kopivad.quizzes.domain.db.tables.Quizzes.QUIZZES;

@Repository("jooqQuizRepository")
@RequiredArgsConstructor
public class QuizRepositoryImpl implements QuizRepository {
    private final DSLContext dslContext;

    @Override
    public List<Quiz> findAll() {
        return dslContext
                .selectFrom(QUIZZES)
                .fetch()
                .map(getQuizFromRecordMapper());
    }

    @Override
    public Quiz findById(Long id) {
        return dslContext
                .selectFrom(QUIZZES)
                .where(QUIZZES.ID.eq(id))
                .fetchOne()
                .map(getQuizFromRecordMapper());
    }

    @Override
    public Quiz save(Quiz quiz) {
        return dslContext
                .insertInto(QUIZZES, QUIZZES.TITLE, QUIZZES.ACTIVE, QUIZZES.DESCRIPTION, QUIZZES.AUTHOR_ID, QUIZZES.CREATION_DATE)
                .values(quiz.getTitle(), quiz.isActive(), quiz.getDescription(), quiz.getAuthor().getId(), Timestamp.valueOf(quiz.getCreationDate()))
                .returning(QUIZZES.ID, QUIZZES.TITLE, QUIZZES.ACTIVE, QUIZZES.DESCRIPTION, QUIZZES.AUTHOR_ID, QUIZZES.CREATION_DATE)
                .fetchOne()
                .map(getQuizFromRecordMapper());
    }

    @Override
    public Quiz update(Long id, Quiz quiz) {
        return dslContext
                .update(QUIZZES)
                .set(QUIZZES.TITLE, quiz.getTitle())
                .set(QUIZZES.DESCRIPTION, quiz.getDescription())
                .set(QUIZZES.ACTIVE, quiz.isActive())
                .set(QUIZZES.AUTHOR_ID, quiz.getAuthor().getId())
                .where(QUIZZES.ID.eq(id))
                .returningResult(QUIZZES.ID, QUIZZES.TITLE, QUIZZES.ACTIVE, QUIZZES.DESCRIPTION, QUIZZES.AUTHOR_ID, QUIZZES.CREATION_DATE)
                .fetchOne()
                .map(getQuizFromRecordMapper());
    }

    @Override
    public void delete(Long id) {
        dslContext
                .deleteFrom(QUIZZES)
                .where(QUIZZES.ID.eq(id))
                .execute();
    }

    private RecordMapper<Record, Quiz> getQuizFromRecordMapper() {
        return record -> Quiz
                .builder()
                .id(record.getValue(QUIZZES.ID))
                .title(record.getValue(QUIZZES.TITLE))
                .description(record.getValue(QUIZZES.DESCRIPTION))
                .active(record.getValue(QUIZZES.ACTIVE))
                .creationDate(record.getValue(QUIZZES.CREATION_DATE).toLocalDateTime())
                .build();
    }
}
