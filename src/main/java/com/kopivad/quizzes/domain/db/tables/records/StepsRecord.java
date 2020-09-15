/*
 * This file is generated by jOOQ.
 */
package com.kopivad.quizzes.domain.db.tables.records;


import com.kopivad.quizzes.domain.db.tables.Steps;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.processing.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StepsRecord extends UpdatableRecordImpl<StepsRecord> implements Record5<Long, Integer, Integer, String, Long> {

    private static final long serialVersionUID = 331916057;

    /**
     * Setter for <code>public.steps.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.steps.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.steps.min_total</code>.
     */
    public void setMinTotal(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.steps.min_total</code>.
     */
    public Integer getMinTotal() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.steps.max_total</code>.
     */
    public void setMaxTotal(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.steps.max_total</code>.
     */
    public Integer getMaxTotal() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.steps.rating</code>.
     */
    public void setRating(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.steps.rating</code>.
     */
    public String getRating() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.steps.quiz_id</code>.
     */
    public void setQuizId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.steps.quiz_id</code>.
     */
    public Long getQuizId() {
        return (Long) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Integer, Integer, String, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, Integer, Integer, String, Long> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Steps.STEPS.ID;
    }

    @Override
    public Field<Integer> field2() {
        return Steps.STEPS.MIN_TOTAL;
    }

    @Override
    public Field<Integer> field3() {
        return Steps.STEPS.MAX_TOTAL;
    }

    @Override
    public Field<String> field4() {
        return Steps.STEPS.RATING;
    }

    @Override
    public Field<Long> field5() {
        return Steps.STEPS.QUIZ_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getMinTotal();
    }

    @Override
    public Integer component3() {
        return getMaxTotal();
    }

    @Override
    public String component4() {
        return getRating();
    }

    @Override
    public Long component5() {
        return getQuizId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getMinTotal();
    }

    @Override
    public Integer value3() {
        return getMaxTotal();
    }

    @Override
    public String value4() {
        return getRating();
    }

    @Override
    public Long value5() {
        return getQuizId();
    }

    @Override
    public StepsRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public StepsRecord value2(Integer value) {
        setMinTotal(value);
        return this;
    }

    @Override
    public StepsRecord value3(Integer value) {
        setMaxTotal(value);
        return this;
    }

    @Override
    public StepsRecord value4(String value) {
        setRating(value);
        return this;
    }

    @Override
    public StepsRecord value5(Long value) {
        setQuizId(value);
        return this;
    }

    @Override
    public StepsRecord values(Long value1, Integer value2, Integer value3, String value4, Long value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StepsRecord
     */
    public StepsRecord() {
        super(Steps.STEPS);
    }

    /**
     * Create a detached, initialised StepsRecord
     */
    public StepsRecord(Long id, Integer minTotal, Integer maxTotal, String rating, Long quizId) {
        super(Steps.STEPS);

        set(0, id);
        set(1, minTotal);
        set(2, maxTotal);
        set(3, rating);
        set(4, quizId);
    }
}