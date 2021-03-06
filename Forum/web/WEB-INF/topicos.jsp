<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topicos</title>
    </head>
    <body>
        <h1> Forum ProgMania - T�picos </h1>
        <h3 style="text-align:left"><a href="/Forum/home"> [/\] Voltar para os Assuntos</a></h3>
        <hr>
        
        <br><br>
        <h2>${msg2}</h2>
        <div style="border:solid 1px; width: 200px;">
            <a style="text-align:center;" href="/Forum/novoTopico/?idAssunto=${idAssunto}">Novo T�pico</a>
        </div>
        <br><br>
        
        <div class="datagrid">
            <table>
                <thead>
                    <tr>
                        <th>T�pico</th>
                        <th>Visitas</th>
                        <th>Respostas</th>
                        <th>Autor</th>
                        <th>Criado em</th>
                        <th>Ultimo Post</th>
                    </tr>
                </thead>
                    <tr style="text-align:center;"><td><p>${msg}</p></td></tr>
                <c:forEach var="p" items="${topicos}">
                    <tr class="${p.idTopico % 2 == 0 ? 'classetdpar' : 'classetdimpar'}" style="border: solid 1px; text-align:left; font-size:15px">
                        <td style="font-size:15px;"><a href="/Forum/posts/?idTopico=${p.idTopico}&idAssuntoFK=${p.assunto.idAssunto}"><c:out value="${p.nome}"></c:out></a></td>
                        <td><c:out value="${p.visitas}"></c:out></td>
                        <td><c:out value="${p.numPost}"></c:out></td>
                        <td style="font-size:15px;"><c:out value="${p.autor}"></c:out></td>
                        <td style="font-size:15px;"><fmt:formatDate pattern="dd/MM/yyyy" value="${p.dataCriacao}"></fmt:formatDate></td>
                        <td><c:out value="${p.ultimoPost.autor}"></c:out> <br> <fmt:formatDate pattern="dd/MM/yyyy" value="${p.ultimoPost.dataCriacao}"></fmt:formatDate></td>
                    </tr>
                    <c:set value="${idAssunto}" var="idAssunto"></c:set>
                </c:forEach>
                <tfoot><tr><td colspan="6"><div id="paging"><ul><li><br><span>ProgMania &reg;2015 <br></span><br></li></ul></div></td></tr></tfoot>
            
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
        
        
        .classetdpar { color: #7D7D7D; border-left: 1px solid #DBDBDB;font-size: 14px;font-weight: normal; }

        .classetdimpar { background: #EBEBEB; color: #7D7D7D; }


        .datagrid table { border-collapse: collapse; text-align: left; width: 100%; } .datagrid {font: normal 12px/150% Verdana, Arial, Helvetica, sans-serif; background: #fff; overflow: hidden; border: 1px solid #8C8C8C; -webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; }.datagrid table td, .datagrid table th { padding: 10px 20px; }.datagrid table thead th {background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #8C8C8C), color-stop(1, #7D7D7D) );background:-moz-linear-gradient( center top, #8C8C8C 5%, #7D7D7D 100% );filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#8C8C8C', endColorstr='#7D7D7D');background-color:#8C8C8C; color:#FFFFFF; font-size: 13px; font-weight: bold; } .datagrid table thead th:first-child { border: none; }.datagrid table tbody * td { color: #7D7D7D; border-left: 1px solid #DBDBDB;font-size: 14px;font-weight: normal; }.datagrid table tbody .alt td { background: #EBEBEB; color: #7D7D7D; }.datagrid table * td:first-child { border-left: none; }.datagrid table tbody  tr:last-child td { border-bottom: none; }.datagrid table tfoot td div { border-top: 1px solid #8C8C8C;background: #EBEBEB;} .datagrid table tfoot td { padding: 0; font-size: 11px } .datagrid table tfoot td div{ padding: 0px; }.datagrid table tfoot td ul { margin: 0; padding:0; list-style: none; text-align: center; }.datagrid table tfoot  li { display: inline; }.datagrid table tfoot li a { text-decoration: none; display: inline-block;  padding: 2px 8px; margin: 1px;color: #F5F5F5;border: 4px solid #8C8C8C;-webkit-border-radius: 20px; -moz-border-radius: 20px; border-radius: 20px; background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #8C8C8C), color-stop(1, #7D7D7D) );background:-moz-linear-gradient( center top, #8C8C8C 5%, #7D7D7D 100% );filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#8C8C8C', endColorstr='#7D7D7D');background-color:#8C8C8C; }.datagrid table tfoot ul.active, .datagrid table tfoot ul a:hover { text-decoration: none;border-color: #7D7D7D; color: #F5F5F5; background: none; background-color:#8C8C8C;}div.dhtmlx_window_active, div.dhx_modal_cover_dv { position: fixed !important; }
    
    </style>
</html>
