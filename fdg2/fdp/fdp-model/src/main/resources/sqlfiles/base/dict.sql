#namespace("dict")

#sql("find")
SELECT d.* FROM T_DICT d
  #if(pid!=null)
  WHERE d.PID=#para(pid)
  #else
  WHERE d.PID IS NULL
  #end
  #if(title!=null)
  AND d.TITLE LIKE CONCAT('%', #para(title) , '%')
  #end
  #if(code!=null)
  AND d.CODE LIKE CONCAT('%', #para(code) , '%')
  #end
ORDER BY d.SEQ
#end
#sql("findMaxSeq")
  SELECT IFNULL(MAX(d.SEQ),0) FROM T_DICT d
  #if(pid!=null)
  WHERE d.PID=#para(pid)
  #else
  WHERE d.PID IS NULL
  #end
#end
#sql("findSubCount")
  SELECT COUNT(1) FROM T_DICT WHERE PID=?
#end
#sql("findNearBy")
SELECT * FROM T_DICT where id!=#para(id)
  #if(pid!=null)
  and PID=#para(pid)
  #else
  and PID IS NULL
  #end
  #if(direct>0)
  and SEQ>#para(seq) order by SEQ asc
  #else
  and SEQ<#para(seq) order by SEQ desc
  #end
#end
#sql("findSubByPid")
SELECT * FROM T_DICT where PID=#para(pid) ORDER BY SEQ
#end
#sql("findByCode")
SELECT * FROM T_DICT where CODE=#para(code) ORDER BY SEQ
#end
#sql("findByValue")
SELECT a.* FROM T_DICT a LEFT JOIN T_DICT b ON a.PID=b.ID WHERE b.CODE=#para(code) AND a.CODE=#para(value)
#end
#sql("findByTable")
SELECT #(showColumn) TITLE,#(valueColumn) CODE FROM #(table)
#end
#sql("findByTitle")
SELECT a.* FROM T_DICT a LEFT JOIN T_DICT b ON a.PID=b.ID WHERE b.CODE=#para(code) AND a.TITLE=#para(value)
#end


#end