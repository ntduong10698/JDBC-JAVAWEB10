package com.bksoftwarevn.itstudent.controller;

import com.bksoftwarevn.itstudent.model.JsonResult;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "UploadFileController", value = "/api/v1/upload-file/*")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxRequestSize = 1024 * 1024 * 50, maxFileSize = 1024 * 1024 * 50)
//fileSizeThreshold nếu file truyền lớn hơn ngưỡng quy định thì sẽ thực hiện cơ chế ghi thẳng vào ổ
//dĩa không thông bộ đệm (sử dụng bộ đệm thì chắc chắn các bit trong file sẽ được giữ hoàn toàn,
// , nếu ko dùng bộ đệm có thể xảy mất dữ liệu)
//maxRequestSize: kích thước tối đa của 1 request (1 request có thểm chứa nhiều file)
//maxFileSize: kích thước tối đa của 1 file (1 request 1 file = maxRequestSize)

//để demo với api upload file thì cần phải có giao diẹn


/**
 * Khi upload cung 1 file có tên và phần mở rộng trùng nhau thì file đã upload trước
 * bị ghi đè (giải quyết vấn đề này mà gvaaxn giữ nguyên tên file):
 *      + mỗi 1 file upload lên thì sẽ nằm trong 1 folder riêng (folder sẽ là new Date().getTime())
 *      + mỗi 1 request sẽ là 1 thư mục (new Date().getTime());
 */
public class UploadFileController extends HttpServlet {

    private JsonResult jsonResult = new JsonResult();

    private Gson gson = new Gson();

    public static final String SAVE_DIRECTORY = "file-upload";

    private String getFileName(Part part) {
        String fileNameRs = null;
        //thuộc tính header của đối tượng part tương ứng với key content-disposition
        // thì sẽ chưa một một chuỗi có định dạng tương tự
        // form-data; name="file"; filename="C:\a\file1.zip"
        //từ chuỗi này mình lấy ra tên file và phần mở rộng của file.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s: items) {
            if(s.trim().startsWith("filename")) {
                //filename="C:\file1.zip"
                fileNameRs = s.substring(s.indexOf("=") + 2, s.length() - 1);
                fileNameRs = fileNameRs.replace("\\", "/");
                int i = fileNameRs.lastIndexOf("/");
                fileNameRs = fileNameRs.substring(i + 1);
            }
        }
        return fileNameRs;
    }

    private File getFolderUpload() {
        //chỉ rõ đường dẫn tuyệt đối vào folder muốn chứa file upload lên
        String appPath = "D:\\";
        appPath += SAVE_DIRECTORY;
        //xẩy ra 2 trường hợp thư thực đã tồn tại, chưa tồn
        File folderUpload = new File(appPath);
        if(!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rs = null;
        try {
            //lấy các file người dùng truyền lên
            Collection<Part> partCollection = request.getParts();
            //duyệt từng file 1 để lưu vào
            List<String> listFileName = new ArrayList<>();
            for (Part part: partCollection) {
                //khi upload file ngoài trừ lưu file thành công thì phải giữ được tên file của file
                //vừa được lưu
                String fileName = getFileName(part); //tạo ra một hàm để lấy fileName đầu vàoPpart
                if(fileName != null) {
                    //khi upload file lên server cần chỉ rõ file đấy sẽ được upload vào thư mục nào
                    //để quản lý đường dẫn upload vào thưc mục nào thì cần viết thêm 1 hàm

                    //getAbsolutePath trả về đường dẫn tuyệt đối của 1 file
                    String filePath = getFolderUpload().getAbsolutePath() + File.separator + fileName ;
                    System.out.println("Write File: "+ filePath);
                    //thực hiện ghi file
                    part.write(filePath);
                    //muốn kết quả trả cho client danh sách list file đã được upload
                    listFileName.add(SAVE_DIRECTORY + "/" + fileName);
                }
            }
            rs = gson.toJson(jsonResult.jsonSuccess(listFileName));
        } catch (Exception ex) {
            ex.printStackTrace();
            rs = gson.toJson(jsonResult.jsonFail("Tải file thất bại!"));
        }
        response.getWriter().println(rs);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
