// pages/servers/guanai/trip/trip.js
const App =getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    arr:[
      {
        starting:"香坊区政府",
        address:"香坊区残联",
        date:"07-17",
        time:"10:00",
        num:2,
        level:"二级残疾"
      }, {
        starting:"王安",
        address:"王刚",
        date:"07-17",
        time:"10:33",
        num:2,
        level:"二级残疾"
      }, {
        starting:"香坊区政府",
        address:"香坊区残联",
        date:"07-17",
        time:"10:00",
        num:2,
        level:"二级残疾"
      },
    ],
    //判断是否为司机
    isdriver:false
  },
  jiedan(){
    let isdriver = this.data.isdriver
    
    if(isdriver==true){
      wx.navigateTo({
        url: './tripMes/tripMes',
      })
    }else{
    wx.showModal({
      title:"信息提示",
      cancelColor: 'cancelColor',
      content:"您还不是爱心司机，是否立即申请为爱心司机",
      confirmText:"立即申请",
      confirmColor:"#2e8ded",
      success:(res)=>{
        console.log(res,"OKKOO")
        if(res.confirm){
          wx.redirectTo({
            url: './nodriver/nodriver',
          })
        }
      }
    })
  }

  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
this.setData({
  height:App.globalData.navHeight
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