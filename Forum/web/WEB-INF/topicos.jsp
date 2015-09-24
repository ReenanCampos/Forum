<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topicos</title>
    </head>
    <body>
        <h1> Forum Progmania - Tópicos </h1>
        <h3><a href="/Forum/home">Voltar para Assuntos</a></h3>
        <hr>
        <div class="pa">
            <table>
                <tr>
                    <th>Tópico</th>
                    <th>Autor</th>
                    <th>Criado em</th>
                    <th>Ultimo Post</th>
                </tr>
                <c:forEach var="p" items="${topicos}">
                    <tr style="border: solid 1px; text-align:left; font-size:15px">
                        <td style="font-size:15px;"><a href="/Forum/posts/?idTopico=${p.idTopico}&idAssuntoFK=${p.assunto.idAssunto}"><c:out value="${p.nome}"></c:out></a></td>
                        <td style="font-size:15px;"><c:out value="${p.autor}"></c:out></td>
                        <td style="font-size:15px;"><c:out value="${p.dataCriacao}"></c:out></td>
                        <td>ULTIMO POST</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
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
        
        
        
        .pa {
	margin:0px;padding:0px;
	width:100%;
	box-shadow: 10px 10px 5px #888888;
	border:1px solid #000000;
	
	-moz-border-radius-bottomleft:8px;
	-webkit-border-bottom-left-radius:8px;
	border-bottom-left-radius:8px;
	
	-moz-border-radius-bottomright:8px;
	-webkit-border-bottom-right-radius:8px;
	border-bottom-right-radius:8px;
	
	-moz-border-radius-topright:8px;
	-webkit-border-top-right-radius:8px;
	border-top-right-radius:8px;
	
	-moz-border-radius-topleft:8px;
	-webkit-border-top-left-radius:8px;
	border-top-left-radius:8px;
}.pa table{
    border-collapse: collapse;
        border-spacing: 0;
	width:100%;
	height:100%;
	margin:0px;padding:0px;
}.pa tr:last-child td:last-child {
	-moz-border-radius-bottomright:8px;
	-webkit-border-bottom-right-radius:8px;
	border-bottom-right-radius:8px;
}
.pa table tr:first-child td:first-child {
	-moz-border-radius-topleft:8px;
	-webkit-border-top-left-radius:8px;
	border-top-left-radius:8px;
}
.pa table tr:first-child td:last-child {
	-moz-border-radius-topright:8px;
	-webkit-border-top-right-radius:8px;
	border-top-right-radius:8px;
}.pa tr:last-child td:first-child{
	-moz-border-radius-bottomleft:8px;
	-webkit-border-bottom-left-radius:8px;
	border-bottom-left-radius:8px;
}.pa tr:hover td{
	
}
.pa tr:nth-child(odd){ background-color:#d8d8d8; }
.pa tr:nth-child(even)    { background-color:#f2f2f2; }.pa td{
	vertical-align:middle;
	
	
	border:1px solid #000000;
	border-width:0px 1px 1px 0px;
	text-align:left;
	padding:12px;
	font-size:10px;
	font-family:Arial;
	font-weight:normal;
	color:#000000;
}.pa tr:last-child td{
	border-width:0px 1px 0px 0px;
}.pa tr td:last-child{
	border-width:0px 0px 1px 0px;
}.pa tr:last-child td:last-child{
	border-width:0px 0px 0px 0px;
}
.pa tr:first-child td{
		background:-o-linear-gradient(bottom, #7f7f7f 5%, #000000 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #7f7f7f), color-stop(1, #000000) );
	background:-moz-linear-gradient( center top, #7f7f7f 5%, #000000 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#7f7f7f", endColorstr="#000000");	background: -o-linear-gradient(top,#7f7f7f,000000);

	background-color:#7f7f7f;
	border:0px solid #000000;
	text-align:center;
	border-width:0px 0px 1px 1px;
	font-size:14px;
	font-family:Arial;
	font-weight:bold;
	color:#ffffff;
}
.pa tr:first-child:hover td{
	background:-o-linear-gradient(bottom, #7f7f7f 5%, #000000 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #7f7f7f), color-stop(1, #000000) );
	background:-moz-linear-gradient( center top, #7f7f7f 5%, #000000 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#7f7f7f", endColorstr="#000000");	background: -o-linear-gradient(top,#7f7f7f,000000);

	background-color:#7f7f7f;
}
.pa tr:first-child td:first-child{
	border-width:0px 0px 1px 0px;
}
.pa tr:first-child td:last-child{
	border-width:0px 0px 1px 1px;
}
        
    </style>
</html>
