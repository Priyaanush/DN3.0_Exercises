CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) AS
    v_current_salary NUMBER;
BEGIN
    -- Check if the employee exists and fetch the current salary
    BEGIN
        SELECT salary INTO v_current_salary
        FROM employees
        WHERE employee_id = p_employee_id;
        
        -- Update the salary
        UPDATE employees
        SET salary = salary * (1 + p_percentage / 100)
        WHERE employee_id = p_employee_id;
        
        -- Commit the transaction
        COMMIT;
        
        DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            -- Handle the case where the employee ID does not exist
            DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' does not exist.');
        WHEN OTHERS THEN
            -- Handle other exceptions
            DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
    END;
END;