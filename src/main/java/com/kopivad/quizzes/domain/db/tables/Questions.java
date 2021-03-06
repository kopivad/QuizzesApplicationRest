/*
 * This file is generated by jOOQ.
 */
package com.kopivad.quizzes.domain.db.tables;


import com.kopivad.quizzes.domain.db.Indexes;
import com.kopivad.quizzes.domain.db.Keys;
import com.kopivad.quizzes.domain.db.Public;
import com.kopivad.quizzes.domain.db.tables.records.QuestionsRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.processing.Generated;
import java.util.Arrays;
import java.util.List;


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
public class Questions extends TableImpl<QuestionsRecord> {

    private static final long serialVersionUID = -1982031004;

    /**
     * The reference instance of <code>public.questions</code>
     */
    public static final Questions QUESTIONS = new Questions();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QuestionsRecord> getRecordType() {
        return QuestionsRecord.class;
    }

    /**
     * The column <code>public.questions.id</code>.
     */
    public final TableField<QuestionsRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(DSL.field("nextval('questions_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.questions.title</code>.
     */
    public final TableField<QuestionsRecord, String> TITLE = createField(DSL.name("title"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.questions.value</code>.
     */
    public final TableField<QuestionsRecord, Integer> VALUE = createField(DSL.name("value"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.questions.type</code>.
     */
    public final TableField<QuestionsRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.questions.quiz_id</code>.
     */
    public final TableField<QuestionsRecord, Long> QUIZ_ID = createField(DSL.name("quiz_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>public.questions</code> table reference
     */
    public Questions() {
        this(DSL.name("questions"), null);
    }

    /**
     * Create an aliased <code>public.questions</code> table reference
     */
    public Questions(String alias) {
        this(DSL.name(alias), QUESTIONS);
    }

    /**
     * Create an aliased <code>public.questions</code> table reference
     */
    public Questions(Name alias) {
        this(alias, QUESTIONS);
    }

    private Questions(Name alias, Table<QuestionsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Questions(Name alias, Table<QuestionsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Questions(Table<O> child, ForeignKey<O, QuestionsRecord> key) {
        super(child, key, QUESTIONS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.QUESTIONS_PK);
    }

    @Override
    public Identity<QuestionsRecord, Long> getIdentity() {
        return Keys.IDENTITY_QUESTIONS;
    }

    @Override
    public UniqueKey<QuestionsRecord> getPrimaryKey() {
        return Keys.QUESTIONS_PK;
    }

    @Override
    public List<UniqueKey<QuestionsRecord>> getKeys() {
        return Arrays.<UniqueKey<QuestionsRecord>>asList(Keys.QUESTIONS_PK);
    }

    @Override
    public List<ForeignKey<QuestionsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<QuestionsRecord, ?>>asList(Keys.QUESTIONS__QUESTIONS_QUIZZES_ID_FK);
    }

    public Quizzes quizzes() {
        return new Quizzes(this, Keys.QUESTIONS__QUESTIONS_QUIZZES_ID_FK);
    }

    @Override
    public Questions as(String alias) {
        return new Questions(DSL.name(alias), this);
    }

    @Override
    public Questions as(Name alias) {
        return new Questions(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Questions rename(String name) {
        return new Questions(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Questions rename(Name name) {
        return new Questions(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, String, Integer, String, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
