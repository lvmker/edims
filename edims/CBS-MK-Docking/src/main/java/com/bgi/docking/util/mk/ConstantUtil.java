package com.bgi.docking.util.mk;

/**
 * 常量工具类
 * author:zengfanxinpaymenttransaction-list
 * date:2017-11-27 21:56:28
 */

/**
 * Created by shaoyg on 2018年9月17日
 *
 * 
 */
public class ConstantUtil {
    public static final String YES="Y";
    public static final String NO="N";
    /**每刻请求参数信息**/
    public static final String REQUEST_TIMESTAMP_KEY="timestamp";
    public static final String REQUEST_DATA_KEY="data";
    /**每刻请求结果信息**/
    public static final String RESULT_CODE_SUCCESS_KEY="ACK";
    public static final String RESULT_SUCCESS_DATA_KEY="data";
    public static final String RESULT_CODE_FAILURE_KEY="NACK";
    public static final String RESULT_FAILURE_MSG_KEY="message";
    /**钉钉请求结果信息**/
    public static final String DingDing_RESULT_CODE_SUCCESS_KEY="0";

    /**钉钉平台信息**/
    /**钉钉平台应用编码常量KEY**/
    public static final String DingDing_CORPID_KEY="dingding.corpid";
    /**钉钉平台应用秘钥常量KEY**/
    public static final String DingDing_CORPSECRET_KEY="dingding.corpsecret";
    /**钉钉平台主机常量KEY**/
    public static final String DingDing_HOST_KEY="dingding.host";
    /**钉钉身份校验api**/
    public static final String DINGDING_APP_GETTOKEN_KEY="openapi.dingding.gettoken";
    /**钉钉获取子部门ID列表**/
    public static final String DINGDING_APP_DEPARTMENT_LIST_IDS_KEY="openapi.dingding.department-list_ids";
    /**钉钉获取部门列表**/
    public static final String DINGDING_APP_DEPARTMENT_LIST_KEY="openapi.dingding.department-list";
    /**钉钉获取通讯录权限范围**/
    public static final String DINGDING_APP_AUTH_SCOPES_KEY="openapi.dingding.auth-scopes";

    /*** 钉钉获取打卡详情*/
    public static final String DINGDING_APP_ATTENDANCE_LISTRECORD_KEY="openapi.dingding.attendance-listRecord";
    /**
     *获取部门用户userid列表
     */
    public static final String DINGDING_APP_USER_GETDEPTMEMBER_KEY="openapi.dingding.user-getDeptMember";

    /**
     * 获取部门用户
     */
    public static final String DINGDING_APP_USER_SIMPLELIST_KEY="openapi.dingding.user-simplelist";

    /**
     * 获取部门用户（详情）
     */
    public static final String DINGDING_APP_USER_LISTBYPAGE_KEY="openapi.dingding.user-listbypage";
    /**
     * 获取用户详情
     */
    public static final String DINGDING_APP_USER_GET_KEY="openapi.dingding.user-get";

    /**每刻平台信息**/
    /**每刻平台应用编码常量KEY**/
    public static final String MAYCUR_APP_CODE_KEY="maycur.code";
    /**每刻平台应用秘钥常量KEY**/
    public static final String MAYCUR_APP_SECRET_KEY="maycur.secret";
    /**每刻平台主机常量KEY**/
    public static final String MAYCUR_APP_HOST_KEY="maycur.host";
    /*** 每刻平台对应业务实体编码（中小企业唯一）*/
    public static final String MAYCUR_SUBSIDIARYBIZCODE_KEY="maycur.subsidiarybizcode";
    /**每刻接口响应编码常量KEY**/
    public static final String MAYCUR_APP_OPENAPI_RESPONSE_CODE_KEY="code";
    /*** 钉钉接口响应编码常量KEY*/
    public static final String DingDing_APP_OPENAPI_RESPONSE_CODE_KEY="errcode";
    /**身份校验api**/
    public static final String MAYCUR_APP_OPENAPI_AUTH_KEY="openapi.maycur.authapi";
    /**辅助核算信息保存api**/
    public static final String MAYCUR_APP_OPENAPI_COSTTRACKING_SAVE_KEY="openapi.maycur.costtrackingapi-save";
    /**获取已审批申请数据api**/
    public static final String MAYCUR_APP_OPENAPI_REQUEST_APPROVED_KEY="openapi.maycur.request-approved";
    /**获取预算科目**/
    public static final String MAYCUR_APP_BUDGET_ACCOUNT_KEY="openapi.maycur.budget-account";
    /**员工信用查询 **/
    public static final String MAYCUR_APP_CREDITS_KEY="openapi.maycur.credits";
    /*** 员工考勤*/
    public static final String MAYCUR_APP_ATTENDANCE_KEY="openapi.maycur.attendance";
    /**获取导出中的支付流水 **/
    public static final String MAYCUR_APP_PAYMENTTRANSACTION_LIST_KEY="openapi.maycur.paymenttransaction-list";
    /**更新支付状态根据流水号**/
    public static final String MAYCUR_APP_PAYMENTTRANSACTION_UPDATE_KEY="openapi.maycur.paymenttransaction-update";
    /**更新支付状态根据单据号**/
    public static final String MAYCUR_APP_PUPDATE_BYFORMCODE_KEY="openapi.maycur.update-byFormCode";

