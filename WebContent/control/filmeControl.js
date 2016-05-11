var app = angular.module('filmeModule',[]);

app.controller('filmeControl',function($scope,$http){
	
	var url = 'http://localhost:8080/SantuFlix/rs/filme';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (filmesRetorno) {
			$scope.filmes = filmesRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.filme = {};
	}

    $scope.salvar = function() {
		if ($scope.filme.codigo == '') {
			$http.post(url,$scope.filme).success(function(filme) {
				$scope.filmes.push($scope.filme);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.filme).success(function(filme) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.filme.codigo == '') {
			alert('Selecione um filme');
		} else {
			urlExcluir = url+'/'+$scope.filme.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(filmeTabela) {
		$scope.filme = filmeTabela;
	}
});