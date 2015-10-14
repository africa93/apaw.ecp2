package client;

import server.Server;
import voting.http.HttpRequest;
import voting.http.HttpResponse;

public class Client {

    public HttpResponse send(HttpRequest request) {
        return new Server().send(request);
    }

}
