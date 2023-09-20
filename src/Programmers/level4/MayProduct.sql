select p.PRODUCT_ID, p.PRODUCT_NAME, SUM((p.PRICE * o.AMOUNT)) as TOTAL_SALES
from FOOD_PRODUCT as p join FOOD_ORDER as o
                            on o.PRODUCT_ID = p.PRODUCT_ID
where DATE_FORMAT(o.PRODUCE_DATE, '%Y%m') = 202205
group by p.PRODUCT_ID
order by TOTAL_SALES desc, p.PRODUCT_ID asc