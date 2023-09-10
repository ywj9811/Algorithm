select MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, "%Y-%m-%d")
from MEMBER_PROFILE
where MONTH(DATE_OF_BIRTH) = '03' and GENDER = 'W' and NOT TLNO is null
order by MEMBER_ID