# Write your MySQL query statement below
select
 round(sum(difference)/count(distinct player_id),2)as fraction
from
#subquery
(select
 datediff(event_date ,min(event_date) over(partition by player_id))=1 as difference,
 player_id 
from activity) table2