/*
 * This file is generated by jOOQ.
 */
package com.kopivad.quizzes.domain.db.tables.records;


import com.kopivad.quizzes.domain.db.tables.Questions;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class QuestionsRecord extends UpdatableRecordImpl<QuestionsRecord> implements Record4<Long, String, Long, String> {

    private static final long serialVersionUID = 1075041316;

    /**
     * Setter for <code>public.questions.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.questions.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.questions.title</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.questions.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.questions.quiz_id</code>.
     */
    public void setQuizId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.questions.quiz_id</code>.
     */
    public Long getQuizId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.questions.type</code>.
     */
    public void setType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.questions.type</code>.
     */
    public String getType() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, Long, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, String, Long, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Questions.QUESTIONS.ID;
    }

    @Override
    public Field<String> field2() {
        return Questions.QUESTIONS.TITLE;
    }

    @Override
    public Field<Long> field3() {
        return Questions.QUESTIONS.QUIZ_ID;
    }

    @Override
    public Field<String> field4() {
        return Questions.QUESTIONS.TYPE;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getTitle();
    }

    @Override
    public Long component3() {
        return getQuizId();
    }

    @Override
    public String component4() {
        return getType();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getTitle();
    }

    @Override
    public Long value3() {
        return getQuizId();
    }

    @Override
    public String value4() {
        return getType();
    }

    @Override
    public QuestionsRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public QuestionsRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public QuestionsRecord value3(Long value) {
        setQuizId(value);
        return this;
    }

    @Override
    public QuestionsRecord value4(String value) {
        setType(value);
        return this;
    }

    @Override
    public QuestionsRecord values(Long value1, String value2, Long value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached QuestionsRecord
     */
    public QuestionsRecord() {
        super(Questions.QUESTIONS);
    }

    /**
     * Create a detached, initialised QuestionsRecord
     */
    public QuestionsRecord(Long id, String title, Long quizId, String type) {
        super(Questions.QUESTIONS);

        set(0, id);
        set(1, title);
        set(2, quizId);
        set(3, type);
    }
}
