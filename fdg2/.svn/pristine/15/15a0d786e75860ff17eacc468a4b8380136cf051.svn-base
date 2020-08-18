#namespace("tinyWishTmp")

#sql("find")
  SELECT * FROM F_CONTENT_TMP A LEFT JOIN F_TINY_WISH_TMP M ON A.ID=M.ID WHERE A.DELETED=0 AND A.VISIBLE=1 AND A.TYPE='C103' ORDER BY A.STATUS ASC, A.REGIST_TIME DESC
  #if(tinyWishTmp.id??)
    and M.ID=#para(tinyWishTmp.id)
  #end
  #if(tinyWishTmp.realname??)
    and M.REALNAME=#para(tinyWishTmp.realname)
  #end
  #if(tinyWishTmp.idCard??)
    and M.ID_CARD=#para(tinyWishTmp.idCard)
  #end
  #if(tinyWishTmp.linkman??)
    and M.LINKMAN=#para(tinyWishTmp.linkman)
  #end
  #if(tinyWishTmp.tel??)
    and M.TEL=#para(tinyWishTmp.tel)
  #end
  #if(tinyWishTmp.disabilityType??)
    and M.DISABILITY_TYPE=#para(tinyWishTmp.disabilityType)
  #end
  #if(tinyWishTmp.disabilityLevel??)
    and M.DISABILITY_LEVEL=#para(tinyWishTmp.disabilityLevel)
  #end
  #if(tinyWishTmp.startDate??)
    and M.START_DATE=#para(tinyWishTmp.startDate)
  #end
  #if(tinyWishTmp.endDate??)
    and M.END_DATE=#para(tinyWishTmp.endDate)
  #end
  #if(tinyWishTmp.takeStatus??)
    and M.TAKE_STATUS=#para(tinyWishTmp.takeStatus)
  #end
  #if(tinyWishTmp.takerId??)
    and M.TAKER_ID=#para(tinyWishTmp.takerId)
  #end
  #if(tinyWishTmp.takerName??)
    and M.TAKER_NAME=#para(tinyWishTmp.takerName)
  #end
  #if(tinyWishTmp.takeTime??)
    and M.TAKE_TIME=#para(tinyWishTmp.takeTime)
  #end
  #if(tinyWishTmp.completeDate??)
    and M.COMPLETE_DATE=#para(tinyWishTmp.completeDate)
  #end
  #if(tinyWishTmp.photo??)
    and M.PHOTO=#para(tinyWishTmp.photo)
  #end
#end

#end