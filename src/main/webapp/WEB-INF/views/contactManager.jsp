<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mantenedor de Contactos</title>
<script type="text/javascript">
	var idSelect = 0;
	function submitFormAction(action, method) {
		document.getElementById("frmAcciones").action = action;
		document.getElementById("frmAcciones").method = method;
		document.getElementById("frmAcciones").submit();
	}
	function setIdSelect(id) {
		idSelect = id;
	}
	function deleteRow() {
		window.location.href = "/contactManager/deleteContact/?id=" + idSelect;
	}
</script>
</head>
<body>

	<form:form id="frmAcciones" modelAttribute="contacto">
		<div>
			<fieldset>
				<legend>Mantenedor de Contactos</legend>
				<table border="1">
					<tr>
						<td>Nombre:</td>
						<td><input type="text" id="nombre" name="nombre" /></td>
						<td>Apellido Paterno:</td>
						<td><input type="text" id="apellidoPaterno"
							name="apellidoPaterno" /></td>
						<td>Apellido Materno:</td>
						<td><input type="text" id="apellidoMaterno"
							name="apellidoMaterno" /></td>
					</tr>
					<tr>
						<td>Dirección:</td>
						<td colspan="3"><input type="text" id="direccion" name="direccion" /></td>
						<td>Teléfono:</td>
						<td><input type="text" id="telefono" name="telefono" /></td>
					</tr>
					<tr>
						<td colspan="4"><input type="button" value="Agregar"
							onclick="submitFormAction('/contactManager/addContact', 'post')" />
							<input type="button" value="Eliminar" onclick="deleteRow()"/></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</form:form>

	<div>
		<fieldset>
			<legend>Lista de Contactos</legend>
			<div align="center">
				<table border="1">
					<thead>
						<tr>
							<th></th>
							<th>Id</th>
							<th>Nombre</th>
							<th>Apellido Paterno</th>
							<th>Apellido Materno</th>
							<th>Dirección</th>
							<th>Teléfono</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaContacto}" var="contacto">
							<tr>
								<td><input type="radio" id="optSelectRow${contacto.idContacto}" name="optSelectRow" onclick="setIdSelect(${contacto.idContacto})"/></td>
								<td><c:out value="${contacto.idContacto}" /></td>
								<td><c:out value="${contacto.nombre}" /></td>
								<td><c:out value="${contacto.apellidoPaterno}" /></td>
								<td><c:out value="${contacto.apellidoMaterno}" /></td>
								<td><c:out value="${contacto.direccion}" /></td>
								<td><c:out value="${contacto.telefono}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</fieldset>
	</div>


</body>
</html>