CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check if the source account has sufficient funds
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_from_account_id;
    
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds for account ID ' || p_from_account_id);
    END IF;
    
    -- Start the transaction
    BEGIN
        -- Deduct the amount from the source account
        UPDATE accounts
        SET balance = balance - p_amount
        WHERE account_id = p_from_account_id;
        
        -- Add the amount to the destination account
        UPDATE accounts
        SET balance = balance + p_amount
        WHERE account_id = p_to_account_id;
        
        -- Commit the transaction
        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
    EXCEPTION
        WHEN OTHERS THEN
            -- Rollback transaction in case of error
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Error during fund transfer: ' || SQLERRM);
    END;
END;