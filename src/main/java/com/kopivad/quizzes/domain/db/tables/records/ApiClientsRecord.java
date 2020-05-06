/*
 * This file is generated by jOOQ.
 */
package com.kopivad.quizzes.domain.db.tables.records;


import com.kopivad.quizzes.domain.db.tables.ApiClients;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class ApiClientsRecord extends UpdatableRecordImpl<ApiClientsRecord> implements Record3<Long, String, String> {

    private static final long serialVersionUID = 239133597;

    /**
     * Setter for <code>public.api_clients.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.api_clients.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.api_clients.password</code>.
     */
    public void setPassword(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.api_clients.password</code>.
     */
    public String getPassword() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.api_clients.username</code>.
     */
    public void setUsername(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.api_clients.username</code>.
     */
    public String getUsername() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return ApiClients.API_CLIENTS.ID;
    }

    @Override
    public Field<String> field2() {
        return ApiClients.API_CLIENTS.PASSWORD;
    }

    @Override
    public Field<String> field3() {
        return ApiClients.API_CLIENTS.USERNAME;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getPassword();
    }

    @Override
    public String component3() {
        return getUsername();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getPassword();
    }

    @Override
    public String value3() {
        return getUsername();
    }

    @Override
    public ApiClientsRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public ApiClientsRecord value2(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public ApiClientsRecord value3(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public ApiClientsRecord values(Long value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ApiClientsRecord
     */
    public ApiClientsRecord() {
        super(ApiClients.API_CLIENTS);
    }

    /**
     * Create a detached, initialised ApiClientsRecord
     */
    public ApiClientsRecord(Long id, String password, String username) {
        super(ApiClients.API_CLIENTS);

        set(0, id);
        set(1, password);
        set(2, username);
    }
}
