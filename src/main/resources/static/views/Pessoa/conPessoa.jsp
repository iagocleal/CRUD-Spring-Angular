<div class="content animate-panel">
	<div class="row">
 		<div class="col-lg-12">
 			<div class="hpanel">
  				
 				<div class="panel-body">  	
  				
  					<form id="PessoaSearch">
  						<div class="row">
  							<div class="form-group col-md-4">
	  							<label>Nome</label>
								<input id="idNome" name="idNome" class="form-control" type="text" ng-model="pessoa.nome" placeholder="Pesquisar por Nome" /> 
	  						</div>
	  						
	  						<div class="form-group col-md-4">
	  							<label>CPF</label>
								<input id="idCpf" name="idCpf" class="form-control" type="text" ng-model="pessoa.cpf" placeholder="Pesquisar por CPF" maxlength="14" onkeydown="javascript: fMasc( this, mCPF );" /> 
	  						</div>
  						</div>
  						
  						<div class="text-right">
	  						<a id="Filtro" name="Filtro" class="btn btn-info" ng-click="buscarPessoaFiltro()"><span class="glyphicon glyphicon-search"></span> Filtrar</a>
	  						
	  						<a id="Create" name="Novo" class="btn btn-success" href="#/Pessoa/new"><span class="fa fa-plus"></span> Novo</a>
	  					</div>
  					</form>
  					
  					<hr />				
  					
  					<label style="margin-bottom: -2px;font-size: 140%;" for="pessoa">Lista de Pessoas:</label>
 					<fieldset style="padding-top: 10px; padding-bottom: 10px; margin-bottom: 10px">
	  					<div id="search-result" class="row">
	  						<table class="table table-responsive table-bordered table-striped clearfix">
								<thead>
					                <tr class="cor-tabela">
										<th>Id</th>
										<th>Nome</th>
										<th>E-mail</th>
										<th>CPF</th>
										<th>Idade</th>
										<th>Quantidade de Telefones</th>
										<th class="text-center" style="width: 130px;">Ações</th>
					                </tr>
					            </thead>
					            <tbody id="search-results-body">
					                <tr ng-repeat="result in filteredResults | startFrom:currentPage*pageSize | limitTo:pageSize">
					                    <td>{{ result.id }}</td>
					                    <td>{{ result.nome}}</td>
					                    <td>{{ result.email }}</td>
					                    <td>{{ result.cpf }}</td>
					                    <td>{{ result.idade }} anos</td>
					                    <td>{{ result.qtdTelefones }}</td>
					                    <td align="center">
					                    	<a href="#/Pessoa/edit/{{result.id}}">
							                	<img src="img/editar.jpg" alt="logo">
							            	</a>
							            	<a href ng-click="excluir(result.id)">
							                	<img src="img/excluir.jpg" alt="logo">
							            	</a>
							            </td>
					                </tr>
					            </tbody>
	  						</table>
	  						
	  						<div class="pull-center">
								<ul class="pagination pagination-centered" style="margin-top: 0px; margin-bottom: 0px;">
							        <li ng-class="{disabled:currentPage == 0}">
							            <a id="prev" href ng-click="previous()">«</a>
							        </li>
							        <li ng-repeat="n in pageRange" ng-class="{active:currentPage == n}" ng-click="setPage(n)">
							            <a href ng-bind="n + 1">1</a>
							        </li>
							        <li ng-class="{disabled: currentPage == (numberOfPages() - 1)}">
							            <a id="next" href ng-click="next()">»</a>
							        </li>
							    </ul>
							</div>
	  					</div>
	  				</fieldset>
  				</div>
			</div>
		</div>
	</div>
</div>