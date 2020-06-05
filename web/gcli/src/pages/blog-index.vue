<template>
  <div id="page-top" class="index">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
          <button type="button" class="navbar-toggle" data-toggle="collapse"
                  data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#page-top">Ant Black</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li class="hidden">
              <a href="#page-top"></a>
            </li>
            <li class="page-scroll">
              <a href="#portfolio">门户</a>
            </li>
            <li class="page-scroll">
              <a href="#about">作品</a>
            </li>
            <li class="page-scroll">
              <a href="#contact">关于我</a>
            </li>
          </ul>
        </div>
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-fluid -->
    </nav>

    <!-- Header -->
    <header>
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <img class="img-responsive" :src="pic+'profile.png'" alt="">
            <div class="intro-text">
              <span class="name">小蚂蚁 - Gang</span>
              <hr class="star-light">
              <span class="skills">欢迎来到我的个人博客 ! Thanks</span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Portfolio Grid Section -->
    <section id="portfolio">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2>我的作品</h2>
            <hr class="star-primary">
          </div>
        </div>
        <div class="row">
          <div class="col-sm-4 portfolio-item">
            <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img :src="pic+'portfolio/cabin.png'" class="img-responsive" alt="">
            </a>
          </div>
          <div class="col-sm-4 portfolio-item">
            <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img :src="pic+'portfolio/cake.png'" class="img-responsive" alt="">
            </a>
          </div>
          <div class="col-sm-4 portfolio-item">
            <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img :src="pic+'portfolio/circus.png'" class="img-responsive" alt="">
            </a>
          </div>
          <div class="col-sm-4 portfolio-item">
            <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img :src="pic+'portfolio/game.png'" class="img-responsive" alt="">
            </a>
          </div>
          <div class="col-sm-4 portfolio-item">
            <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img :src="pic+'portfolio/safe.png'" class="img-responsive" alt="">
            </a>
          </div>
          <div class="col-sm-4 portfolio-item">
            <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img :src="pic+'portfolio/submarine.png'" class="img-responsive" alt="">
            </a>
          </div>
        </div>
      </div>
    </section>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top page-scroll visible-xs visble-sm">
      <a class="btn btn-primary" href="#page-top">
        <i class="fa fa-chevron-up"></i>
      </a>
    </div>


    <!--    &lt;!&ndash; jQuery Version 1.11.0 &ndash;&gt;-->
    <!--    <script src="js/jquery-1.11.0.js"></script>-->

    <!--    &lt;!&ndash; Bootstrap Core JavaScript &ndash;&gt;-->
    <!--    <script src="js/bootstrap.min.js"></script>-->

    <!--    &lt;!&ndash; Plugin JavaScript &ndash;&gt;-->
    <!--    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>-->
    <!--    <script src="js/classie.js"></script>-->
    <!--    <script src="js/cbpAnimatedHeader.js"></script>-->

    <!--    &lt;!&ndash; Contact Form JavaScript &ndash;&gt;-->
    <!--    <script src="js/jqBootstrapValidation.js"></script>-->
    <!--    <script src="js/contact_me.js"></script>-->

    <!--    &lt;!&ndash; Custom Theme JavaScript &ndash;&gt;-->
    <!--    <script src="js/freelancer.js"></script>-->

  </div>
</template>

<script>
  export default {
    name: "blog-index",
    data() {
      return {
        pic: "/static/img/"
      }
    }
  }
</script>

<style scoped>
  @import "../assets/css/freelancer.css";
</style>
