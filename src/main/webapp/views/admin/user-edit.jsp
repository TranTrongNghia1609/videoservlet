<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<form action="${pageContext.request.contextPath }/admin/user/update" method="post" enctype="multipart/form-data">

	<label for="Username">Username:</label><br>
	<input type="text" id="Username" name="Username" value="${usr.Username}"><br>
	<label for="password">PassWord:</label><br>
	<input type="text" id="Password" name="Password" value="${user.Password}"><br>
	<label for="email">Email:</label><br>
	<input type="text" id="Email" name="Email" value="${user.Email}"><br>
	<label for="phone">Phone:</label><br>
	<input type="text" id="phone" name="Phone" value="${user.Phone}"><br>
	<label for="fullname">FullName:</label><br>
	<input type="text" id="fullname" name="FullName" value="${user.FullName}"><br>
	<label for="images">Images: </label><br>
	<c:if test="${user.Images.substring(0,5) != 'https'}">
		<c:url value="/image?fname=${user.images }" var="imgUrl"></c:url>
	</c:if>
	<c:if test="${user.Images.substring(0,5) == 'https'}">
		<c:url value="${user.Images }" var="imgUrl"></c:url>
	</c:if>
	<img id="images" height="150" width="200" src="${imgUrl}" />
	Tải ảnh lên:
	<input type="file" onchange="chooseFile(this)" id="images" name="Images" value="${user.Images}"><br>

	<label for="active">Active: </label>
	<input id="activeon" type="radio" name="Active" value="true" ${user.active ? 'checked' : ''}>
	<label for="activeon">Hoạt động</label>
	<input id="activeoff" type="radio" name="Active" value="false" ${!user.active ? 'checked' : ''}>
	<label for="activeoff">Khóa</label>
	<br>

	<label for="admin">Admin: </label>
	<input id="adminon" type="radio" name="Admin" value="true" ${user.admin ? 'checked' : ''}>
	<label for="adminon">Là Admin</label>
	<input id="adminoff" type="radio" name="Admin" value="false" ${!user.admin ? 'checked' : ''}>
	<label for="adminoff">Không phải admin</label>
	<br> <input type="submit" value="Submit">
</form>
