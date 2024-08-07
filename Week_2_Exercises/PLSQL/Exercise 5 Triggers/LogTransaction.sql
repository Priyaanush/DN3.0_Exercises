CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON transactions
FOR EACH ROW
BEGIN
    INSERT INTO audit_log (transaction_id, transaction_date, action)
    VALUES (:NEW.transaction_id, SYSDATE, 'INSERT');
END;