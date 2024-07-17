# Desafío: Conversor de Monedas

##Descripción
Este proyecto es parte del desafío propuesto por el programa Oracle Next Education y Alura Latam. El objetivo principal es desarrollar un conversor de monedas utilizando Java 17. El conversor obtiene las tasas de cambio actuales desde una API y permite convertir cantidades entre diferentes monedas.

El conversor de monedas ofrece un menú interactivo que permite al usuario seleccionar opciones para convertir entre diversas monedas. Las tasas de cambio se obtienen en tiempo real a través de una solicitud HTTP a la API de ExchangeRate. El programa facilita la conversión entre las siguientes monedas:

Dólar estadounidense (USD) a Peso argentino (ARS)
Peso argentino (ARS) a Dólar estadounidense (USD)
Dólar estadounidense (USD) a Real brasileño (BRL)
Real brasileño (BRL) a Dólar estadounidense (USD)
Dólar estadounidense (USD) a Peso colombiano (COP)
Peso colombiano (COP) a Dólar estadounidense (USD)
Estructura del Proyecto
El proyecto se compone de tres clases principales:

## ConexionApi: 

Esta clase se encarga de realizar la solicitud HTTP a la API de ExchangeRate y obtener las tasas de cambio.
CurrencyConverterApp: Esta clase contiene el menú interactivo y la lógica principal del programa.
CurrencyUtil: Esta clase almacena los datos de las tasas de cambio obtenidos de la API.

## Recursos Utilizados
Java 17
IntelliJ IDEA: IDE utilizado para el desarrollo.
ExchangeRate: API para obtener las tasas de cambio.
Gson Library: Biblioteca para el manejo de JSON.

## Autor
Julián Villamizar