    /**获取已提交对私报销单据**/
    public static final String MAYCUR_APP_REPORT_PERSONAL_SUBMITTED="openapi.maycur.report-personal-submitted";
    /**获取已提交对私报销单据详情 **/
    public static final String MAYCUR_APP_REPORT_PERSONAL_DETAIL_KEY="openapi.maycur.report-personal-detail";
    /**
     * 获取已提交申请单详情
     */
    public static final String MAYCUR_APP_REPORT_CONSUME_DETAIL_KEY="openapi.maycur.report-consume-detail";
    /**
     * 获取已提交对公报销单据
     */
    public static final String MAYCUR_APP_REPORT_CORP_SUBMITTED_KEY="openapi.maycur.report-corp-submitted";

    /**获取已提交对公报销单据详情 **/
    public static final String MAYCUR_APP_REPORT_CORP_DETAIL_KEY="openapi.maycur.report-corp-detail";
    /**组织架构 部门更新**/
    public static final String MAYCUR_APP_ORG_DEPARTMENT_SAVE_KEY="openapi.maycur.org-department-save"; 
    /**预算冻结**/
    public static final String MAYCUR_APP_BUDGET_FREEZE_KEY="openapi.maycur.budget-freeze";
    /**预算释放**/
    public static final String MAYCUR_APP_BUDGET_RELEASE_KEY="openapi.maycur.budget-release";
    /**预算扣减**/
    public static final String MAYCUR_APP_BUDGET_OCCUPY_KEY="openapi.maycur.budget-occupy";
    /**供应商**/
    public static final String MAYCUR_APP_SUPPLIER_SAVE_KEY="openapi.maycur.supplier-save";
    /**对私报销单据导出状态修改**/
    public static final String MAYCUR_APP_REPORT_PERSONAL_EXPORTINFO_UPDATE_KEY="openapi.maycur.report-personal-exportInfo-update";

    /**异常情况邮件发送接收方key**/
    public static final String MAYCUR_APP_OPENAPI_ERROR_EMAIL_RECEIVER_KEY="xsky.mail.notification";
    /**对公收款单据详情api**/
    public static final String MAYCUR_APP_OPENAPI_CORPREPAYMENT_REPORT_DETAIL_KEY="openapi.maycur.corprepayment-report—detail-api";
    /**
     * 员工同步接口
     */
    public static final String MAYCUR_APP_EMPLOYEE_SAVE_KEY="openapi.maycur.employreport-personal-submittedee-save";

    /**
     * 员工查询接口
     */
    public static final String MAYCUR_APP_EMPLOYEE_KEY="openapi.maycur.employee";
    /**
     *员工银行卡
     */
    public static final String MAYCUR_APP_ACCOUNT_PERSONAL_SAVE_KEY="openapi.maycur.account-personal-save";

    /**销售易平台信息**/
    /**销售易平台应用秘钥常量KEY**/
    public static final String XSKY_APP_SECRET_KEY ="xsky.secret";
    /**销售易平台主机常量KEY**/
    public static final String XSKY_APP_HOST_KEY ="xsky.host";
    /**查询api**/
    public static final String XSKY_APP_OPENAPI_QUERY_KEY ="openapi.xsky.query";
    /**市场活动父类名称变量KEY**/
    public static final String XSKY_APP_MKACT_CAT_NAME_KEY ="xsky.mk-act.name";
    /**市场活动层级名称变量KEY**/
    public static final String XSKY_APP_MKACT_LEVEL_NAME_KEY ="xsky.mk-act.level-name";
    /**每页记录书变量KEY**/
    public static final String XSKY_APP_MKACT_PAGE_SIZE_KEY ="xsky.mk-act.page-size";
    /**市场活动可用状态值列表变量key***/
    public static final String XSKY_APP_MKACT_AVAILABLE_STATUS_KEY ="xsky.mk-act.available-status";
    /**市场活动字段与辅助核算字段列表映射变量key***/
    public static final String XSKY_APP_MKACT_FIELDSE_MAPPING_KEY ="xsky.mk-act.field-mapping";
    /**市场活动表名变量key***/
    public static final String XSKY_APP_MKACT_TABLE_NAME_KEY ="xsky.mk-act.table-name";


}
