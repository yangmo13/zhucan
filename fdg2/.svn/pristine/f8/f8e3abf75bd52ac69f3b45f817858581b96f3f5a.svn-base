#namespace("resume")

#sql("find")
  SELECT M.* FROM f_resume M WHERE 1=1
  #if(resume.id??)
    and M.ID=#para(resume.id)
  #end
  #if(resume.deleted??)
    and M.DELETED=#para(resume.deleted)
  #end
  #if(resume.userId??)
    and M.USER_ID=#para(resume.userId)
  #end
  #if(resume.orgId??)
    and M.ORG_ID=#para(resume.orgId)
  #end
  #if(resume.orgName??)
    and M.ORG_NAME=#para(resume.orgName)
  #end
  #if(resume.registerId??)
    and M.REGISTER_ID=#para(resume.registerId)
  #end
  #if(resume.registerName??)
    and M.REGISTER_NAME=#para(resume.registerName)
  #end
  #if(resume.registTime??)
    and M.REGIST_TIME=#para(resume.registTime)
  #end
  #if(resume.realname??)
    and M.REALNAME=#para(resume.realname)
  #end
  #if(resume.idCard??)
    and M.ID_CARD=#para(resume.idCard)
  #end
  #if(resume.workFrom??)
    and M.WORK_FROM=#para(resume.workFrom)
  #end
  #if(resume.city??)
    and M.CITY=#para(resume.city)
  #end
  #if(resume.tel??)
    and M.TEL=#para(resume.tel)
  #end
  #if(resume.disabilityLevel??)
    and M.DISABILITY_LEVEL=#para(resume.disabilityLevel)
  #end
  #if(resume.disabilityType??)
    and M.DISABILITY_TYPE=#para(resume.disabilityType)
  #end
  #if(resume.expectSalary??)
    and M.EXPECT_SALARY=#para(resume.expectSalary)
  #end
  #if(resume.expectCity??)
    and M.EXPECT_CITY=#para(resume.expectCity)
  #end
  #if(resume.expectPost??)
    and M.EXPECT_POST=#para(resume.expectPost)
  #end
  #if(resume.selfEval??)
    and M.SELF_EVAL=#para(resume.selfEval)
  #end
#end

#end