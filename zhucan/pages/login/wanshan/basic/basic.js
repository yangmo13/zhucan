// pages/login/wanshan/basic/basic.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isNew:true,
    height:0,
    form:{
      // // 姓名
      // name:"",
      // // 身份证
      // idcard:"",
      // // 参加工作时间
      // job_times:"",
      // // 现居住城市
      // city:"",
      // // 手机号码,
      // phone:"",
      // //年龄
      // age:""
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
   
    let form =JSON.parse(options.form)
      this.setData({
        height:App.globalData.navHeight,
        form:form
      })
      console.log(form,"jjjjj")
  },
  iptBlur(e){
 
    let name= e.currentTarget.dataset.name
    this.setData({
      [name]:e.detail,
    })

    
  },
  next(){
    let form = JSON.stringify(this.data.form)
   

    wx.navigateTo({
      url: `../index?form=${form}`,
    })
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