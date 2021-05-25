select 1;

select brand,
       color,
       price,
       date
from car;

select *
from car
where date > to_timestamp('2018-06-27', 'yyyy-mm-dd');

select brand as car_name,
       color,
       price,
       date
from car;

select brand    as car_name,
       color,
       price,
       date,
       'blabla' as simple_column
from car;

select brand,
       sum(price),
       max(price),
       avg(price),
       count(*)
from car
group by brand;

select brand,
       sum(price)
from car
where price < 10000
group by brand
having sum(price) > 5000;

select brand,
       price
from car
where price < 10000;

select o.order_number,
       o.car_brand,
       cl.date,
       cl.name,
       cl.phone
from "order" as o
         inner join client cl
                    on o.client = cl.name;

select *
from car
order by price, id;