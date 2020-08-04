// pages/login/wanshan/purpose/purpose.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isNew:true,
    height:0,
    form:{
      //求职意向
      'purpose': "",
      //薪资
      'pay': "",
      //期望工作地点
      'workplace': "",
      //期望岗位
      'station': ""
    },
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
      
    ],
   ' old_form':{}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let data = JSON.parse(options.form)
    let form =this.data.form
    console.log(data)
    Object.keys(form).forEach(key=>{
      form[key]=data[key]
    })
    this.setData({
      form:form,
      old_form:data,
      height:App.globalData.navHeight
    })
    console.log(this.data.form)
  },
  valueChange(e){
    
    this.setData({
      [e.currentTarget.dataset.msg]:e.detail
    })
    console.log(this.data.form,5555)
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
  isBlur(e){
    console.log(e.currentTarget.dataset.msg)
  
    this.setData({
      [e.currentTarget.dataset.msg]:e.detail
    })
    console.log(this.data.form)
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