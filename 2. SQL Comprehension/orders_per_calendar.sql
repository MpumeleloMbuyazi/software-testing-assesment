select count(*), extract (year from o.order_date) as years from orders o 
group by years 
order by years asc  
