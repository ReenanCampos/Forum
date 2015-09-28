<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posts</title>
    </head>
    <body>
        <h1> Forum ProgMania - Posts </h1>
        <h3 style="text-align:left"><a href="/Forum/topicos/?idAssunto=${idAssuntoFK}"> [/\] Voltar para os Tópicos</a></h3>
        <hr>
        <br><br>
        <h2>${msg}</h2>
        <div style="border:solid 1px; width: 200px;">
            <a style="text-align:center;" href="/Forum/novoPost/?idTopico=${idTopico}&idAssuntoFK=${idAssuntoFK}">Responder a este tópico</a>
        </div>
        <br><br>
        <div style="text-align: center;"> 
            <c:forEach var="p" items="${posts}" >
                <div class="post">
                    <div class="post cabecalho">
                        <p>Autor: <c:out value="${p.autor}"></c:out> <br>
                        Data: <fmt:formatDate pattern="dd/MM/yyyy" value="${p.dataCriacao}"></fmt:formatDate></p>
                    </div>
                    <p style="text-align: left; padding-left: 3%;"><c:out value="${p.texto}"></c:out></p>
                </div>
                <br><br>
            </c:forEach>
        </div
        
        <br><br><br><br>
        
    </body>
    <style>
            body{
                text-align: center;
            }
            .post{
                width: 700px;
                height: 300px;
                background-color: #DCDCDC;
                border-radius: 10px;
                border: 2px solid;
                text-align: center;
            }
            .post .cabecalho{
                width: 100%;
                height: 20%;
                background-color:#F;
                border: 1px dashed;
                font-color: #808080;
                text-align: left;
            }
            .post .cabecalho p{
                padding-left: 5%;
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
