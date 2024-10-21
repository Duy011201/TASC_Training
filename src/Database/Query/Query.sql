-- Các loại JOIN trong database
1. INNER JOIN
    SELECT employees.name, departments.department_name
    FROM employees
    INNER JOIN departments
    ON employees.department_id = departments.department_id;

2. LEFT JOIN
    SELECT employees.name, departments.department_name
    FROM employees
    LEFT JOIN departments
    ON employees.department_id = departments.department_id;

3. RIGHT JOIN
    SELECT employees.name, departments.department_name
    FROM employees
    RIGHT JOIN departments
    ON employees.department_id = departments.department_id;

4. FULL JOIN
    SELECT employees.name, departments.department_name
    FROM employees
    FULL OUTER JOIN departments
    ON employees.department_id = departments.department_id;

5. CROSS JOIN
    SELECT employees.name, departments.department_name
    FROM employees
    CROSS JOIN departments;

6. SELF JOIN
    SELECT a.employee_id, a.name, b.name AS manager_name
    FROM employees a
    LEFT JOIN employees b
    ON a.manager_id = b.employee_id;

-- Các loại Subquery
1. Single-Row Subquery: Trả về một hàng duy nhất và có thể được sử dụng với các toán tử so sánh.
    SELECT *
    FROM employees
    WHERE salary > (SELECT AVG(salary) FROM employees);

2. Multiple-Row Subquery: Trả về nhiều hàng và có thể được sử dụng với IN, ANY, hoặc ALL
    SELECT employee_name
    FROM employees
    WHERE department_id IN (SELECT department_id FROM departments WHERE location_id = 100);

3. Correlated Subquery: Một subquery tham chiếu đến các cột từ truy vấn bên ngoài.
    SELECT employee_name
    FROM employees e1
    WHERE salary > (SELECT AVG(salary) FROM employees e2 WHERE e1.department_id = e2.department_id);

-- CTE (Common Table Expression)
WITH cte_name AS (
    SELECT column1, column2
    FROM table_name
    WHERE condition
)
SELECT *
FROM cte_name;

-- Ranking : ROW_NUMBER, RANK, DENSE_RANK
1. ROW_NUMBER()
    SELECT column_name,
           ROW_NUMBER() OVER (PARTITION BY partition_column ORDER BY order_column) AS row_num
    FROM table_name;

2. RANK()
    SELECT column_name,
           RANK() OVER (PARTITION BY partition_column ORDER BY order_column) AS rank_num
    FROM table_name;

3. DENSE_RANK()
    SELECT column_name,
           DENSE_RANK() OVER (PARTITION BY partition_column ORDER BY order_column) AS dense_rank_num
    FROM table_name;
