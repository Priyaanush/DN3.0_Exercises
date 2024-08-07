DECLARE
    CURSOR customer_cursor IS
        SELECT customer_id, age, loan_interest_rate
        FROM customers
        WHERE age > 60;

    v_customer_id customers.customer_id%TYPE;
    v_age customers.age%TYPE;
    v_loan_interest_rate customers.loan_interest_rate%TYPE;
BEGIN
    FOR customer_record IN customer_cursor LOOP
        v_customer_id := customer_record.customer_id;
        v_age := customer_record.age;
        v_loan_interest_rate := customer_record.loan_interest_rate;
        
        -- Apply a 1% discount
        UPDATE loans
        SET interest_rate = interest_rate - 0.01
        WHERE customer_id = v_customer_id;
        
        -- Commit after each update if necessary (optional, depending on requirements)
        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Applied discount to customer_id: ' || v_customer_id);
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Discount application completed.');
END;