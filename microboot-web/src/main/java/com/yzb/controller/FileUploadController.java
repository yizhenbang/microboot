package com.yzb.controller;

import com.yzb.asb.action.AbstractBaseAction;
import com.yzb.pojo.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: FileUploadController
 * Description:
 * date: 2021/9/2 14:07
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class FileUploadController extends AbstractBaseAction {
    @RequestMapping("/upload")
    public Object upload(Student student, MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        result.put("Student", student);
        result.put("FileName", file.getName());
        result.put("OriginalFilename", file.getOriginalFilename());
        result.put("getContentType", file.getContentType());
        return result;
    }
}
