#namespace("dept")

#define data_auth_func()
  #set(user=getCurrentUser())
  #if(dataAuth==0)
  	and OP_USER_ID=#para(user.id)
  #else if(dataAuth==1)
  	and ID like concat(#para(user.deptId??''), '%')
  #else if(dataAuth==2)
  	and ID like concat(substr(#para(user.deptId??''),1,3), '%')
  #else if(dataAuth==3)
  #else
  	and 1=2
  #end
#end

#sql("findMaxSeq")
  SELECT IFNULL(MAX(SEQ),0) FROM T_DEPT WHERE PID=?
#end
#sql("findAll")
  SELECT m.* FROM T_DEPT m WHERE 1=1 
  #call("data_auth_func")
  order by m.LV,m.SEQ
#end
#sql("findByPid")
  SELECT m.* FROM T_DEPT m WHERE m.PID=#para(pid) 
  #if(id!=null) 
    and id!=#para(id) 
  #end
  #call("data_auth_func")
  order by m.LV,m.SEQ
#end
#sql("findSubCount")
  SELECT COUNT(1) FROM T_DEPT WHERE PID=?
#end
#sql("findNearBy")
SELECT * FROM T_DEPT where id!=#para(id) and pid=#para(pid)
	#if(direct>0)
	and SEQ>#para(seq) order by SEQ asc
	#else
	and SEQ<#para(seq) order by SEQ desc
	#end
#end
#sql("findMaxId")
  SELECT MAX(ID) FROM T_DEPT WHERE PID=?
#end
#sql("findByTitle")
  SELECT * FROM T_DEPT WHERE 1=1
  #if(title!=null)
  AND TITLE LIKE concat('%',#para(title),'%')
  #end
  #if(lv!=null)
  AND LV=#para(lv)
  #end
#end

#sql("findByTileAndPTitle")
  SELECT a.* FROM T_DEPT a left JOIN T_DEPT b on a.PID=b.ID 
 WHERE a.TITLE=#para(title) AND b.TITLE=#para(ptitle) AND a.LV=#para(lv)
#end

#sql("findAllForShow")
SELECT a.ID id, CASE a.LV WHEN 3 THEN CONCAT(b.TITLE, '/', a.TITLE) ELSE a.TITLE END as title FROM T_DEPT A LEFT JOIN T_DEPT b ON a.PID=b.ID
#end

#end