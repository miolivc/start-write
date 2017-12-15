
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifpb.bdnc.start.write.model.Pagina"%>
<!--
        Author: W3layouts
        Author URL: http://w3layouts.com
        License: Creative Commons Attribution 3.0 Unported
        License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- Head -->
    <head>

        <title>start-write</title>

        <!-- Meta-Tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <!-- //Meta-Tags -->

        <!-- Style -->
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all">

        <!-- Fonts -->
        <link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
        <!-- //Fonts -->

    </head>
    <!-- //Head -->

    <!-- Body -->
    <body>
        <div class="banner">
            <div class="agileinfo-dot">
                <img class="brand" src="images/logomarca.png" alt="Start-Write">

                <div class="w3layoutscontaineragileits">
                    <h2>Bem vindo(a), ${usuario.name}</h2>

                    <h2>Seus Blogs</h2>

                    <c:forEach var="pagina" items="${listaPaginas}"> 
                        <div>
                            <form action="ControlePrincipal" method="post">
                                <p>
                                <h2> ${pagina.nome} </h2>
                                <input type="hidden" value="${pagina.nome}" name="nomePagina">
                                <input type="hidden" value="Redirecionar" name="comando">
                                <input type="submit" value="Visualizar Blog"/>
                                </p>
                            </form>    
                        </c:forEach>

                        <div class="w3footeragile">
                            <p> &copy; 2017 | All Rights Reserved </p>
                        </div>

                    </div>
                </div>
                <script type="text/javascript" src="js/main.js"></script>
        </body>
                <!-- //Body -->
</html>
