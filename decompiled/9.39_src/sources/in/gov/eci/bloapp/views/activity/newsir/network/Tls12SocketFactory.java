package in.gov.eci.bloapp.views.activity.newsir.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: /tmp/dex_9.39/classes4.dex */
public final class Tls12SocketFactory extends SSLSocketFactory {
    private final SSLSocketFactory delegate;

    public Tls12SocketFactory(SSLSocketFactory base) {
        this.delegate = base;
    }

    private Socket patch(Socket s) {
        if (s instanceof SSLSocket) {
            ((SSLSocket) s).setEnabledProtocols(new String[]{"TLSv1.2"});
        }
        return s;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        return patch(this.delegate.createSocket(s, host, port, autoClose));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port) throws IOException {
        return patch(this.delegate.createSocket(host, port));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        return patch(this.delegate.createSocket(host, port, localHost, localPort));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return patch(this.delegate.createSocket(host, port));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        return patch(this.delegate.createSocket(address, port, localAddress, localPort));
    }
}
