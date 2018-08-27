<div class="content animate-panel">
	<div class="row">
 		<div class="col-lg-12">
 			<div class="hpanel">
 				
 				<div class="panel-body">
 					<form id="PessoaForm" name="PessoaForm" role="form">
 						<fieldset>
 							<div class="row">
 								<md-input-container class="col-md-3">
 									<div ng-class="{'has-error': PessoaForm.pesNome.$touched  && PessoaForm.pesNome.$invalid}">
								        <label for="pesNome">Nome</label>
							            <input id="pesNome" name="pesNome" type="text" required class="form-control" ng-model="pessoa.nome" />
							            <span class="help-block error" ng-show="PessoaForm.pesNome.$error.required && PessoaForm.pesNome.$touched">obrigatório</span> 
							        </div>
 								</md-input-container>
 								
 								<md-input-container class="col-md-3">
 									<div ng-class="{'has-error': PessoaForm.pesCpf.$touched  && PessoaForm.pesCpf.$invalid}">
								        <label for="pesCpf">CPF</label>
							            <input id="pesCpf" name="pesCpf" type="text" required class="form-control" ng-model="pessoa.cpf" maxlength="14" onkeydown="javascript: fMasc( this, mCPF );"/>
							            <span class="help-block error" ng-show="PessoaForm.pesCpf.$error.required && PessoaForm.pesCpf.$touched">obrigatório</span> 
							        </div>
 								</md-input-container>
 							</div>
 							<div class="row">
 								<md-input-container class="col-md-3">
 									<div ng-class="{'has-error': PessoaForm.pesEmail.$touched  && PessoaForm.pesEmail.$invalid}">
								        <label for="pesEmail">E-mail</label>
							            <input id="pesEmail" name="pesEmail" type="text" required class="form-control" ng-model="pessoa.email" />
							            <span class="help-block error" ng-show="PessoaForm.pesEmail.$error.required && PessoaForm.pesEmail.$touched">obrigatório</span> 
							        </div>
 								</md-input-container>
 								
 								<md-input-container class="col-md-2">
 									<div ng-class="{'has-error': PessoaForm.pesDatNascimento.$touched && PessoaForm.pesDatNascimento.$invalid}">
		  								<md-datepicker id="pesDatNascimento" name="pesDatNascimento" required ng-model="pessoa.dataNascimento"  md-placeholder="Data de Nascimento"></md-datepicker>	
							            <span class="help-block error" ng-show="PessoaForm.pesDatNascimento.$error.required && PessoaForm.pesDatNascimento.$touched && PessoaForm.pesDatNascimento.$error.dateFormat">Formato de data válida Ex.: 01/12/2017</span>
		  							</div>
 								</md-input-container>
 							</div>
 						</fieldset>
 						
 						<label style="margin-bottom: -2px;font-size: 140%;" for="listaTelefones">Lista de Telefones</label>
 						<fieldset>
  							<div class="row">
	  							<md-input-container class="col-md-1">
	  								<div ng-class="{'has-error': PessoaForm.telDdd.$invalid}">
								        <label for="telDdd" class="control-label">DDD</label>
								        <input id="telDdd" name="telDdd" type="text" class="form-control" ng-model="telefone.ddd" maxlength="3" onkeydown="javascript: fMasc( this, mNum );"/>
								    </div>
	  							</md-input-container>
	  							<md-input-container class="col-md-2">
	  								<div ng-class="{'has-error': PessoaForm.telNumero.$invalid}">
								        <label for="telNumero" class="control-label">Telefone</label>
								        <input id="telNumero" name="telNumero" type="text" class="form-control" ng-model="telefone.numero" maxlength="9" onkeydown="javascript: fMasc( this, mNum );"/>
								    </div>
	  							</md-input-container>
	  							
	  							<md-input-container class="col-md-1">
	  								<button class="btn btn-primary2" type="button" ng-click="addTelefone()">										
										<i class="fa fa-plus"></i>
									</button>
	  							</md-input-container>
  							</div>
  							
  							<div class="row">
  								<table style="width: 40%;" class="table table-responsive table-bordered table-striped clearfix">
  									<thead>
  										<tr class="cor-tabela">
  											<th>DDD</th>
  											<th>Telefone</th>
  											<th style="width: 70px;" class="text-center">Excluir</th>
  										</tr>
  									</thead>
							  		<tbody>
							    		<tr ng-repeat="row in tableTelefone">
							      			<td>{{row.ddd}}</td>
							      			<td>{{row.numero}}</td>
				                    		<td align="center">
								      			<div >
						                    		<button class="btn btn-danger btn-circle btn-xs" type="button" ng-click="removeTelefone(row)"><i class="fa fa-close"></i></button>
					                    		</div>
				                    		</td>
							    		</tr>
							  		</tbody>
								</table>
  							</div>
  						</fieldset>
 					</form>
 				</div>
 				
 				<div class="panel-heading hbuilt text-right">
 					<button id="saveLocal" name="salvarPessoa" class="btn btn-success " type="button" ng-disabled="PessoaForm.$invalid" ng-click="salvar()">
						<i class="fa fa-save"></i>
						<span class="bold">Salvar</span>
					</button>
					
					<button class="btn btn-warning" type="button" ng-click="cancelar()">
						<i class="fa fa-times"></i>
						<span class="bold">Cancelar</span>
					</button>
 				</div>
 			</div>
		</div>
	</div>
</div>