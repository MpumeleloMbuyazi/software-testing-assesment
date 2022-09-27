select count(c.customer_id), company_name  from customers c 
join orders o 
on c.customer_id = o.customer_id 
group by c.customer_id 
order by count(c.customer_id) desc
