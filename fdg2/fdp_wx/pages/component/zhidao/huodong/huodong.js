// pages/component/zhidao/活动/huodong.js
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
    arr: [{
        name: "手工编织",
        label: [
          "残肢、聋哑"
        ],
        msg: "讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧",
        src: "../../../../image/banner1.jpg",
        isZhibo: "直播中",
        date: "2020-05-30",
        time: "13:00",
        endTime: "15:00",
        url:"/pages/servers/index/zhiye/zhidao/detail_live/detail_live"
      },
      {
        name: "手工编织",
        label: [
          "残肢"
        ],
        msg: "讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧",
        src: "../../../../image/banner1.jpg",
        isZhibo: "未开始",
        date: "2020-05-30",
        time: "13:00",
        endTime: "15:00",url:"/pages/servers/index/zhiye/zhidao/detail_audio/detail_audio"
      },
      {
        name: "手工编织",
        label: [
          "残肢、聋哑"
        ],
        msg: "讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧",
        src: "../../../../image/banner1.jpg",
        isZhibo: "已结束",
        date: "2020-05-30",
        time: "13:00",
        endTime: "15:00",
        url:"/pages/servers/index/zhiye/zhidao/detail_other/detail_other"
      },
      {
        name: "图为类无图片",
        label: [
          "残肢、聋哑"
        ],
        msg: "讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧讲解手工艺品的制作方法和注意事项，各种串珠手法和技巧",
        src: "",
        isZhibo: "未开始",
        date: "2020-05-30",
        time: "13:00",
        endTime: "15:00",
        url:"/pages/servers/index/zhiye/zhidao/detail_pic/detail_pic"
      },
    ]
  },

  /**
   * 组件的方法列表
   */
  methods: {
    next(e) {
      let url = e.currentTarget.dataset.url
      wx.navigateTo({
        url: `${url}`,
      })
    }
  }
})