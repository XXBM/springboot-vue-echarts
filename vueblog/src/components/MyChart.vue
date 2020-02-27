<template>
  <div id="app" style="margin-top: 10px;display: flex;justify-content: center">
    <v-chart class="my-chart" ref="dschart" :options="multipleYData"></v-chart>
  </div>
</template>
<script>
  import ECharts from 'vue-echarts/components/ECharts.vue'
  import "echarts/lib/chart/bar";//type: "bar",
  import 'echarts/lib/chart/line';//type: "line",
  import 'echarts/lib/chart/pie';//type: "pie",
  import 'echarts/lib/chart/map';//type: "map",
  import 'echarts/lib/chart/funnel';//type: "funnel",
  import 'echarts/lib/chart/parallel';//type: "parallel",

  export default {
    name: "App",
    components: {
      "v-chart": ECharts
    },
    data: function () {
      return {
        testData:{
          //标题
          title: {
            text: '某某某的统计图'
          },
          //工具箱
          toolbox: {
            show: true,
            feature: {
              dataView: {
                show: true
              },
              restore: {
                show: true
              },
              dataZoom: {
                yAxisIndex: 'none'
              },
              magicType: {
                type: ['line', 'bar']
              },
              saveAsImage: {
                show: true
              },
            }
          },
          //弹窗组件
          tooltip: {
            trigger:'axis'
          },
          //图例
          legend: {
            data: ['销量','产量']
          },
          //x轴
          xAxis: {
            type: 'category',
            data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
          },
          //y轴
          yAxis: {
            type: 'value'
          },
          //数据
          series: [{
            name: '销量',
            data: [5, 20, 36, 10, 10, 20],
            type: 'bar',
            smooth: true,
          },{
            name: '产量',
            data: [7, 30, 50, 11, 40, 80],
            type: 'line',
            smooth: true,
            markPoint:{
              data:[
                {type:'max',name:'最大值',symbolSize:'30'},
                {type:'min',name:'最小值',symbol:'pin', symbolSize:'30'}
              ]
            },
            markLine:{
              data:[{type:'average',name:'平均值'}]
            }
          }
          ]
        },
        pieData:{
          title : {
            text: '某站点用户访问来源',
            subtext: '纯属虚构',
            x:'center'
          },
          tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
          },
          legend: {
            orient: 'vertical',
            left: 'left',
            data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
          },
          series : [
            {
              name: '访问来源',
              type: 'pie',
              radius : '55%',
              center: ['50%', '60%'],
              data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                {value:135, name:'视频广告'},
                {value:1548, name:'搜索引擎'}
              ]
            }
          ]
        },
        gaugeData:{
          tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
          },
          toolbox: {
            feature: {
              restore: {},
              saveAsImage: {}
            }
          },
          series: [
            {
              name: '业务指标',
              type: 'gauge',
              detail: {formatter:'{value}%'},
              data: [{value: 32, name: '完成率'}]
            }
          ]
        },
        multipleYData:{
          tooltip: {
            trigger: 'axis'
          },
          toolbox: {
            feature: {
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar']},
              restore: {show: true},
              saveAsImage: {show: true}
            }
          },
          legend: {
            data:['蒸发量','降水量','平均温度']
          },
          xAxis: [
            {
              type: 'category',
              data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
          ],
          yAxis: [
            {
              type: 'value',
              name: '水量',
              min: 0,
              max: 250,
              interval: 50,
              axisLabel: {
                formatter: '{value} ml'
              }
            },
            {
              type: 'value',
              name: '温度',
              min: 0,
              max: 25,
              interval: 5,
              axisLabel: {
                formatter: '{value} °C'
              }
            }
          ],
          series: [
            {
              name:'蒸发量',
              type:'bar',
              data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
            },
            {
              name:'降水量',
              type:'bar',
              data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
            },
            {
              name:'平均温度',
              type:'line',
              yAxisIndex: 1,
              data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
            }
          ]
        },
      };
    }
  };
</script>
