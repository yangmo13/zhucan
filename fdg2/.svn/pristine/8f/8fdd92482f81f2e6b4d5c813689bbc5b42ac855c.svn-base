#namespace("trainExper")

#sql("find")
  SELECT M.* FROM f_train_exper M WHERE 1=1
  #if(trainExper.id??)
    and M.ID=#para(trainExper.id)
  #end
  #if(trainExper.refId??)
    and M.REF_ID=#para(trainExper.refId)
  #end
  #if(trainExper.orgName??)
    and M.ORG_NAME=#para(trainExper.orgName)
  #end
  #if(trainExper.fromDate??)
    and M.FROM_DATE=#para(trainExper.fromDate)
  #end
  #if(trainExper.endDate??)
    and M.END_DATE=#para(trainExper.endDate)
  #end
  #if(trainExper.course??)
    and M.COURSE=#para(trainExper.course)
  #end
  #if(trainExper.witness??)
    and M.WITNESS=#para(trainExper.witness)
  #end
  #if(trainExper.witnessTel??)
    and M.WITNESS_TEL=#para(trainExper.witnessTel)
  #end
#end

#end