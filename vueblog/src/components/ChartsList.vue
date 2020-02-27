<template>
  <el-container class="article_list">
    <el-main class="main">
      <el-tabs type="card" v-model="activeName">
        <el-tab-pane label="图表1" name="first">
          <my_chart></my_chart>
        </el-tab-pane>
        <el-tab-pane label="图表2" name="second">
          <map_tset></map_tset>
        </el-tab-pane>
        <el-tab-pane label="图表3" name="third">
          <data_zoom></data_zoom>
        </el-tab-pane>
        <el-tab-pane label="图表4" name="forth">
          <data_range></data_range>
        </el-tab-pane>
      </el-tabs>
    </el-main>
  </el-container>
</template>
<script>
  import MyChart from '@/components/MyChart'
  import MapTest from '@/components/MapTest'
  import DataZoom from '@/components/DataZoom'
  import DataRange from '@/components/DataRange'

  export default {
    mounted: function () {
    },
    data() {
      return {
        activeName: 'first'
      };
    },
    methods: {

    },
    components: {
      'my_chart': MyChart,
      'map_tset': MapTest,
      'data_zoom':DataZoom,
      'data_range':DataRange
    }
  };
</script>
<style>
  .article_list > .header {
    background-color: #ececec;
    margin-top: 10px;
    padding-left: 5px;
    display: flex;
    justify-content: flex-start;
  }

  .article_list > .main {
    /*justify-content: flex-start;*/
    display: flex;
    flex-direction: column;
    padding-left: 0px;
    background-color: #fff;
    padding-top: 0px;
    margin-top: 8px;
  }
</style>
