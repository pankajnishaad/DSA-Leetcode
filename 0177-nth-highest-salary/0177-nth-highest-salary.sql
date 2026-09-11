CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
-- SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      
        SELECT MAX(salary)
        FROM (
            SELECT salary,
                   DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
            FROM Employee
        ) tbl
        WHERE rnk = N
  );
END