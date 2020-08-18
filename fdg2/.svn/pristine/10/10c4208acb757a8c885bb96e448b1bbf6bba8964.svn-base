#namespace("tUser")

#sql("find")
  SELECT M.* FROM t_user M WHERE 1=1
  #if(tUser.id??)
    and M.ID=#para(tUser.id)
  #end
  #if(tUser.username??)
    and M.USERNAME=#para(tUser.username)
  #end
  #if(tUser.password??)
    and M.PASSWORD=#para(tUser.password)
  #end
  #if(tUser.status??)
    and M.STATUS=#para(tUser.status)
  #end
  #if(tUser.editable??)
    and M.EDITABLE=#para(tUser.editable)
  #end
  #if(tUser.deletable??)
    and M.DELETABLE=#para(tUser.deletable)
  #end
  #if(tUser.deleted??)
    and M.DELETED=#para(tUser.deleted)
  #end
  #if(tUser.realname??)
    and M.REALNAME=#para(tUser.realname)
  #end
  #if(tUser.sex??)
    and M.SEX=#para(tUser.sex)
  #end
  #if(tUser.opTime??)
    and M.OP_TIME=#para(tUser.opTime)
  #end
  #if(tUser.opUserId??)
    and M.OP_USER_ID=#para(tUser.opUserId)
  #end
  #if(tUser.deptId??)
    and M.DEPT_ID=#para(tUser.deptId)
  #end
  #if(tUser.startTime??)
    and M.START_TIME=#para(tUser.startTime)
  #end
  #if(tUser.endTime??)
    and M.END_TIME=#para(tUser.endTime)
  #end
  #if(tUser.token??)
    and M.TOKEN=#para(tUser.token)
  #end
  #if(tUser.phone??)
    and M.PHONE=#para(tUser.phone)
  #end
  #if(tUser.refArchiveId??)
    and M.REF_ARCHIVE_ID=#para(tUser.refArchiveId)
  #end
  #if(tUser.refResumeId??)
    and M.REF_RESUME_ID=#para(tUser.refResumeId)
  #end
  #if(tUser.infoCompleted??)
    and M.INFO_COMPLETED=#para(tUser.infoCompleted)
  #end
  #if(tUser.openid??)
    and M.OPENID=#para(tUser.openid)
  #end
  #if(tUser.orgId??)
    and M.ORG_ID=#para(tUser.orgId)
  #end
#end

#end