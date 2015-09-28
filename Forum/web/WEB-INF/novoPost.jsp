<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Post</title>
    </head>
    <body>
        <h1> Forum ProgMania - Novo Post </h1>
        <h3 style="text-align:left"><h3 style="text-align:left"><a href="/Forum/posts/?idTopico=${idTopico}&idAssuntoFK=${idAssuntoFK}"> [/\] Voltar para os Posts</a></h3></h3>
        <hr>
        
        <form style="text-align:center;" method="POST" action="/Forum/posts/?idTopico=${idTopico}&idAssuntoFK=${idAssuntoFK}">
            <input type="hidden" name="idTopico" value="${idTopico}">
            <input type="hidden" name="idAssuntoFK" value="${idAssuntoFK}">
            <label for="nome">Nome (ou apelido): </label><br>
            <input type="text" name="autor" id="Nome" />
            <br><br>
            <label for="texto">Texto: </label><br>
            <textarea cols="50" rows="5" name="texto"></textarea>
            <br><br>
            <input type="submit" value="Responder" />
        </form>
    </body>
    
    <style>
        body{
            text-align:center;
        }

        a{
        text-decoration: none;
        }
        a:link{
            text-decoration: none;
            color: #0014EB;
        }
        a:visited{
            color: #0014EB;
        }
        a:hover{
            color: #0014EB;
        }
        a:active{
            color: #0014EB;
        }
    </style>
</html>
