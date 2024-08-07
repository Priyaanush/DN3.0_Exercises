CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    -- Update the salary with the bonus percentage
    UPDATE employees
    SET salary = salary * (1 + p_bonus_percentage / 100)
    WHERE department_id = p_department_id;
    
    -- Commit the transaction
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Salaries updated with bonus for department ID ' || p_department_id);
EXCEPTION
    WHEN OTHERS THEN
        -- Handle any exceptions that may occur
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonuses: ' || SQLERRM);
        ROLLBACK;
END;