
<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->



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

                    <input type="button" onclick="criarBlog()" value="Criar um novo Blog"/>
                    <button type="submit" onclick="listarBlogs()" value="Ver Blogs existentes"/>

                </div>

                <div class="w3footeragile">
                    <p> &copy; 2017 | All Rights Reserved </p>
                </div>

            </div>
        </div>
        <script type="text/javascript" src="js/main.js"></script>
    </body>
    <!-- //Body -->
</html>
