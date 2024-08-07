-- Package Specification
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_salary IN NUMBER);
    PROCEDURE UpdateEmployeeDetails(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_salary IN NUMBER);
    FUNCTION CalculateAnnualSalary(p_employee_id IN NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_salary IN NUMBER) IS
    BEGIN
        INSERT INTO employees (employee_id, employee_name, salary)
        VALUES (p_employee_id, p_name, p_salary);
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error hiring employee: ' || SQLERRM);
    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_salary IN NUMBER) IS
    BEGIN
        UPDATE employees
        SET employee_name = p_name, salary = p_salary
        WHERE employee_id = p_employee_id;
        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' does not exist.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error updating employee details: ' || SQLERRM);
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(p_employee_id IN NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT salary * 12 INTO v_salary
        FROM employees
        WHERE employee_id = p_employee_id;
        RETURN v_salary;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' does not exist.');
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error calculating annual salary: ' || SQLERRM);
            RETURN NULL;
    END CalculateAnnualSalary;

END EmployeeManagement;
/