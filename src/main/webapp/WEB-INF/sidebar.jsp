<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<text class="content">

      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" id="search-text" class="form-control" placeholder="Buscar Camadas...">
          <span class="input-group-btn">
              <button type="button" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
            </span>
        </div>
      </form>
      <!-- /.search form -->


      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MENU PRINCIPAL</li>
        <li class="treeview">
		
          <a href="${pageContext.servletContext.contextPath}/home">
            <i class="fa fa-flash"></i><span>Solucionadores</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-red">2</small>
            </span>
          </a>
		  
		  
          <ul class="treeview-menu">
            <li>
				<a href="${pageContext.servletContext.contextPath}/home">
					<i class="fa fa-crosshairs"></i><span>Problema de Tiro</span>
				</a>
			</li>
            <li>
				<a href="${pageContext.servletContext.contextPath}/home">
					<i class="fa fa-eye"></i><span>Linha de Visada</span>
					<span class="pull-right-container">
					  <small class="label pull-right bg-green">NOVO</small>
					</span>
				</a>
			</li>
			<li>
				<a href="${pageContext.servletContext.contextPath}/home">
					<i class="fa fa-map-signs"></i><span>Geocodificação</span>
				</a>
			</li>
			<li>
				<a href="${pageContext.servletContext.contextPath}/home"><i class="fa fa-cloud">
					</i><span>Meteorologia</span>
					<span class="pull-right-container">
					  <small class="label pull-right bg-green">NOVO</small>
					</span>
				</a>
			</li>
			<li>
				<a href="${pageContext.servletContext.contextPath}/home">
					<i class="fa fa-car"></i><span>Cálculo de Rota</span>
				</a>
			</li>
          </ul>
        </li>
		
        <li>
          <a href="${pageContext.servletContext.contextPath}/home">
            <i class="fa fa-th"></i><span>Metadados</span>
          </a>
        </li>		

        <li>
          <a href="home">
            <i class="fa fa-heartbeat"></i><span>Estatísticas do Sistema</span>
          </a>
        </li>
<security:authorize access="hasRole('ROLE_ADMIN')">
        <li class="header">ADMINISTRAÇÃO</li>
	        <li>
	          <a href="${pageContext.servletContext.contextPath}/users">
	            <i class="fa fa-users"></i><span>Usuários</span>
	          </a>
	        </li>
	        <li>
	          <a href="${pageContext.servletContext.contextPath}/home">
	            <i class="fa fa-plug"></i><span>Importadores</span>
	          </a>
	        </li>
	        <li>
	          <a href="${pageContext.servletContext.contextPath}/home">
	            <i class="fa fa-cogs"></i><span>Configuração do Portal</span>
	          </a>
	        </li>
</security:authorize>	        
	                
		</ul>
</text>		
