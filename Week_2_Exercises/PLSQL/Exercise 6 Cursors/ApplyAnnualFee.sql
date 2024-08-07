DECLARE
    CURSOR account_cursor IS
        SELECT account_id, balance
        FROM accounts;

    v_account_id accounts.account_id%TYPE;
    v_balance accounts.balance%TYPE;
    v_annual_fee CONSTANT NUMBER := 50; -- Assuming the annual fee is $50
BEGIN
    OPEN account_cursor;
    LOOP
        FETCH account_cursor INTO v_account_id, v_balance;
        EXIT WHEN account_cursor%NOTFOUND;
        
        -- Deduct the annual fee
        UPDATE accounts
        SET balance = balance - v_annual_fee
        WHERE account_id = v_account_id;
        
        -- Commit after each update (optional, depending on requirements)
        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Annual fee applied to account ID: ' || v_account_id);
    END LOOP;
    CLOSE account_cursor;
    
    DBMS_OUTPUT.PUT_LINE('Annual fee application completed.');
END;