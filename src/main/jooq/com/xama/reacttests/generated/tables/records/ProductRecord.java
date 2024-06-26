/*
 * This file is generated by jOOQ.
 */
package com.xama.reacttests.generated.tables.records;


import com.xama.reacttests.generated.tables.Product;

import java.util.UUID;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ProductRecord extends UpdatableRecordImpl<ProductRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.product.id</code>.
     */
    public ProductRecord setId(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.product.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.product.name</code>.
     */
    public ProductRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.product.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProductRecord
     */
    public ProductRecord() {
        super(Product.PRODUCT);
    }

    /**
     * Create a detached, initialised ProductRecord
     */
    public ProductRecord(UUID id, String name) {
        super(Product.PRODUCT);

        setId(id);
        setName(name);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised ProductRecord
     */
    public ProductRecord(com.xama.reacttests.generated.tables.pojos.Product value) {
        super(Product.PRODUCT);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            resetChangedOnNotNull();
        }
    }
}
