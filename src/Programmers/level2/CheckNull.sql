select ANIMAL_TYPE, if(NAME is null, 'No name', NAME) as NAME
     , SEX_UPON_INTAKE
from ANIMAL_INS