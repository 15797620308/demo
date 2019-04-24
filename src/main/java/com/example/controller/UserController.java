package com.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.mapper.AccountInfoMapper;
import com.example.model.*;
import com.example.service.DataService;
import com.example.service.LoginService;
import com.example.service.RegisterService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private DataService dataService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }


    //跳转
    @RequestMapping(value = "/test/{pageUrl}",produces = {"application/json;charset=UTF-8"})
    public String test(@PathVariable("pageUrl") String pageUrl){
        return pageUrl;
    }

    @RequestMapping(value = "/forward/{pageUrl}",produces = {"application/json;charset=UTF-8"})
    public String pageForward(@PathVariable("pageUrl") String pageUrl){
        return "page/"+pageUrl;
    }

    @RequestMapping(value = "/show/{pageUrl}",produces = {"application/json;charset=UTF-8"})
    public String showPage(@PathVariable("pageUrl") String pageUrl){
        return "page/showPage/"+pageUrl;
    }

    @RequestMapping(value = "/edit/{pageUrl}",produces = {"application/json;charset=UTF-8"})
    public String EditPage(@PathVariable("pageUrl") String pageUrl){
        return "page/EditPage/"+pageUrl;
    }

    //登录
    @ResponseBody
    @RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"})
    public boolean login(AccountInfo accountInfo, HttpSession session){
        boolean result = loginService.findManager(accountInfo,session);
        return result;
    }

    //注册
    @ResponseBody
    @RequestMapping(value = "/register",produces = {"application/json;charset=UTF-8"})
    public boolean register(AccountInfo accountInfo, HttpSession session){
        boolean result = registerService.saveAccount(accountInfo);
        return result;
    }

    //退出
    @RequestMapping(value = "/exit",produces = {"application/json;charset=UTF-8"})
    public String exit(HttpSession session){
        loginService.exit(session);
        return "login";
    }

    //查看个人资料
    @RequestMapping(value = "/findData",produces = {"application/json;charset=UTF-8"})
    public String findData(HttpSession session, Model model){
        AccountInfo accountInfo = (AccountInfo) session.getAttribute("user");
        Object data = dataService.findData(accountInfo);
        model.addAttribute("data",data);
        return "page/userInfo" ;
    }

    //修改密码
    @ResponseBody
    @RequestMapping(value = "/changePwd",produces = {"application/json;charset=UTF-8"})
    public String changePwd(HttpSession session,AccountInfo accountInfo){
        int result = loginService.changePwd(accountInfo);
        String resut2 = "false";
        if(result==1){
            loginService.exit(session);
            resut2 = "true";
        }

        return resut2 ;
    }

    //测试
    @ResponseBody
    @RequestMapping(value = "/ceshi",produces = {"application/json;charset=UTF-8"})
    public jsondata ceshi(int pageNumber,int pageSize){
        jsondata jsondata = new jsondata();
        jsondata.setCode(200);
        jsondata.setSuccess(true);
        content content = new content();
        ArrayList<records> records = new ArrayList<records>();
        for(int i=pageNumber;i<pageSize+pageNumber;i++){
            records records1 = new records("00"+i,""+i,
                    "362201199311295412","大阳","123456",null,true);
            records.add(records1);
        }
        content.setCurrentPage(pageNumber);
        content.setHasNext(true);
        content.setHasPrev(false);
        content.setPageSize(pageSize);
        content.setRecords(records);
        content.setTotalPages(3);
        content.setTotalRecords(3);
        jsondata.setContent(content);
        jsondata.setSuccess(true);
        return jsondata ;
    }

    //模糊查询
    @ResponseBody
    @RequestMapping(value = "/getdatas",produces = {"application/json;charset=UTF-8"})
    public returnDatas getDatas(int pageNumber,int pageSize,String object,String filterData,HttpSession session){
        if(filterData!= null&&!"".equals(filterData)){
            filterData = "%"+filterData+"%";
        }
        returnDatas returnDatas = dataService.getDatas(pageNumber, pageSize, object,filterData,session);
        return returnDatas ;
    }

    //删除操作
    @ResponseBody
    @RequestMapping(value = "/deldata",produces = {"application/json;charset=UTF-8"})
    public String delData(String object,Short id){
        int result = dataService.deldata(object,id);
        String data = "{code:"+result+"}";
        JSONObject json = JSONObject.parseObject(data);
        return json.toJSONString() ;
    }

    //删除操作
    @ResponseBody
    @RequestMapping(value = "/batchdel",produces = {"application/json;charset=UTF-8"})
    public String batchDelete(String object,int[] arr){
        int code = 0;
        try{
            boolean result = dataService.batchDelete(object,arr);
        }catch (Exception e){
            e.printStackTrace();
            code = 1;
        }
        String data = "{code:"+code+"}";
        JSONObject json = JSONObject.parseObject(data);
        return json.toJSONString() ;
    }

    @ResponseBody
    @RequestMapping("/error")
    public List<RoleInfo> error() {
        List<RoleInfo> roleInfo = dataService.roleSelect();
        return roleInfo;
    }

    //学生选课
    @ResponseBody
    @RequestMapping("/select")
    public int select(Short id,HttpSession session){
        int result = dataService.select(id,session);
        return result;
    }

    //学生信息查询。用于select
    @ResponseBody
    @RequestMapping("/stuforSelect")
    public Map stuforSelect(){
        Map map = dataService.stuforSelect();
        return map;
    }

    //初始化账号
    @ResponseBody
    @RequestMapping("/init")
    public int init(int[] arr){
        int result = dataService.init(arr);
        return result;
    }

    /**
     * 个人信息上传
     * @return {Result}
     */
    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    @ResponseBody
    public Object headImg(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        AccountInfo user = (AccountInfo) session.getAttribute("user");
        short id = user.getAccountid();
        String imgURL = user.getImgurl();
        try{
            if(file!=null){
                String originalName = file.getOriginalFilename();
                String filepath = "E:/static/img/"+ id + "." + "jpg";
                filepath = filepath.replace("\\", "/");
                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
                if (files.exists() && files.isFile()) {
                    if (files.delete()) {
                        System.out.println("删除单个文件" + filepath + "成功！");
                    } else {
                        System.out.println("删除单个文件" + filepath + "失败！");
                    }
                } else {
                    System.out.println("删除单个文件失败：" + filepath + "不存在！");
                }
                file.transferTo(files);
                if(imgURL==null||imgURL.equals("")){
                    user.setImgurl("/image/"+ id + "." + "jpg");
                    dataService.chageImg(user);
                }
            }
        }catch (Exception e){
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String,Object> map2=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map2.put("src","/image/"+ id + ".jpg" );
        map.put("data",map2);
        return map;
    }

    //导入
    @RequestMapping(value = "/import", method = {RequestMethod.POST})
    @ResponseBody
    public Object importExcl(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response,HttpSession session)  {
        String str = "";
        Map<String, String> resObj = new HashMap<>();
        if (!file.isEmpty()) {
            try {
                    String filename = file.getOriginalFilename();
                    str = dataService.importExcl(filename, file);
            } catch (Exception e) {
                    resObj.put("msg", "error");
                    resObj.put("code", "1");
                    return JSONObject.toJSONString(resObj);
            }
            resObj.put("msg", str);
            resObj.put("code", "0");
            return JSONObject.toJSONString(resObj);
        } else {
            return null;
        }
    }
}

