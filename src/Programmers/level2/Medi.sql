SELECT mcdp_cd AS "진료과코드", count(PT_No) as "5월예약건수"
FROM appointment
where date_format(APNT_YMD, '%Y%m%d') like '202205%'
group by mcdp_cd
order by count(APNT_YMD) asc, mcdp_cd asc