/*
 * This file is generated by jOOQ.
 */
package com.kopivad.quizzes.domain.db.tables;


import com.kopivad.quizzes.domain.db.Keys;
import com.kopivad.quizzes.domain.db.Public;
import com.kopivad.quizzes.domain.db.tables.records.UsrsGroupsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class UsrsGroups extends TableImpl<UsrsGroupsRecord> {

    private static final long serialVersionUID = 2083201979;

    /**
     * The reference instance of <code>public.usrs_groups</code>
     */
    public static final UsrsGroups USRS_GROUPS = new UsrsGroups();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsrsGroupsRecord> getRecordType() {
        return UsrsGroupsRecord.class;
    }

    /**
     * The column <code>public.usrs_groups.user_id</code>.
     */
    public final TableField<UsrsGroupsRecord, Long> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.usrs_groups.group_id</code>.
     */
    public final TableField<UsrsGroupsRecord, Long> GROUP_ID = createField(DSL.name("group_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>public.usrs_groups</code> table reference
     */
    public UsrsGroups() {
        this(DSL.name("usrs_groups"), null);
    }

    /**
     * Create an aliased <code>public.usrs_groups</code> table reference
     */
    public UsrsGroups(String alias) {
        this(DSL.name(alias), USRS_GROUPS);
    }

    /**
     * Create an aliased <code>public.usrs_groups</code> table reference
     */
    public UsrsGroups(Name alias) {
        this(alias, USRS_GROUPS);
    }

    private UsrsGroups(Name alias, Table<UsrsGroupsRecord> aliased) {
        this(alias, aliased, null);
    }

    private UsrsGroups(Name alias, Table<UsrsGroupsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> UsrsGroups(Table<O> child, ForeignKey<O, UsrsGroupsRecord> key) {
        super(child, key, USRS_GROUPS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public List<ForeignKey<UsrsGroupsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UsrsGroupsRecord, ?>>asList(Keys.USRS_GROUPS__USRS_GROUPS_USR_ID_FK, Keys.USRS_GROUPS__USRS_GROUPS_GROUPS_ID_FK);
    }

    public Usr usr() {
        return new Usr(this, Keys.USRS_GROUPS__USRS_GROUPS_USR_ID_FK);
    }

    public Groups groups() {
        return new Groups(this, Keys.USRS_GROUPS__USRS_GROUPS_GROUPS_ID_FK);
    }

    @Override
    public UsrsGroups as(String alias) {
        return new UsrsGroups(DSL.name(alias), this);
    }

    @Override
    public UsrsGroups as(Name alias) {
        return new UsrsGroups(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UsrsGroups rename(String name) {
        return new UsrsGroups(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UsrsGroups rename(Name name) {
        return new UsrsGroups(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}