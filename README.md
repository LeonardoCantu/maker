### Exercício 1

<b>Baseado no estudo de caso proposto, construa a estrutura de classes, sugerindo atributos
para cada uma delas, seus construtores e encapsulamentos;</b>

Responsta: Realizada a cosntrução da estrutura de classes.

### Exercício 2

<b>Qual o objetivo da utilização de uma biblioteca como o Lombok durante o desenvolvimento
Java?</b>

Resposta: No caso do lombok ele permite realizar uma redução no códigos escritos em seu projeto, pois, com a utilização de suas anotações é criado
os métodos setter, getter, construtores, entre outros em tempo de execução, sem a necessidade de realizar sua implantação em todas as classes.
Contudo, de modo geral a utilização de bibliotecas de terceiros permite uma maior agilidade e eficiência no desenvolvimento, pois, em muitos
casos essas bibliotecas são desenvolvidas com o intuito de facilitar ou agilizar alguma tarefa/procedimento.

### Exercício 3

<b>A partir da implementação e definição de classes realizada no Exercício 1, quais os próximos
passos torná-las gerenciadas em um banco de dados relacional com o apoio de um framework
de persistência?</b>

Resposta: A partir da implementação e definição de classes realizada no Exercício 1, quais os próximos
passos torná-las gerenciadas em um banco de dados relacional com o apoio de um framework
de persistência?

* 1º Devemos definir a conexão com a base de dados em questão e sua configuração para permitirmos que nosso sistema se conecte a base de dados. Para isso,
quando utilizado spring, a duas formas simples de realizar essa configuração, a primeira consiste em adicionar as configurações no arquivo "aplication.proprerties",
já a segunda consiste em criarmos uma classe de configuração.

* 2º Após configurar a conexão devemos criar nossos repositórios. Com spring, podemos criar uma interface anotada com @Repository que se estende a interface
JpaRepository do spring data.

<b>Exemplo:</b>
@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Integer>{}

Desta forma o spring nos permite realizar a persistência e listagem dos dados de forma simples.

* 3º Com os passo acima ja podemos realizar a persistência e listagem de dados, contudo, é ideal que a chamada para esses métodos ocorram nas classes de serviço.


### Exercício 4

<b>Com o apoio do Spring MVC, realize uma implementação para realizar a persistência de um
"produto". Obs.: Não há necessidade de realizar a persistência dos seus objetos relacionados,
neste momento o objetivo será apenas compreender sua habilidade em realizar o setup do
projeto e implementação das classes e interfaces mínimas para tal operação.</b>

Resposta: Realizada a criação de end point para inclusão de produtos(/product), contudo para incluir um produto e necessário ter
uma marca cadastrada(/brand), para isso disponibilizei uma collection com ambos os end points, uma para cadastro da marca e outro para 
cadastro do produto.

[Collection do postman com os end points](https://www.getpostman.com/collections/cd141e5dc4cb148e5d65)


### Exercício 5

<b>Um dos principais pilares e funcionalidades da nossa aplicação envolve o consumo de dados
através de APIs RESTful e realização de persistência em nossas entidades, utilizando para isso,
conceitos de transformação e reflexão,
* A. Implemente uma classe para realizar uma requisição na URL a seguir e obtenha o seu
resultado. http://mockbin.org/bin/fd9103a1-81dc-4a5d-88c3-dd9f8eaf2661
* B. A partir da String obtida do Response Body acima, atribua o conteúdo da chave
"descricao" ao objeto "produto", em seu atributo que represente sua descrição,
definido no Exercício 1. Obs.: utilize para isso a estratégia de reflexão.
https://www.oracle.com/technical-resources/articles/java/javareflection.html
</b>

Resposta: Para ambos os exercício realizei a criação de um end point onde, ao executá-lo é realizado o que
foi proposto, exibindo o resultado do <b>Exercício A</b> no console e o resultado do <b>Exercício B</b> é
enviado como resposta da requisição.

[Collection do postman com o end point](https://www.getpostman.com/collections/cd141e5dc4cb148e5d65)

### Exercício 6

<b>Construa uma classe Java com um método "main" para realizar a leitura de uma String
contendo um pequeno texto "XML" e realize a conversão do mesmo para "JSON".</b>

Resposta: Criei um [repositório](https://github.com/LeonardoCantu/maker2) com a resolução do exercício 6 
