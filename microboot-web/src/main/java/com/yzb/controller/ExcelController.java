package com.yzb.controller;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.export.ExcelExportService;
import com.yzb.pojo.Emp;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName: ExcelController
 * Description:
 * date: 2021/8/29 20:37
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@RestController
public class ExcelController {
    @RequestMapping("/excel")
    public void excel(HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition","attachment;filename=yzhenb.xlsx");//设置响应头

        //先定义好消息内容
        String[] empnos = {"emp001","emp002","emp003"};
        String[] empname = {"小易","贺知书","蒋文旭"};

        //装载着所有数据
        List<Emp> objs = new ArrayList<>();
        for (int i = 0; i < empnos.length; i++) {
            Emp emp = new Emp();
            emp.setId(i);
            emp.setEmpno(empnos[i]);
            emp.setEmpname(empname[i]);
            // emp.setTesttime(new Date());
            objs.add(emp);
            System.out.println(emp);
        }

        Workbook workbook = new XSSFWorkbook();
        // workbook.createSheet("我的测试工作簿");

        //进行文件内容的设置
        ExportParams exportParams = new ExportParams("测试title","测试sheet", ExcelType.XSSF);//ExcelType.XSSF 是针对07年之后的版本
        // 创建一个sheet
        new ExcelExportService().createSheet(workbook,exportParams,Emp.class,objs);

        workbook.write(response.getOutputStream());


    }
}
