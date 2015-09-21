<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>[HOME] / Assuntos</title>
    </head>
    <body>
        <h1>Home FORUM - Assuntos</h1>
        <hr>
            <form method="POST" action="/Forum/topicos">
                <table style="border: solid 1px; width: 100%;">
                    <tr>
                        <th>Assunto</th>
                        <th>Descrição</th>
                    </tr>
                    <c:forEach var="p" items="${assuntos}">
                        <tr style="border: solid 1px; text-align:center">
                            <input type="hidden" value="${p.idAssunto}" name="idAssunto">
                            <td><c:out value="${p.nome}"></c:out></td>
                            <td><c:out value="${p.descricao}"></c:out></td>
                            <td><input type="submit" value="Entrar">
                        </tr>
                    </c:forEach>
                </table>
            </form>
    </body>
</html>
