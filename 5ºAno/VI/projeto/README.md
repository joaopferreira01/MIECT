# Visualização de Informação 
## assignment 1

## João Morcão 103625
## Rui Campos 103709

### How to run

1. 
```bash
python3 -m http.server 8000
```
2. 
```bash
http://localhost:8000/
```


Ideias para o projeto
Este projeto tem como objetivo explorar a visualização de dados sobre obesidade e a participação em esportes, usando um mapa interativo do mundo. Com base nos dados fornecidos, o projeto visa criar uma ferramenta interativa para explorar as taxas de obesidade e participação em esportes (futebol, basquet e corrida) em diferentes grupos etários e gêneros. 
Utilizadores-alvo
Os utilizadores-alvo podem incluir:

Profissionais de saúde: que desejam estudar correlações entre esportes e obesidade por país.
Pesquisadores em saúde pública: que procuram entender tendências globais de saúde.
Políticos e legisladores: interessados em políticas de combate à obesidade.
Treinadores desportivos: que querem monitorar a adesão aos esportes por faixa etária e gênero.
Público em geral: que deseja conhecer mais sobre a saúde e a participação em esportes de diferentes países.
Dados
Os dados consistem em informações sobre a taxa de obesidade e a participação em desportos(futebol, basquet e corrida) em quatro grupos:

Children - Male
Children - Female
Adult - Male
Adult - Female
Para cada um desses grupos, os dados incluem percentuais de obesidade, além das taxas de participação nos desportos. Esses dados serão cruzados com os códigos ISO dos países, possibilitando uma análise interativa no mapa.
Objetivos do projeto
Exibir as taxas de obesidade e participação em desportos por país: Permitir que o utilizador selecione diferentes países para visualizar essas informações.
Filtrar por grupo etário e gênero: Dar a opção de visualizar as informações separadamente para "Children" (crianças) e "Adult" (adultos), assim como por "Male" (masculino) e "Female" (feminino).
Explorar interativamente os dados: Permitir zoom, panning e exibição de pop-ups ao clicar nos países para exibir os detalhes.
Comparar dados entre países: Permitir a comparação visual das taxas de obesidade e participação em desportos.
Propósito de cada gráfico
O gráfico principal é o mapa interativo, que apresenta os dados de obesidade e desportos  num contexto global. A visualização interativa ajuda os utilizadores a entender a relação entre obesidade e desportos, permitindo que eles explorem esses fatores por país, faixa etária e gênero.

Para cada gráfico, perguntas a serem respondidas:
Qual é a relação entre a obesidade e a participação em esportes em um determinado país para determinado género e idade?

Exemplo: No Reino Unido, como a participação no futebol (por género) afeta a obesidade entre crianças e adultos?
Como o padrão de participação em desportos difere entre países e faixas etárias?

Exemplo: A Alemanha tem maior participação em corrida entre adultos em comparação com o Brasil?
Há uma correlação entre a taxa de obesidade e a taxa de participação em desportos?

Exemplo: Nos Estados Unidos, as crianças com maior taxa de obesidade também têm baixa participação em desportos?
