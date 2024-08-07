CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_balance IN NUMBER
) AS
BEGIN
    -- Attempt to insert a new customer
    BEGIN
        INSERT INTO customers (customer_id, customer_name, balance)
        VALUES (p_customer_id, p_name, p_balance);
        
        -- Commit the transaction
        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Customer added successfully.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            -- Handle the case where the customer ID already exists
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customer_id || ' already exists.');
        WHEN OTHERS THEN
            -- Handle other exceptions
            DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
    END;
END;