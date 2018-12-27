# Teste

##Endpont
- http://localhost:8080/customer

##Para cadatrar os dados fake
- http://localhost:8080/fakedata

#Docker-machine
- Caso você utilize Windows antigo, deve alterar o Ip do banco 
- Utilize o comando docker-machine ip  para saber 
- comando para subir o container
- docker-compose up -d

- caso você já tenha um banco na porte 3306 ele dará conflito



#Para rodar o projeto
Você deve ter  mavem instalado na sua máquina
- spring-boot:run
- a aplicaçao roda na porta 8080, para desativar no linux 
kill $(lsof -t -i:8080)

    


