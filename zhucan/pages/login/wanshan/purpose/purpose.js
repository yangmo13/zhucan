// pages/login/wanshan/purpose/purpose.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isNew:true,
    height:0,
    form:[],
    arr:[
      "离职,随时到岗",
      "在职，月内到岗",
      "在职，考虑机会"
    ],
    arr2:[
      "1千以下",
      "1千到2千",
      "2千到4千",
      "4千到6千",
      "6千到8千",
      "8千到1万",
      "1万到2万",
      "2万以上"
      
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let form = JSON.parse(options.form)
    console.log(form)
    
    this.setData({
      form:form,
      height:App.globalData.navHeight
    })
  },
  valueChange(e){
    console.log(e.detail,5555)
    this.setData({
      [e.currentTarget.dataset.msg]:e.detail
    })
  },
  next(){
    let form = JSON.stringify(this.data.form)
    wx.navigateTo({
      url: `../index?form=${form}`,
    })
  },
  isBlur(e){
    console.log(e.currentTarget.dataset.msg)
    console.log(e.detail)
    this.setData({
      [e.currentTarget.dataset.msg]:e.detail
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