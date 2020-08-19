#namespace("eduExper")

#sql("find")
  SELECT M.* FROM f_edu_exper M WHERE 1=1
  #if(eduExper.id??)
    and M.ID=#para(eduExper.id)
  #end
  #if(eduExper.refId??)
    and M.REF_ID=#para(eduExper.refId)
  #end
  #if(eduExper.schoolName??)
    and M.SCHOOL_NAME=#para(eduExper.schoolName)
  #end
  #if(eduExper.fromDate??)
    and M.FROM_DATE=#para(eduExper.fromDate)
  #end
  #if(eduExper.endDate??)
    and M.END_DATE=#para(eduExper.endDate)
  #end
  #if(eduExper.edu??)
    and M.EDU=#para(eduExper.edu)
  #end
  #if(eduExper.unified??)
    and M.UNIFIED=#para(eduExper.unified)
  #end
  #if(eduExper.major??)
    and M.MAJOR=#para(eduExper.major)
  #end
#end

#end