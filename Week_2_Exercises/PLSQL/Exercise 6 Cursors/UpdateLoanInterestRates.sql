DECLARE
    CURSOR loan_cursor IS
        SELECT loan_id, interest_rate
        FROM loans;

    v_loan_id loans.loan_id%TYPE;
    v_interest_rate loans.interest_rate%TYPE;
    v_new_interest_rate NUMBER;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_interest_rate;
        EXIT WHEN loan_cursor%NOTFOUND;
        
        -- Assume the new policy increases interest rate by 0.5%
        v_new_interest_rate := v_interest_rate + 0.5;
        
        -- Update the interest rate
        UPDATE loans
        SET interest_rate = v_new_interest_rate
        WHERE loan_id = v_loan_id;
        
        -- Commit after each update (optional, depending on requirements)
        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Updated interest rate for loan ID: ' || v_loan_id || ' to ' || v_new_interest_rate || '%');
    END LOOP;
    CLOSE loan_cursor;
    
    DBMS_OUTPUT.PUT_LINE('Interest rate update completed.');
END;