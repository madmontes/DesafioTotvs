#Automatização de login no site OLX
Funcionalidade: realizar login no site OLX
Para validar a autenticação no sistema 
Como usuário do sistema
Eu quero logar no site.

Contexto: possibilidade de acessar o sistema
Dado que usuário possa acessar a tela de login do sistema

Esquema do Cenário: realizar login no sistema com usuários válidos
Quando informar um <Email> válido
E inserir uma <Senha> válida
Então o sistema deve permitir a autenticação do usuário


Exemplos:
| Email 			| Senha    | 
| "marco@gmail.com" | "123456" | 


==============================================================================

#desafioTotvs
Script de teste em selenium webdriver para automatizar a realização do login no site OLX.

O teste consiste em Acessar o site da OLX, efetuar login com um usuário genérico (criado especificamente para este teste), selecionar 
Rio de Janeiro, buscar por um produto qualquer, realizar todos os asserts para validação do produto e efetuar logoff. 

Para execução do teste:

1 - Fazer download do eclipse - versão atual disponível no site https://www.eclipse.org/
2 - Fazer download do chromedriver.
3 - Importar o projeto desafioTotvs.
4 - Alterar o diretorio do chromedriver na linha 38 da classe LoginSite.
5 - Executar a classe LoginSite as JUnit Test.

#API TESTE

Executar a collection API.desafioTotvs.json  via prompt de comando:
1 - Realizar o download 
2 - Instalar o newman:  npm install -g newman
3 - Executar a collection: newman run API.desafioTotvs.json

