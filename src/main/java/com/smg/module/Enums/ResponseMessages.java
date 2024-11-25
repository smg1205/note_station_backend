package com.smg.module.Enums;

public class ResponseMessages {
    // 登录
    public static final String LOGIN_SUCCESS = "登录成功，即将跳转到主页";
    public static final String LOGIN_FAIL_PASSWORD_ERROR = "登录失败，密码错误";
    public static final String LOGIN_FAIL_ACCOUNT_NOT_EXIST = "登录失败，账户不存在";
    public static final String LOGIN_FAIL_SYSTEM_NO_RESPONSE = "登录失败，系统无响应";

    // 注册
    public static final String REGISTER_SUCCESS = "注册成功，即将跳转到主页";
    public static final String REGISTER_CHECK_EMAIL_SUCCESS = "邮箱校验无误";
    public static final String REGISTER_FAIL_INPUT_ERROR = "注册失败，输入格式有误";
    public static final String REGISTER_FAIL_ACCOUNT_EXISTS = "注册失败，账户已存在";
    public static final String REGISTER_FAIL_PASSWORD_LENGTH = "注册失败，密码长度有误";
    public static final String REGISTER_FAIL_USERNAME_LENGTH = "注册失败，用户名长度有误";
    public static final String REGISTER_FAIL_SYSTEM_NO_RESPONSE = "注册失败，系统无响应";
    public static final String REGISTER_FAIL_EMAIL_VERIFICATION_ERROR = "注册失败，邮箱验证码错误";

    // 注册检查
    public static final String REGISTER_CHECK_USERNAME_ISSUE = "用户名称存在问题";
    public static final String REGISTER_CHECK_PASSWORD_MISMATCH = "两次密码输入不一致";
    public static final String REGISTER_CHECK_EMAIL_FORMAT_ERROR = "邮箱书写有误";
    public static final String REGISTER_CHECK_EMAIL_EXISTS = "邮箱已存在";

    // 上传文档
    public static final String UPLOAD_SUCCESS = "上传成功";
    public static final String UPLOAD_FAIL = "上传失败";
    public static final String UPLOAD_FILE_NOT_ALLOWED = "该文件不允许上传";
    public static final String UPLOAD_FILE_TOO_LARGE = "该文件太大";

    // 查看文档
    public static final String VIEW_DOCUMENT_SUCCESS = "文档查看成功";
    public static final String VIEW_DOCUMENT_FAIL = "文件查看失败";

    // 个人页面
    public static final String PERSONAL_INFO_TRANSFER_SUCCESS = "个人信息传输成功";
    public static final String PERSONAL_INFO_TRANSFER_FAIL = "个人信息传输失败";

    // 如果需要，你也可以将所有这些消息和响应代码放到一个 Map 中来管理。
    // 例如可以添加一个方法来根据响应码返回相应的消息：
    public static String getMessageByCode(String code) {
        switch (code) {
            case "20001": return LOGIN_SUCCESS;
            case "20002": return LOGIN_FAIL_PASSWORD_ERROR;
            case "20003": return LOGIN_FAIL_ACCOUNT_NOT_EXIST;
            case "20004": return LOGIN_FAIL_SYSTEM_NO_RESPONSE;
            case "20011": return REGISTER_SUCCESS;
            case "20012": return REGISTER_FAIL_INPUT_ERROR;
            case "20013": return REGISTER_FAIL_ACCOUNT_EXISTS;
            case "20014": return REGISTER_FAIL_SYSTEM_NO_RESPONSE;
            case "20015": return REGISTER_FAIL_EMAIL_VERIFICATION_ERROR;
            case "20016": return REGISTER_FAIL_PASSWORD_LENGTH;
            case "20017": return REGISTER_FAIL_USERNAME_LENGTH;
            case "20018": return REGISTER_CHECK_EMAIL_EXISTS;
            case "20019": return REGISTER_CHECK_EMAIL_SUCCESS;
            case "80001": return REGISTER_CHECK_USERNAME_ISSUE;
            case "80002": return REGISTER_CHECK_PASSWORD_MISMATCH;
            case "80003": return REGISTER_CHECK_EMAIL_FORMAT_ERROR;
            case "20021": return UPLOAD_SUCCESS;
            case "20022": return UPLOAD_FAIL;
            case "20023": return UPLOAD_FILE_NOT_ALLOWED;
            case "20024": return UPLOAD_FILE_TOO_LARGE;
            case "20031": return VIEW_DOCUMENT_SUCCESS;
            case "20032": return VIEW_DOCUMENT_FAIL;
            case "20041": return PERSONAL_INFO_TRANSFER_SUCCESS;
            case "20042": return PERSONAL_INFO_TRANSFER_FAIL;
            default: return "未知错误";
        }
    }
}
