package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import java.io.File;
import java.io.IOException;

public class UploadAction extends ActionSupport {
    private String uid;        // 封装帐号（uid）请求参数属性
    private File headImage;     // 封装上传文件域属性
    private String headImageContentType;     // 封装上传文件类型的属性
    private String headImageFileName;// 封装上传文件属性

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }

    public File getHeadImage() {
        return headImage;
    }
    public void setHeadImage(File headImage) {
        this.headImage = headImage;
    }

    public String getHeadImageContentType() {
        return headImageContentType;
    }
    public void setHeadImageContentType(String headImageContentType) {
        this.headImageContentType = headImageContentType;
    }

    public String getHeadImageFileName() {
        return headImageFileName;
    }
    public void setHeadImageFileName(String headImageFileName) {
        this.headImageFileName = headImageFileName;
    }

    public String execute() throws IOException {
        // 上传文件的保存位置在“/image”,该位置在tomcat服务器的“webapps”之中
        String  realpath= ServletActionContext.getServletContext().getRealPath("/myimage");

        // 声明文件目录image，如果文件名不存在就建一个呗～
        File file = new File(realpath);
        if(!file.exists()){
            file.mkdirs();
        }

        // 实现文件上传，也就是做了一个方法调用～
        FileUtils.copyFile(headImage,new File(file,headImageFileName));
        return SUCCESS;
    }
}