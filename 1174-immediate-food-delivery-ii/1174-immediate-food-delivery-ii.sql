# Write your MySQL query statement below
select
 round(sum(if(first_order_date=first_customer_pref_delivery_date,1,0)*100)/count(first_order_date),2)as immediate_percentage 
from
#make sub query table
(select 
 delivery_id,
 customer_id,
 min(order_date )as first_order_date,
 min(customer_pref_delivery_date ) as first_customer_pref_delivery_date
 from delivery
 group by customer_id) as table2
 