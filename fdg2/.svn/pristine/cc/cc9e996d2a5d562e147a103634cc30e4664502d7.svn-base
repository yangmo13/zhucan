// pages/login/wanshan/jingli/jingli.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    old_form: "",
    form: {
      //单位名称
      'company': '',
      //工作岗位
      'job_station': "",
      //入职时间

      //在职时间开始
      'job_start': "",
      //在职时间结束
      'job_end': "",

      //工作职责
      'responsibility': "",
    },
    'express': [{
      'company': "xxx清洁服务公司",
      //工作岗位
      'job_station': "保洁",
      //在职时间开始
      'job_start': "2010-08",
      //在职时间结束
      'job_end': "2020-01",
      //职责
      'responsibility': "负责xx小区及xx街道道路及环境卫生",
    }],
    num: -1,
    height: 0,
    isnew: true
  },

  iptChnage(e) {
    console.log(15155)
    let msg = e.currentTarget.dataset.msg
    let start = 'form.job_start'
    let end = 'form.job_end'

    if (e.detail.start) {
      this.setData({
        [start]: e.detail.start,
        [end]: e.detail.end,
      })
    } else {
      this.setData({
        [msg]: e.detail
      })
    }


    console.log(this.data.form)

  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    let num = options.num;

    this.setData({
      num: num
    })
    let data = JSON.parse(options.form)
    let form = this.data.form
    if (num != -1) {  
      console.log(data.express[num])
      Object.keys(form).forEach(key => {
        form[key] = data.express[num][key]
      })
      this.setData({
        form: form,
        height: App.globalData.navHeight,
        old_form: data
      })
      console.log(this.data.form)

    }else{
      this.setData({
        height: App.globalData.navHeight,
        old_form: data
      })
    }

  },
  next() {
    let num = this.data.num
    let new_form = this.data.old_form
    let data = this.data.form
  let length = new_form.express.length
    console.log(new_form.express.length,"lhk")
    if(num!=-1){
      console.log(data, '第一个form')
      console.log(new_form, 'new_form')
      
      new_form.express[num]=data
      this.setData({
        old_form:new_form
      })
      console.log(this.data.old_form)
      this.setData({
        old_form: new_form
      })
  
      let form = JSON.stringify(this.data.old_form)
      console.log(form, '4555454s')
      wx.redirectTo({
        url: `../index?form=${form}`,
      })
    }else{
      
      new_form.express.push(data)
      this.setData({
        old_form:new_form
      })
      let form = JSON.stringify(this.data.old_form)
      wx.redirectTo({
        url: `../index?form=${form}`,
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