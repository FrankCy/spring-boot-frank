package com.frank.boot.jdk5.enumeration;

/**
 *
 *
 * @author cy
 * @version EnumExample.java, v 0.1 2020年12月25日 3:27 下午 cy Exp $
 */
public enum EnumExample {
    /**
     * http状态码枚举所有状态码注解
     */
    CONTINUE(4000100, "Continue", "请继续发送请求的剩余部分"),
    SWITCHING_PROTOCOLS(4000101, "Switching Protocols", "协议切换"),
    PROCESSING(4000102, "Processing", "请求将继续执行"),
    CHECKPOINT(4000103, "Checkpoint", "可以预加载"),
    OK(0, "success", "请求已经成功处理"),
    SUCCESS(4000200, "OK", "请求已经成功处理"),
    CREATED(4000201, "Created", "请求已经成功处理，并创建了资源"),
    ACCEPTED(4000202, "Accepted", "请求已经接受，等待执行"),
    NON_AUTHORITATIVE_INFORMATION(4000203, "Non-Authoritative Information", "请求已经成功处理，但是信息不是原始的"),
    NO_CONTENT(4000204, "No Content", "请求已经成功处理，没有内容需要返回"),
    RESET_CONTENT(4000205, "Reset Content", "请求已经成功处理，请重置视图"),
    PARTIAL_CONTENT(4000206, "Partial Content", "部分Get请求已经成功处理"),
    MULTI_STATUS(4000207, "Multi-Status", "请求已经成功处理，将返回XML消息体"),
    ALREADY_REPORTED(4000208, "Already Reported", "请求已经成功处理，一个DAV的绑定成员被前一个请求枚举，并且没有被再一次包括"),
    IM_USED(4000226, "IM Used", "请求已经成功处理，将响应一个或者多个实例"),
    MULTIPLE_CHOICES(4000300, "Multiple Choices", "提供可供选择的回馈"),
    MOVED_PERMANENTLY(4000301, "Moved Permanently", "请求的资源已经永久转移"),
    FOUND(4000302, "Found", "请重新发送请求"),
    // MOVED_TEMPORARILY(4000302, "Moved Temporarily", "") 已经过时
    SEE_OTHER(4000303, "See Other", "请以Get方式请求另一个URI"),
    NOT_MODIFIED(4000304, "Not Modified", "资源未改变"),
    USE_PROXY(4000305, "Use Proxy", "请通过Location域中的代理进行访问"),
    // 0306在新版本的规范中被弃用
    TEMPORARY_REDIRECT(4000307, "Temporary Redirect", "请求的资源临时从不同的URI响应请求"),
    RESUME_INCOMPLETE(4000308, "Resume Incomplete", "请求的资源已经永久转移"),
    BAD_REQUEST(4000400, "Bad Request", "请求错误，请修正请求"),
    UNAUTHORIZED(4000401, "Unauthorized", "没有被授权或者授权已经失效"),
    PAYMENT_REQUIRED(4000402, "Payment Required", "预留状态"),
    FORBIDDEN(4000403, "Forbidden", "请求被理解，但是拒绝执行"),
    NOT_FOUND(4000404, "Not Found", "资源未找到"),
    METHOD_NOT_ALLOWED(4000405, "Method Not Allowed", "请求方法不允许被执行"),
    NOT_ACCEPTABLE(4000406, "Not Acceptable", "请求的资源不满足请求者要求"),
    PROXY_AUTHENTICATION_REQUIRED(4000407, "Proxy Authentication Required", "请通过代理进行身份验证"),
    REQUEST_TIMEOUT(4000408, "Request Timeout", "请求超时"),
    CONFLICT(4000409, "Conflict", "请求冲突"),
    GONE(4000410, "Gone", "请求的资源不可用"),
    LENGTH_REQUIRED(4000411, "Length Required", "Content-Length未定义"),
    PRECONDITION_FAILED(4000412, "Precondition Failed", "不满足请求的先决条件"),
    REQUEST_ENTITY_TOO_LARGE(4000413, "Request Entity Too Large", "请求发送的实体太大"),
    REQUEST_URI_TOO_LONG(4000414, "Request-URI Too Long", "请求的URI超长"),
    UNSUPPORTED_MEDIA_TYPE(4000415, "Unsupported Media Type", "请求发送的实体类型不受支持"),
    REQUESTED_RANGE_NOT_SATISFIABLE(4000416, "Requested range not satisfiable", "Range指定的范围与当前资源可用范围不一致"),
    EXPECTATION_FAILED(4000417, "Expectation Failed", "请求头Expect中指定的预期内容无法被服务器满足"),
    UNPROCESSABLE_ENTITY(4000422, "Unprocessable Entity", "请求格式正确，但是由于含有语义错误，无法响应"),
    LOCKED(4000423, "Locked", "当前资源被锁定"),
    FAILED_DEPENDENCY(4000424, "Failed Dependency", "由于之前的请求发生错误，导致当前请求失败"),
    UPGRADE_REQUIRED(4000426, "Upgrade Required", "客户端需要切换到TLS1.0"),
    PRECONDITION_REQUIRED(4000428, "Precondition Required", "请求需要提供前置条件"),
    TOO_MANY_REQUESTS(4000429, "Too Many Requests", "请求过多"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(4000431, "Request Header Fields Too Large", "请求头超大，拒绝请求"),
    INTERNAL_SERVER_ERROR(4000500, "Internal Server Error", "服务器内部错误"),
    NOT_IMPLEMENTED(4000501, "Not Implemented", "服务器不支持当前请求的部分功能"),
    BAD_GATEWAY(4000502, "Bad Gateway", "响应无效"),
    SERVICE_UNAVAILABLE(4000503, "Service Unavailable", "服务器维护或者过载，拒绝服务"),
    GATEWAY_TIMEOUT(4000504, "Gateway Timeout", "上游服务器超时"),
    HTTP_VERSION_NOT_SUPPORTED(4000505, "HTTP Version not supported", "不支持的HTTP版本"),
    VARIANT_ALSO_NEGOTIATES(4000506, "Variant Also Negotiates", "服务器内部配置错误"),
    INSUFFICIENT_STORAGE(4000507, "Insufficient Storage", "服务器无法完成存储请求所需的内容"),
    LOOP_DETECTED(4000508, "Loop Detected", "服务器处理请求时发现死循环"),
    BANDWIDTH_LIMIT_EXCEEDED(4000509, "Bandwidth Limit Exceeded", "服务器达到带宽限制"),
    NOT_EXTENDED(4000510, "Not Extended", "获取资源所需的策略没有被满足"),
    NETWORK_AUTHENTICATION_REQUIRED(4000511, "Network Authentication Required", "需要进行网络授权");

    private final int code;

    private final String reasonPhraseUS;

    private final String reasonPhraseCN;

    private static final int
            INFORMATIONAL = 1,
            SUCCESSFUL = 2,
            REDIRECTION = 3,
            CLIENT_ERROR = 4,
            SERVER_ERROR = 5;

    EnumExample(int code, String reasonPhraseUS, String reasonPhraseCN) {
        this.code = code;
        this.reasonPhraseUS = reasonPhraseUS;
        this.reasonPhraseCN = reasonPhraseCN;
    }

    public int code() {
        return code;
    }

    public String reasonPhraseUS() {
        return reasonPhraseUS;
    }

    public String reasonPhraseCN() {
        return reasonPhraseCN;
    }

    public static EnumExample valueOf(int code) {
        for (EnumExample httpStatus : values()) {
            if (httpStatus.code() == code) {
                return httpStatus;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }

    public boolean is1xxInformational() {
        return type() == INFORMATIONAL;
    }

    public boolean is2xxSuccessful() {
        return type() == SUCCESSFUL;
    }

    public boolean is3xxRedirection() {
        return type() == REDIRECTION;
    }

    public boolean is4xxClientError() {
        return type() == CLIENT_ERROR;
    }

    public boolean is5xxServerError() {
        return type() == SERVER_ERROR;
    }

    private int type() {
        return (int) code / 100;
    }

}