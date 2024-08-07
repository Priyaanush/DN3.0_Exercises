-- Package Specification
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_customer_id IN NUMBER, p_name IN VARCHAR2, p_balance IN NUMBER);
    PROCEDURE UpdateCustomerDetails(p_customer_id IN NUMBER, p_name IN VARCHAR2);
    FUNCTION GetCustomerBalance(p_customer_id IN NUMBER) RETURN NUMBER;
END CustomerManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(p_customer_id IN NUMBER, p_name IN VARCHAR2, p_balance IN NUMBER) IS
    BEGIN
        INSERT INTO customers (customer_id, customer_name, balance)
        VALUES (p_customer_id, p_name, p_balance);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customer_id || ' already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
    END AddCustomer;

    PROCEDURE UpdateCustomerDetails(p_customer_id IN NUMBER, p_name IN VARCHAR2) IS
    BEGIN
        UPDATE customers
        SET customer_name = p_name
        WHERE customer_id = p_customer_id;
        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customer_id || ' does not exist.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error updating customer details: ' || SQLERRM);
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance(p_customer_id IN NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT balance INTO v_balance
        FROM customers
        WHERE customer_id = p_customer_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customer_id || ' does not exist.');
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error fetching customer balance: ' || SQLERRM);
            RETURN NULL;
    END GetCustomerBalance;

END CustomerManagement;
/