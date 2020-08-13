
const App = getApp()
const html=''
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isNew:true,
    height:"",
    arr:{
      title:"省残联召开视频会议督导绥化市贫困残疾人脱贫攻坚工作",
    laiyuan:"省残联",
    time:"2020-8-11",
      text:'<span>为深入贯彻落实习近平总书记在决战决胜脱贫攻坚座谈会上的重要讲话精神和省委决战决胜脱贫攻坚座谈会精神，加快助推贫困残疾人脱贫攻坚步伐，按照《贫困残疾人脱贫攻坚挂牌督战工作方案》安排，结合我省疫情防控形势，5月20日，省残联召开视频督导会议，对绥化市及海伦市、青冈县、兰西县贫困残疾人脱贫攻坚工作进行视频督导。省残联党组书记、理事长、对绥化市贫困残疾人脱贫攻坚挂牌督导牵头领导董濮出席会议并讲话。</span>'
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