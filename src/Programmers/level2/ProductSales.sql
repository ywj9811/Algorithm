select p.PRODUCT_CODE, p.PRICE * sum(o.SALES_AMOUNT) as SALES
from PRODUCT as p
         join OFFLINE_SALE as o
              on p.PRODUCT_ID = o.PRODUCT_ID
group by p.product_code
order by SALES desc, PRODUCT_CODE asc