// pages/servers/guanai/literature/literature.js
const App = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    num: 2,
    arr: [{
        name: "哈尔滨市开展助残日系列活动",
        mes: "7月19日上午，哈尔滨市残联在呼兰区萧红故居广场举行以 “推进残疾预防，健康成就小康为主题的系列惠残活动。”",
        src: "/image/other/u3396.svg",
        state: {
          apply: "报名中",
          date: "2020-05-30",
          time: "13:00~15:00"
        }
      },
      {
        name: "哈尔滨市开展助残日系列活动",
        mes: "7月19日上午，哈尔滨市残联在呼兰区萧红故居广场举行以 “推进残疾预防，健康成就小康为主题的系列惠残活动。”",
        src: "/image/other/u3396.svg",
        state: {
          apply: "报名中",
          date: "2020-05-30",
          time: "13:00~15:00"
        }
      },
      {
        name: "哈尔滨市开展助残日系列活动",
        mes: "7月19日上午，哈尔滨市残联在呼兰区萧红故居广场举行以 “推进残疾预防，健康成就小康为主题的系列惠残活动。”",
        src: "/image/other/u3396.svg",
        state: {
          apply: "报名中",
          date: "2020-05-30",
          time: "13:00~15:00"
        }
      },

    ],
    arr2:[
      {
        src:"http://222.32.73.38:8180/fdp/images/3_5_%E6%96%87%E4%BD%93%E6%B4%BB%E5%8A%A8/u3233.png",
        msg:"哈尔滨开展助残日系列活动",
        icon:"/image/literature/u3235.svg"
      },{
        src:"http://222.32.73.38:8180/fdp/images/3_5_%E6%96%87%E4%BD%93%E6%B4%BB%E5%8A%A8/u3233.png",
        msg:"哈尔滨开展助残日系列活动",
        icon:"/image/literature/u3235.svg"
      },{
        src:"http://222.32.73.38:8180/fdp/images/3_5_%E6%96%87%E4%BD%93%E6%B4%BB%E5%8A%A8/u3233.png",
        msg:"哈尔滨开展助残日系列活动",
        icon:"/image/literature/u3235.svg"
      },
    ],
    isloading:"loading",
    page:1
  },
  changeList(e) {
    let num = e.currentTarget.dataset.num
    this.setData({
      num: num
    })
  },
  next(e){
    let msg = e.currentTarget.dataset.msg
    wx.navigateTo({
      url: `./literaMes/literaMes?msg=${msg}`,
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      height: App.globalData.navHeight
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
    console.log(12122)
    let arr = []
    let arr2 = this.data.arr
    let num = this.data.page
    num++
    this.setData({
      page:num
    })
    if(num<4){
      setTimeout(() => {
        for (var i = 0; i < 10; i++) {
          let data = {
            name: "哈尔滨市开展助残日系列活动",
            mes: "7月19日上午，哈尔滨市残联在呼兰区萧红故居广场举行以 “推进残疾预防，健康成就小康为主题的系列惠残活动。”",
            src: "/image/other/u3396.svg",
            state: {
              apply: "报名中",
              date: "2020-05-30",
              time: "13:00~15:00"
            }
          }
          arr.push(data)
        }
        arr2 = arr2.concat(arr)
        this.setData({
          arr:arr2,
          isloading:"loading"
        })
      }, 1200);
  
    }else{
      this.setData({
        isloading:'nomore'
      })
    }
    console.log(num)
 
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})