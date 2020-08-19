#namespace("documentTmp")

#sql("find")
SELECT * FROM F_CONTENT_TMP A LEFT JOIN F_DOCUMENT_TMP B ON A.ID=B.ID 
WHERE A.DELETED=0 AND A.VISIBLE=1 
#if(TYPE??)
	AND A.TYPE=#para(TYPE)
#end
#if(contentTmp.TITLE??)
	AND A.TITLE LIKE '%#(contentTmp.TITLE)%'
#end
#if(documentTmp.TYPE??)
	AND B.TYPE = #para(documentTmp.TYPE)
#end
#if(contentTmp.STATUS??)
	AND A.STATUS = #para(contentTmp.STATUS)
#end
#if(ID??)
	and A.ID = #para(ID)
#end
ORDER BY A.STATUS ASC, A.REGIST_TIME DESC
#end

#end