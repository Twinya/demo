package com.ymatou.demo1.infrastructure.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.stereotype.Component;

/**
 * Created by @Author on 2017/4/5.
 */
@Component
@DisconfFile(fileName = "biz.properties")
public class BizConfig {


    private String respLogMaxLength;
    

    @DisconfFileItem(name = "respLogMaxLength")
    public String getRespLogMaxLength() {
        return respLogMaxLength;
    }

    public void setRespLogMaxLength(String respLogMaxLength) {
        this.respLogMaxLength = respLogMaxLength;
    }

    
}
