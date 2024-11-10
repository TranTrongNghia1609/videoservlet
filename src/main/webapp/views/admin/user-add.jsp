<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="${pageContext.request.contextPath }/admin/user/insert" method="post" enctype="multipart/form-data">
	<label for="username">UserName:</label><br>
	<input type="text" id="username" name="Username"><br>
	<label for="password">PassWord:</label><br>
	<input type="text" id="password" name="Password"><br>
	<label for="email">Email:</label><br>
	<input type="text" id="email" name="Email"><br>
	<label for="phone">Phone:</label><br>
	<input type="text" id="phone" name="Phone"><br>
	<label for="fullname">FullName:</label><br>
	<input type="text" id="fullname" name="FullName"><br>
	<label for="images">Images: </label><br>
	<div style="width:100px; height:100px">
	<img alt="images" id="imagess" src="" width="150px" height="150px" />
	</div><br>
	Tải ảnh lên:
	<input type="file" onchange="chooseFile(this)" id="images" name="Images"><br>

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
  