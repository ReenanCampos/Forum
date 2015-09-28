<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Tópico</title>
    </head>
    <body>
        <h1> Forum ProgMania - Novo Tópico </h1>
        <h3 style="text-align:left"><a href="/Forum/topicos/?idAssunto=${idAssunto}"> [/\] Voltar para os Tópicos</a></h3>
        <hr>
        
        <form style="text-align:center;" method="POST" action="/Forum/topicos/?idAssunto=${idAssunto}">
            <input type="hidden" name="idAssunto" value="${idAssunto}">
            <br><br>
            <label for="autor">Nome (ou apelido): </label><br>
            <input type="text" name="autor" id="autor" />
            <br><br>
            <label for="nome">Titulo: </label><br>
            <input type="text" name="nome" id="nome" />
            <br><br>
            
            <label for="texto">Texto: </label><br>
            <textarea cols="50" rows="5" name="texto"></textarea>
            <br><br>
            <input type="submit" value="Criar novo tópico" />
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
