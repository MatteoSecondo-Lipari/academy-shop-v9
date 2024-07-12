create database shop;

select qs - qo as availability, orders.product_id  from 
(select sum(s.quantity) as qs, s.product_id
from supply s
group by s.product_id) as furnitures
join 
(select sum(o.quantity) as qo, o.product_id
from order_entry o
group by o.product_id) as orders
on orders.product_id = furnitures.product_id
group by orders.product_id;

select id, name, description, price, category
from 
	(select order_price.product_id, p.id, p.name, p.description, p.price, p.category, order_price.order_price - supply_price.supply_price as profit
	from 
		(select p.price as order_price, p.id as product_id
		from order_entry o
			inner join product p on o.product_id = p.id) as order_price
	inner join
		(select s.price as supply_price, s.product_id as product_id
		from supply s) as supply_price
	on supply_price.product_id = order_price.product_id
	inner join product p
	on p.id = order_price.product_id
	order by profit desc
	limit 1) as temp;