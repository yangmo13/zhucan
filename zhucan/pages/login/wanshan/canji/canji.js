// pages/login/wanshan/canji/canji.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    height:"",
    arr:[
      "视力残疾",
      "听力残疾",
      "言语残疾",
      "肢体残疾",
      "智力残疾",
      "精神残疾",
      "其他",
    ],
    arr2:[
      "一级",
      "二级",
      "三级",
      "其他"
    ],
    form:{
   //残疾证类型
   "type": [],
   //残疾等级
   "level": "",

    },
    old_form:{}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let data = JSON.parse(options.form)
    let form = this.data.form
    console.log(data,"data")
    Object.keys(form).forEach(key=>{
      form[key]=data[key]
    })
      this.setData({
        height:App.globalData.navHeight,
        form:form,old_form:data
      })
      console.log(form)

  },
  change(e){
    console.log(e.detail.value)
    this.setData({
      [e.currentTarget.dataset.msg]:e.detail.value
    })
  },
  next(){
    let new_form = this.data.old_form
    let data =this.data.form
    Object.keys(new_form).forEach(key=>{
      if(data[key]){
        new_form[key]=data[key]
      }
      
    })

    this.setData({
      old_form:new_form
    })

    let form = JSON.stringify(this.data.old_form)
    console.log(form)
    wx.redirectTo({
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