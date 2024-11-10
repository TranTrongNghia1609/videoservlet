<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%--<form action="${pageContext.request.contextPath }/admin/user/update" method="post" enctype="multipart/form-data">--%>

<%--    <label for="Username">Username:</label><br>--%>
<%--    &lt;%&ndash;    <input type="text" id="Username" name="Username" value="${user.Username}"><br>&ndash;%&gt;--%>
<%--    <label for="password">PassWord:</label><br>--%>
<%--    <input type="text" id="Password" name="Password" value="${User.Password}"><br>--%>
<%--    <label for="email">Email:</label><br>--%>
<%--    <input type="text" id="Email" name="Email" value="${User.Email}"><br>--%>
<%--    <label for="phone">Phone:</label><br>--%>
<%--    <input type="text" id="phone" name="Phone" value="${User.Phone}"><br>--%>
<%--    <label for="fullname">FullName:</label><br>--%>
<%--    <input type="text" id="fullname" name="FullName" value="${User.FullName}"><br>--%>
<%--    <label for="images">Images: </label><br>--%>
<%--    <c:if test="${User.Images.substring(0,5) != 'https'}">--%>
<%--        <c:url value="/image?fname=${User.images }" var="imgUrl"></c:url>--%>
<%--    </c:if>--%>
<%--    <c:if test="${User.Images.substring(0,5) == 'https'}">--%>
<%--        <c:url value="${User.Images }" var="imgUrl"></c:url>--%>
<%--    </c:if>--%>
<%--    <img id="images" height="150" width="200" src="${imgUrl}" />--%>
<%--    Tải ảnh lên:--%>
<%--    <input type="file" onchange="chooseFile(this)" id="images" name="Images" value="${User.Images}"><br>--%>

<%--    <label for="active">Active: </label>--%>
<%--    <input id="activeon" type="radio" name="Active" value="true" ${User.active ? 'checked' : ''}>--%>
<%--    <label for="activeon">Hoạt động</label>--%>
<%--    <input id="activeoff" type="radio" name="Active" value="false" ${!User.active ? 'checked' : ''}>--%>
<%--    <label for="activeoff">Khóa</label>--%>
<%--    <br>--%>

<%--    <label for="admin">Admin: </label>--%>
<%--    <input id="adminon" type="radio" name="Admin" value="true" ${User.admin ? 'checked' : ''}>--%>
<%--    <label for="adminon">Là Admin</label>--%>
<%--    <input id="adminoff" type="radio" name="Admin" value="false" ${!User.admin ? 'checked' : ''}>--%>
<%--    <label for="adminoff">Không phải admin</label>--%>
<%--    <br> <input type="submit" value="Submit">--%>
<%--</form>--%>

<p>${msg}</p>