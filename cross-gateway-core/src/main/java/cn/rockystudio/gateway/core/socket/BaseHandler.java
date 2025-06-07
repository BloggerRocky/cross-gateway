package cn.rockystudio.gateway.core.socket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.dubbo.config.annotation.Reference;

/**
 * @author Rocky
 * @description 数据处理器基累
 * @github github.com/fuzhengwei
 * @copyright 公众号：rockystudio虫洞栈 | 博客：rockystudio.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public abstract class BaseHandler<T> extends SimpleChannelInboundHandler<T> {
    @Reference


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, T msg) throws Exception {
        session(ctx, ctx.channel(), msg);
    }

    protected abstract void session(ChannelHandlerContext ctx, final Channel channel, T request);

}
