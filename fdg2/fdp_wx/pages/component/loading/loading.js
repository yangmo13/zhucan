// pages/component/loading/loading.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {

  },

  /**
   * 组件的初始数据
   */
  data: {
    ani:0
  },

  /**
   * 组件的方法列表
   */
  methods: {
      // start:()=>{
      //   console.log(11111)
      //   let animation = wx.createAnimation({
      //     delay: 4000,
      //     timingFunction:"ease",
      //     delay:1000
      //   });
      //   animation.opacity(0.2)
      //   this.setData({
      //     ani:animation.export()
      //   })
      //   this.setData({
      //     ani:2
      //   })
      // },
      start(){
        let animation = wx.createAnimation({
          delay: 4000,
          timingFunction:"ease",
           delay:1000
        })
        animation.translate()
        this.setData({
          ani:animation.export()
        })
      }
      
  }
})
