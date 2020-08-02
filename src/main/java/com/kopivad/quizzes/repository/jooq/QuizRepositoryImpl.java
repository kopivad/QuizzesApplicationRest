package com.kopivad.quizzes.repository.jooq;

import com.kopivad.quizzes.domain.Group;
import com.kopivad.quizzes.domain.Quiz;
import com.kopivad.quizzes.domain.User;
import com.kopivad.quizzes.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

import static com.kopivad.quizzes.domain.db.tables.Quizzes.QUIZZES;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

@Repository
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
    public long save(Quiz quiz) {
        return dslContext
                .insertInto(QUIZZES)
                .set(QUIZZES.TITLE, quiz.getTitle())
                .set(QUIZZES.ACTIVE, quiz.isActive())
                .set(QUIZZES.TOTAL, quiz.getTotal())
                .set(QUIZZES.DESCRIPTION, quiz.getDescription())
                .set(QUIZZES.AUTHOR_ID, quiz.getAuthor().getId())
                .set(QUIZZES.CREATION_DATE, Timestamp.valueOf(quiz.getCreationDate()))
                .set(QUIZZES.GROUP_ID, quiz.getGroup().getId())
                .returning(QUIZZES.ID)
                .fetchOne()
                .getId();
    }

    @Override
    public boolean update(Quiz quiz) {
        int affectedRows = dslContext
                .update(QUIZZES)
                .set(QUIZZES.TITLE, quiz.getTitle())
                .set(QUIZZES.DESCRIPTION, quiz.getDescription())
                .set(QUIZZES.ACTIVE, quiz.isActive())
                .set(QUIZZES.TOTAL, quiz.getTotal())
                .set(QUIZZES.AUTHOR_ID, quiz.getAuthor().getId())
                .set(QUIZZES.GROUP_ID, quiz.getGroup().getId())
                .where(QUIZZES.ID.eq(quiz.getId()))
                .execute();

        return affectedRows > INTEGER_ZERO;
    }

    @Override
    public boolean delete(Long id) {
        int affectedRows = dslContext
                .deleteFrom(QUIZZES)
                .where(QUIZZES.ID.eq(id))
                .execute();

        return affectedRows > INTEGER_ZERO;
    }

    @Override
    public List<Quiz> findByGroupId(long id) {
        return dslContext
                .selectFrom(QUIZZES)
                .where(QUIZZES.GROUP_ID.eq(id))
                .fetch()
                .map(getQuizFromRecordMapper());
    }

    @Override
    public List<Quiz> findByTitleStartsWith(String title) {
        return dslContext
                .selectFrom(QUIZZES)
                .where(QUIZZES.TITLE.startsWithIgnoreCase(title))
                .fetch()
                .map(getQuizFromRecordMapper());
    }

    private RecordMapper<Record, Quiz> getQuizFromRecordMapper() {
        return record -> Quiz
                .builder()
                .id(record.getValue(QUIZZES.ID))
                .title(record.getValue(QUIZZES.TITLE))
                .description(record.getValue(QUIZZES.DESCRIPTION))
                .total(record.getValue(QUIZZES.TOTAL))
                .author(User.builder().id(record.getValue(QUIZZES.AUTHOR_ID)).build())
                .active(record.getValue(QUIZZES.ACTIVE))
                .creationDate(record.getValue(QUIZZES.CREATION_DATE).toLocalDateTime())
                .group(
                        ObjectUtils.isNotEmpty(record.getValue(QUIZZES.GROUP_ID))
                                ? Group.builder().id(record.getValue(QUIZZES.GROUP_ID)).build()
                                : Group.builder().build()
                )
                .build();
    }
}
