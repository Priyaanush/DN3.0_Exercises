-- Package Specification
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_account_id IN NUMBER, p_customer_id IN NUMBER, p_initial_balance IN NUMBER);
    PROCEDURE CloseAccount(p_account_id IN NUMBER);
    FUNCTION GetTotalBalance(p_customer_id IN NUMBER) RETURN NUMBER;
END AccountOperations;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(p_account_id IN NUMBER, p_customer_id IN NUMBER, p_initial_balance IN NUMBER) IS
    BEGIN
        INSERT INTO accounts (account_id, customer_id, balance)
        VALUES (p_account_id, p_customer_id, p_initial_balance);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Account ID ' || p_account_id || ' already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error opening account: ' || SQLERRM);
    END OpenAccount;

    PROCEDURE CloseAccount(p_account_id IN NUMBER) IS
    BEGIN
        DELETE FROM accounts
        WHERE account_id = p_account_id;
        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Account ID ' || p_account_id || ' does not exist.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error closing account: ' || SQLERRM);
    END CloseAccount;

    FUNCTION GetTotalBalance(p_customer_id IN NUMBER) RETURN NUMBER IS
        v_total_balance NUMBER;
    BEGIN
        SELECT SUM(balance) INTO v_total_balance
        FROM accounts
        WHERE customer_id = p_customer_id;
        RETURN v_total_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customer_id || ' does not exist.');
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error fetching total balance: ' || SQLERRM);
            RETURN NULL;
    END GetTotalBalance;

END AccountOperations;
/