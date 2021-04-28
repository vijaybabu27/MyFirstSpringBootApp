<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
		<div class="container">
		<form method="post" action="/login">
			Name : <input type="text" name="name"/>
			Password : <input type="password" name="password"/>
			<input type="submit" />
			<font color="red">${errorMsg }</font>
		</form>
		</div>
<%@ include file="common/footer.jspf" %>