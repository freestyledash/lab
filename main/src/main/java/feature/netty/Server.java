package main.java.feature.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

/**
 * @author zhangyanqi
 * @since 1.0 2019-04-06
 */
public class Server {


    private static class EchoServerHandler extends ChannelInboundHandlerAdapter {


        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("有一个channal就绪了！");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf m = (ByteBuf) msg;
            System.out.println("server received:" + m.toString(CharsetUtil.UTF_8));
        }


        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            System.out.println("server received all data");
            ctx.writeAndFlush("finish").addListener(ChannelFutureListener.CLOSE);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }


    private String ip;

    private int prot;

    public Server(String ip, int prot) {
        this.ip = ip;
        this.prot = prot;
    }

    public void start() {
        final EchoServerHandler handler = new EchoServerHandler();
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap
                    .group(eventExecutors)
                    .localAddress(ip, prot)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(handler);
                        }
                    });
            ChannelFuture sync = bootstrap.bind().sync();
            sync.channel().closeFuture().sync();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                eventExecutors.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("服务器启动");
        Server server = new Server("127.0.0.1", 9090);
        server.start();
        System.out.println("服务器关闭");
    }
}
