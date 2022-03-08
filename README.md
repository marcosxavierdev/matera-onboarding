# MATERA ONBOARDING
## Sobre
Matera Onboarding � um projeto composto por APIs REST, `Client`, `Address`, `IdentityDocument` e `Telephone`. S�o organizados como mostra na imagem abaixo:

![alt text](others/imgs/Matera-Onboarding-UML.jpg)

## Roadmap 

- Semana 1 - Montagem de ambiente e Codifica��o;
- Semana 2 - Revis�o de C�digo e Corre��es;
- Semana 3 - Implementa��o de Testes Unit�rios e Revis�o dos testes unit�rios;
- Semana 4 - Merges, Resolu��o de Conflitos e Fechamento de Vers�o

## Pr� Requisitos

Para esse projeto, ser� necess�rio a instala��o e configura��o das sequintes ferramentas:
- Maven
- Git
- IDE (Eclipse de prefer�ncia por conta do suporte GSX / Intellij)



## Primeiros passos

1.Clonar o reposit�rio para o ambiente local.

        git clone https://stash.matera.com/scm/mat/matera-onboarding.git


2.Dentro do diret�rio do projeto, realizar um build do projeto utilizando o Maven.

        mvn clean install

3.Importar o projeto para IDE (Eclipse / Intellij) 


4.Rodar a aplica��o Springboot:

    Intellij:
   
        Rodar a classe matera-onboarding/rest-application/src/main/java/com/matera/onboarding/materaonboarding/MateraOnboardingApplication.java

    Eclipse:
   
        Rodar a classe matera-onboarding/rest-application/src/main/java/com/matera/onboarding/materaonboarding/MateraOnboardingApplication.java
        ou
        Installar o plugin Spring Tools e rodar com esse plugin

5.N�s usamos a [biblioteca Lombok](https://projectlombok.org/) neste projeto, ent�o caso for abri-lo em uma IDE, como IntelliJ ou Eclipse, voc� deve instalar um plugin para conseguir rodar a aplica��o sem erros.

6.Para validar o ambiente local, abra um navegador e fa�a a seguinte requisi��o:

        http://localhost:8080/api/v1/example/hello


### Banco da dados
Inicialmente o projeto ser� desenvolvido utilizando o H2 Database.



## Documenta��o
Voc� pode acessar a documenta��o do projeto em others/docs/DV_MateraOnboarding.odt