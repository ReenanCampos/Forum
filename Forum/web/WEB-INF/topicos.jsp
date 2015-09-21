<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topicos</title>
    </head>
    <body>
        <h1>TOPICOS </h1>
        <hr>
        <form style="text-align:center;" action="" method="POST" action="/posts">
            <table style="width:100%; height: 100%;">
                <tr>
                    <th>Topicos</th>
                    <th>Autor</th>
                    <th>Criado em</th>
                </tr>
                
                <c:forEach var="p" items="${topicos}">
                    <input type="hidden" value="${p.idTopico}" name="idTopico">
                    <tr style="float: left">
                        <td><c:out value="${p.nome}"></c:out></td>
                        <td><c:out value="${p.descricao}"></c:out></td>
                        <td><c:out value="${p.dataCriacao}"></c:out></td>
                    </tr>
                    <input type="submit" value="Ver">
                </c:forEach>
                
            </table>
        </form>
    </body>
</html>
