package org.sangaizhi.common.constant;

import java.math.BigDecimal;

/**
 * @author sangaizhi
 * @date 2017/9/10
 */
public class LogConstants {
    /**
     * 全局的金额保留小数位数
     */
    public final static int BIGDECIMAL_AMOUNT_SCALE = 2;

    /**
     * 全局的金额保留小数方式（向上四舍五入）
     */
    public final static int BIGDECIMAL_AMOUNT_ROUND = BigDecimal.ROUND_HALF_UP;

    /**
     * 错误日志模板 [blog][说明](参数json)
     */
    public final static String LOG_ERROR_MODEL = "[blog][{}]({})";

    /**
     * 业务异常日志模板 [blog][说明](参数json)
     */
    public final static String LOG_EXCEPTION_MODEL = "[blog][{}]({})";

    /**
     * 删除业务日志模板 [blog][说明](参数json)
     */
    public final static String LOG_EXCEPTION_MODEL_DELETE = "[blog][DELETE][{}]({})";

    /**
     * 新增业务日志模板 [blog][ADD][说明](参数json)
     */
    public final static String LOG_INFO_MODEL_ADD = "[blog][ADD][{}]({})";

    /**
     * 修改业务日志模板 [blog][UPDATE][说明](参数json)
     */
    public final static String LOG_INFO_MODEL_UPDATE = "[blog][UPDATE][{}][old]({})[new]({})";

    /**
     * 业务流日志模板 [blog][说明](参数json)
     */
    public final static String LOG_INFO_MODEL_BUSSINESS = "[blog][{}]({})";

    /**
     * 业务起始日志模板 [blog][说明][start](参数json)
     */
    public final static String LOG_INFO_MODEL_BUSSINESS_START = "[blog][{}][start]({})";

    /**
     * 业务结束日志模板 [blog][说明][end](参数json)
     */
    public final static String LOG_INFO_MODEL_BUSSINESS_END = "[blog][{}][end]({})";

}
