DECLARE
    CURSOR loan_cursor IS
        SELECT l.customer_id, c.customer_name, l.due_date
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;

    v_customer_id loans.customer_id%TYPE;
    v_customer_name customers.customer_name%TYPE;
    v_due_date loans.due_date%TYPE;
BEGIN
    FOR loan_record IN loan_cursor LOOP
        v_customer_id := loan_record.customer_id;
        v_customer_name := loan_record.customer_name;
        v_due_date := loan_record.due_date;
        
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan for customer ' || v_customer_name ||
                             ' (ID: ' || v_customer_id || ') is due on ' || v_due_date ||
                             '. Please make arrangements to repay.');
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Reminder notifications completed.');
END;