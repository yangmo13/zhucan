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

function time(time){
  
  let date  = new Date(parseInt(time)*1000)
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
function isChinese(msg,name){
let reg = /^[\u0391-\uFFE5]+$/
if(name=="name"){
  if(!reg.test(msg)||msg==""){
    console.log(222)
   return  wx.showToast({
      title: '名字不正确',
      mask:true,
      duration:1000,
      icon:'none'
   
    })
  }
}


  
}
module.exports = {
  time:time,
  isChinese:isChinese
}