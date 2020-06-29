package com.bgi.docking;

import com.alibaba.fastjson.JSON;
import com.bgi.docking.Bean.mk.MaycurAuthInfo;
import com.bgi.docking.service.MaycurBaseService;
import com.bgi.docking.Bean.mk.Result;
import com.bgi.docking.util.HttpClientUtil;
import com.bgi.docking.util.mk.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Author: huangshun
 * @Date: 2019/6/28 16:26   注意的点  json的格式  或者数据泛型
 * @Version 1.0
 */
@Controller
@RequestMapping("hs")
public class InterfaceTest {

    @Autowired
    MaycurBaseService service;//
    @Autowired
    private Environment env;// 注入enviroment 获取配置文件里面的值

    /**
     * 登录   OK
     * 客户端提供以下信息登录每刻系统
     * 接口： /auth/login POST JSON
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public Object login(){
        Result<MaycurAuthInfo> result = service.loginMaycurOpenAPI();
        return result;
    }


    /**
     * 业务实体    OK
     * 新增／更新
     * 接口：/org/subsidiary/save
     * Method：POST
     * 数据格式：JSON
     * @return
     */
    @ResponseBody
    @RequestMapping("subsidiarySave")
    public Object subsidiarySave(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "杭州时光科技有限公司");//业务实体名称，公司内唯一
        map.put("businessCode", "134162");//	业务实体编码,若businessCode已存在，则更新已有数据
        map.put("baseCurrency", "CNY");//	业务实体本币
        map.put("principal", "");//业务实体负责人工号
        map.put("active", true);//是否启用
        map.put("parentBizCode", "");//上级业务实体编码
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.org-subsidiary-save",
                "POST", "application/json", "UTF-8", list);
        return result;
    }

    /**
     * 删除   OK
     * 接口: /org/subsidiary/delete
     * Method：DELETE
     * 数据格式：JSON
     */
    @ResponseBody
    @RequestMapping("subsidiaryDelete")
    public Object testSubdidiaryDelete(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("businessCode","134162");//businessCode	string	Y	业务实体编码
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.subsidiaryDelete",
                "DELETE", "application/json", "UTF-8", list);
        return result;
    }

    /** ok  默认为全量查询
     * 根据修改时间获取业务实体信息
     * 接口: /org/subsidiaries
     * Method：POST
     * 数据格式：JSON
     * 接口说明：start为开始日期闭区间，end为结束日期开区间，若两个都为空，默认为全量查询
     */
    @ResponseBody
    @RequestMapping("subsidiaryByTime")
    public Object testsubsidiariesByTime(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.subsidiarybyUpdateTime",
                "POST", "application/json", "UTF-8", list);
        return result;
    }

    /**
     * 组织架构 部门   OK
     * 新增／更新
     * 接口：/org/department/save
     * Method：POST
     * 数据格式：JSON
     */
    @RequestMapping("departmentSave")
    @ResponseBody
    public Object testDepartmentSave(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","测试134162");//string	Y			部门名称
        map.put("nameEn","ADBCGAD");//string	Y			部门英文名称（name和nameEn至少其中一个要有值）
        map.put("businessCode","dsadasdasdas");//string	Y		Y	部门编码
        map.put("costCenterCode","成本中心编码hs");//string	N	系统生成		成本中心编码

        //共享部门的业务实体编码
        List list_department=new ArrayList();
        list_department.add("134162");//杭州时光科技有限公司
        map.put("subsidiaryBizCodes",list_department);//array	N			共享部门的业务实体编码

        map.put("active",true);//bool	N	false		是否启用
        map.put("principal","456651");//string	N			部门负责人工号
        //map.put("parentBizCode","");//string	N			上级部门编码
        map.put("childrenSubsidiaryOperation","OVERRIDE");//string	N	OVERRIDE		如何处理子部门共享业务实体，可选值OVERRIDE, NO_OVERRIDE

        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.departmentSave",
                "POST", "application/json", "UTF-8", list);
        return result;
    }


    /**
     * 更新部分部门信息 OK
     * 接口：/org/department/part/update
     * Method：POST
     * 数据格式：JSON
     * 接口说明：对于已存在的部门，更新传入的参数，没有传入的参数则保持不变。如果部门不存在则新增一个部门
     */
    @ResponseBody
    @RequestMapping("departmentPartUpdate")
    public Object testDepartmentPArtUpdate(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","测试134162");//string	Y			部门名称
        map.put("nameEn","HHHHHHHHH");//string	Y			部门英文名称（name和nameEn至少其中一个要有值）
        map.put("businessCode","dsadasdasdas");//        	string	Y		Y	部门编码
        map.put("costCenterCode","成本中心编码hs");//string	N	系统生成		成本中心编码
        List list_department=new ArrayList();
        list_department.add("134162");//杭州时光科技有限公司
        map.put("subsidiaryBizCodes",list_department);//array	N			共享部门的业务实体编码
        map.put("active",true);//bool	N	false		是否启用
        map.put("principal","456651");//string	N			部门负责人工号
        //map.put("parentBizCode",);//string	N			上级部门编码  非必须
        map.put("childrenSubsidiaryOperation","OVERRIDE");//string	N	OVERRIDE		如何处理子部门共享业务实体，可选值OVERRIDE, NO_OVERRIDE
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.departmentPartUpdate",
                "POST", "application/json", "UTF-8", list);
        return result;

    }


    /**
     * 删除   OK
     * 接口：/org/department/delete
     * Method：DELETE
     * 数据格式：JSON
     */
    @ResponseBody
    @RequestMapping("departmentDelete")
    public Object testDepartmentDelete(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("businessCode","dsadasdasdas");//string	Y	部门编码
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.departmentDelete",
                "DELETE", "application/json", "UTF-8", list);
        return result;

    }

    /** OK
     * 根据修改时间获取部门信息
     * 接口：/org/departments
     * Method：POST
     * 数据格式：JSON
     * 接口说明：开始时间为闭区间，结束时间为开区间，开始时间和结束时间不传默认为全量搜索
     */
    @ResponseBody
    @RequestMapping("departmentFindByTime")
    public Object testdepartments(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.departments",
                "POST", "application/json", "UTF-8", list);
        return result;

    }

    /**
     * 员工   OK --
     * 新增／更新， 每批次最多可处理300条记录
     * 接口 /employee/save POST JSON
     */
    @ResponseBody
    @RequestMapping("employeeSave")
    public Object testEmployeeSave(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("mobile",);//string	Y			手机号码（也可提供邮箱）
        map.put("email","hs134@foxmail.com");//string	Y			邮箱(也可提供手机号码）
        map.put("name","hstest5");//string	Y			员工姓名
        map.put("employeeId","00138");//string	Y		Y	员工工号
        map.put("rank","技术员工");//string				员工职级名称， （如果系统无该职级，将自动创建该职级）
        map.put("position","PI190608123R96MU");//string				员工职务编码

        List<Map<String,Object>> list_departments=new ArrayList<Map<String,Object>>();
        Map<String,Object> map_departments=new HashMap<String, Object>();

        map_departments.put("departmentBizCode","DI190608123R96MT");//string	Y			部门编码  测试部
        //map_departments.put("managerId",);//string	N			部门内上级工号
        //map_departments.put("cover","N");//string	N	Y		是否承担部门， 如果不是承担部门，请输入 N
        list_departments.add(map_departments);

        map.put("departments",list_departments);//array	Y			员工所属部门，及部门上级，详见下表


        map.put("status","ENABLE");//string		ENABLE		员工在职状态， 可以选择ENABLE, DISABLE
        //map.put("defaultSubsidiaryBizCode","134162");//string				员工默认业务实体
        //map.put("hireDate",new Date());//long				入职时间
        //map.put("tag",);//string				属性，可被用于流程
        //map.put("source",);//string				外联平台，可选值 WEIXIN、DING_TALK
        //map.put("sourceId",);//string				外联平台key 格式:外联平台的企业ID+"_"+外联平台的用户ID
        //map.put("residenceCode",);//string				常驻地，传入每刻地址编码，具体见备注
        //map.put("note",);//string				备注
        //map.put("firstName",);//string				姓
        //map.put("middleName",);//string				多为非中国人填写使用
        //map.put("lastName",);//string				名
        //map.put("restrictSubsidiaryBizCodes",);//array				限定的业务实体
        map.put("notifyActivation",true);//boolean		false		是否发送激活通知
        list.add(map);


        Result result = service.synchronizeToMaycur("openapi.maycur.employeeSave",
                "POST", "application/json", "UTF-8", list);
        return result;

    }


    /**
     * 设置员工部门  OK
     * 接口 /employee/department/save POST JSON
     * 请求参数
     */
    @ResponseBody
    @RequestMapping("employeeDepartmentSave")
    public Object testEmployeeDepartmentSave(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("employeeId","00136");//string	Y		Y	员工工号
        map.put("departmentBizCode","89639044");//string	Y			部门编码  市场部
        map.put("managerId",null);//string	N			部门内上级工号， 提供null，则在该部门内删除该上级

        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.employeeDepartmentSave",
                "POST", "application/json", "UTF-8", list);
        return result;

    }

    /**
     * 删除员工部门   OK
     * 接口 /employee/department/delete DELETE JSON
     */

    @ResponseBody
    @RequestMapping("employeeDepartmentDelete")
    public Object testEmployeeDepartmentDelete(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("employeeId","00136");//string	Y		Y	员工工号
        map.put("departmentBizCode","89639044");//string	Y			部门编码
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.employeeDepartmentDetete",
                "DELETE", "application/json", "UTF-8", list);
        return result;

    }

    /**
     * 设置员工默认辅助核算选项  OK
     * 接口 /employee/costTracking/items/save POST JSON
     */
    @ResponseBody
    @RequestMapping("employeeCostTrackingItemsSave")
    public Object testEmployeeCostTrackinngItemSave(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("employeeId","00136");//string	Y		Y	员工工号
        map.put("costTrackingName","同行人数");//string	Y			辅助核算名称
        map.put("costTrackingItemBusinessCode","CTI1902191AD3YLFK");//string	U			辅助核算选贤业务编码
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.employeeCostTrackingItemSave",
                "POST", "application/json", "UTF-8", list);
        return result;

    }

    /**
     * 员工离职接口  OK
     * 接口 /employee/disable POST JSON
     */
    @ResponseBody
    @RequestMapping("employeeDisable")
    public Object testEmployeeDisable(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("employeeId","000135"); //string	Y		Y	员工工号
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.employeeDisable",
                "POST", "application/json", "UTF-8", list);
        return result;

    }

    /**
     * 员工查询接口  OK   查询员工信息  注意  这里传进去的list 参数 直接传null 即可
     * 接口 /employee?offset={offset}&limit={limit} GET JSON
     */
    @ResponseBody
    @RequestMapping("employee")
    public Object testEmployee(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.findEmployeebylimtAndend",
                "GET", "application/json", "UTF-8", null);
        return result;

    }



    /** OK     注意json  格式问题！！
     * 员工增量更新角色接口
     * 接口 /employee/roles/incremental POST JSON
     */

    @ResponseBody
    @RequestMapping("employeeRolesIncremental")
    public Object testEmplyeeBusinessPrivilegeIncremental() throws Exception {
        Result<MaycurAuthInfo> authInfoResult = service.loginMaycurOpenAPI();
        MaycurAuthInfo data = authInfoResult.getData();
        String entCode = data.getEntCode();
        String tokenId = data.getTokenId();
        long timestamp = data.getTimestamp();
        System.out.println("entCode=="+entCode+"/n"+"tokenId=="+tokenId+"/n"+"timestamp=="+timestamp);
        //准备参数
        Map<String,String > header=new HashMap<String, String>();
        header.put("entCode",entCode);
        header.put("tokenId",tokenId);


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("employeeId","00136");//string	Y		员工工号

        List<Map<String,Object>> list_roles=new ArrayList<Map<String,Object>>();
        Map<String,Object> map_roles=new HashMap<String, Object>();
        map_roles.put("role","SYSTEM_ADMIN");//
        map_roles.put("assume",true);//
        map_roles.put("visibility","OPEN");//
        map_roles.put("subsidiaries",Arrays.asList(new String[]{"SI1808031D0VYOP8"}));//适用的业务实体
        map_roles.put("departments",Arrays.asList(new String[]{"DI1808031H0OO23Q"}));//适用的部门
        list_roles.add(map_roles);

        map.put("roles",list_roles);

        Map<String,Object> paramMap=new HashMap<String,Object>();
        paramMap.put(ConstantUtil.REQUEST_TIMESTAMP_KEY,timestamp);//timestamp
        paramMap.put(ConstantUtil.REQUEST_DATA_KEY,map);//data
        String jsonString = JSON.toJSONString(paramMap);//将对象转化为Json字符串
        System.out.println("转换后的json 为："+jsonString);


        String result = HttpClientUtil.sendHttpsRequest("https://uat.maycur.com/api/openapi/employee/roles/incremental",
                "POST", "application/json", "UTF-8", header, jsonString);

        return result;

    }

    /**  OK
     * 员工增量更新权限接口
     * 接口 /employee/business/privilege/incremental POST JSON
     */
    @ResponseBody
    @RequestMapping("employeeBusinessPrivilegeIncremental")
    public Object testEmployeeBusinessPrivilege() throws Exception {
        Result<MaycurAuthInfo> authInfoResult = service.loginMaycurOpenAPI();
        MaycurAuthInfo data = authInfoResult.getData();
        String entCode = data.getEntCode();
        String tokenId = data.getTokenId();
        long timestamp = data.getTimestamp();
        System.out.println("entCode=="+entCode+"\n"+"tokenId=="+tokenId+"\n"+"timestamp=="+timestamp);
        //准备头信息
        Map<String,String > header=new HashMap<String, String>();
        header.put("entCode",entCode);
        header.put("tokenId",tokenId);
        // 准备参数信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("employeeId","00136");//string	Y		员工工号

        List<Map<String,Object>> list_power=new ArrayList<Map<String,Object>>();
        Map<String,Object> map_power=new HashMap<String, Object>();
        map_power.put("businessPrivilege","REPORTING");//业务权限名称
        map_power.put("assume",true);//增加权限
        map_power.put("visibility","OPEN");//权限适用范围类型, 可选用OPEN, WHITE_LIST
        list_power.add(map_power);
        //map_power.put("subsidiaries",Arrays.asList(new String[]{"SI1808031D0VYOP8"}));//权限适用业务实体, 业务实体的业务编码
        //map_power.put("departments",Arrays.asList(new String[]{"DI1808031H0OO23Q"}));//权限适用部门, 部门的业务编码

        map.put("businessPrivileges",list_power);//权限组,

        Map<String,Object> paramMap=new HashMap<String,Object>();
        paramMap.put(ConstantUtil.REQUEST_TIMESTAMP_KEY,timestamp);//timestamp
        paramMap.put(ConstantUtil.REQUEST_DATA_KEY,map);//data
        String jsonString = JSON.toJSONString(paramMap);//将对象转化为Json字符串
        System.out.println("转换后的json 为："+jsonString);

        String result = HttpClientUtil.sendHttpsRequest("https://uat.maycur.com/api/openapi/employee/business/privilege/incremental",
                "POST", "application/json", "UTF-8", header, jsonString);

        return result;
    }


    /**  OK
     * 辅助核算选项
     * 新增／更新
     * 接口：/costtracking/item/save
     * Method：POST
     * 数据格式：JSON
     * 接口说明：每批次最多处理50条记录
     * @return
     */
    @ResponseBody
    @RequestMapping("costtrackingItemSave")
    public Object testCosttractingItemSave(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("costTrackingName","成本中心");//string	Y			选项属于的辅助核算名称
        map.put("name","成本中心D");//string	Y			辅助核算选项名称
        map.put("businessCode","DDDDD");//string	Y		Y	辅助核算编码
        map.put("visibilityAuthLevel","RESP_AND_AUTH_USER");//可见性授权，默认值及历史数据为 不可授权；可选值：NONE, RESP_USER,RESP_AND_AUTH_USER；
        //map.put("category",);//string	N			辅助核算选项分类，以／分隔层次，类似A/B/C
        map.put("principal","456651");//string	N			负责人工号
        map.put("departmentBizCodes",Arrays.asList(new String[]{"DI1808031H0OO23Q"}));//array	N			可见部门编码列表
        //map.put("employeeIds",);//array	N			可见员工工号列表
        map.put("active",true);//bool	N	false		是否启用
        //map.put("visibility",);//enum	N	WHITE_LIST		辅助核算可见性，可选值: OPEN,.....
        //map.put("tag",);//string	N			选项属性
        //map.put("subsidiaryBizCodes",);//array	N			关联业务实体编码列表，如果不提供， 则可用于所有业务实体
        //map.put("source",);//string	N			来源，不同来源的辅助核算授权， 不会相互影响
        //map.put("reportAssignees",);//array	N			报表授权人员，工号列表
        //map.put("dependencyBizCode",);//string	N			依赖的辅助核算选项编码；只有当辅助核算设置了依赖， 并且这里被依赖的选项正确时，才能设置上去
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.costtrackingapiSave",
                "POST", "application/json", "UTF-8", list);
        return result;

    }


    /**
     * 删除   OK
     * 接口：/costtracking/item/delete
     * Method：DELETE
     * 数据格式：JSON
     */
    @ResponseBody
    @RequestMapping("costtrackingItemDelete")
    public Object testCosttrackingItemDelete(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("businessCode","DDDDD");//businessCode	string	Y	业务编码
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.costtrackingItemDelete",
                "DELETE", "application/json", "UTF-8", list);
        return result;

    }

    /**  OK
     * 授权
     * 接口：/costtracking/item/auth
     * Method：POST
     * 数据格式：JSON
     * 接口说明：该接口将辅助核算选项（增量）授权给给定的部门列表
     */
    @ResponseBody
    @RequestMapping("costtrackingItemAuth")
    public Object testCosttrackingItemAuth(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("businessCode","DDDDD");//string	Y		Y	辅助核算选项业务编码
        map.put("departmentBizCodes",Arrays.asList(new String[]{"DI1808031GZOW782"}));//array				授权部门列表
        map.put("employeeIds",Arrays.asList(new String[]{"000134","000135"}));//array				授权人员工号列表*/
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.constrrackingItemAuth",
                "POST", "application/json", "UTF-8", list);
        return result;

    }

    /**  OK
     * 解授权
     * 接口：/costtracking/item/revoke
     * Method：POST
     * 数据格式：JSON
     * 接口说明：该接口将辅助核算选项收回授权给给定的部门列表；如果辅助核算没有授权给任何部门，该辅助核算将会被设置为全公司可见
     */
    @ResponseBody
    @RequestMapping("costtrackingItemRevoke")
    public Object testCosttrackingItemRevoke(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("businessCode","DDDDD");//string	Y		Y	辅助核算选项业务编码
        map.put("departmentBizCodes",Arrays.asList(new String[]{"DI1808031GZOW782"}));//array				授权部门列表
        map.put("employeeIds",Arrays.asList(new String[]{"000134","000135"}));//array				授权人员工号列表*/

        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.costtrackingItemRevoke",
                "POST", "application/json", "UTF-8", list);
        return result;

    }

    /** OK
     * 1、财务设置里  禁止员工自行维护银行卡要打开 才能通过接口维护
     * 2、开户行分支行名称 和 开户行联行号  要对应
     * 用于同步员工银行卡信息
     * 新建/更新
     * 接口 /account/personal/save
     * Method：POST
     * 数据格式：JSON
     */

    @ResponseBody
    @RequestMapping("accountPersonalSave")
    public Object testEmployeeAccountPersonalSave(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("employeeId","456651");//string	Y		Y	员工工号
        map.put("payeeCardNo","6325885");//string	Y		Y	银行卡号
        map.put("payeeName","测试hs");//string	Y			户名
        map.put("defaultBankCard",false);//boolean	N	false		该银行卡是否是该员工的默认银行卡
        map.put("bankName","工商银行");//string	N			银行名称
        map.put("bankBranchNo","102368000010");//string	Y			开户行联行号
        map.put("bankBranchName","中国工商银行安庆分行业务处理中心");//string	N			开户行分支行名称
        map.put("certificationType","居民身份证");//string		居民身份证		员工证件号码类型, 可选的值参考下表
        map.put("identification","342401199510068494");//string	Y			证件号码
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.accountPersonalSave",
                "POST", "application/json", "UTF-8", list);
        return result;

    }

    /**
     * 删除银行卡  OK
     * 接口 /account/personal/delete/{employeeId}
     * Method：DELETE
     */
    @ResponseBody
    @RequestMapping("accountPersonalDelete")
    public Object testAccountPersonaldelete(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.accountPersonalDelete",
                "DELETE", "application/json", "UTF-8", list);
        return result;

    }

    /** 还是一样的问题
     * 员工海外银行卡号 和名字要对应
     * 用于同步员工海外银行卡信息
     * 新建/更新
     * 接口 /account/personal/abroad/save
     * Method：POST
     * 数据格式：JSON
     */
    @ResponseBody
    @RequestMapping("accountPersonalAbroadSave")
    public Object testACcountPersonalAbroadSave(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("employeeId","456651");//string	Y		Y	员工工号
        map.put("payeeCardNo","6235522");//string	Y		Y	银行卡号
        map.put("payeeName","海外hs");//string	Y			户名
        map.put("bankCountry","HONG_KONG");//string	Y			该银行卡所属国，目前只支持香港，值固定为"HONG_KONG"
        map.put("swiftCode","235112220");//string	Y

        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.accountPersonalAbroadSave",
                "POST", "application/json", "UTF-8", list);
        return result;
    }

    /**  OK   这里在添加子用户组时， condition  要传  不然只会把默认用户组保存进去
     * 用户组
     * 保存用户组
     * 接口：/usergroup/save
     * Method：POST
     * 数据格式：JSON
     */
    @ResponseBody
    @RequestMapping("userGroupSave")
    public Object testUserGroupSave(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","HsMain");//string	Y			用户组名称
        map.put("businessCode","134162");//string	Y		Y	用户组编码(已存在则更新)
            List<Map<String,Object>> group_list=new ArrayList<Map<String,Object>>();
            Map<String,Object> group_map=new HashMap<String,Object>();
            group_map.put("name","子分组1");//string	Y			子分组名称
            group_map.put("businessCode","1341621");//string	Y		Y	子分组编码，同一个用户组下的子用户组编码不能重复(已存在则更新)
            group_map.put("assigneeEmployeeIds",Arrays.asList(new String[]{"000134","000135"}));//	List<String>	Y			子分组成员工号(默认子分组可为空)

                Map<String,Object> map_condition=new HashMap<String,Object>();
                map_condition.put("departmentBusinessCodes",Arrays.asList(new String[]{"700000","DI1808031H0OO23R"}));//List<String>	N			部门编码列表
                map_condition.put("subsidiaryBusinessCodes",Arrays.asList(new String[]{"SI1808031D0VYOP8"}));//List<String>	N			业务实体编码列表
                map_condition.put("costTrackingItemBusinessCodes",new String[]{"1456"});//List<String>	N			辅助核算选项编码列表

            group_map.put("condition",map_condition);//Condition	N			子分组职责范围条件(默认子分组无法配置职责条件)*/
            group_list.add(group_map);
        map.put("subUserGroups",group_list);//List<SubUserGroup>	N			子分组信息
            Map<String,Object> default_map=new HashMap<String,Object>();
            default_map.put("name","DefaultGroup");//string	Y			子分组名称
            default_map.put("businessCode","1341622");//string	Y		Y	子分组编码，同一个用户组下的子用户组编码不能重复(已存在则更新)
            default_map.put("assigneeEmployeeIds",Arrays.asList(new String[]{"00136","00137"}));//	List<String>	Y			子分组成员工号(默认子分组可为空)
            //group_map.put("condition",);//Condition	N			子分组职责范围条件(默认子分组无法配置职责条件)*/
        map.put("defaultSubUserGroup",default_map);//SubUserGroup	N			默认子分组信息，不填则默认生成一个不含成员的子分组,默认用户组不支持名称的修改
        list.add(map);

        Result result = service.synchronizeToMaycur("openapi.maycur.userGroupSave",
                "POST", "application/json", "UTF-8", list);
        return result;

    }

    /**  OK   又臭又长--
     * 增量保存用户组
     * 接口：/usergroup/save/delta
     * Method：POST
     * 数据格式：JSON
     */
    @ResponseBody
    @RequestMapping("userGroupDaveDelta")
    public Object testUserGroupSaveDelta(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","TestMain2");//string	Y			用户组名称
        map.put("businessCode","00134162");//string	Y		Y	用户组编码(已存在则更新)

        List<Map<String,Object>> list_group=new ArrayList<Map<String,Object>>();
        Map<String,Object> map_group=new HashMap<String,Object>();
            map_group.put("name","子分组1");//string	Y			子分组名称
            map_group.put("businessCode","00135666");//string	Y		Y	子分组编码，同一个用户组下的子用户组编码不能重复(已存在则更新)
            map_group.put("assigneeEmployeeIds", Arrays.asList(new String[]{"000134","000135"}));//List<String>	Y			子分组成员工号(默认子分组可为空)
                Map<String,Object> map_condition=new HashMap<String,Object>();
                map_condition.put("departmentBusinessCodes",Arrays.asList(new String[]{"700000","DI1808031H0OO23R"}));//List<String>	N			部门编码列表
                map_condition.put("subsidiaryBusinessCodes",Arrays.asList(new String[]{"SI1808031D0VYOP8"}));//List<String>	N			业务实体编码列表
                map_condition.put("costTrackingItemBusinessCodes",new String[]{"1456"});//List<String>	N			辅助核算选项编码列表

            map_group.put("condition",map_condition);//Condition	N			子分组职责范围条件(默认子分组无法配置职责条件)

                Map<String,Object> default_map=new HashMap<String,Object>();
                default_map.put("name","DefaultGroup");//string	Y			子分组名称
                default_map.put("businessCode","1341622");//string	Y		Y	子分组编码，同一个用户组下的子用户组编码不能重复(已存在则更新)
                default_map.put("assigneeEmployeeIds",Arrays.asList(new String[]{"00136","00137"}));//	List<String>	Y
            map_group.put("defaultSubUserGroup",default_map);//SubUserGroup	N			默认子分组信息，不填则默认生成一个不含成员的子分组,默认用户组不支持名称的修改
        list_group.add(map_group);
        map.put("subUserGroups",list_group);//List<SubUserGroup>	N			子分组信息*/
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.userGroupSaveDelta",
                "POST", "application/json", "UTF-8", list);
        return result;

    }

    /** NOK
     * 查询用户组  猜测接口有问题
     * 接口：/usergroup/query/userGroup
     * Method：POST
     * 数据格式：JSON
     */

    @ResponseBody
    @RequestMapping("userGroupQueryUserGroup")
    public Object testUserGroupQuery(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","TestMain2");//string	N			用户组名称
        map.put("businessCode","00134162");//string	N			用户组编码
        map.put("employeeId","000134");//string	N			用户组内的员工工号,仅支持一个员工工号
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.userGroupQueryUserGruop",
                "POST", "application/json", "UTF-8", list);
        return result;

    }


    /**
     * 供应商
     * 新增／更新
     * 接口： /supplier/save POST JSON
     */
    @ResponseBody
    @RequestMapping("supplierSave")
    public Object testSupplierSave(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("businessCode","332212122");//string	Y	Y		供应商编码， 系统内唯一
        map.put("name","供应商测试11");//string	Y	N		供应商名称
        //map.put("supplierType","CORP");//string	N	N	CORP	供应商类型: CORP (公司), SELF_EMPLOYED(个体经营商)


/*        Map<String,Object> map_account=new HashMap<String,Object>();
        map_account.put("name","测试供应商");//string	Y	N		帐号名称
        map_account.put("businessCode","AAAAA");//string	Y	Y		帐号业务编码
        map_account.put("account","622482244");//string				帐号
        map_account.put("bankName","中国银行");//string				银行名称， 如： 中国银行
        map_account.put("bankCode","BOC");//string				银行简码， 如： BOC
        map_account.put("bankBranchNo","104368704664");//string				分支行编码
        map_account.put("bankBranchName","中国银行望江支行");//string				分支行名称
        map_account.put("bankBranchLocation","dsadsadsadsa");//address				分支行地址
        map_account.put("paymentType","BANK");//string				支付类型， 包括BANK（银行）, CASH（现金）, THIRD_PARTY（第三方）, OTHER（其他）
        map_account.put("thirdPayType","");//string				第三方支付类型
        map_account.put("active",true);//bool			false	启用
        map_account.put("subsidiaries",Arrays.asList(new String[]{"SI1808031D0VYOP8"}));//array				可用于业务实体列表*/
        //map.put("accounts",map_account);//SupplierAccount数组	N	N		供应商帐号

        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.supplierSave",
                "POST", "application/json", "UTF-8", list);
        return result;

    }
















    @ResponseBody
    @RequestMapping("aaa")
    public Object testAA(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        list.add(map);
        Result result = service.synchronizeToMaycur("openapi.maycur.subsidiarybyUpdateTime",
                "POST", "application/json", "UTF-8", list);
        return result;

    }


    /**
     * 测试调用list接口获取银行流水
     * @return
     */
    @ResponseBody
    @RequestMapping("paymenttransaction")
    public Object testPaymenttransaction(){
        //List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //Map<String, Object> map = new HashMap<String, Object>();
        //map.put("name","TestMain2");//string	N			用户组名称
        //map.put("businessCode","00134162");//string	N			用户组编码
        //map.put("employeeId","000134");//string	N			用户组内的员工工号,仅支持一个员工工号
        //list.add(map);


        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("sequence", "-1");
        hashMap.put("pageSize", "1");


        Result result = service.synchronizeToMaycur("openapi.maycur.paymenttransaction-list",
                "POST", "application/json", "UTF-8", hashMap);
        return result;

    }





}
