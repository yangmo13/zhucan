// pages/component/form/input.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    isRed: Boolean,
    text: String,
    msg: String,
    start_time:String,
    end_time:String
  },

  /**
   * 组件的初始数据
   */
  data: {
 
        start: "",
        end: ""
    
   
    
  },
  attached(){
   
   wx.nextTick(()=>{
    
    this.setData({
      start:this.properties.start_time,
      end:this.properties.end_time
    })
   
   })
   
  },

  /**
   * 组件的方法列表
   */
  methods: {
    change(e) {

      this.triggerEvent('blur', e.detail.value)
    },
    bindDateChange(e) {
   
      this.setData({
        [e.currentTarget.dataset.msg]:e.detail.value
      })
      

      this.triggerEvent('blur', this.data)
    }
  }
})