#namespace("articleTmp")

#sql("find")
SELECT * FROM F_CONTENT_TMP A LEFT JOIN F_ARTICLE_TMP B ON A.ID=B.ID 
WHERE A.DELETED=0 AND A.VISIBLE=1 AND A.TYPE= #para(TYPE)
#if(contentTmp.TITLE??)
	AND A.TITLE like '%#(contentTmp.TITLE)%'
#end
#if(contentTmp.STATUS??)
	AND A.STATUS = #para(contentTmp.STATUS)
#end
#if(articleTmp.SRC??)
	AND B.SRC = #para(articleTmp.SRC)
#end
#if(articleTmp.PUB_TIME??)
	and DATE_FORMAT(B.PUB_TIME,'%Y-%m-%d')  >= '#(articleTmp.PUB_TIME.split("~")[0].trim())' and DATE_FORMAT(B.PUB_TIME,'%Y-%m-%d') <= '#(articleTmp.PUB_TIME.split("~")[1].trim())'
#end
#if(ID??)
	and A.ID = #para(ID)
#end
ORDER BY A.STATUS ASC, A.REGIST_TIME DESC
#end

#end