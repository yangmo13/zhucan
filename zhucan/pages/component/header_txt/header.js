// pages/component/header/header.js
const App =getApp()
Component({
  /**
   * 组件的属性列表
   */
  properties: {
      text:String,
      isNew:Boolean,
      color:String,
      back:Boolean,
      back_age:Boolean
  },

  /**
   * 组件的初始数据
   */
  data: {
    navHeight:0,
    text:'',
    isBack:true,
    back:false
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
    back(){
      console.log(this.properties.back,"dssasdsad")
     
      if(this.properties.back_age==true){
        wx.navigateBack({
          delta:1
        })
      }else{
        console.log(this.properties.text)
        this.triggerEvent('backNow',this.data.isBack)
      }
      
    }
  }
})
