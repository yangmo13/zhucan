#namespace("content")

#sql("find")
  SELECT M.* FROM f_content M WHERE 1=1
  #if(content.id??)
    and M.ID=#para(content.id)
  #end
  #if(content.type??)
    and M.TYPE=#para(content.type)
  #end
  #if(content.title??)
    and M.TITLE=#para(content.title)
  #end
  #if(content.txt??)
    and M.TXT=#para(content.txt)
  #end
  #if(content.registerOrgId??)
    and M.REGISTER_ORG_ID=#para(content.registerOrgId)
  #end
  #if(content.registerOrgName??)
    and M.REGISTER_ORG_NAME=#para(content.registerOrgName)
  #end
  #if(content.registerId??)
    and M.REGISTER_ID=#para(content.registerId)
  #end
  #if(content.registerName??)
    and M.REGISTER_NAME=#para(content.registerName)
  #end
  #if(content.registTime??)
    and M.REGIST_TIME=#para(content.registTime)
  #end
  #if(content.submitorOrgId??)
    and M.SUBMITOR_ORG_ID=#para(content.submitorOrgId)
  #end
  #if(content.submitorOrgName??)
    and M.SUBMITOR_ORG_NAME=#para(content.submitorOrgName)
  #end
  #if(content.submitorId??)
    and M.SUBMITOR_ID=#para(content.submitorId)
  #end
  #if(content.submitorName??)
    and M.SUBMITOR_NAME=#para(content.submitorName)
  #end
  #if(content.submitTime??)
    and M.SUBMIT_TIME=#para(content.submitTime)
  #end
  #if(content.auditorOrgId??)
    and M.AUDITOR_ORG_ID=#para(content.auditorOrgId)
  #end
  #if(content.auditorOrgName??)
    and M.AUDITOR_ORG_NAME=#para(content.auditorOrgName)
  #end
  #if(content.auditorId??)
    and M.AUDITOR_ID=#para(content.auditorId)
  #end
  #if(content.auditorName??)
    and M.AUDITOR_NAME=#para(content.auditorName)
  #end
  #if(content.auditTime??)
    and M.AUDIT_TIME=#para(content.auditTime)
  #end
  #if(content.status??)
    and M.STATUS=#para(content.status)
  #end
  #if(content.auditRemark??)
    and M.AUDIT_REMARK=#para(content.auditRemark)
  #end
  #if(content.deleted??)
    and M.DELETED=#para(content.deleted)
  #end
  #if(content.visible??)
    and M.VISIBLE=#para(content.visible)
  #end
#end

#end