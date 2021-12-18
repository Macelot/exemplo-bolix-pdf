# exemplo-bolix-pdf
geração de bolit com a API PIX Java Gerencianet

Este projeto é umaa continuação do projeto do repositório: https://github.com/Macelot/exemplo-bolix

Este projeto gera um Bolix com dois itens, um de 6 reais outro de 10 reais. 
Vamos definir um desconto de 5 reais. Caso o pagaddor efetuar o pagamento dentro de 6 dias será concedido um desconto de 0,55.
Caso pagar depois do vencimento haverá um juros e uma multa.
Ao receber o Bolix da Gerencianet, vamos ler a resposta, pela key "data", "pdf" e "charge" para obter a url do Bolix em PDF.
No final o Bolix é salvo no computador.
