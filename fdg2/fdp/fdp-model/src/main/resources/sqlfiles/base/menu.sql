#namespace("menu")

#sql("findAll")
  SELECT m.* FROM T_MENU m order by m.LV,m.SEQ
#end

#sql("findByPid")
  SELECT m.* FROM T_MENU m WHERE m.PID=#para(pid) 
  #if(id!=null) 
    and id!=#para(id) 
  #end
  order by m.LV,m.SEQ
#end

#sql("findByUserId")
  SELECT DISTINCT m.* FROM T_MENU m LEFT JOIN T_ROLE_MENU rm ON m.ID=rm.MENU_ID LEFT JOIN T_ROLE_USER ru ON rm.ROLE_ID=ru.ROLE_ID WHERE m.PID=#para(pid) 
  #if(userId!=null) 
    and ru.USER_ID=#para(userId)
  #end
  order by m.LV,m.SEQ
#end

#sql("deleteFunctions")
  DELETE FROM T_FUNCTION WHERE MENU_ID=#para(menuId)
#end

#sql("findFunctionsByMenuId")
  SELECT * FROM T_FUNCTION WHERE MENU_ID=#para(menuId) ORDER BY MENU_ID,SEQ
#end

#sql("findAllFunctions")
  SELECT f.* FROM T_FUNCTION f LEFT JOIN T_MENU m ON f.MENU_ID=m.ID ORDER BY f.MENU_ID,f.SEQ
#end

#sql("deleteRoleMenuByMenuId")
  DELETE FROM T_ROLE_MENU WHERE MENU_ID=#para(menuId)
#end

#sql("deleteFunctionByMenuId")
  DELETE FROM T_FUNCTION WHERE MENU_ID=#para(menuId)
#end

#sql("findSubCount")
  SELECT COUNT(1) FROM T_MENU WHERE PID=?
#end

#sql("findByRoleId")
  SELECT DISTINCT m.* FROM T_MENU m LEFT JOIN T_ROLE_MENU rm on m.ID=rm.MENU_ID WHERE rm.ROLE_ID=#para(roleId) ORDER BY m.LV,m.SEQ
#end

#sql("findMaxSeq1")
  SELECT IFNULL(MAX(SEQ),0) FROM T_MENU WHERE PID=? 
#end
#sql("findMaxSeq2")
  SELECT IFNULL(MAX(SEQ),0) FROM T_MENU WHERE PID=? AND ID!=?
#end
#sql("findNearBy")
SELECT * FROM T_MENU where id!=#para(id) and pid=#para(pid)
	#if(direct>0)
	and SEQ>#para(seq) order by SEQ asc
	#else
	and SEQ<#para(seq) order by SEQ desc
	#end
#end

#end