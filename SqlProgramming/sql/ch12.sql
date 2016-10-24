-- 1024
-- 행순번 붙히기
-- rownum 정렬전의 순번이 나옴 rownum 하고 나서 order by가 정의
select rownum, bno, btitle
from (select bno, btitle from board order by bno);

select rownum, bno, btitle
from (select bno, btitle from board order by bno desc);

-- 최근 삽입된 행 5개를 가져오기
-- rownum으로 순번을 매길때 마다 조건(where)을 검사 true면 rownum동작
select rownum, bno, btitle
from (select bno, btitle from board order by bno desc)
where rownum<=5;

--rownum이 조건보다 큰형식(rownum > n)은 맞지 않는다.(rownum이 실행후 where을 실행하기 때문에 빈 값이 나온다.)
select rownum, bno, btitle
from (select bno, btitle from board order by bno desc)
where rownum>100;

--행의 순번이 11번~20번까지를 가져와라
select rn,bno, btitle
from (select rownum as rn, bno, btitle
      from (select bno, btitle from board order by bno desc)
            where rownum<=20)
where rn>=11;

--1페이지에 10개씩 구성하고, n번째 페이지를 가져오기
--10개씩 - rowsPerPage
--공식 => (n-1)*rowperpage+1 => n은 page수
select rn,bno, btitle
from (select rownum as rn, bno, btitle
      from (select bno, btitle from board order by bno desc)
            where rownum<=(n*10))
where rn>=((n-1)*10+1);

select rn,bno, btitle
from (select rownum as rn, bno, btitle
      from (select bno, btitle from board order by bno desc)
            where rownum<=(2*10))
where rn>=((2-1)*10+1);