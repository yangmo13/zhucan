#namespace("workExper")

#sql("find")
  SELECT M.* FROM f_work_exper M WHERE 1=1
  #if(workExper.id??)
    and M.ID=#para(workExper.id)
  #end
  #if(workExper.refId??)
    and M.REF_ID=#para(workExper.refId)
  #end
  #if(workExper.companyName??)
    and M.COMPANY_NAME=#para(workExper.companyName)
  #end
  #if(workExper.post??)
    and M.POST=#para(workExper.post)
  #end
  #if(workExper.fromDate??)
    and M.FROM_DATE=#para(workExper.fromDate)
  #end
  #if(workExper.endDate??)
    and M.END_DATE=#para(workExper.endDate)
  #end
  #if(workExper.duty??)
    and M.DUTY=#para(workExper.duty)
  #end
#end

#end