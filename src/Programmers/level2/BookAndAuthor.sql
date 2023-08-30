select b.book_id, a.AUTHOR_NAME, date_format(b.PUBLISHED_DATE,'%Y-%m-%d') as PUBLISHED_DATE
from book as b inner join author as a
where b.category = '경제' and b.AUTHOR_ID = a.AUTHOR_ID
order by b.published_Date asc