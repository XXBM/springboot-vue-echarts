<template>
  <div id="app" style="margin-top: 10px;display: flex;justify-content: center">
    <v-chart class="my-chart" ref="dschart" :options="dataZoomData"></v-chart>
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
      var base = +new Date(1968, 9, 3);
      var oneDay = 24 * 3600 * 1000;
      var date = [];

      var data = [Math.random() * 300];

      for (var i = 1; i < 20000; i++) {
        var now = new Date(base += oneDay);
        date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('-'));
        data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]));
      }

      return {
        dataZoomData:{
          tooltip: {
            trigger: 'axis',
            position: function (pt) {
              return [pt[0], '10%'];
            }
          },
          title: {
            left: 'center',
            text: '大数据量折线图',
          },
          legend: {
            top: 'bottom',
            data:['意向']
          },
          toolbox: {
            show: true,
            feature: {
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
              restore: {show: true},
              saveAsImage: {show: true}
            }
          },
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date
          },
          yAxis: {
            type: 'value',
            boundaryGap: [0, '100%']
          },
          dataZoom: [{
            type: 'slider',
            start: 10,
            end: 40
          }],
          series: [
            {
              name:'模拟数据',
              type:'line',
              smooth:true,
              symbol: 'none',
              sampling: 'average',
              itemStyle: {
                normal: {
                  color: 'rgb(255, 70, 131)'
                }
              },
              areaStyle: {
                normal: {
                  color: 'rgb(255, 70, 131)'
                }

              },
              data: data
            }
          ]
        }
      };
    }
  };
</script>
