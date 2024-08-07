DECLARE
    CURSOR customer_cursor IS
        SELECT customer_id, balance
        FROM customers
        WHERE balance > 10000;

    v_customer_id customers.customer_id%TYPE;
    v_balance customers.balance%TYPE;
BEGIN
    FOR customer_record IN customer_cursor LOOP
        v_customer_id := customer_record.customer_id;
        v_balance := customer_record.balance;
        
        -- Set IsVIP flag to TRUE
        UPDATE customers
        SET is_vip = TRUE
        WHERE customer_id = v_customer_id;
        
        -- Commit after each update if necessary (optional, depending on requirements)
        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Customer with ID ' || v_customer_id || ' promoted to VIP.');
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('VIP promotion completed.');
END;