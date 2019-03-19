package com.litbo.hospitalzj.Cfq;

import com.litbo.hospitalzj.sf.mapper.UserMapper;
import com.litbo.hospitalzj.zk.mapper.YqTslsMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.slf4j.LoggerFactory;

@Component
@ServerEndpoint(value = "/productWebSocket/{userId}", configurator = MyEndpointConfigure.class)
public class YqWebSocket {

    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    // concurrent包的线程安全Set，用来存放每个客户端对应的ProductWebSocket对象。
    private static CopyOnWriteArraySet<YqWebSocket> webSocketSet = new CopyOnWriteArraySet<YqWebSocket>();
    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private YqTslsMapper yqTslsMapper;

    private Logger log = LoggerFactory.getLogger(YqWebSocket.class);

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("userId")String userId, Session session) {
        log.info("新客户端连入，用户id：" + userId);
        this.session = session;
        webSocketSet.add(this); // 加入set中
        addOnlineCount(); // 在线数加1

        //相关业务处理，根据拿到的用户ID判断其为那种角色，根据角色ID去查询是否有需要推送给该角色的消息，有则推送
        if(StringUtils.isNotBlank(userId)) {
            List<String> roleIds = userMapper.findRoleName(userId);
            List<String> totalPushMsgs = new ArrayList<String>();
            for (String roleId : roleIds) {
                List<String> pushMsgs = yqTslsMapper.select(roleId);
                if(pushMsgs != null && !pushMsgs.isEmpty())
                    totalPushMsgs.addAll(pushMsgs);
            }
            if(totalPushMsgs != null && !totalPushMsgs.isEmpty()) {
                totalPushMsgs.forEach(e -> sendMessage(e));
            }
        }

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        log.info("一个客户端关闭连接");
        webSocketSet.remove(this); // 从set中删除
        subOnlineCount(); // 在线数减1
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     *            客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {

    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("websocket出现错误");
        error.printStackTrace();
    }

    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
            log.info("推送消息成功，消息为：" + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message) throws IOException {
        for (YqWebSocket productWebSocket : webSocketSet) {
            productWebSocket.sendMessage(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        YqWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        YqWebSocket.onlineCount--;
    }
}
