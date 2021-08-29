package com.yzb.lombok;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;

/**
 * ClassName: CleanupIO
 * Description:
 * date: 2021/8/23 11:33
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public class CleanupIO {
    private String parentPath;
    private String filename;

    @SneakyThrows
    public String read(){
        @Cleanup  FileInputStream fileInputStream = new FileInputStream(new File(parentPath, filename));
        byte[] data = new byte[1024];
        int len = fileInputStream.read(data);
        return new String(data,0,len);
    }

}
