<%--

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<a href="${pageContext.request.contextPath }/admin/user/add">Add User</a>


<table border="1" width="100%">
	<tr>
		<th>STT</th>
		<th>Images</th>
		<th>Username</th>
		<th>Password</th>
		<th>Phone</th>
		<th>Email</th>
		<th>FullName</th>
		<th>Active</th>
		<th>Admin</th>
		<th>Action</th>
	</tr>

	<c:forEach items="${listuser}" var="user" varStatus="STT">
		<tr>
			<td>${STT.index+1}</td>

			<td><c:if test="${user.images.substring(0,5) != 'https'}">
					<c:url value="/image?fname=${user.images}" var="imgUrl"></c:url>
				</c:if>
					<c:if test="${user.images.substring(0,5) == 'https'}">
					<c:url value="${user.images}" var="imgUrl"></c:url>
				</c:if>
				 <img height="150" width="200" src="${imgUrl}" /></td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.phone}</td>
			<td>${user.email}</td>
			<td>${user.fullname}</td>
			<td>
			<c:if test="${user!=null && user.active}">
			<span>Hoạt động</span>
			</c:if>
			<c:if test="${user != null && !user.active}">
			<span>Khóa</span>
			</c:if>
			</td>
			<td>
				<c:if test="${user!=null && user.admin}">
					<span>YES</span>
				</c:if>
				<c:if test="${user != null && !user.admin}">
					<span>NO</span>
				</c:if>
			</td>

			<td><a href="<c:url value='/admin/user/edit?id=${user.username }'/>">Sửa</a>
				| <a href="<c:url value='/admin/user/delete?id=${user.username }'/>">Xóa</a>

			</td>
		</tr>
	</c:forEach>

</table>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<a href="${pageContext.request.contextPath }/admin/user/add">Add User</a>

<table border="1" width="100%">
	<tr>
		<th>STT</th>
		<th>Images</th>
		<th>Username</th>
		<th>Password</th>
		<th>Phone</th>
		<th>Email</th>
		<th>FullName</th>
		<th>Active</th>
		<th>Admin</th>
		<th>Action</th>
	</tr>

	<c:forEach items="${listuser}" var="user" varStatus="STT">
		<tr>
			<td>${STT.index+1}</td>
			<td>
				<c:choose>
					<c:when test="${user.images.substring(0,5) != 'https'}">
						<c:url value="/image?fname=${user.images}" var="imgUrl" />
					</c:when>
					<c:otherwise>
						<c:url value="${user.images}" var="imgUrl" />
					</c:otherwise>
				</c:choose>
				<img height="150" width="200" src="${imgUrl}" />
			</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.phone}</td>
			<td>${user.email}</td>
			<td>${user.fullname}</td>
			<td>
				<c:if test="${user.active}">
					<span>Hoạt động</span>
				</c:if>
				<c:if test="${!user.active}">
					<span>Khóa</span>
				</c:if>
			</td>
			<td>
				<c:if test="${user.admin}">
					<span>YES</span>
				</c:if>
				<c:if test="${!user.admin}">
					<span>NO</span>
				</c:if>
			</td>
			<td>
				<a href="<c:url value='/admin/user/edit?id=${user.username}'/>">Sửa</a> |
				<a href="<c:url value='/admin/user/delete?id=${user.username}'/>">Xóa</a>
			</td>
		</tr>
	</c:forEach>
</table>

<!-- Phần phân trang -->
<nav aria-label="Page navigation">
	<ul class="pagination">
		<c:if test="${totalPages > 1}">
			<c:forEach var="pageNumber" begin="1" end="${totalPages}">
				<li class="page-item ${currentPage == pageNumber ? 'active' : ''}">
					<a class="page-link"
					   href="<c:url value='/admin/user/list?page=${pageNumber}&size=${pageSize}' />">
							${pageNumber}
					</a>
				</li>
			</c:forEach>
		</c:if>
	</ul>
</nav>
