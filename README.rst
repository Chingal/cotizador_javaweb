Cotizador de Préstamos en JavaWeb
======================
Cotizador de un prestamo para clientes, donde se ingresar el monto requerido y el sistema
automáticamente calcula la mejor cotización.

Se cuenta con una base de socios quienes son los que aportan el capital para otorgar los préstamos, esta información debe ser almacenada en una base de datos.

Requisitos:
============
* El sistema debe buscar el socio que ofrezca la tasa de interés más baja para el cliente y que cuente con el capital suficiente para realizar el préstamo.
* Los préstamos siempre son otorgados a un plazo fijo de 36 meses.
* Las cuotas mensuales son fijas durante todo el crédito.
* El interés es calculado basado en la fórmula de interés simple
* El sistema hace redondeo con 2 cifras decimales.
* Si el sistema no cuenta con un socio que pueda cubrir la solicitud el sistema debe mostrar un mensaje diciendo “​No hay socio disponible​”.
* La cotización debe estar disponible a través de un servicio web implementado con SOAP o REST, el servicio debe recibir como parámetro el monto del préstamo.

Web Service
========
* **URL**: ``/CotizadorWS/?Tesst``

* **METHOD**: ``GET``

* **Success Response**:
    * **Code**: ``200 OK``
    
* **URL Params**: ``monto``

	.. code-block:: json
    	?monto=4000000

Creditos
-------

``Cotizador Django`` fue creado por Rodrigo Chingal (`@chingal
<https://github.com/chingal>`_)
