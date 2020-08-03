// pages/login/wanshan/index.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    age: "22岁",
    idcard: "",
    job: "",
    phone: "180****4549",
    idcard2: "",
    form: [],
    height: ""
  },
  goPurpose(){
    let form = JSON.stringify(this.data.form)
    wx.navigateTo({
      url: `./purpose/purpose?form=${form}`,
    })
  },
  goBasic() {
    let form = JSON.stringify(this.data.form)
    wx.navigateTo({
      url: `./basic/basic?form=${form}`,
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let data = JSON.parse(options.form)
    console.log(data,"shuju")
    let idcard2=''
    data.idcard?idcard2 = (data.idcard).slice(0, 4) + '*** ':''
    console.log(data.phone, 55555)
    this.setData({
      height: App.globalData.navHeight,
      idcard2: idcard2,
      form: data
    })
  },
  next() {
    wx.navigateTo({
      url: '../fuwu/index',
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