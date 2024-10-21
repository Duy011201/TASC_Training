-- Clustered Index và Non-Clustered
1. Clustered Index
    CREATE TABLE Employees
    (
        EmployeeID INT PRIMARY KEY, -- Đây là khóa chính, tự động trở thành clustered index
        Name       VARCHAR(100),
        HireDate   DATE,
        Salary     DECIMAL(10, 2)
    );

2. Non-Clustered Index
    CREATE NONCLUSTERED INDEX idx_hiredate ON Employees(HireDate);
    SELECT * FROM Employees WHERE HireDate BETWEEN '2020-01-01' AND '2021-01-01';


