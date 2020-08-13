// pages/login/wanshan/index.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    form: {
      //姓名
      'name': '杨墨',
      //年龄
      'age': "22",
      //身份证号码
      'idcard': '230103199708305714',
      //参加工作时间
      'job_time': '0年',
      //现居住城市
      'city': "",
      //手机号码
      'phone': "18045478923",
      //意向

      //求职意向
      'purpose': "离职,随时到岗",
      //薪资
      'pay': "1千",
      //期望工作地点
      'workplace': "",
      //期望岗位
      'station': "",

      //残疾情况
      //残疾证类型
      "type": [],
      //残疾等级
      "level": "",

      //工作经历
      //单位名称
      "company": "",
      //工作岗位
      'job_station': "",
      //入职时间

      //在职时间开始
      'job_start': "",
      //在职时间结束
      'job_end': "",

      //工作职责
      'responsibility': "",

      //教育经历

      //学校名称
      'school': '',
      //在校时间
      'school_start': "",
      'school_end': '',
      //学历
      'education_background': '',
      //是否统招
      'recruitment': "",

      //培训经历
      //培训机构
      'organization': "",
      //培训时间
      //培训开始
      'peixun_start': "",
      //培训结束
      'prixun_end': "",
      //培训专业
      'major': '',
      //证明人
      'certifier': "",
      //证明人手机
      'certifier_phone': "",

      //自我评价
      'myself': ""


    },
    phone2:'',
    height:0
  },

  goNext(e) {
    let url = e.currentTarget.dataset.url
    let form = JSON.stringify(this.data.form)
    wx.navigateTo({
      url: `./${url}/${url}?form=${form}`,
    })

  },
  jump(){
    wx.navigateTo({
      url: '../fuwu/index',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let phone2 = this.data.form.phone.substr(0,3)+'****'+this.data.form.phone.substr(7)
    this.setData({
      height:App.globalData.navHeight,phone2:phone2
    })
    if (options.form) {
      let data = JSON.parse(options.form)
      phone2 = data.phone.substr(0,3)+'****'+data.phone.substr(7)
      console.log(data, "DATA")
      this.setData({
        form: data,
        phone2:phone2
      })

    }


  },
  next() {
    let arr =[]
    this.setData({
      a:5555
    })
    let form = this.data.form
    Object.keys(form).forEach(key=>{
      if(key=='name'&&form[key]==''){
          arr.push("姓名信息不对")
          this.setData({
            next_name:"red"
          })
      }else if(key =='idcard'&&form[key]==''){
        arr.push("身份证信息未填写")
        this.setData({
          next_idcard:"red"
        })
      }
      else if(key =='job_time'&&form[key]==''){
        arr.push("工作时间信息未填写")
        this.setData({
          next_job_time:"red"
        })
      }
      else if(key =='city'&&form[key]==''){
        arr.push("城市信息未填写")
        this.setData({
          next_city:"red"
        })
      }
      else if(key =='phone'&&form[key]==''){
        arr.push("手机信息未填写")
        this.setData({
          next_phone:"red"
        })
      }
      else if(key =='type'&&form[key]==''){
        arr.push("残疾类型未填写")
        this.setData({
          next_type:"red"
        })
      }
      else if(key =='level'&&form[key]==''){
        arr.push("残疾等级未填写")
        this.setData({
          next_level:"red"
        })
      }
    })
    console.log(arr,'ARR')
    if(arr.length==0){
  wx.navigateTo({
      url: '../fuwu/index',
    })
    }else{
      wx.showModal({
        cancelColor: 'cancelColor',
        content:`${arr}`
      })
    }
    
    
  
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})