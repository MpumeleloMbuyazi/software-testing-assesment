select count(*) from customers c
join orders o 
on c.customer_id = o.customer_id 
join shippers s  
on s.shipper_id  = 2
where c.company_name = 'Simons bistro'
