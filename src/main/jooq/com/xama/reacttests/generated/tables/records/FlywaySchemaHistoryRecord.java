/*
 * This file is generated by jOOQ.
 */
package com.xama.reacttests.generated.tables.records;


import com.xama.reacttests.generated.tables.FlywaySchemaHistory;

import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class FlywaySchemaHistoryRecord extends UpdatableRecordImpl<FlywaySchemaHistoryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.flyway_schema_history.installed_rank</code>.
     */
    public FlywaySchemaHistoryRecord setInstalledRank(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.flyway_schema_history.installed_rank</code>.
     */
    public Integer getInstalledRank() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.flyway_schema_history.version</code>.
     */
    public FlywaySchemaHistoryRecord setVersion(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.flyway_schema_history.version</code>.
     */
    public String getVersion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.flyway_schema_history.description</code>.
     */
    public FlywaySchemaHistoryRecord setDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.flyway_schema_history.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.flyway_schema_history.type</code>.
     */
    public FlywaySchemaHistoryRecord setType(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.flyway_schema_history.type</code>.
     */
    public String getType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.flyway_schema_history.script</code>.
     */
    public FlywaySchemaHistoryRecord setScript(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.flyway_schema_history.script</code>.
     */
    public String getScript() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.flyway_schema_history.checksum</code>.
     */
    public FlywaySchemaHistoryRecord setChecksum(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.flyway_schema_history.checksum</code>.
     */
    public Integer getChecksum() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.flyway_schema_history.installed_by</code>.
     */
    public FlywaySchemaHistoryRecord setInstalledBy(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.flyway_schema_history.installed_by</code>.
     */
    public String getInstalledBy() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.flyway_schema_history.installed_on</code>.
     */
    public FlywaySchemaHistoryRecord setInstalledOn(LocalDateTime value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.flyway_schema_history.installed_on</code>.
     */
    public LocalDateTime getInstalledOn() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>public.flyway_schema_history.execution_time</code>.
     */
    public FlywaySchemaHistoryRecord setExecutionTime(Integer value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.flyway_schema_history.execution_time</code>.
     */
    public Integer getExecutionTime() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.flyway_schema_history.success</code>.
     */
    public FlywaySchemaHistoryRecord setSuccess(Boolean value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.flyway_schema_history.success</code>.
     */
    public Boolean getSuccess() {
        return (Boolean) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FlywaySchemaHistoryRecord
     */
    public FlywaySchemaHistoryRecord() {
        super(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);
    }

    /**
     * Create a detached, initialised FlywaySchemaHistoryRecord
     */
    public FlywaySchemaHistoryRecord(Integer installedRank, String version, String description, String type, String script, Integer checksum, String installedBy, LocalDateTime installedOn, Integer executionTime, Boolean success) {
        super(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);

        setInstalledRank(installedRank);
        setVersion(version);
        setDescription(description);
        setType(type);
        setScript(script);
        setChecksum(checksum);
        setInstalledBy(installedBy);
        setInstalledOn(installedOn);
        setExecutionTime(executionTime);
        setSuccess(success);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised FlywaySchemaHistoryRecord
     */
    public FlywaySchemaHistoryRecord(com.xama.reacttests.generated.tables.pojos.FlywaySchemaHistory value) {
        super(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);

        if (value != null) {
            setInstalledRank(value.getInstalledRank());
            setVersion(value.getVersion());
            setDescription(value.getDescription());
            setType(value.getType());
            setScript(value.getScript());
            setChecksum(value.getChecksum());
            setInstalledBy(value.getInstalledBy());
            setInstalledOn(value.getInstalledOn());
            setExecutionTime(value.getExecutionTime());
            setSuccess(value.getSuccess());
            resetChangedOnNotNull();
        }
    }
}
