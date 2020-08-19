#namespace("tmpUser")

#sql("findByToken")
SELECT M.* FROM T_TMP_USER M WHERE M.TOKEN=#para(token)
#end

#sql("findByOpenid")
  SELECT * FROM T_TMP_USER W WHERE W.OPENID=#para(openid)
#end

#sql("find")
  SELECT M.* FROM t_tmp_user M WHERE 1=1
  #if(tmpUser.id??)
    and M.ID=#para(tmpUser.id)
  #end
  #if(tmpUser.opTime??)
    and M.OP_TIME=#para(tmpUser.opTime)
  #end
  #if(tmpUser.token??)
    and M.TOKEN=#para(tmpUser.token)
  #end
  #if(tmpUser.infoCompleted??)
    and M.INFO_COMPLETED=#para(tmpUser.infoCompleted)
  #end
  #if(tmpUser.openid??)
    and M.OPENID=#para(tmpUser.openid)
  #end
#end

#end