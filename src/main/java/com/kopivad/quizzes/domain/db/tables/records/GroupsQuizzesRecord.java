/*
 * This file is generated by jOOQ.
 */
package com.kopivad.quizzes.domain.db.tables.records;


import com.kopivad.quizzes.domain.db.tables.GroupsQuizzes;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;

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
public class GroupsQuizzesRecord extends TableRecordImpl<GroupsQuizzesRecord> implements Record2<Long, Long> {

    private static final long serialVersionUID = -930617410;

    /**
     * Setter for <code>public.groups_quizzes.group_id</code>.
     */
    public void setGroupId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.groups_quizzes.group_id</code>.
     */
    public Long getGroupId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.groups_quizzes.quiz_id</code>.
     */
    public void setQuizId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.groups_quizzes.quiz_id</code>.
     */
    public Long getQuizId() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Long, Long> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return GroupsQuizzes.GROUPS_QUIZZES.GROUP_ID;
    }

    @Override
    public Field<Long> field2() {
        return GroupsQuizzes.GROUPS_QUIZZES.QUIZ_ID;
    }

    @Override
    public Long component1() {
        return getGroupId();
    }

    @Override
    public Long component2() {
        return getQuizId();
    }

    @Override
    public Long value1() {
        return getGroupId();
    }

    @Override
    public Long value2() {
        return getQuizId();
    }

    @Override
    public GroupsQuizzesRecord value1(Long value) {
        setGroupId(value);
        return this;
    }

    @Override
    public GroupsQuizzesRecord value2(Long value) {
        setQuizId(value);
        return this;
    }

    @Override
    public GroupsQuizzesRecord values(Long value1, Long value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GroupsQuizzesRecord
     */
    public GroupsQuizzesRecord() {
        super(GroupsQuizzes.GROUPS_QUIZZES);
    }

    /**
     * Create a detached, initialised GroupsQuizzesRecord
     */
    public GroupsQuizzesRecord(Long groupId, Long quizId) {
        super(GroupsQuizzes.GROUPS_QUIZZES);

        set(0, groupId);
        set(1, quizId);
    }
}
