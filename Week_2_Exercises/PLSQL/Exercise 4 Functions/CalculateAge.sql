CREATE OR REPLACE FUNCTION CalculateAge(
    p_date_of_birth IN DATE
) RETURN NUMBER AS
    v_age NUMBER;
BEGIN
    -- Calculate the age
    SELECT FLOOR(MONTHS_BETWEEN(SYSDATE, p_date_of_birth) / 12) INTO v_age
    FROM dual;
    
    RETURN v_age;
EXCEPTION
    WHEN OTHERS THEN
        -- Handle exceptions and return a default value
        DBMS_OUTPUT.PUT_LINE('Error calculating age: ' || SQLERRM);
        RETURN NULL;
END;