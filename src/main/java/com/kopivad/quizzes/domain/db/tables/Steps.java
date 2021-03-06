/*
 * This file is generated by jOOQ.
 */
package com.kopivad.quizzes.domain.db.tables;


import com.kopivad.quizzes.domain.db.Indexes;
import com.kopivad.quizzes.domain.db.Keys;
import com.kopivad.quizzes.domain.db.Public;
import com.kopivad.quizzes.domain.db.tables.records.StepsRecord;
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
public class Steps extends TableImpl<StepsRecord> {

    private static final long serialVersionUID = -1704090421;

    /**
     * The reference instance of <code>public.steps</code>
     */
    public static final Steps STEPS = new Steps();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StepsRecord> getRecordType() {
        return StepsRecord.class;
    }

    /**
     * The column <code>public.steps.id</code>.
     */
    public final TableField<StepsRecord, Long> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(DSL.field("nextval('steps_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.steps.min_total</code>.
     */
    public final TableField<StepsRecord, Integer> MIN_TOTAL = createField(DSL.name("min_total"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.steps.max_total</code>.
     */
    public final TableField<StepsRecord, Integer> MAX_TOTAL = createField(DSL.name("max_total"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.steps.rating</code>.
     */
    public final TableField<StepsRecord, String> RATING = createField(DSL.name("rating"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.steps.quiz_id</code>.
     */
    public final TableField<StepsRecord, Long> QUIZ_ID = createField(DSL.name("quiz_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>public.steps</code> table reference
     */
    public Steps() {
        this(DSL.name("steps"), null);
    }

    /**
     * Create an aliased <code>public.steps</code> table reference
     */
    public Steps(String alias) {
        this(DSL.name(alias), STEPS);
    }

    /**
     * Create an aliased <code>public.steps</code> table reference
     */
    public Steps(Name alias) {
        this(alias, STEPS);
    }

    private Steps(Name alias, Table<StepsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Steps(Name alias, Table<StepsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Steps(Table<O> child, ForeignKey<O, StepsRecord> key) {
        super(child, key, STEPS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.STEPS_PK);
    }

    @Override
    public Identity<StepsRecord, Long> getIdentity() {
        return Keys.IDENTITY_STEPS;
    }

    @Override
    public UniqueKey<StepsRecord> getPrimaryKey() {
        return Keys.STEPS_PK;
    }

    @Override
    public List<UniqueKey<StepsRecord>> getKeys() {
        return Arrays.<UniqueKey<StepsRecord>>asList(Keys.STEPS_PK);
    }

    @Override
    public List<ForeignKey<StepsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<StepsRecord, ?>>asList(Keys.STEPS__STEPS_QUIZZES_ID_FK);
    }

    public Quizzes quizzes() {
        return new Quizzes(this, Keys.STEPS__STEPS_QUIZZES_ID_FK);
    }

    @Override
    public Steps as(String alias) {
        return new Steps(DSL.name(alias), this);
    }

    @Override
    public Steps as(Name alias) {
        return new Steps(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Steps rename(String name) {
        return new Steps(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Steps rename(Name name) {
        return new Steps(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Integer, Integer, String, Long> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
