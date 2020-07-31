//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    img:"./img/header.png",
    isComfirm:""
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  islogin(){
    if(this.data.isComfirm=='yes'){
      wx.showModal({     
        title:"登录确定 ",
        confirmText:"确定登陆",
        
        content:"登陆成功后，需要您绑定身份证，请提前准备好身份证",
        success:(res)=>{
          console.log(res)
          wx.navigateTo({
            url: '/pages/login/identification/identification',
          })
        },
        fail:(res)=>{
          console.log(res)
        }
      })
    }else{
      wx.showModal({     
        title:"登录确定 ",
        confirmText:"确定",       
        content:"请勾选《用户服务协议》和《隐私协议》然后再登录",
        success:(res)=>{
          
        },
        fail:(res)=>{
          console.log(res)
        }
      })
    }
  },
  change(e){
    console.log(e.detail.value[0])
    this.setData({
      isComfirm:e.detail.value[0]
    })
    console.log(this.data.isComfirm)

  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
