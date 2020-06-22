#Automatiza��o de login no site OLX
Funcionalidade: realizar login no site OLX
Para validar a autentica��o no sistema 
Como usu�rio do sistema
Eu quero logar no site.

Contexto: possibilidade de acessar o sistema
Dado que usu�rio possa acessar a tela de login do sistema

Esquema do Cen�rio: realizar login no sistema com usu�rios v�lidos
Quando informar um <Email> v�lido
E inserir uma <Senha> v�lida
Ent�o o sistema deve permitir a autentica��o do usu�rio


Exemplos:
| Email 			| Senha    | 
| "marco@gmail.com" | "123456" | 


==============================================================================

#desafioTotvs
Script de teste em selenium webdriver para automatizar a realiza��o do login no site OLX.

O teste consiste em Acessar o site da OLX, efetuar login com um usu�rio gen�rico (criado especificamente para este teste), selecionar 
Rio de Janeiro, buscar por um produto qualquer, realizar todos os asserts para valida��o do produto e efetuar logoff. 

Para execu��o do teste:

1 - Fazer download do eclipse - vers�o atual dispon�vel no site https://www.eclipse.org/
2 - Fazer download do chromedriver.
3 - Importar o projeto desafioTotvs.
4 - Alterar o diretorio do chromedriver na linha 38 da classe LoginSite.
5 - Executar a classe LoginSite as JUnit Test.

#API TESTE

Executar a collection API.desafioTotvs.json  via prompt de comando:
1 - Realizar o download 
2 - Instalar o newman:  npm install -g newman
3 - Executar a collection: newman run API.desafioTotvs.json

