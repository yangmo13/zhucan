// 组织结构
const App = getApp()
const html='<div id="u2479_text" class="text "><p><span>理事长：周盛国，负责残联全面工作，主管残联办公室、财务室及各科室、中心各项工作</span></p><p><span>副理事长：曲淑波，协助理事长负责残疾人就业服务中心、香坊区残疾人联合会组联科、香坊区残疾人综合管理中心</span></p><p><span><br></span></p><p><span>　　（1）宣传贯彻《中华人民共和国残疾人保障法》，维护残疾人在政治、经济、文化、社会等方面平等的公民权利，密切联系残疾人，听取残疾人意见，反应残疾人诉求，全心全意为残疾人服务。</span></p><p><span>　　（2）团结、教育残疾人遵守法律，履行应尽义务，自尊、自信、自强、自理，为构建和谐社会、全面建设小康社会贡献力量。</span></p><p><span>　　（3）沟通政府、社会与残疾人之间的联系，宣传残疾人事业、动员社会理解、尊重、关心、帮助残疾人。</span></p><p><span>　　（4）开展和促进残疾人康复、教育、劳动就业、维权、文化体育、社会保障和残疾预防等工作，改善残疾人参与社会生活的环境和条件。</span></p><p><span>　　（5）参与研究、制定和实施残疾人事业的法律、法规、政策、规划，发挥综合、协调、咨询、服务作用，管理和指导有关领域的工作。</span></p><p><span>　　（6）承担政府残疾人工作委员会的日常工作。</span></p><p><span>　　（7）管理和发放《中华人民共和国残疾人证》。</span></p><p><span>　　（8）管理和指导各类残疾人群众组织，培养残疾人工作者，使残疾人在残疾人组织中更加活跃，残疾人组织在基层更加活跃，残疾人和残疾人组织在社会上更加活跃。</span></p><p><span>　　（9）开展国际交流与合作，发挥联合国经社理事会特别咨商地位的作用。</span></p></div>'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isNew:true,
    height:"",
     // 音乐
     myaudio:null,
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
    arr:{
      title:"哈尔滨市香坊区残联组织机构",
    laiyuan:"省残联",
    time:"2020-05-11",
      text:html
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 音乐
    this.data.myaudio = wx.createInnerAudioContext({});
    this.data.myaudio.src = "http://webfs.yun.kugou.com/202008131501/9646c6d2348acd9ac513a6133b5fd9f3/G230/M07/0C/1B/Jg4DAF8xCIOAOE0fADJNXLY-z1o546.mp3"
    this.setData({
      height: App.globalData.navHeight,
      // 音乐
      myaudio:this.data.myaudio
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