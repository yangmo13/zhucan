  ### 主体表中必须包含OP_USER_ID（操作人ID）及DEPT_ID（数据所属部门）字段
  ### 数据权限拼接SQL，Kv参数中必须包含user参数，代表当前登陆人
  ### dataAuth，0：操作人是当前登陆人，1：部门ID是当前登陆人所属部门及下级部门，2：部门ID是当前登陆人所属组织，3：所有，其他为无数据权限
  #if (alias??)
  #set(aliasStr=alias+".")
  #end
  #set(current_user=getCurrentUser())###这是调用后台方法
  #if(dataAuth==0)
    and #(aliasStr)OP_USER_ID=#para(current_user.id)
  #else if(dataAuth==1)
  	and #(aliasStr)DEPT_ID like concat(#para(current_user.deptId??''), '%')
  #else if(dataAuth==2)
  	and #(aliasStr)DEPT_ID like concat(substr(#para(current_user.deptId??''),1,3), '%')
  #else if(dataAuth==3)
  #else
  	and 1=2
  #end