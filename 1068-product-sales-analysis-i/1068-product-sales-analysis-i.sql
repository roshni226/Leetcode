# Write your MySQL query statement below
SELECT p.product_name, s.year, s.price FROM SALES as s JOIN product as p ON s.product_id= p.product_id;