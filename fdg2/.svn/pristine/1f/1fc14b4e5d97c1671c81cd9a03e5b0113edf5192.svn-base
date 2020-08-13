#namespace("role")

#sql("findAll")
  SELECT m.* FROM T_ROLE m ORDER BY m.UPDATE_TIME DESC,m.CREATE_TIME DESC
#end

#sql("findByUserId")
  SELECT r.* FROM T_ROLE r LEFT JOIN T_ROLE_USER ru ON r.ID=ru.ROLE_ID WHERE ru.USER_ID=#para(userId) ORDER BY r.UPDATE_TIME DESC,r.CREATE_TIME DESC
#end

#sql("deleteRoleUserByRoleId")
  DELETE FROM T_ROLE_USER WHERE ROLE_ID=#para(roleId)
#end

#sql("deleteRoleMenuByRoleId")
  DELETE FROM T_ROLE_MENU WHERE ROLE_ID=#para(roleId)
#end

#sql("deleteRolePermissionByRoleId")
  DELETE FROM T_ROLE_PERMISSION WHERE ROLE_ID=#para(roleId)
#end

#sql("deleteRoleDataByRoleId")
  DELETE FROM T_ROLE_DATA WHERE ROLE_ID=#para(roleId)
#end

#sql("findPermissionsByUserId")
  SELECT DISTINCT rp.* FROM T_USER u LEFT JOIN T_ROLE_USER ru ON u.ID=ru.USER_ID LEFT JOIN T_ROLE_PERMISSION rp ON ru.ROLE_ID=rp.ROLE_ID WHERE u.ID=#para(userId);
#end

#sql("findFunctionByRoleId")
  SELECT DISTINCT f.* FROM T_ROLE_PERMISSION rp,T_FUNCTION f WHERE rp.MENU_ID=f.MENU_ID AND rp.PERMISSION=f.PERMISSION AND rp.ROLE_ID=#para(roleId) ORDER BY f.MENU_ID,f.SEQ;
#end

#sql("findPermissions")
  select DISTINCT PERMISSION from T_ROLE_PERMISSION where ROLE_ID in 
  (
  	#for(x:roleids)
      #(for.index == 0 ? "" : ",")#para(x)
    #end
  )
#end

#sql("findAllPermissions")
  select DISTINCT PERMISSION from T_FUNCTION
#end

#sql("insertRoleData")
  INSERT INTO T_ROLE_DATA(ID,ROLE_ID,DATA_ID,DATA_AUTH) VALUES(#para(id),#para(roleId),#para(dataId),#para(dataAuth))
#end

#end