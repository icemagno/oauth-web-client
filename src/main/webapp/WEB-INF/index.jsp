<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html manifest="">
  <!-- PAGE HEAD -->
  <jsp:include page="head.jsp" />
  <style type="text/css">
    /* show the move cursor as the user moves the mouse over the panel header.*/
    #draggablePanelList  {
    cursor: move;
    }
  </style>
  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
      <!-- Main Header -->
      <header class="main-header">
        <!-- PAGE LOGO -->
        <jsp:include page="pagelogo.jsp" />
        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
          <span class="sr-only">Toggle navigation</span>
          </a>
          <!-- Navbar Right Menu -->
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- NOTIFICATIONS -->
              <jsp:include page="notifications.jsp" />
              <!-- TASKS -->
              <jsp:include page="tasksmenu.jsp" />
              <!-- USER DROP DOWN -->
              <jsp:include page="userdropdown.jsp" />
              <!-- Control Sidebar Toggle Button -->
              <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
              </li>
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar" >
          <!-- SIDEBAR -->
          <jsp:include page="sidebar.jsp" />
        </section>
        <!-- /.sidebar -->
      </aside>
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Geoportal
            <small>Sistema de Geoinformação de Defesa</small>
          </h1>
        </section>
        <!-- Main content -->
        <section class="content container-fluid">
          <div class="row">
            <div class="col-md-3">
              <div class="box box-primary">
                <div class="box-header with-border">
                  <h3 class="box-title">Camadas Ativas</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                  <ul id="draggablePanelList" class="list-unstyled">
                  
                  	<li>
			          <div class="box box-danger box-solid">
			            <div class="box-header">
			              <h3 class="box-title">Reservatórios ANA</h3>
			            </div>
			            <div class="box-body">
			              Agência Nacional de Águas
			            </div>
			            <!-- /.box-body -->
			            <!-- Loading (remove the following to stop the loading)-->
			            <div class="overlay">
			              <i class="fa fa-refresh fa-spin"></i>
			            </div>
			            <!-- end loading -->
			          </div>                  
                  	</li>
                    
                    <li >
                    
			          <div class="box box-warning box-solid">
			            <div class="box-header">
			              <h3 class="box-title">Curvas de Nível</h3>
			            </div>
			            <div class="box-body">
			              Exército Brasileiro
			            </div>
			          </div>                  
                      
                    </li>
                  </ul>
                </div>
                <!-- /.box-body -->
              </div>
            </div>
            <div class="col-md-9">
              <!-- Map box -->
              <div class="box box-success">
                <div class="box-body" style="padding: 0px;">
                  <div id="world-map" style="height: calc(100vh - 200px); width: 100%;"></div>
                </div>
              </div>
            </div>
          </div>
        </section>
        <!-- /.content -->
      </div>
      <!-- /.content-wrapper -->
      <!-- LOAD PAGE FOOTER -->
      <jsp:include page="footer.jsp" />
      <!-- Control Sidebar -->
      <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
          <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
          <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
          <!-- Home tab content -->
          <div class="tab-pane active" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">Administração</h3>
            

            
            
            
            <!-- /.control-sidebar-menu -->
          </div>
          <!-- /.tab-pane -->
          <!-- Stats tab content -->
          <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
          <!-- /.tab-pane -->
          <!-- Settings tab content -->
          <div class="tab-pane" id="control-sidebar-settings-tab">
            <h3 class="control-sidebar-heading">Importadores Ativos</h3>
            <ul class="control-sidebar-menu">
              <li>
                <a href="javascript:;">
                  <h4 class="control-sidebar-subheading">
                    [XYF4A6] - BDGEX 
                    <span class="pull-right-container">
                    <span class="label label-danger pull-right">70%</span>
                    </span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                  </div>
                </a>
              </li>
              <li>
                <a href="javascript:;">
                  <h4 class="control-sidebar-subheading">
                    [UUH34C] - DHN-CARTAS 
                    <span class="pull-right-container">
                    <span class="label label-success pull-right">30%</span>
                    </span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-success" style="width: 30%"></div>
                  </div>
                </a>
              </li>
            </ul>
          </div>
          <!-- /.tab-pane -->
        </div>
      </aside>
      <!-- /.control-sidebar -->
      <!-- Add the sidebar's background. This div must be placed
        immediately after the control sidebar -->
      <div class="control-sidebar-bg"></div>
    </div>
    <!-- ./wrapper -->
    <!-- LOAD JAVASCRIPT FILES -->
    <jsp:include page="requiredscripts.jsp" />
  </body>
  <script>
    $('#draggablePanelList').sortable({

        update: function() {
            $('.panel', panelList).each(function(index, elem) {
                 var $listItem = $(elem);
                 var newIndex = $listItem.index();
                 // Persist the new indices.
            });
        }
    
    });  
    
  </script>
</html>

