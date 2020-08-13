// pages/component/form/input.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    isRed: Boolean,
    text: String,
    msg: String,
    start_time: String,
    end_time: String
  },

  /**
   * 组件的初始数据
   */
  data: {

    start: "",
    end: "",
    date:"",
    start_begin:'',
    start_end:"",
    end_begin:"",
    end_end:""
  },
  attached() {
    let time = new Date()
    let year = time.getFullYear()
    let month = time.getMonth()+1
    let day = time.getDate()
    console.log(`${year}-`+`${month}-`+`${day}`,"time")
    let date = `${year}-`+`${month}-`+`${day}`

    wx.nextTick(() => {

      this.setData({
        start: this.properties.start_time,
        end: this.properties.end_time,
        Date:date
      })

    })

  },

  /**
   * 组件的方法列表
   */
  methods: {
    bindDateChange(e) {

      this.setData({
        [e.currentTarget.dataset.msg]: e.detail.value
      })
      let start = this.data.start
      let end = this.data.end
      console.log(start, end, "这是开始时间和结束时间")

     
      //第一种情况 我什么都没点
      if(end!=''){
        this.setData({
          start_end:end
        })
      }
      if(start!=''){
        this.setData({
          end_begin:start
        })
      }


      this.triggerEvent('blur', this.data)
    }
  }
})