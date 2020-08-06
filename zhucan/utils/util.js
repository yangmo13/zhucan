const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}


module.exports = {
  formatTime: formatTime
}

//处理时间函数

function time(time) {

  let date = new Date(parseInt(time) * 1000)
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('-')

}
//正则验证
//验证只能为汉字
function isChinese(msg, name) {

  //msg 为传来的内容
  //name 验证什么方法
  console.log(name, 'name')
  //验证中文名字


  if (name == 'test_name') {
    let reg = /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/
    return msg==''?"必填信息不能为空":reg.test(msg) ? '' : "姓名不正确或者为空"
  } else if (name == 'test_idcard') {
    let reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
   return msg==''?"必填信息不能为空":reg.test(msg) ? '' : "身份证号码不正确"
  }else if(name == 'test_phone'){
    let reg =/^1[3456789]\d{9}$/
    return msg==''?"必填信息不能为空":reg.test(msg) ? '' : "手机号码不正确"
  }else if(name == 'must') {
    msg==''?'必填选项不能为空':""
  }else{
    return ""
  }


}
module.exports = {
  time: time,
  test: isChinese
}