#namespace("archive")

#sql("findByIdCard")
  SELECT M.* FROM f_archive M WHERE M.DELETED=0 AND M.ID_CARD=#para(idCard)
#end

#sql("find")
  SELECT M.* FROM f_archive M WHERE M.DELETED=0 OR ISNULL(DELETED)=1
  #if(archive.id??)
    and M.ID=#para(archive.id)
  #end
  #if(archive.isDriver??)
    and M.IS_DRIVER=#para(archive.isDriver)
  #end
  #if(archive.isDisability??)
    and M.IS_DISABILITY=#para(archive.isDisability)
  #end
  #if(archive.idCardFront??)
    and M.ID_CARD_FRONT=#para(archive.idCardFront)
  #end
  #if(archive.idCardBack??)
    and M.ID_CARD_BACK=#para(archive.idCardBack)
  #end
  #if(archive.facePhoto??)
    and M.FACE_PHOTO=#para(archive.facePhoto)
  #end
  #if(archive.realname??)
    and M.REALNAME=#para(archive.realname)
  #end
  #if(archive.idCard??)
    and M.ID_CARD=#para(archive.idCard)
  #end
  #if(archive.tel??)
    and M.TEL=#para(archive.tel)
  #end
  #if(archive.acType??)
    and M.AC_TYPE=#para(archive.acType)
  #end
  #if(archive.birthPlace??)
    and M.BIRTH_PLACE=#para(archive.birthPlace)
  #end
  #if(archive.national??)
    and M.NATIONAL=#para(archive.national)
  #end
  #if(archive.maritalStatus??)
    and M.MARITAL_STATUS=#para(archive.maritalStatus)
  #end
  #if(archive.edu??)
    and M.EDU=#para(archive.edu)
  #end
  #if(archive.idAddr??)
    and M.ID_ADDR=#para(archive.idAddr)
  #end
  #if(archive.addr??)
    and M.ADDR=#para(archive.addr)
  #end
  #if(archive.linkman??)
    and M.LINKMAN=#para(archive.linkman)
  #end
  #if(archive.relation??)
    and M.RELATION=#para(archive.relation)
  #end
  #if(archive.linkmainTel??)
    and M.LINKMAIN_TEL=#para(archive.linkmainTel)
  #end
  #if(archive.company??)
    and M.COMPANY=#para(archive.company)
  #end
  #if(archive.workType??)
    and M.WORK_TYPE=#para(archive.workType)
  #end
  #if(archive.nature??)
    and M.NATURE=#para(archive.nature)
  #end
  #if(archive.welfareOrg??)
    and M.WELFARE_ORG=#para(archive.welfareOrg)
  #end
  #if(archive.certNo??)
    and M.CERT_NO=#para(archive.certNo)
  #end
  #if(archive.disabilityLevel??)
    and M.DISABILITY_LEVEL=#para(archive.disabilityLevel)
  #end
  #if(archive.certPeriod??)
    and M.CERT_PERIOD=#para(archive.certPeriod)
  #end
  #if(archive.disabilityType??)
    and M.DISABILITY_TYPE=#para(archive.disabilityType)
  #end
  #if(archive.registTime??)
    and M.REGIST_TIME=#para(archive.registTime)
  #end
  #if(archive.registOrgId??)
    and M.REGIST_ORG_ID=#para(archive.registOrgId)
  #end
  #if(archive.registOrgName??)
    and M.REGIST_ORG_NAME=#para(archive.registOrgName)
  #end
  #if(archive.registerId??)
    and M.REGISTER_ID=#para(archive.registerId)
  #end
  #if(archive.registerName??)
    and M.REGISTER_NAME=#para(archive.registerName)
  #end
  #if(archive.deleted??)
    and M.DELETED=#para(archive.deleted)
  #end
#end

#end