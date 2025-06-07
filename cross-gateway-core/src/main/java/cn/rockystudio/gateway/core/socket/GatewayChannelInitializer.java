package cn.rockystudio.gateway.core.socket;

import cn.rockystudio.gateway.core.session.Configuration;
import cn.rockystudio.gateway.core.session.defaults.DefaultGatewaySessionFactory;
import cn.rockystudio.gateway.core.socket.handlers.AuthorizationHandler;
import cn.rockystudio.gateway.core.socket.handlers.GatewayServerHandler;
import cn.rockystudio.gateway.core.socket.handlers.ProtocolDataHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @author Rocky
 * @description 会话管道初始化类
 * @github github.com/fuzhengwei
 * @copyright 公众号：rockystudio虫洞栈 | 博客：rockystudio.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class GatewayChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final Configuration configuration;
    private final DefaultGatewaySessionFactory gatewaySessionFactory;

    public GatewayChannelInitializer(Configuration configuration, DefaultGatewaySessionFactory gatewaySessionFactory) {
        this.configuration = configuration;
        this.gatewaySessionFactory = gatewaySessionFactory;
    }

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline line = channel.pipeline();
        //Http请求解析
        line.addLast(new HttpRequestDecoder());
        line.addLast(new HttpResponseEncoder());
        line.addLast(new HttpObjectAggregator(1024 * 1024));
        //网关服务处理
        line.addLast(new GatewayServerHandler(configuration));
        //鉴权认证处理
        line.addLast(new AuthorizationHandler(configuration));
        //调用实际的会话服务
        line.addLast(new ProtocolDataHandler(gatewaySessionFactory));
    }

}
