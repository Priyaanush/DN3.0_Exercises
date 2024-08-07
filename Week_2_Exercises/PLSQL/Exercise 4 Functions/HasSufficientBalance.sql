CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN AS
    v_balance NUMBER;
BEGIN
    -- Fetch the current balance
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_account_id;
    
    -- Check if the balance is sufficient
    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Handle the case where the account ID does not exist
        DBMS_OUTPUT.PUT_LINE('Error: Account ID ' || p_account_id || ' does not exist.');
        RETURN FALSE;
    WHEN OTHERS THEN
        -- Handle other exceptions
        DBMS_OUTPUT.PUT_LINE('Error checking balance: ' || SQLERRM);
        RETURN FALSE;
END;