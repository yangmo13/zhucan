
const App = getApp()
const html='<div id="u2195_text" class="text "><p><span>各区、县（市）残联：</span></p><p><span>&nbsp;&nbsp;&nbsp;&nbsp;今年是全面建成小康社会和加快残疾人小康进程规划纲要的收官之年，是实现第一个百年奋斗目标的决胜之年，也是脱贫攻坚战的决战决胜之年。为贯彻落实中国残联《关于积极应对新冠肺炎疫情 有序推进贫困残疾人脱贫攻坚工作的通知》以及《关于做好新冠肺炎疫情防控期间贫困残疾人脱贫攻坚工作的通知》（黑残联发〔2020〕6号）、《关于做好新冠肺炎疫情防控期间脱贫攻坚工作的通知》（哈扶组发〔2020〕1号）文件精神，迎接第30个全国助残日的到来，根据中、省、市残联《关于开展第三十次全国助残日活动的通知》安排、中狮联〔2020〕27号文件要求，精准实施“关心你的残疾人邻居”和“放飞心灵文化助残扶贫行动”，丰富活跃残疾人业余文化生活，展示残疾人脱贫攻坚及“温馨工程”服务成果，展示残疾人朋友的风采，现决定举办残疾人线上云端风采大赛。</span></p><p><span>一、活动主题</span></p><p><span>温馨工程——身残志坚 脱贫攻坚</span></p><p><span>二、主办单位</span></p><p><span>哈尔滨市残疾人联合会</span></p><p><span>中国狮子联会哈尔滨代表处</span></p><p><span>三、承办单位</span></p><p><span>哈尔滨市残疾人综合服务中心</span></p><p><span>黑龙江省残疾人作家协会</span></p><p><span>中国狮子联会哈尔滨代表处服务项目委员会</span></p><p><span>中国狮子联会哈尔滨代表处助残委</span></p><p><span>中国狮子联会哈尔滨代表处公宣委</span></p><p><span>四、大赛内容</span></p><p><span>（一）身残志坚 脱贫攻坚——残疾人云端征文大赛</span></p><p><span>（二）身残志坚 脱贫攻坚——残疾人云端诵读、演讲大赛</span></p><p><span>（三）身残志坚 脱贫攻坚——残疾人云端歌唱大赛</span></p><p><span>五、相关要求</span></p><p><span>&nbsp;&nbsp; &nbsp; &nbsp; 参与对象为黑龙江省持有二代残疾人证的残疾人，不限性别和年龄。征文、诵读、演讲及歌曲要求内容健康，思想积极向上；紧扣身残志坚、脱贫攻坚主题，讴歌大好时代及新时代最可爱的人，反映改革开放以来残疾人事业的跨越发展及残疾人生活发生的巨变等内容，</span></p><p><span>弘扬主旋律，赞颂真善美。</span></p><p><span>（一）征文：体裁不限，必须为原创作品。字数2000字以内；投稿以WORD或WPS格式、附带报名表统一发送指定邮箱。</span></p><p><span>（二）诵读、演讲：鼓励原创，时间6分钟以内；以MP4或MP3格式，附带报名表发送指定邮箱。</span></p><p><span>（三）歌唱：鼓励原创，时间5分钟以内；以MP4或MP3格式，附带报名表发送指定邮箱。</span></p><p><span>报名时间：5月7日——6月7日</span></p><p><span>联系人：刘向东 电话：15046101123</span></p><p><span>指定邮箱：2228289335@qq.com</span></p><p><span>（四）云端展播：优秀作品采取“随收随展”的方式，每2周在“狮爱龙江”公众平台及主流媒体择优陆续宣传发布。</span></p><p><span>六、大赛评审</span></p><p><span>&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; 大赛将聘请省市作协、文艺院团专业老师进行线上轮评，保证大赛公平公正。6月10——6月20日期间进行评审，并于6月底前</span></p><p><span>在“狮爱龙江”微信公众平台公布成绩。</span></p><p><span>七、大赛设置</span></p><p><span>&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; 各组赛事分设一等奖1名；二等奖2名；三等奖3名；优秀奖若干名。获奖情况将第一时间通过各地残联通知获奖者。获奖者将根据名次获得奖杯、证书及奖品、纪念品。</span></p><p><span>附件：《“温馨工程”杯 身残志坚 脱贫攻坚——残疾人云端风采大赛报名表》</span></p></div>'

const buttons = [{
  label: 'GetUserInfo',
  
},
{
  label: 'Share',
},
{
  label: 'Contact',
},
{
  label: 'View on Demo',
},
]
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isNew:true,
    height:"",
    buttons,
    arr:{
      title:"关于开展“温馨工程”杯身残志坚脱贫攻坚——残疾人云端",
    laiyuan:"省残联",
    time:"2020-8-11",
      text:html
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
  onClick(e) {
    console.log('onClick', e.detail)
    console.log('onContact点击第几个', e.detail.index)
    // if (e.detail.index === 3) {
    //     wx.switchTab({
    //         url: '/pages/index/index'
    //     })
    // }
},
onContact(e) {
    console.log('onContact', e)
},
onGotUserInfo(e) {
    console.log('onGotUserInfo', e)
},
onGotPhoneNumber(e) {
    console.log('onGotPhoneNumber', e)
},
onChange(e) {
    console.log('onChange', e)
},
pickerChange(e) {
    const { value } = e.detail
    const { model } = e.currentTarget.dataset
    this.setData({
        [model]: value,
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