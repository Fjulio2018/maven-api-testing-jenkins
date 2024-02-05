   # language: pt


   Funcionalidade:  Busca de cadastros vivos e não vivos

     Esquema do Cenario: Apresenta vivos ou não

       Dado que tenha enviado os requisitos de busca


         | Name   | Status   | Id   |
         | <Name> | <Status> | <Id> |
       Quando Pergormar a busca
       Entao valido o status de retorno
       Entao valido o Schema

       Exemplos: Exeplos de estado do indiviuo

       Quando Pergormar a busca
         | Name | Status | Id |
         | rick | dead   | 10 |
#         | rick | dead   |
