#namespace("contentTmp")

#sql("find")
  SELECT M.* FROM f_content_tmp M WHERE 1=1
  #if(contentTmp.id??)
    and M.ID=#para(contentTmp.id)
  #end
  #if(contentTmp.type??)
    and M.TYPE=#para(contentTmp.type)
  #end
  #if(contentTmp.title??)
    and M.TITLE=#para(contentTmp.title)
  #end
  #if(contentTmp.txt??)
    and M.TXT=#para(contentTmp.txt)
  #end
  #if(contentTmp.registerOrgId??)
    and M.REGISTER_ORG_ID=#para(contentTmp.registerOrgId)
  #end
  #if(contentTmp.registerOrgName??)
    and M.REGISTER_ORG_NAME=#para(contentTmp.registerOrgName)
  #end
  #if(contentTmp.registerId??)
    and M.REGISTER_ID=#para(contentTmp.registerId)
  #end
  #if(contentTmp.registerName??)
    and M.REGISTER_NAME=#para(contentTmp.registerName)
  #end
  #if(contentTmp.registTime??)
    and M.REGIST_TIME=#para(contentTmp.registTime)
  #end
  #if(contentTmp.submitorOrgId??)
    and M.SUBMITOR_ORG_ID=#para(contentTmp.submitorOrgId)
  #end
  #if(contentTmp.submitorOrgName??)
    and M.SUBMITOR_ORG_NAME=#para(contentTmp.submitorOrgName)
  #end
  #if(contentTmp.submitorId??)
    and M.SUBMITOR_ID=#para(contentTmp.submitorId)
  #end
  #if(contentTmp.submitorName??)
    and M.SUBMITOR_NAME=#para(contentTmp.submitorName)
  #end
  #if(contentTmp.submitTime??)
    and M.SUBMIT_TIME=#para(contentTmp.submitTime)
  #end
  #if(contentTmp.auditorOrgId??)
    and M.AUDITOR_ORG_ID=#para(contentTmp.auditorOrgId)
  #end
  #if(contentTmp.auditorOrgName??)
    and M.AUDITOR_ORG_NAME=#para(contentTmp.auditorOrgName)
  #end
  #if(contentTmp.auditorId??)
    and M.AUDITOR_ID=#para(contentTmp.auditorId)
  #end
  #if(contentTmp.auditorName??)
    and M.AUDITOR_NAME=#para(contentTmp.auditorName)
  #end
  #if(contentTmp.auditTime??)
    and M.AUDIT_TIME=#para(contentTmp.auditTime)
  #end
  #if(contentTmp.status??)
    and M.STATUS=#para(contentTmp.status)
  #end
  #if(contentTmp.auditRemark??)
    and M.AUDIT_REMARK=#para(contentTmp.auditRemark)
  #end
  #if(contentTmp.deleted??)
    and M.DELETED=#para(contentTmp.deleted)
  #end
  #if(contentTmp.visible??)
    and M.VISIBLE=#para(contentTmp.visible)
  #end
#end

#sql("list")

	SELECT * 
	FROM F_CONTENT_TMP A 
	LEFT JOIN F_ORG_TMP B ON A.ID=B.ID 
	WHERE A.DELETED=0 
	AND A.VISIBLE=1 
	AND A.TYPE='C301' 
	#if(title!=null)
		and A.TITLE like '%#(title)%'
	#end
	#if(status!=null)
		and A.STATUS = '#(status)'
	#end
	ORDER BY A.STATUS ASC, A.REGIST_TIME DESC


#end


#end