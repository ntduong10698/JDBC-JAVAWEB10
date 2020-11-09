<%--Jsp là một trang chứa các cấu trúc html và thêm một số thẻ đặc biết của jsp để viết code java--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
    <h1>Demo Upload File:</h1>
<%--    trong html có một cấu thẻ form, thẻ này được sử dụng để chứa các thông tin muốn server--%>
<%--    sử dụng thẻ form để demo với chức năng  upload file--%>
    <form action="api/v1/upload-file" method="post" enctype="multipart/form-data">
        <label>Chọn file cần upload:</label>
        <input type="file" name="file" multiple="multiple">
        <input type="submit" value="Tải lên">
    </form>
</body>
</html>
