/*
 * This file is generated by jOOQ.
 */
package com.kopivad.quizzes.domain.db;


import com.kopivad.quizzes.domain.db.tables.Answers;
import com.kopivad.quizzes.domain.db.tables.ApiClients;
import com.kopivad.quizzes.domain.db.tables.EvaluationSteps;
import com.kopivad.quizzes.domain.db.tables.Questions;
import com.kopivad.quizzes.domain.db.tables.QuizAnswers;
import com.kopivad.quizzes.domain.db.tables.QuizHistories;
import com.kopivad.quizzes.domain.db.tables.QuizSessions;
import com.kopivad.quizzes.domain.db.tables.Quizzes;
import com.kopivad.quizzes.domain.db.tables.Usr;
import com.kopivad.quizzes.domain.db.tables.UsrRoles;
import com.kopivad.quizzes.domain.db.tables.records.AnswersRecord;
import com.kopivad.quizzes.domain.db.tables.records.ApiClientsRecord;
import com.kopivad.quizzes.domain.db.tables.records.EvaluationStepsRecord;
import com.kopivad.quizzes.domain.db.tables.records.QuestionsRecord;
import com.kopivad.quizzes.domain.db.tables.records.QuizAnswersRecord;
import com.kopivad.quizzes.domain.db.tables.records.QuizHistoriesRecord;
import com.kopivad.quizzes.domain.db.tables.records.QuizSessionsRecord;
import com.kopivad.quizzes.domain.db.tables.records.QuizzesRecord;
import com.kopivad.quizzes.domain.db.tables.records.UsrRecord;
import com.kopivad.quizzes.domain.db.tables.records.UsrRolesRecord;

