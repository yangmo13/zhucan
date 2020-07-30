// pages/component/header/header.js
const App =getApp()
Component({
  /**
   * 组件的属性列表
   */
  properties: {
      text:String,
      isNew:Boolean
  },

  /**
   * 组件的初始数据
   */
  data: {
    navHeight:0,
    text:''
  },
  lifetimes:{
    attached:function(){
      console.log(App.globalData.navHeight)
      this.setData({
        navHeight:App.globalData.navHeight
      })
    }

  },

  /**
   * 组件的方法列表
   */
  methods: {

  }
})
