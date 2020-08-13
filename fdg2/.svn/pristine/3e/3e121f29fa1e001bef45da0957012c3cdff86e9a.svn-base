#namespace("data")

#sql("find")
  SELECT m.* FROM T_DATA m where 1=1
  #if(name!=null) 
    and NAME like concat('%', #para(name) , '%')
  #end
  #if(code!=null) 
    and CODE like concat('%', #para(code) , '%')
  #end
#end
#sql("findByRoleId")
SELECT d.*,IFNULL(r.DATA_AUTH,3) DATA_AUTH 
  FROM (SELECT * FROM T_DATA WHERE ENABLE_AUTH=1) d 
  LEFT JOIN (SELECT * FROM T_ROLE_DATA WHERE ROLE_ID=#para(roleId)) r 
    ON d.ID=r.DATA_ID;
#end

#end