import javax.annotation.processing.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AnswersRecord> ANSWERS_PKEY = UniqueKeys0.ANSWERS_PKEY;
    public static final UniqueKey<ApiClientsRecord> API_CLIENTS_PKEY = UniqueKeys0.API_CLIENTS_PKEY;
    public static final UniqueKey<EvaluationStepsRecord> EVALUATION_STEPS_PK = UniqueKeys0.EVALUATION_STEPS_PK;
    public static final UniqueKey<QuestionsRecord> QUESTIONS_PKEY = UniqueKeys0.QUESTIONS_PKEY;
    public static final UniqueKey<QuizAnswersRecord> QUIZ_RESULTS_PK = UniqueKeys0.QUIZ_RESULTS_PK;
    public static final UniqueKey<QuizHistoriesRecord> QUIZ_HISTORIES_PK = UniqueKeys0.QUIZ_HISTORIES_PK;
    public static final UniqueKey<QuizSessionsRecord> QUIZ_SESSIONS_PK = UniqueKeys0.QUIZ_SESSIONS_PK;
    public static final UniqueKey<QuizzesRecord> QUIZZES_PKEY = UniqueKeys0.QUIZZES_PKEY;
    public static final UniqueKey<UsrRecord> USR_PKEY = UniqueKeys0.USR_PKEY;
    public static final UniqueKey<UsrRolesRecord> USR_ROLES_PK = UniqueKeys0.USR_ROLES_PK;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AnswersRecord, QuestionsRecord> ANSWERS__ANSWERS_QUESTIONS_FK = ForeignKeys0.ANSWERS__ANSWERS_QUESTIONS_FK;
    public static final ForeignKey<EvaluationStepsRecord, QuizzesRecord> EVALUATION_STEPS__EVALUATION_STEPS_QUIZZES_ID_FK = ForeignKeys0.EVALUATION_STEPS__EVALUATION_STEPS_QUIZZES_ID_FK;
    public static final ForeignKey<QuestionsRecord, QuizzesRecord> QUESTIONS__QUESTIONS_QUIZZES_FK = ForeignKeys0.QUESTIONS__QUESTIONS_QUIZZES_FK;
    public static final ForeignKey<QuizAnswersRecord, AnswersRecord> QUIZ_ANSWERS__QUIZ_RESULTS_ANSWERS_ID_FK = ForeignKeys0.QUIZ_ANSWERS__QUIZ_RESULTS_ANSWERS_ID_FK;
    public static final ForeignKey<QuizAnswersRecord, QuestionsRecord> QUIZ_ANSWERS__QUIZ_RESULTS_QUESTIONS_ID_FK = ForeignKeys0.QUIZ_ANSWERS__QUIZ_RESULTS_QUESTIONS_ID_FK;
    public static final ForeignKey<QuizAnswersRecord, QuizSessionsRecord> QUIZ_ANSWERS__QUIZ_RESULTS_QUIZ_SESSIONS_ID_FK = ForeignKeys0.QUIZ_ANSWERS__QUIZ_RESULTS_QUIZ_SESSIONS_ID_FK;
    public static final ForeignKey<QuizHistoriesRecord, UsrRecord> QUIZ_HISTORIES__QUIZ_HISTORIES_USR_ID_FK = ForeignKeys0.QUIZ_HISTORIES__QUIZ_HISTORIES_USR_ID_FK;
    public static final ForeignKey<QuizHistoriesRecord, QuizSessionsRecord> QUIZ_HISTORIES__QUIZ_HISTORIES_QUIZ_SESSIONS_ID_FK = ForeignKeys0.QUIZ_HISTORIES__QUIZ_HISTORIES_QUIZ_SESSIONS_ID_FK;
    public static final ForeignKey<QuizSessionsRecord, QuizzesRecord> QUIZ_SESSIONS__QUIZ_SESSIONS_QUIZZES_ID_FK = ForeignKeys0.QUIZ_SESSIONS__QUIZ_SESSIONS_QUIZZES_ID_FK;
    public static final ForeignKey<QuizSessionsRecord, UsrRecord> QUIZ_SESSIONS__QUIZ_SESSIONS_USR_ID_FK = ForeignKeys0.QUIZ_SESSIONS__QUIZ_SESSIONS_USR_ID_FK;
    public static final ForeignKey<QuizzesRecord, UsrRecord> QUIZZES__QUIZZES_USR_FK = ForeignKeys0.QUIZZES__QUIZZES_USR_FK;
    public static final ForeignKey<UsrRolesRecord, UsrRecord> USR_ROLES__USR_ROLES_USR_ID_FK = ForeignKeys0.USR_ROLES__USR_ROLES_USR_ID_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<AnswersRecord> ANSWERS_PKEY = Internal.createUniqueKey(Answers.ANSWERS, "answers_pkey", Answers.ANSWERS.ID);
        public static final UniqueKey<ApiClientsRecord> API_CLIENTS_PKEY = Internal.createUniqueKey(ApiClients.API_CLIENTS, "api_clients_pkey", ApiClients.API_CLIENTS.ID);
        public static final UniqueKey<EvaluationStepsRecord> EVALUATION_STEPS_PK = Internal.createUniqueKey(EvaluationSteps.EVALUATION_STEPS, "evaluation_steps_pk", EvaluationSteps.EVALUATION_STEPS.ID);
        public static final UniqueKey<QuestionsRecord> QUESTIONS_PKEY = Internal.createUniqueKey(Questions.QUESTIONS, "questions_pkey", Questions.QUESTIONS.ID);
        public static final UniqueKey<QuizAnswersRecord> QUIZ_RESULTS_PK = Internal.createUniqueKey(QuizAnswers.QUIZ_ANSWERS, "quiz_results_pk", QuizAnswers.QUIZ_ANSWERS.ID);
        public static final UniqueKey<QuizHistoriesRecord> QUIZ_HISTORIES_PK = Internal.createUniqueKey(QuizHistories.QUIZ_HISTORIES, "quiz_histories_pk", QuizHistories.QUIZ_HISTORIES.ID);
        public static final UniqueKey<QuizSessionsRecord> QUIZ_SESSIONS_PK = Internal.createUniqueKey(QuizSessions.QUIZ_SESSIONS, "quiz_sessions_pk", QuizSessions.QUIZ_SESSIONS.ID);
        public static final UniqueKey<QuizzesRecord> QUIZZES_PKEY = Internal.createUniqueKey(Quizzes.QUIZZES, "quizzes_pkey", Quizzes.QUIZZES.ID);
        public static final UniqueKey<UsrRecord> USR_PKEY = Internal.createUniqueKey(Usr.USR, "usr_pkey", Usr.USR.ID);
        public static final UniqueKey<UsrRolesRecord> USR_ROLES_PK = Internal.createUniqueKey(UsrRoles.USR_ROLES, "usr_roles_pk", UsrRoles.USR_ROLES.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<AnswersRecord, QuestionsRecord> ANSWERS__ANSWERS_QUESTIONS_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.QUESTIONS_PKEY, Answers.ANSWERS, "answers__answers_questions_fk", Answers.ANSWERS.QUESTION_ID);
        public static final ForeignKey<EvaluationStepsRecord, QuizzesRecord> EVALUATION_STEPS__EVALUATION_STEPS_QUIZZES_ID_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.QUIZZES_PKEY, EvaluationSteps.EVALUATION_STEPS, "evaluation_steps__evaluation_steps_quizzes_id_fk", EvaluationSteps.EVALUATION_STEPS.QUIZ_ID);
        public static final ForeignKey<QuestionsRecord, QuizzesRecord> QUESTIONS__QUESTIONS_QUIZZES_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.QUIZZES_PKEY, Questions.QUESTIONS, "questions__questions_quizzes_fk", Questions.QUESTIONS.QUIZ_ID);
        public static final ForeignKey<QuizAnswersRecord, AnswersRecord> QUIZ_ANSWERS__QUIZ_RESULTS_ANSWERS_ID_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.ANSWERS_PKEY, QuizAnswers.QUIZ_ANSWERS, "quiz_answers__quiz_results_answers_id_fk", QuizAnswers.QUIZ_ANSWERS.ANSWER_ID);
        public static final ForeignKey<QuizAnswersRecord, QuestionsRecord> QUIZ_ANSWERS__QUIZ_RESULTS_QUESTIONS_ID_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.QUESTIONS_PKEY, QuizAnswers.QUIZ_ANSWERS, "quiz_answers__quiz_results_questions_id_fk", QuizAnswers.QUIZ_ANSWERS.QUESTION_ID);
        public static final ForeignKey<QuizAnswersRecord, QuizSessionsRecord> QUIZ_ANSWERS__QUIZ_RESULTS_QUIZ_SESSIONS_ID_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.QUIZ_SESSIONS_PK, QuizAnswers.QUIZ_ANSWERS, "quiz_answers__quiz_results_quiz_sessions_id_fk", QuizAnswers.QUIZ_ANSWERS.SESSION_ID);
        public static final ForeignKey<QuizHistoriesRecord, UsrRecord> QUIZ_HISTORIES__QUIZ_HISTORIES_USR_ID_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.USR_PKEY, QuizHistories.QUIZ_HISTORIES, "quiz_histories__quiz_histories_usr_id_fk", QuizHistories.QUIZ_HISTORIES.USER_ID);
        public static final ForeignKey<QuizHistoriesRecord, QuizSessionsRecord> QUIZ_HISTORIES__QUIZ_HISTORIES_QUIZ_SESSIONS_ID_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.QUIZ_SESSIONS_PK, QuizHistories.QUIZ_HISTORIES, "quiz_histories__quiz_histories_quiz_sessions_id_fk", QuizHistories.QUIZ_HISTORIES.SESSION_ID);
        public static final ForeignKey<QuizSessionsRecord, QuizzesRecord> QUIZ_SESSIONS__QUIZ_SESSIONS_QUIZZES_ID_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.QUIZZES_PKEY, QuizSessions.QUIZ_SESSIONS, "quiz_sessions__quiz_sessions_quizzes_id_fk", QuizSessions.QUIZ_SESSIONS.QUIZ_ID);
        public static final ForeignKey<QuizSessionsRecord, UsrRecord> QUIZ_SESSIONS__QUIZ_SESSIONS_USR_ID_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.USR_PKEY, QuizSessions.QUIZ_SESSIONS, "quiz_sessions__quiz_sessions_usr_id_fk", QuizSessions.QUIZ_SESSIONS.USER_ID);
        public static final ForeignKey<QuizzesRecord, UsrRecord> QUIZZES__QUIZZES_USR_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.USR_PKEY, Quizzes.QUIZZES, "quizzes__quizzes_usr_fk", Quizzes.QUIZZES.AUTHOR_ID);
        public static final ForeignKey<UsrRolesRecord, UsrRecord> USR_ROLES__USR_ROLES_USR_ID_FK = Internal.createForeignKey(com.kopivad.quizzes.domain.db.Keys.USR_PKEY, UsrRoles.USR_ROLES, "usr_roles__usr_roles_usr_id_fk", UsrRoles.USR_ROLES.USER_ID);
    }
}
