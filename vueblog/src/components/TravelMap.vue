<template>
  <div v-loading="loading">
    <div style="margin-top: 10px;display: flex;justify-content: center">
      <el-input
        placeholder="你想去的地方..."
        prefix-icon="el-icon-search"
        v-model="keywords" style="width: 400px" size="small">
      </el-input>
      <el-button type="primary" icon="el-icon-search" size="small" style="margin-left: 3px" @click="searchClick">搜索
      </el-button>
    </div>
    <div style="display: flex;justify-content: space-around;flex-wrap: wrap;margin-top: 30px">
      <v-chart class="my-chart" ref="dschart" :options="mapData"></v-chart>
    </div>
  </div>
</template>
<script>
  import ECharts from 'vue-echarts/components/ECharts.vue'
  import china from 'echarts/map/json/china.json'
  ECharts.registerMap('china', china)
  import 'echarts/lib/chart/scatter';//type: "scatter",

  export default{
    name: "App",
    components: {
      "v-chart": ECharts
    },
    mounted: function () {
    },
    methods: {
      loadUserList(){
        var url = "/map/travel?place="+this.keywords;
        var lng,lat;
        this.$http.get(url).then(response=>{
          lng = JSON.stringify(response.data.result.location.lng);
          lat = JSON.stringify(response.data.result.location.lat);
          console.log(lng+"***"+lat)
          this.mapData.series[0].data.push({
            name: this.keywords,
            value: [lng, lat]
          });
        }).catch(errors=>{
          //this.$refs.msgDialog.confirm("获取失败！")
        })
      },
      searchClick(){
        this.loadUserList();
      }
    },
    data(){
      return {
        loading: false,
        keywords: '',
        mapData:{
          backgroundColor: '#404a59',
          title: {
            text: '2020要去的地方',
            left: 'center',
            textStyle: {
              color: '#fff'
            }
          },
          tooltip: {
            trigger: 'item'
          },
          toolbox: {
            show: true,
            feature: {
              saveAsImage: {
                show: true
              }
            }
          },
          geo: {
            map: 'china',
            label: {
              emphasis: {
                show: false
              }
            },
            roam: true,
            itemStyle: {
              normal: {
                areaColor: '#323c48',
                borderColor: '#111'
              },
              emphasis: {
                areaColor: '#2a333d'
              }
            }
          },
          series: [{
            name: '地址',
            type: 'scatter',
            coordinateSystem: 'geo',
            data: [],
            symbolSize: function(val) {
              return 10;
            },
          }]
        }
      }
    }
  }
</script>
