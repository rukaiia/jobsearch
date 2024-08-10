--task1
SELECT products.name , sum(actions.qty) from actions
join public.products  on products.id = actions.product_id
where actions.type = 'arrival'
  and stickrecipient = 1
and actions.date <= '2024-06-15'
group by products.name
order by products.name;


--task2
SELECT products.name , sum(actions.qty) from actions
join public.products  on products.id = actions.product_id
where actions.type = 'extradition'
  and stocksender_id = 4
and actions.date >= '2024-04-15'
group by products.name
order by products.name;


--task3
select sum(actions.qty), categories.type from actions
 join public.products p on actions.product_id = p.id
 join public.categories  on categories.id = p.categories_id
where actions.type = 'moving'
  and actions.stocksender_id = 4
and actions.stickrecipient = 3
and actions.date >= '2024-01-03'
group by categories.type
order by categories.type;


--task5
select products.name AS ProductName, SUM(CASE
    when actions.type = 'arrival'
    then actions.qty
    else -actions.qty
    END)
from actions
join products  ON actions.product_id = products.id
where actions.date >= '2024-02-03'
    AND actions.stocksender_id = 1
group by products.name
order by  products.name;

--task6
SELECT products.name , sum(actions.qty) from actions
join public.products  on products.id = actions.product_id
where actions.type = 'arrival'
  and actions.coontractors_id = 3
and actions.date <= '2024-06-15'
group by products.name
order by products.name;

--task7
SELECT products.name , sum(actions.qty) from actions
join public.products  on products.id = actions.product_id
where actions.type = 'arrival'
  and actions.coontractors_id = 5
  and stickrecipient = 2
and actions.date <= '2024-06-15'
group by products.name
order by products.name;

--task8
SELECT products.name , sum(actions.qty) from actions
join public.products  on products.id = actions.product_id
where actions.type = 'extradition'
  and actions.coontractors_id = 1
  and stocksender_id = 2
and actions.date <= '2024-06-15'
group by products.name
order by products.name;

--task9
SELECT contractors.name , sum(actions.qty) from actions
join contractors on actions.coontractors_id = contractors.id
    where actions.type = 'arrival'
  and product_id = 9
and actions.date <= '2024-06-15'
group by contractors.name
order by sum(actions.qty) desc ;

--task10
SELECT contractors.name , sum(actions.qty) from actions
join contractors on actions.coontractors_id = contractors.id
    where actions.type = 'extradition'
  and product_id = 6
and actions.date <= '2024-06-15'
group by contractors.name
order by sum(actions.qty) desc ;

--task11
 SELECT products.name , sum(actions.qty) from actions
join public.products  on actions.product_id = products.id
    where actions.type = 'moving'
  and stickrecipient = 3
and actions.date <= '2024-06-15'
group by products.name
order by products.name;


--task12
SELECT products.name , sum(actions.qty) from actions
join public.products  on actions.product_id = products.id
    where actions.type = 'moving'
  and stocksender_id = 3
and actions.date <= '2024-06-15'
group by products.name
order by products.name;
