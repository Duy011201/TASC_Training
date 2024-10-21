CREATE TABLE Sales (
                       SaleID INT PRIMARY KEY,
                       ProductName VARCHAR(100),
                       SaleAmount DECIMAL(10, 2),
                       SaleDate DATE
)
    PARTITION BY RANGE (YEAR(SaleDate)) (
    PARTITION p2022 VALUES LESS THAN (2023),
    PARTITION p2023 VALUES LESS THAN (2024),
    PARTITION p2024 VALUES LESS THAN (2025)
);

SELECT * FROM Sales WHERE SaleDate BETWEEN '2023-01-01' AND '2023-12-31';
SELECT * FROM information_schema.partitions WHERE table_name = 'Sales';
