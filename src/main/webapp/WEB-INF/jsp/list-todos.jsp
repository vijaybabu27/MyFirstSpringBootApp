<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
		<div class="container">
			<table class="table table-striped">
				<caption>Your Todos are</caption>
				<thead>
					<tr>
						<th>Description</th>
						<th>Target Date</th>
						<th>is it Done?</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos }" var="item">
						<tr>
							<td>${item.desc}</td>
							<td><fmt:formatDate value="${item.targetDate }" pattern="MM/dd/yyyy"/> </td>
							<td>${item.status }</td>
							<td> <a type="button" class="btn btn-success" href="/update-todo?id=${item.id }" >Update</a> </td>
							<td> <a type="button" class="btn btn-warning" href="/delete-todo?id=${item.id }" >Delete</a> </td>
						</tr>
					</c:forEach>
					<tr>
						
					</tr>
				</tbody>
			</table>
			<div>
			
			<a class="btn btn-primary" href="/add-todo">Add a ToDo</a>
			
			</div>
		</div>
		
<%@ include file="common/footer.jspf" %>