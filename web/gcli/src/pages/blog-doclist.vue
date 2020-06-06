<template>
  <div>

    <div class="bs-example">
      <!-- Bottom to top-->
      <div class="row">
        <div class="col-sm-12">
          <!-- normal -->
          <div class="col-sm-3 ih-item square effect10 bottom_to_top">
            <a href="#">
              <div class="img"><img :src="pic+'assets/rect/8.jpg'" alt="img"></div>
              <div class="info">
                <h3>Heading here</h3>
                <p>Description goes here</p>
              </div>
            </a>
          </div>
          <div class="col-sm-8 doclist-content">
            <div class="doclist-title">项目名称</div>
            <div class="doclist-desc">项目描述,项目描述,项目描述,项目描述,项目描述,项目描述,项目描述,项目描述</div>
            <div class="doclist-taglist">
              <div class="doclist-tagitem">Spring</div>
              <div class="doclist-tagitem">Spring</div>
              <div class="doclist-tagitem">Spring</div>
              <div class="doclist-tagitem">Spring</div>
            </div>
          </div>
          <!-- end normal -->
        </div>
        <div class="col-sm-12">
          <!-- normal -->
          <div class="ih-item square effect10 bottom_to_top"><a href="#">
            <div class="img"><img :src="pic+'assets/rect/8.jpg'" alt="img"></div>
            <div class="info">
              <h3>Heading here</h3>
              <p>Description goes here</p>
            </div>
          </a></div>
        </div>
        <!-- end normal -->
        <div class="col-sm-12">
          <!-- normal -->
          <div class="ih-item square effect10 bottom_to_top"><a href="#">
            <div class="img"><img :src="pic+'assets/rect/8.jpg'" alt="img"></div>
            <div class="info">
              <h3>Heading here</h3>
              <p>Description goes here</p>
            </div>
          </a></div>
          <!-- end normal -->
        </div>
        <div class="col-sm-12">
          <!-- normal -->
          <div class="ih-item square effect10 bottom_to_top"><a href="#">
            <div class="img"><img :src="pic+'assets/rect/8.jpg'" alt="img"></div>
            <div class="info">
              <h3>Heading here</h3>
              <p>Description goes here</p>
            </div>
          </a></div>
          <!-- end normal -->
        </div>
      </div>
    </div>
  </div>


</template>

<script>
  export default {
    name: "blog-doclist",
    data() {
      return {
        pic: "/static/doclist/images/"
      }
    },
  }
</script>

<style scoped>
  @import "../assets/doclist/css/main.css";
  @import "../assets/doclist/css/default.css";
  @import "../assets/doclist/css/normalize.css";
</style>
