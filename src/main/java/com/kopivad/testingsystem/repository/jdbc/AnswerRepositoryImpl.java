package com.kopivad.testingsystem.repository.jdbc;

import com.kopivad.testingsystem.domain.Answer;
import com.kopivad.testingsystem.domain.Question;
import com.kopivad.testingsystem.exeption.DaoOperationException;
import com.kopivad.testingsystem.repository.AnswerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class AnswerRepositoryImpl implements AnswerRepository {
    private final DataSource dataSource;

    private static final String SELECT_ALL_SQL = "SELECT * FROM Answers;";
    private static final String SELECT_ANSWER_BY_ID_SQL = "SELECT * FROM Answers WHERE id = ?;";
    private static final String INSERT_ANSWER_SQL = "INSERT INTO Answers(text, is_right, question_id) VALUES (?, ?, ?);";
    private static final String UPDATE_ANSWER_SQL = "UPDATE Answers SET text = ?, is_right = ?, question_id = ? WHERE id = ?;";
    private static final String DELETE_ANSWER_SQL = "DELETE FROM Answers WHERE id = ?;";

    @Override
    public List<Answer> findAll() {
        try (Connection connection = dataSource.getConnection()) {
            return findAllAnswers(connection);
        } catch (SQLException e) {
            throw new DaoOperationException(e.getMessage(), e);
        }
    }

    private List<Answer> findAllAnswers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(SELECT_ALL_SQL);
        return collectToList(rs);
    }

    private List<Answer> collectToList(ResultSet rs) throws SQLException {
        List<Answer> answers = new ArrayList<>();
        while (rs.next())
            answers.add(parseRow(rs));
        return answers;
    }

    private Answer parseRow(ResultSet rs) throws SQLException {
        return Answer.builder()
                .id(rs.getLong(1))
                .text(rs.getString(2))
                .isRight(rs.getBoolean(3))
                .question(Question.builder().id(rs.getLong(4)).build())
                .build();
    }

    @Override
    public Answer findById(Long id) {
        try (Connection connection = dataSource.getConnection()) {
            return findAnswerById(id, connection);
        } catch (SQLException e) {
            throw new DaoOperationException(e.getMessage(), e);
        }
    }

    private Answer findAnswerById(Long id, Connection connection) throws SQLException {
        PreparedStatement selectStatement = prepareSelectStatement(id, connection);
        ResultSet rs = selectStatement.executeQuery();
        rs.next();
        return parseRow(rs);
    }

    private PreparedStatement prepareSelectStatement(Long id, Connection connection) {
        try {
            PreparedStatement selectStatement = connection.prepareStatement(SELECT_ANSWER_BY_ID_SQL);
            selectStatement.setLong(1, id);
            return selectStatement;
        } catch (SQLException e) {
            throw new DaoOperationException("Can not prepare select statement");
        }
    }

    @Override
    public Answer save(Answer answer) {
        try (Connection connection = dataSource.getConnection()) {
            return saveAnswer(answer, connection);
        } catch (SQLException e) {
            throw new DaoOperationException(e.getMessage(), e);
        }
    }

    private Answer saveAnswer(Answer answer, Connection connection) throws SQLException {
        PreparedStatement insertStatement = prepareInsertStatement(answer, connection);
        executeUpdate(insertStatement, "Answer was not created!");
        Long id = fetchGeneratedId(insertStatement);
        return findById(id);
    }

    private PreparedStatement prepareInsertStatement(Answer answer, Connection connection) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(INSERT_ANSWER_SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            return fillStatementWithAnswerData(insertStatement, answer);
        } catch (SQLException e) {
            throw new DaoOperationException("Can to prepare insert statement");
        }

    }

    private Long fetchGeneratedId(PreparedStatement insertStatement) throws SQLException {
        ResultSet rs = insertStatement.getGeneratedKeys();
        if (rs.next()) {
            return rs.getLong(1);
        } else throw new DaoOperationException("Can not get generated id");
    }

    private PreparedStatement fillStatementWithAnswerData(PreparedStatement insertStatement, Answer answer) throws SQLException {
        insertStatement.setString(1, answer.getText());
        insertStatement.setBoolean(2, answer.isRight());
        insertStatement.setLong(3, answer.getQuestion().getId());
        return insertStatement;
    }

    @Override
    public Answer update(Long id, Answer answer) {
        try (Connection connection = dataSource.getConnection()) {
            return updateAnswer(id, answer, connection);
        } catch (SQLException e) {
            throw new DaoOperationException(e.getMessage(), e);
        }
    }

    private Answer updateAnswer(Long id, Answer answer, Connection connection) throws SQLException {
        PreparedStatement updateStatement = prepareUpdateStatement(id, answer, connection);
        executeUpdate(updateStatement, "Answer was not updated!");
        return findById(id);
    }

    private void executeUpdate(PreparedStatement updateStatement, String error) throws SQLException {
        int affectedRows = updateStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new DaoOperationException(error);
        }
    }

    private PreparedStatement prepareUpdateStatement(Long id, Answer answer, Connection connection) {
        try {
            PreparedStatement updateStatement = connection.prepareStatement(UPDATE_ANSWER_SQL);
            updateStatement.setLong(4, id);
            return fillStatementWithAnswerData(updateStatement, answer);
        } catch (SQLException e) {
            throw new DaoOperationException("Can not prepare update statement");
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = dataSource.getConnection()) {
            deleteAnswer(id, connection);
        } catch (SQLException e) {
            throw new DaoOperationException(e.getMessage(), e);
        }
    }

    private void deleteAnswer(Long id, Connection connection) throws SQLException {
        PreparedStatement deleteStatement = prepareDeleteStatement(id, connection);
        executeUpdate(deleteStatement, "Answer was not deleted!");
    }

    private PreparedStatement prepareDeleteStatement(Long id, Connection connection) {
        try {
            PreparedStatement deleteStatement = connection.prepareStatement(DELETE_ANSWER_SQL);
            deleteStatement.setLong(1, id);
            return deleteStatement;
        } catch (SQLException e) {
            throw new DaoOperationException("Can not prepare delete statement!");
        }
    }
}
