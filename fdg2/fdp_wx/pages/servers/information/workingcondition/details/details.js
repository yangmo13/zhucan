const App = getApp()
const html = ''
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isNew: true,
    height: "",
    // 音乐
    myaudio: null,
    buttons: [{
      label: '收藏',
      sel:false,
      icon: "md-heart-empty"
    },
    {
      label: '声音',
      sel:false,
      icon:"md-volume-off"
    },
  ],

    arr: {
      title: "省残联召开视频会议督导绥化市贫困残疾人脱贫攻坚工作",
      laiyuan: "省残联",
      time: "2020-8-11",
      text: '<span>为深入贯彻落实习近平总书记在决战决胜脱贫攻坚座谈会上的重要讲话精神和省委决战决胜脱贫攻坚座谈会精神，加快助推贫困残疾人脱贫攻坚步伐，按照《贫困残疾人脱贫攻坚挂牌督战工作方案》安排，结合我省疫情防控形势，5月20日，省残联召开视频督导会议，对绥化市及海伦市、青冈县、兰西县贫困残疾人脱贫攻坚工作进行视频督导。省残联党组书记、理事长、对绥化市贫困残疾人脱贫攻坚挂牌督导牵头领导董濮出席会议并讲话。</span>'
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 音乐
    this.data.myaudio = wx.createInnerAudioContext({});
    this.data.myaudio.src = "https://webfs.yun.kugou.com/202008131619/96bbe20a36d8b00e75bf0a3b58550b68/G230/M02/1E/10/hocBAF80nguAGUqFADSLmRTI2Uk396.mp3"
    this.setData({
      height: App.globalData.navHeight,
      // 音乐
      myaudio: this.data.myaudio
    })
  },
// 音乐、收藏
onClick(e) {
  console.log('onClick', e.detail)
  console.log('onClick点击第几个', e.detail.index)
  this.data.buttons[e.detail.index].sel= !this.data.buttons[e.detail.index].sel;
  if (e.detail.index === 0) {
    this.data.buttons[e.detail.index].icon=!this.data.buttons[e.detail.index].sel?"md-heart-empty":"md-heart"
    if(this.data.buttons[e.detail.index].sel){
      wx.showToast({
        title: "已收藏",
      })
    }else{
      wx.showToast({
        title: "未收藏",
      })
    }
  }
  else  if (e.detail.index === 1) {
    this.data.buttons[e.detail.index].icon=!this.data.buttons[e.detail.index].sel?"md-volume-off":"md-volume-high"
    if(this.data.buttons[1].sel){
     this.data. myaudio.play();
    }else{
     this.data. myaudio.pause();
    }

  }
  this.setData({
    buttons:this.data.buttons
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
    // 音乐
    this.data.myaudio.destroy();
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