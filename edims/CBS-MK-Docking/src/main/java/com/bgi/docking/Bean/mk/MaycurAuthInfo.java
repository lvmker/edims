package com.bgi.docking.Bean.mk;

import java.io.Serializable;

/**
 * 每刻平台身份认证信息类
 * author:huangshun
 * date:2019-06-27 21:52:18
 */
public class MaycurAuthInfo implements Serializable{
    private static final long serialVersionUID = 637021555289523960L;
    /**公司唯一编码**/
    private String entCode;
    /**本次登录有效的临时令牌**/
    private String tokenId;
    /**客户端提供的时间戳**/
    private long timestamp;

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MaycurAuthInfo{" +
                "entCode='" + entCode + '\'' +
                ", tokenId='" + tokenId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
