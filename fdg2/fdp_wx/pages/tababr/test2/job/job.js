// pages/tababr/test2/job/job.js
const App =getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    arr:[
     
      {
        name:"爱心生产，行政岗位后勤",
        company:"广顺电子有限公司",
        state:"企业未查看",
        date:"2020-05-23"
      },{
        name:"爱心生产，行政岗位后勤",
        company:"广顺电子有限公司",
        state:"企业未查看",
        date:"2020-05-23"
      },{
        name:"爱心生产，行政岗位后勤",
        company:"广顺电子有限公司",
        state:"企业未查看",
        date:"2020-05-23"
      },{
        name:"爱心生产，行政岗位后勤",
        company:"广顺电子有限公司",
        state:"企业未查看",
        date:"2020-05-23"
      },{
        name:"爱心生产，行政岗位后勤",
        company:"广顺电子有限公司",
        state:"企业未查看",
        date:"2020-05-23"
      }
    ],
    isloading:false
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
    console.log("上拉加载更多")
    let  newArr=[]
    let arr = this.data.arr
    this.setData({
      isloading:true
    })
    setTimeout(()=>{
      for(var i = 0 ;i<10;i++){
        newArr[i]={
          name:"爱心生产，行政岗位后勤"+i,
          company:"广顺电子有限公司",
          state:"企业未查看",
          date:"2020-05-23"
        }
      }
      arr = arr.concat(newArr)
      this.setData({
        arr:arr,
        isloading:false
      })
    },1500)
    
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})