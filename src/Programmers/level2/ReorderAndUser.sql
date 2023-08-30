select distinct user_id, product_id
from ONLINE_SALE
where (user_id, product_id) in
      (select user_id, product_id from ONLINE_SALE group by user_id, product_id having count(*) > 1)
order by user_id asc, product_id des