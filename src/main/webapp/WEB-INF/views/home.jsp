<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form class="form">
            <div class="page-header">
                <h1>
                    Registrar Ponto
                </h1>                
            </div>
            ${serverTime}
            <div class="form-inline">
                <label>Hora de Entrada</label>
                <input class="form-control" type="text"/>
                <input class="btn btn-default" type="button" value="Registrar" id="btnHoraEntrada">
  </div>
  <div class="form-inline">
              <label>Hora de Saída</label>
                <input class="form-control" type="text"/>
                <input class="btn btn-default" type="button" value="Registrar" id="btnHoraSaida">
            </div>
        </form>
</body>
</html>
