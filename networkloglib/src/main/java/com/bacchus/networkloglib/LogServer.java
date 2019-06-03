package com.bacchus.networkloglib;

/**
 * 用于响应网页端发送的请求
 */
public class LogServer {

//    private final Gson g = new Gson();
//
//    private static final LogServer ourInstance = new LogServer();
//
//    public static LogServer getInstance() {
//        return ourInstance;
//    }
//
//    private SocketClient mSocketClient;
//
//    private SocketMessageAcceptListener messageAcceptListener;
//
//    private LogServer() {
//    }
//
//    @Override
//    public void accept(SocketMaintain socket, String data) {
//        if (messageAcceptListener != null) {
//            messageAcceptListener.accept(socket, data);
//        }
//    }
//
//    private boolean isDebug;
//    private String mIp;
//    private int mPort;
//    private String mDeviceName;
//
//    public void init(boolean debug, String ip, int port, @NonNull String uniqueDeviceName) {
//
//        isDebug = debug;
//        mIp = ip;
//        mPort = port;
//        mDeviceName = uniqueDeviceName;
//
//        if (!debug) {
//            return;
//        }
//
//        if (mSocketClient != null) {
//            mSocketClient.exit();
//            mSocketClient = null;
//        }
//
//        SocketLog.setLogListener(this);
//
//    }
//
//    public void startIfNotStart() {
//
//        if (!isDebug) { // 说明没有调用 init 方法或者不是debug环境,所以这里不管
//            return;
//        }
//
//        if (mSocketClient == null) {
//            mSocketClient = new SocketClient(mIp, mPort);
//            mSocketClient.setSocketMessageAcceptListener(this);
//        } else {
//            mSocketClient.startIfNotConnect();
//        }
//
//    }
//
//    public void sendAddDeviceTagMessage() {
//
//        if (mDeviceName == null || "".equals(mDeviceName)) {
//            return;
//        }
//
//        MessageBean messageBean = new MessageBean(MessageBean.ACTON_ADD_DEVICE);
//        messageBean.setTargetTag(MessageBean.TARRGET_SERVER);
//        messageBean.setData(mDeviceName);
//        send(g.toJson(messageBean));
//
//    }
//
//    public void sendNetworkData(String action, NetWorkLogInfo netWorkLogInfo) {
//
//        if (mDeviceName == null || "".equals(mDeviceName)) {
//            return;
//        }
//
//        MessageBean messageBean = new MessageBean(action);
//        messageBean.setSelfTag(mDeviceName);
//        messageBean.setData(netWorkLogInfo);
//
//        send(g.toJson(messageBean));
//
//
//    }
//
//    public void send(String data) {
//        if (isDebug && mSocketClient != null && !TextUtils.isEmpty(data)) {
//            mSocketClient.send(data);
//        }
//    }
//
//    public void exit() {
//
//        if (mSocketClient == null) {
//            return;
//        }
//
//        final SocketClient socketClient = this.mSocketClient;
//
//        mSocketClient.setSocketMessageAcceptListener(null);
//        mSocketClient = null;
//
//        // 里面有发送结束消息的代码,所以这里需要启动一个线程去处理
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//
//                socketClient.exit();
//
//            }
//        }.start();
//
//    }
//
//    @Override
//    public void onLog(String s, String msg) {
//        if (isDebug) {
//        }
//    }
//
//    public void setMessageAcceptListener(SocketMessageAcceptListener messageAcceptListener) {
//        this.messageAcceptListener = messageAcceptListener;
//    }

}
