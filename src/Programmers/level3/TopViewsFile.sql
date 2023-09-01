select concat('/home/grep/src/', b.BOARD_ID, '/', f.FILE_ID, f.FILE_NAME, f.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD as b inner join USED_GOODS_FILE as f
where f.BOARD_ID = b.BOARD_ID
  and b.BOARD_ID = (select b.BOARD_ID from USED_GOODS_BOARD as b
                    order by b.VIEWS desc limit 1)
order by f.file_id desc
