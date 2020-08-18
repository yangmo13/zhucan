#namespace("orgTmp")

#sql("find")
  SELECT M.* FROM f_org_tmp M WHERE 1=1
  #if(orgTmp.id??)
    and M.ID=#para(orgTmp.id)
  #end
  #if(orgTmp.logo??)
    and M.LOGO=#para(orgTmp.logo)
  #end
  #if(orgTmp.industry??)
    and M.INDUSTRY=#para(orgTmp.industry)
  #end
  #if(orgTmp.size??)
    and M.SIZE=#para(orgTmp.size)
  #end
  #if(orgTmp.nature??)
    and M.NATURE=#para(orgTmp.nature)
  #end
  #if(orgTmp.linkman??)
    and M.LINKMAN=#para(orgTmp.linkman)
  #end
  #if(orgTmp.tel??)
    and M.TEL=#para(orgTmp.tel)
  #end
  #if(orgTmp.username??)
    and M.USERNAME=#para(orgTmp.username)
  #end
  #if(orgTmp.roles??)
    and M.ROLES=#para(orgTmp.roles)
  #end
  #if(orgTmp.addr??)
    and M.ADDR=#para(orgTmp.addr)
  #end
  #if(orgTmp.x??)
    and M.X=#para(orgTmp.x)
  #end
  #if(orgTmp.y??)
    and M.Y=#para(orgTmp.y)
  #end
  #if(orgTmp.refUserId??)
    and M.REF_USER_ID=#para(orgTmp.refUserId)
  #end
  #if(orgTmp.refDeptId??)
    and M.REF_DEPT_ID=#para(orgTmp.refDeptId)
  #end
#end

#end