CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    -- Update the balance for all savings accounts
    UPDATE savings_accounts
    SET balance = balance * 1.01; -- Apply 1% interest
    
    -- Commit the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        -- Handle any exceptions that may occur
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
        ROLLBACK;
END;