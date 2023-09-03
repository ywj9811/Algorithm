SELECT HOUR(DATETIME) as HOUR, count(*) as count
from ANIMAL_OUTS
where HOUR(DATETIME) BETWEEN '09' AND '19'
group by 1
order by hour