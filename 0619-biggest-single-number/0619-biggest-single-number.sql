# Write your MySQL query statement below
select Max(num)AS num from MyNumbers where num in(select num from MyNumbers group by num having count(num)=1);