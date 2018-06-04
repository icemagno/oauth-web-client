<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html manifest="">

  <!-- PAGE HEAD -->
  <jsp:include page="head.jsp" />
  
  
<body class="hold-transition login-page bg">



<div class="login-box">

  <!-- /.login-logo -->
  
	<c:if test = "${param.error}">
        <div class="alert alert-danger alert-dismissible">
          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
          <h4><i class="icon fa fa-ban"></i>Dados Inválidos</h4>
          Não foi possível entrar no sistema com as credenciais fornecidas.
        </div>
	</c:if>  
  
  <div class="login-box-body">
    <div style="margin:0 auto; width:150px;height:180px"><img style="width:150px;height:170px" src="resources/custom/img/logo.png"></div>
  
    <p class="login-box-msg">Entrar no sistema</p>

    <form action="login" method="POST">
      <div class="form-group has-feedback">
        <input type="email" name="username" class="form-control" placeholder="Email">
        <input type="hidden" name="error" value="">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="password" class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
			&nbsp;
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Entrar</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

    <a href="#">Esqueci minha senha</a><br>
    <a href="#" class="text-center">Registrar-se</a>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

    <!-- LOAD JAVASCRIPT FILES -->
    <jsp:include page="requiredscripts.jsp" />

<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
</script>



</body>
</html>
