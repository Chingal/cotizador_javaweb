<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Cotización de Prestamo</title>
        <!-- Favicons-->
        <link rel="icon" href="assets/images/favicon/favicon-32x32.png" sizes="32x32">
        <!-- Favicons-->
        <link rel="apple-touch-icon-precomposed" href="assets/images/favicon/apple-touch-icon-152x152.png">
        <!-- For iPhone -->
        <meta name="msapplication-TileColor" content="#00bcd4">
        <meta name="msapplication-TileImage" content="assets/images/favicon/mstile-144x144.png">        
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="assets/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <link href="assets/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>        
    </head>
    <body>
        <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper container">            
                <a href="/" class="brand-logo" id="logo-container">
                    <img src="assets/images/favicon/favicon-32x32.png" alt="materialize logo">
                    <span class="logo-text hide-on-med-and-down">Cotizador</span>
                </a>
            </div>
        </nav>

        <div class="section no-pad-bot" id="index-banner">
            <h1 class="header center orange-text">Préstamos</h1>                    
        </div>

        <div class="container">
            <div class="section">
                <div class="row">
                    <div class="col s12 m6">
                        <div class="card-panel z-depth-4">
                            <div class="row">
                                <div class="icon-block">
                                    <h2 class="center light-blue-text"><i class="material-icons">credit_card</i></h2>
                                    <h5 class="header center">Términos del Crédito</h5>
                                    
                                    <form class="col s12" action="cotizacion" method="POST" id="datos-form">
                                        <div class="row">
                                            <br>
                                            <div class="input-field col s12">
                                                <c:set var="monto" value="${monto}"></c:set>
                                                <input id="monto" name="monto" type="text" class="validate" placeholder="$" value="${monto}">
                                                <label for="monto">Monto del Préstamo</label>
                                            </div>                            
                                        </div>
                                        <div class="row">
                                            <div class="input-field col s12">
                                                <input disabled value="36 Meses" id="plazo" type="text" class="validate">
                                                <label for="disabled">Plazo</label>
                                            </div>
                                            </div>
                                            <div class="input-field col s12 center">
                                                <button class="btn waves-effect waves-light blue-grey" type="submit" name="action">Calcular
                                                    <i class="material-icons right">monetization_on</i>
                                                </button>
                                            </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col s12 m6">
                        <div class="card-panel z-depth-4">
                            <div class="icon-block">
                                <h2 class="center light-blue-text"><i class="material-icons">monetization_on</i></h2>
                            <c:choose>                                
                                <c:when test="${capital!=null}">
                                <h5 class="center">Resultado de la Cotización</h5>
                                <br>
                                <table class="centered striped">
                                    <tbody>
                                        <tr>
                                            <td><i class="material-icons center">person</i>Socio</td>
                                            <td>${capital.socio.nombre} ${capital.socio.apellido}</td>
                                        </tr>
                                        <tr>
                                            <td>Tasa de Interés Efectiva Anual </td>
                                            <td>${tasaEfectivaAnual}%</td>
                                        </tr>
                                        <tr>
                                            <td>Tasa de Interés Efectiva Mensual </td>
                                            <td>${capital.tasa}%</td>
                                        </tr>                          
                                        <tr>
                                            <td>Cuota Mensual</td>
                                            <td><span class="badge blue white-text">${cuotaMensual}%</span></td>                                            
                                        </tr>
                                        <tr>
                                            <td>Pago Total del Crédito</td>
                                            <td><span class="badge green white-text">${valorCredito}%</span></td>
                                        </tr>
                                        <tr>
                                            <td>Plazo del Credito</td>
                                            <td>36 Meses</td>
                                        </tr>
                                    </tbody>
                                  </table>
                                </c:when>
                                <c:when test="${capital == null and monto > 0}">
                                <h6 class="center red-text">No hay socio disponible</h6>
                                </c:when>                                
                                <c:otherwise>
                                <h5 class="center">Cotización</h5>
                                <p class="light">Le damos la bienvenida al <strong>cotizador de préstamos</strong>. En este sitio encontraras toda la información necesaria para calcular en detalle la financiación y las cuotas mensuales de tú crédito indicando los datos necesarios.</p>                
                                </c:otherwise>
                            </c:choose>
                            </div>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer class="page-footer orange">
            <div class="container">
                <div class="footer-copyright">
                    <div class="container">
                        Desarrollado por <a class="orange-text text-lighten-3" href="http://github.com/chingal">Rodrigo Chingal</a>
                    </div>
                </div>
            </div>
        </footer>
        
    </body>
    
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="assets/js/materialize.js"></script>
    <script src="assets/js/init.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#datos-form").validate({
                rules: {
                    monto: {
                        required: true,
                        number: true,
                        min: 1
                    }
                },
                messages: {
                    monto: {
                        required: 'Este campo es requerido.',
                        number: 'Por favor ingrese un número valido.',
                        min: 'Por favor ingrese un valor mayor a 0.',
                    }
                },
                errorElement: 'div',
                errorPlacement: function (error, element) {
                    var placement = $(element).data('error');
                    if (placement) {
                        $(placement).append(error);
                    } else {
                        error.insertAfter(element);
                    }
                }
            });
        });
    </script>
</html>
